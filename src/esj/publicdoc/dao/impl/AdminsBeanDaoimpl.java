package esj.publicdoc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.publicdoc.bean.AdminsBean;
import esj.publicdoc.dao.AdminsBeanDao;
import esj.util.JdbcSourceUtil;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:27:50
 * @最后修改时间 2016-6-25 下午5:27:50
 * @描述 管理员表 操作类
 * @version 1.0
 */
public class AdminsBeanDaoimpl implements AdminsBeanDao {

	public int saveAdmins(AdminsBean admin) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO admins(adminPhone,adminName,adminPwd,sex,birthDay,rigistDay,authId,state) VALUES(?,?,?,?,?,?,?,?) ";
		Object[] obj = new Object[]{admin.getAdminPhone(),admin.getAdminName(),admin.getAdminPwd(),admin.getSex(),admin.getBirthDay(),admin.getRigistDay(),admin.getAuthId(),admin.getState()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<AdminsBean> findAllAdmins() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from admins;";
		List<AdminsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<AdminsBean>(AdminsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
/**
 * 这里的删除是设置管理员的状态为禁用 没有真的删除数据
 */
	public int updateAdminsState(AdminsBean adminsBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "UPDATE admins SET state = ? where adminId = ? ;";
		Object[] obj = new Object[]{adminsBean.getState(), adminsBean.getAdminId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateAdmins(AdminsBean admin) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "UPDATE admins SET adminPhone=? ,sex=? ,birthDay=?,rigistDay=?,adminPwd=?,authId=? where adminId=?;";
		Object[] obj = new Object[]{admin.getAdminPhone(),admin.getSex(),admin.getBirthDay(),admin.getRigistDay(),admin.getAdminPwd(),admin.getAuthId(),admin.getAdminId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public AdminsBean findAdminsByAdminId(Integer id) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from admins where adminId = ?;";
		Object[] obj = new Object[]{id};
		AdminsBean bean = null;
		try {
			bean = runner.query(sql, new BeanHandler<AdminsBean>(AdminsBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	

}
