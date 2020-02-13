package esj.publicdoc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.publicdoc.bean.UserdemandsBean;
import esj.publicdoc.bean.UsersBean;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:30:59
 * @最后修改时间 2016-6-25 下午5:30:59
 * @描述 用户需求 操作类
 * @version 1.0
 */
import esj.util.JdbcSourceUtil;


public class UserdemandsBeanDaoImpl implements esj.publicdoc.dao.UserdemandsBeanDao {

	public int saveUserdemands(UserdemandsBean userdemandsBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO userdemands( demandId,typeId,tagName,userId,title,details,bdate,edate,state,photoAddr) VALUES (?,?,?,?,?,?,?,?,?,?);";
		Object[] obj = new Object[]{
				userdemandsBean.getDemandId(),
				userdemandsBean.getTypeId(),
				userdemandsBean.getTagName(),
				userdemandsBean.getUserId(),
				userdemandsBean.getTitle(),
				userdemandsBean.getDetails(),
				userdemandsBean.getBdate(),
				userdemandsBean.getEdate(),
				userdemandsBean.getState(),
				userdemandsBean.getPhotoAddr()
		};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<UserdemandsBean> findAllUserdemands() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from userdemands;";
		List<UserdemandsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<UserdemandsBean>(UserdemandsBean.class));
			for(UserdemandsBean demand:list){
				String sql1 = "select * from users where userId ='"+demand.getUserId()+"'";
				UsersBean user = runner.query(sql1, new BeanHandler<UsersBean>(UsersBean.class));
				demand.setUserId(user.getUserName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int changeUserdemandsState(UserdemandsBean userdemandsBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		
		String sql = "UPDATE userdemands set  state=? ,edate =? where demandId = ?";
		
		Object[] obj = new Object[]{
				userdemandsBean.getState(),
				userdemandsBean.getEdate(),
				userdemandsBean.getDemandId()
		};
		
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateUserdemands(UserdemandsBean userdemandsBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		
		String sql = "UPDATE userdemands set "
				+ "tagName=?,title=?,details=?,edate=?,state=?,photoAddr=? "
				+ "where demandId = ?";
		
		Object[] obj = new Object[]{
				userdemandsBean.getTagName(),
				userdemandsBean.getTitle(),
				userdemandsBean.getDetails(),
				userdemandsBean.getEdate(),
				userdemandsBean.getState(),
				userdemandsBean.getPhotoAddr(),
				userdemandsBean.getDemandId()
		};
		
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public UserdemandsBean findUserdemandsById(String id) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from userdemands where demandId = ?;";
		Object[] obj = new Object[]{id};
		UserdemandsBean bean = null;
		try {
			bean = runner.query(sql, new BeanHandler<UserdemandsBean>(UserdemandsBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	

}
