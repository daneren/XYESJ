package esj.publicdoc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.publicdoc.bean.StatesBean;
import esj.publicdoc.dao.StatesBeanDao;
import esj.util.JdbcSourceUtil;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:30:40
 * @最后修改时间 2016-6-25 下午5:30:40
 * @描述 状态表操作类
 * @version 1.0
 */


public class StatesBeanDaoimpl implements StatesBeanDao {

	public int saveStates(StatesBean statesBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO states(stateName,state) VALUES (?,?);";
		Object[] obj = new Object[]{
				statesBean.getStateName(),
				statesBean.getState(),
		};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<StatesBean> findAllStates() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from states;";
		List<StatesBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<StatesBean>(StatesBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int changeStatesState(StatesBean statesBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		
		String sql = "UPDATE states set  state=? where stateId = ?";
		
		Object[] obj = new Object[]{
				statesBean.getState(),
				statesBean.getStateId()
		};
		
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateStates(StatesBean statesBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();

		String sql = "UPDATE states set stateName=?,state=? where stateId = ?";
		
		Object[] obj = new Object[]{
				statesBean.getStateName(),
				statesBean.getState(),
				statesBean.getStateId()
				
		};
		
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public StatesBean findStatesById(Integer id) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from reserves where stateId = "+id;
		StatesBean statesBean=null;
		try {
			
			statesBean=runner.query(sql, new BeanHandler<StatesBean>(StatesBean.class));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statesBean;
	}

	
}
