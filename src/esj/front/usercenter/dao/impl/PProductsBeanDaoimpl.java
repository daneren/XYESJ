package esj.front.usercenter.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.front.usercenter.bean.ProCommBean;
import esj.front.usercenter.dao.PProductsBeanDao;
import esj.publicdoc.bean.ProductsBean;
import esj.util.JdbcSourceUtil;
/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-6-26 下午8:14:28
 * @最后修改时间 2016-6-26 下午8:14:28
 * @描述：
 * @version 1.0
 */
public class PProductsBeanDaoimpl implements PProductsBeanDao {

	public List<ProductsBean> findProductByUserId(String userId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from products where userId = ? ;";
		List<ProductsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<ProductsBean>(ProductsBean.class),userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ProductsBean> findProduct(String userId, String state) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from products where userId = ? and state = ?;";
		Object[] params = {userId,state};
		List<ProductsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<ProductsBean>(ProductsBean.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ProductsBean> countProduct(String state) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select count(adminId)AS nCount, state from admins WHERE state IN("+state+")  GROUP BY state;";
		List<ProductsBean> productsBean = null;
		try {
			productsBean = runner.query(sql, new BeanListHandler<ProductsBean>(ProductsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productsBean;
	}

	public List<ProCommBean> getSoldOut(String buyerId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "SELECT p.proId,p.title,p.pCount,p.nCount, p.photoAddr,r.cjdate, " +
		"r.buyerPrice,COUNT(r.buyerId) AS ruCount,COUNT(c.userId) AS cuCount " +
"FROM products AS p   " +
"LEFT JOIN reserves AS r ON p.proId = r.proId     " +
"LEFT JOIN collects AS c ON p.proId = c.proId " +
"WHERE p.userId = ? AND p.state ='已售出' " +
"GROUP BY p.proId " +
"ORDER BY p.bdate desc;";
		//System.out.println(sql);
		List<ProCommBean> pBeans = null;
		try {
			pBeans = runner.query(sql, new BeanListHandler<ProCommBean>(ProCommBean.class),buyerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pBeans;
	}

	public List<ProCommBean> getOnSale(String buyerId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "SELECT p.proId,p.title,p.pCount,p.nCount, p.photoAddr,COUNT(r.buyerId)AS " +
				"ruCount FROM products AS p  LEFT JOIN reserves AS r ON p.proId = r.proId " +
				" WHERE p.userId = ? AND p.state ='出售中' GROUP BY p.proId ORDER BY p.bdate desc;";
		//System.out.println(sql);
		List<ProCommBean> pBeans = null;
		try {
			pBeans = runner.query(sql, new BeanListHandler<ProCommBean>(ProCommBean.class),buyerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pBeans;
	}
	
	
	public int setProductStateByProId(String proId, String state) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update products set state=? where proId =?";
		Object[] obj = new Object[]{state ,proId};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateProduct(ProductsBean productsBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update products set tagName=?,details=?,photoAddr=?,cprice=?,dprice=?,edate=? where proId = ?;";
		Object[] obj = new Object[]{
				productsBean.getTagName(),
				productsBean.getDetails(),
				productsBean.getPhotoAddr(),
				productsBean.getCprice(),
				productsBean.getDprice(),
				productsBean.getEdate(),
				productsBean.getProId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
