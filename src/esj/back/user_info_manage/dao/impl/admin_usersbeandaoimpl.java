package esj.back.user_info_manage.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.back.bean.coutsbean;
import esj.back.user_info_manage.dao.admin_usersbeandao;
import esj.publicdoc.bean.UsersBean;
import esj.util.JdbcSourceUtil;

public class admin_usersbeandaoimpl implements admin_usersbeandao{

	public int userschangestate(UsersBean userBean) {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		
		String sql = "UPDATE users set  state=? where userName = ?";	
		Object[] obj = new Object[]{
				userBean.getState(),
				userBean.getUserName()
		};
		
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public List<UsersBean> blacklistUsers() {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from users where state= '0'";
		List<UsersBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<UsersBean>(UsersBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public UsersBean findUserByName(String name) {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from users where userName = "+"'"+name+"';";
//		System.out.println(sql);
		UsersBean userBean=null;
		try {
			
			userBean=runner.query(sql, new BeanHandler<UsersBean>(UsersBean.class));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userBean;
	}
	public coutsbean coutpproduct(String id) {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select count(*)as pproduct from products where userId = "+"'"+id+"';";
//		System.out.println(sql);
		coutsbean coutsbeans=new coutsbean();
		try {
			
			coutsbeans=runner.query(sql, new BeanHandler<coutsbean>(coutsbean.class));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coutsbeans;
	}
	public coutsbean coutpdemands(String id) {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select count(*)as pdemands from userdemands where userId = "+"'"+id+"';";
//		System.out.println(sql);
		coutsbean coutsbeans=new coutsbean();
		try {
			
			coutsbeans=runner.query(sql, new BeanHandler<coutsbean>(coutsbean.class));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coutsbeans;
	}
	public coutsbean coutbproduct(String id) {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select count(*)as pdemands from userdemands where userId = "+"'"+id+"';";
//		System.out.println(sql);
		coutsbean coutsbeans=new coutsbean();
		try {
			
			coutsbeans=runner.query(sql, new BeanHandler<coutsbean>(coutsbean.class));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coutsbeans;
	}
	public coutsbean coutrproduct(String id) {
		// TODO Auto-generated method stub
		return null;
	}}
