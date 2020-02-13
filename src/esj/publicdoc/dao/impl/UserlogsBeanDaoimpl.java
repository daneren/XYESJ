package esj.publicdoc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.publicdoc.bean.UserlogsBean;
import esj.publicdoc.dao.UserlogsBeanDao;
import esj.util.JdbcSourceUtil;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:31:55
 * @最后修改时间 2016-6-25 下午5:31:55
 * @描述 用户登录日志操作类
 * @version 1.0
 */
public class UserlogsBeanDaoimpl implements UserlogsBeanDao {

	public int saveUserlogs(UserlogsBean userlogsBean) {
		// TODO Auto-generated method stub
			
			QueryRunner runner = JdbcSourceUtil.getQueryRunner();
			String sql = "INSERT INTO userlogs( ulogId,userId,ip,ipAddr,textAddr) VALUES (?,?,?,?,?);";
			Object[] obj = new Object[]{
					userlogsBean.getUlogId(),
					userlogsBean.getUserId(),
					userlogsBean.getIp(),
					userlogsBean.getIpAddr(),
					userlogsBean.getTextAddr()
			};
			int count = 0;
			try {
				count = runner.update(sql,obj);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
	}

	public List<UserlogsBean> findAllAdminlogs() {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from userlogs;";
		List<UserlogsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<UserlogsBean>(UserlogsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int removeUserlogs(UserlogsBean userlogsBean) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	public int updateUserlogs(UserlogsBean userlogsBean) {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		
		String sql = "UPDATE userlogs set userId=?,ip=?,ipAddr=?,textAddr=? where ulogId = ?";
		
		Object[] obj = new Object[]{
				userlogsBean.getUserId(),
				userlogsBean.getIp(),
				userlogsBean.getIpAddr(),
				userlogsBean.getTextAddr(),
				userlogsBean.getUlogId()
		};
		
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public UserlogsBean findUserlogsById(String id) {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from userlogs where ulogId = '"+id+"'";
		UserlogsBean userlogsBean=null;
		try {
			
			userlogsBean=runner.query(sql, new BeanHandler<UserlogsBean>(UserlogsBean.class));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userlogsBean;
	}

	

}
