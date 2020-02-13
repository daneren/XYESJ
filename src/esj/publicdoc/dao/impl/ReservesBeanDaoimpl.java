package esj.publicdoc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.publicdoc.bean.ReservesBean;
import esj.publicdoc.dao.ReservesBeanDao;
import esj.util.JdbcSourceUtil;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:30:12
 * @最后修改时间 2016-6-25 下午5:30:12
 * @描述 预约表操作
 * @version 1.0
 */


public class ReservesBeanDaoimpl implements ReservesBeanDao {

	public int saveReserves(ReservesBean reservesBean) {
		
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO reserves( reservId,proId,buyerId,sellerId,buyerPrice,reservdate,cjdate,state,remark) VALUES (?,?,?,?,?,?,?,?,?);";
		Object[] obj = new Object[]{
				reservesBean.getReservId(),
				reservesBean.getProId(),
				reservesBean.getBuyerId(),
				reservesBean.getSellerId(),
				reservesBean.getBuyerPrice(),
				reservesBean.getReservdate(),
				reservesBean.getCjdate(),
				reservesBean.getState(),
				reservesBean.getRemark()
		};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<ReservesBean> findAllReserves() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from reserves;";
		List<ReservesBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<ReservesBean>(ReservesBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int removeReserves(ReservesBean reservesBean) {
		
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		
		String sql = "UPDATE reserves set  state=? where reservId = ?";
		
		Object[] obj = new Object[]{
				reservesBean.getState(),
				reservesBean.getReservId()
		};
		
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateReserves(ReservesBean reservesBean) {
		
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		
		String sql = "UPDATE reserves set buyerPrice=?,reservdate=?,cjdate=?,state=? where reservId = ?";
		
		Object[] obj = new Object[]{
				reservesBean.getBuyerPrice(),
				reservesBean.getReservdate(),
				reservesBean.getCjdate(),
				reservesBean.getState(),
				reservesBean.getReservId()
		};
		
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public ReservesBean findReservesById(String id) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from reserves where reservId = '"+id+"'";
		ReservesBean reservesBean=null;
		try {
			
			reservesBean=runner.query(sql, new BeanHandler<ReservesBean>(ReservesBean.class));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservesBean;
	}


}
