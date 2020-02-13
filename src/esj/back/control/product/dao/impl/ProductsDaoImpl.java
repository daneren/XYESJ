package esj.back.control.product.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.back.control.product.dao.ProductsDao;
import esj.publicdoc.bean.ProductsBean;
import esj.publicdoc.bean.ProtypesBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.ProtypesBeanService;
import esj.publicdoc.service.UsersBeanService;
import esj.publicdoc.service.impl.ProtypesBeanServiceimpl;
import esj.publicdoc.service.impl.UsersBeanServiceimpl;
import esj.util.JdbcSourceUtil;

public class ProductsDaoImpl implements ProductsDao {

	public List<ProductsBean> findAllProducts() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from products;";
		List<ProductsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<ProductsBean>(ProductsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
        for(ProductsBean products:list)  
        {  	
        	UsersBeanService usersBeanService=new UsersBeanServiceimpl();
        	ProtypesBeanService protypesBeanService=new ProtypesBeanServiceimpl();
        	
        	List<UsersBean> userslist = new ArrayList<UsersBean>();
        	String userId="'"+products.getUserId()+"'";
        	UsersBean usersBean= null;
        	usersBean=findUserById(userId);
        	
        	userslist.add(usersBean);
        	products.setUsers(userslist);
        	
        	List<ProtypesBean> protypesBeanlist = new ArrayList<ProtypesBean>();
        	int typeId=products.getTypeId();
        	protypesBeanlist.add(protypesBeanService.findProtypesById(typeId));
        	products.setProtypes(protypesBeanlist);
           
        }  
		return list;
	}
	
	public UsersBean findUserById(String id) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from users where userId = "+id;
		//Object[] obj = new Object[]{id};
		UsersBean bean = null;
		try {
			bean = runner.query(sql, new BeanHandler<UsersBean>(UsersBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
		
	}

	public int deleteProduct(ProductsBean bean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "delete from products where proId = ?;";
		Object[] obj = new Object[]{bean.getProId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	

}
