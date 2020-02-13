package esj.front.usercenter.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import esj.front.usercenter.dao.XUsersBeanDao;
import esj.publicdoc.bean.UsersBean;
import esj.util.JdbcSourceUtil;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-27 上午10:35:03
 * @最后修改时间 2016-6-27 上午10:35:03
 * @描述 用户数据库操作类
 * @version 1.0
 */
public class XUsersBeanDaoImpl implements XUsersBeanDao {

	public boolean userLogin(String email,String pwd) {
		boolean flag = false;
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from users where email = ? and userPwd=? and state = 1";
		Object[] obj = new Object[]{email,pwd};
		UsersBean usersBean = null;
		try {
			usersBean = runner.query(sql, new BeanHandler<UsersBean>(UsersBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(usersBean != null){
			flag = true;
		}
		return flag;
	}

	public String getUserIdByEmailAndPwd(String email, String pwd) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from users where email = ? and userPwd=?";
		Object[] obj = new Object[]{email,pwd};
		UsersBean usersBean = null;
		try {
			usersBean = runner.query(sql, new BeanHandler<UsersBean>(UsersBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usersBean.getUserId();
	}

	public int changePwdByEmail(String email,String pwd) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update users set userPwd =? where email = ?";
		Object[] obj = new Object[]{pwd,email};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public String getPwdByUserId(String userId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from users where userId = ?";
		Object[] obj = new Object[]{userId};
		UsersBean usersBean = null;
		try {
			usersBean = runner.query(sql, new BeanHandler<UsersBean>(UsersBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usersBean.getUserPwd();
	}

	

}
