package esj.front.usercenter.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import esj.publicdoc.bean.UsersBean;
import esj.util.JdbcSourceUtil;
/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-6-26 下午8:14:23
 * @最后修改时间 2016-6-26 下午8:14:23
 * @描述：
 * @version 1.0
 */
public class PUsersBeanDaoimpl implements esj.front.usercenter.dao.PUsersBeanDao {

	public UsersBean findUserByEmail(String email) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from users where email = ?";
		UsersBean usersBean = null;
		try {
			usersBean = runner.query(sql, new BeanHandler<UsersBean>(UsersBean.class),email);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usersBean;
	}

	public int updateUser(String email, String state) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update  users set state=? where  email = ?";
		String[] params = {state,email};
		int count = 0;
		try {
			count =runner.update(sql, params);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	public int updateUserMsg(UsersBean usersBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update  users set school=? department= ?" +
				" major= ? birthDay= ? " +
				"entranceDay= ? iconAddr= ? " +
				"userName= ? where  userId = ?";
		String[] params = {usersBean.getSchool(),usersBean.getDepartment(),
				usersBean.getMajor(),usersBean.getBirthDay(),
				usersBean.getEntranceDay(),usersBean.getIconAddr(),
				usersBean.getUserName(),usersBean.getUserId()};
		int count = 0;
		try {
			count =runner.update(sql, params);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updatePwd(String userId,String npwd) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update  users set userPwd=? where  userId = ?";
		String[] params = {npwd,userId};
		int count = 0;
		try {
			count =runner.update(sql, params);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	public int updatePhone(String userId, String userPhone) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update  users set userPhone=? where  userId = ?";
		String[] params = {userPhone,userId};
		int count = 0;
		try {
			count =runner.update(sql, params);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

}
