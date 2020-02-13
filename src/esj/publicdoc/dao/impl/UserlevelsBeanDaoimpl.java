package esj.publicdoc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.publicdoc.bean.UserlevelsBean;
import esj.publicdoc.dao.UserlevelsBeanDao;
import esj.util.JdbcSourceUtil;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:31:30
 * @最后修改时间 2016-6-25 下午5:31:30
 * @描述 用户等级操作
 * @version 1.0
 */
public class UserlevelsBeanDaoimpl implements UserlevelsBeanDao {

	public int saveUserlevels(UserlevelsBean serlevelsBean) {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO userlevels(levelname,upperlimit) VALUES (?,?);";
		Object[] obj = new Object[]{
				serlevelsBean.getLevelName(),
				serlevelsBean.getUpperLimit()
		};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<UserlevelsBean> findAllAdminlogs() {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from userlevels;";
		List<UserlevelsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<UserlevelsBean>(UserlevelsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int changeStatesState(UserlevelsBean userlevelsBean) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	public int updateUserlevels(UserlevelsBean userlevelsBean) {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		
		String sql = "UPDATE userlevels set levelName=?,upperLimit=? where levelId = ?";
		
		Object[] obj = new Object[]{
				userlevelsBean.getLevelName(),
				userlevelsBean.getUpperLimit(),
				userlevelsBean.getLevelId()
		};
		
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public UserlevelsBean findUserlevelsById(Integer id) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from userlevels where levelId = "+id;
		UserlevelsBean serlevelsBean=null;
		try {
			
			serlevelsBean=runner.query(sql, new BeanHandler<UserlevelsBean>(UserlevelsBean.class));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return serlevelsBean;
	}

	

}
