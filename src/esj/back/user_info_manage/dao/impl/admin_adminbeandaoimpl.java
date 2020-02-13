package esj.back.user_info_manage.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import esj.back.user_info_manage.dao.admin_adminbeandao;
import esj.publicdoc.bean.AdminsBean;
import esj.publicdoc.bean.UsersBean;
import esj.util.JdbcSourceUtil;

public class admin_adminbeandaoimpl implements admin_adminbeandao{

	public AdminsBean findAdminsByAdminId(String adminPhoneid) {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from admins where adminPhone ='"+adminPhoneid+"';";
//		System.out.println(sql);
		AdminsBean bean = null;
		try {
			bean = runner.query(sql, new BeanHandler<AdminsBean>(AdminsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;

	}

}
