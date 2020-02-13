package esj.publicdoc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.publicdoc.bean.ProductsBean;
import esj.publicdoc.dao.ProductsBeanDao;
import esj.util.JdbcSourceUtil;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:29:51
 * @最后修改时间 2016-6-25 下午5:29:51
 * @描述 商品表操作
 * @version 1.0
 */
public  class ProductsBeanDaoimpl implements ProductsBeanDao {

	public int saveProducts(ProductsBean bean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO products(proId,userId,typeId,tagName,title,details,photoAddr,oprice,cprice,dprice,bdate,edate,state) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";
		Object[] obj = new Object[]{bean.getProId(),
									bean.getUserId(),
									bean.getTypeId(),
									bean.getTagName(),
									bean.getTitle(),
									bean.getDetails(),
									bean.getPhotoAddr(),
									bean.getOprice(),
									bean.getCprice(),
									bean.getDprice(),
									bean.getBdate(),
									bean.getEdate(),
									bean.getState()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<ProductsBean> findAllProducts() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from products;";
		List<ProductsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<ProductsBean>(ProductsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int changeProductsState(ProductsBean bean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update products set state =? where proId = ?;";
		Object[] obj = new Object[]{bean.getState(),bean.getProId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateProducts(ProductsBean bean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update products set typeId =?,tagName=?, title=?,details=?,photoAddr=?,oprice=?,cprice=?,dprice=?,edate=? where proId = ?;";
		Object[] obj = new Object[]{bean.getTypeId(),bean.getTagName(),bean.getTitle(),bean.getDetails(),bean.getPhotoAddr(),bean.getOprice(),bean.getCprice(),bean.getDprice(),bean.getEdate(),bean.getProId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public ProductsBean findProductsById(String id) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from products where proId = ?;";
		Object[] obj = new Object[]{id};
		ProductsBean bean = null;
		try {
			bean = runner.query(sql, new BeanHandler<ProductsBean>(ProductsBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	

}
