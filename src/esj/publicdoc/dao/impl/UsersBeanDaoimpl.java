package esj.publicdoc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.dao.UsersBeanDao;
import esj.util.JdbcSourceUtil;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:32:24
 * @最后修改时间 2016-6-25 下午5:32:24
 * @描述 用户表操作类
 * @version 1.0
 */
public class UsersBeanDaoimpl implements UsersBeanDao {

	public int saveUsers(UsersBean userBean) {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO users( userId,userName,userPwd,rigistDay,email,state) VALUES (?,?,?,?,?,?);";
		Object[] obj = new Object[]{
				userBean.getUserId(),
				userBean.getUserName(),
				userBean.getUserPwd(),
				userBean.getRigistDay(),
				userBean.getEmail(),"1"
		};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<UsersBean> findAllUsers() {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from users;";
		List<UsersBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<UsersBean>(UsersBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int changeUserState(UsersBean userBean) {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		
		String sql = "UPDATE users set  state=? where userId = ?";
		
		Object[] obj = new Object[]{
				userBean.getState(),
				userBean.getUserId()
		};
		
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public int updateUser(UsersBean userBean) {
		// TODO Auto-generated method stub
QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		
		String sql = "UPDATE users set userPhone=?,userName=?,userPwd=?,rigistDay=?,sex=?,birthDay=?,school=?" +
				"department=?,major=?,entranceDay=?,state=?,empirical=?,creditPoints=?,iconAddr=?,email=?,remark=? where userId = ?";
		
		Object[] obj = new Object[]{
				userBean.getUserPhone(),
				
				userBean.getUserName(),
				userBean.getUserPwd(),
				userBean.getRigistDay(),
				userBean.getSex(),
				userBean.getBirthDay(),
				userBean.getSchool(),
				userBean.getDepartment(),
				userBean.getMajor(),
				userBean.getEntranceDay(),
				userBean.getState(),
				userBean.getEmpirical(),
				userBean.getCreditPoints(),
				userBean.getIconAddr(),
				userBean.getEmail(),
				userBean.getRemark(),
				userBean.getUserId()
		};
		
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public UsersBean findUserById(String id) {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from users where userId = '"+id+"'";
		UsersBean userBean=null;
		try {
			
			userBean=runner.query(sql, new BeanHandler<UsersBean>(UsersBean.class));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userBean;
	}



	

}
