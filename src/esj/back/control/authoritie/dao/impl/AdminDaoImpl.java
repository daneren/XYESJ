package esj.back.control.authoritie.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import esj.back.control.authoritie.dao.AdminDao;
import esj.publicdoc.bean.AdminsBean;
import esj.util.JdbcSourceUtil;

public class AdminDaoImpl implements AdminDao {

	public int addAdmin(AdminsBean admin) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO admins(adminPhone,adminName,adminPwd,sex,rigistDay,authId,state) VALUES(?,?,?,?,?,?,?) ";
		Object[] obj = new Object[]{
				admin.getAdminPhone(),
				admin.getAdminName(),
				admin.getAdminPwd(),
				admin.getSex(),
				admin.getRigistDay(),
				admin.getAuthId(),
				admin.getState()
				};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateAdminById(AdminsBean admin) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "UPDATE admins SET adminPhone=?,adminName=? ,sex=?,adminPwd=?,authId=? where adminId=?;";
		Object[] obj = new Object[]{
				admin.getAdminPhone(),
				admin.getAdminName(),
				admin.getSex(),
				admin.getAdminPwd(),
				admin.getAuthId(),
				admin.getAdminId()
				};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int deleteAdminById(AdminsBean adminsBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "delete from admins where adminId=?;";
		Object[] obj = new Object[]{ 
				adminsBean.getAdminId()
				};
		int count=0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

}
