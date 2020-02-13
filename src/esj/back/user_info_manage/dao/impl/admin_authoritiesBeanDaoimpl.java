package esj.back.user_info_manage.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.back.user_info_manage.dao.admin_authoritiesBeanDao;
import esj.publicdoc.bean.AdminlogsBean;
import esj.publicdoc.bean.AuthoritiesBean;
import esj.publicdoc.bean.MenusBean;
import esj.util.JdbcSourceUtil;

public class admin_authoritiesBeanDaoimpl implements admin_authoritiesBeanDao{

	public List<MenusBean> findmenuname(String menulist) {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "SELECT menuId,menuName FROM `menus` WHERE menuId in(menulist);";
		List<MenusBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<MenusBean>(MenusBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
