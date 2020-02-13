package esj.back.control.authoritie.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.back.control.authoritie.dao.AuthoritiesBeanDao;
import esj.publicdoc.bean.AuthoritiesBean;
import esj.publicdoc.bean.MenusBean;
import esj.util.JdbcSourceUtil;

public class AuthoritiesBeanDaoImpl extends AuthoritiesBean implements AuthoritiesBeanDao {

	
	public int updateStateAuthoritiesByID(AuthoritiesBean authoritiesBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update authorities set state = ?where authId=?;";
		Object[] obj = new Object[]{authoritiesBean.getState(),authoritiesBean.getAuthId()};
		int count=0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	public int deleteAuthoritiesByID(AuthoritiesBean authoritiesBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "delete from authorities where authId=?;";
		Object[] obj = new Object[]{authoritiesBean.getAuthId()};
		int count=0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	public List<AuthoritiesBean> getAllAuthoritiesInfo() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from authorities;";
		List<AuthoritiesBean> list = null;
		MenusBean menu = null;
		List<AuthoritiesBean> authlist = new ArrayList<AuthoritiesBean>();
		String menuNames = "";
		try {
			list = runner.query(sql, new BeanListHandler<AuthoritiesBean>(AuthoritiesBean.class));
			for(AuthoritiesBean auth:list){
				if(auth.getMenuList().contains(",")){
					 menuNames = "";
					for(String menuid:auth.getMenuList().split(",")){
						String sql1 = "select * from menus where menuId = '"+menuid+"'";
						menu = runner.query(sql1, new BeanHandler<MenusBean>(MenusBean.class));
						menuNames += menu.getMenuName()+"  ";
					}
				}
				auth.setMenuList(menuNames);
				authlist.add(auth);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authlist;
	}

}
