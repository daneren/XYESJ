package esj.front.usercenter.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.front.usercenter.bean.ProCommBean;
import esj.front.usercenter.dao.PReservesBeanDao;
import esj.publicdoc.bean.ReservesBean;
import esj.publicdoc.bean.UsersBean;
import esj.util.JdbcSourceUtil;

public class PReservesBeanDaoimpl implements PReservesBeanDao {

	public List<ProCommBean> getPriceSum(String buyerId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "SELECT state as rstate ,COUNT(proId)as remark,sum(buyerPrice) as buyerPrice  " +
				"FROM reserves where buyerId = ? GROUP  BY state;";
		List<ProCommBean> pBeans = null;
		try {
			pBeans = runner.query(sql, new BeanListHandler<ProCommBean>(ProCommBean.class),buyerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pBeans;
	}

	public List<ProCommBean> getUserReserve(String buyerId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "SELECT r.proId, p.title,r.sellerId,p.photoAddr," +
				"r.buyerPrice,r.reservId,p.cprice,p.dprice,p.oprice " +
				"FROM  reserves as r, products as p   " +
				"where r.proId = p.proId AND r.buyerId = ?  AND r.state = '预约中'   " +
				"ORDER BY r.reservdate desc";
		//System.out.println(sql);
		List<ProCommBean> pBeans = null;
		try {
			pBeans = runner.query(sql, new BeanListHandler<ProCommBean>(ProCommBean.class),buyerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pBeans;
	}

	public List<ProCommBean> getUserBuy(String buyerId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "SELECT r.proId, p.title,r.sellerId,p.photoAddr," +
				"r.buyerPrice,r.cjdate,r.reservId " +
				"FROM reserves as r, products as p   " +
				"where r.proId = p.proId AND r.buyerId = ?  AND r.state ='交易达成' " +
				"ORDER BY r.cjdate desc";
		List<ProCommBean> pBeans = null;
		try {
			pBeans = runner.query(sql, new BeanListHandler<ProCommBean>(ProCommBean.class),buyerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pBeans;
	}
	
	public List<ProCommBean> getSellerDealing(String sellerId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "SELECT r.reservId,r.proId, p.title,p.dprice," +
				" r.buyerPrice , u.userName,u.userPhone as pstate,u.email as ruCount,r.remark,r.reservdate as bdate " +
				" FROM reserves as r, products as p   ,users AS u " +
				" where r.proId = p.proId AND r.buyerId = u.userId  AND r.sellerId = ?" +
				"  AND r.state = '交易中'  " +
				" ORDER BY r.reservdate desc";
		List<ProCommBean> pBeans = null;
		try {
			pBeans = runner.query(sql, new BeanListHandler<ProCommBean>(ProCommBean.class),sellerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pBeans;
	}


	public List<ProCommBean> getBuyerDealing(String buyerId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "SELECT r.reservId,r.proId, p.title,p.dprice," +
				" r.buyerPrice , u.userName,u.userPhone as pstate,u.email as ruCount,r.remark,r.reservdate as bdate " +
				" FROM reserves as r, products as p   ,users AS u " +
				" where r.proId = p.proId AND r.sellerId = u.userId  AND r.buyerId = ?" +
				"  AND r.state = '交易中'  " +
				" ORDER BY r.reservdate desc";
		List<ProCommBean> pBeans = null;
		try {
			pBeans = runner.query(sql, new BeanListHandler<ProCommBean>(ProCommBean.class),buyerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pBeans;
	}
	
	public List<ProCommBean> getAllReserved(String sellerId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "SELECT r.proId,p.title,p.bdate,p.edate AS cjdate,p.dprice," +
				" COUNT(r.buyerId) AS ruCount  " +
				"	FROM reserves AS r " +
				"LEFT JOIN products AS p ON p.proId = r.proId" +
				" where r.sellerId = ?" +
				" AND r.state = '预约中'  " +
				"GROUP BY r.proId" +
				" ORDER BY p.bdate desc;";
		List<ProCommBean> pBeans = null;
		try {
			pBeans = runner.query(sql, new BeanListHandler<ProCommBean>(ProCommBean.class),sellerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pBeans;
	}

	public List<ReservesBean> getDetailReserved(String proId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "SELECT r.reservId,r.proId,r.buyerId,u.userName AS state, r.remark," +
				"r.buyerPrice,r.reservdate " +
				" FROM reserves AS r  " +
				"LEFT JOIN users AS u ON r.buyerId = u.userId " +
				"where r.proId = ? " +
				"ORDER BY buyerPrice ";
		List<ReservesBean> rBeans = null;
		try {
			rBeans = runner.query(sql, new BeanListHandler<ReservesBean>(ReservesBean.class),proId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rBeans;
	}

	public int updateReserveState(String reserveId,String state) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "UPDATE reserves SET state = ? WHERE reservId = ?";
		Object[] params = {state,reserveId};
		int count = 0;
		try {
			count = runner.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	public int updateTurndownReserve(String proId, String ostate, String nstate) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "UPDATE reserves SET state = ? WHERE proId = ? and state = ?";
		Object[] params = {nstate,proId,ostate};
		int count = 0;
		try {
			count = runner.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	public ReservesBean getUserMag(String reserveId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "SELECT r.buyerPrice,u.userName AS buyerId,u.email AS sellerId,p.proId,p.title AS remark " +
				"FROM reserves as r " +
				"LEFT JOIN users  as u ON r.buyerId = u.userId " +
				"LEFT JOIN products as p ON p.proId = r.proId " +
				"WHERE reservId = ? ";
		ReservesBean rBeans = null;
		try {
			rBeans = runner.query(sql, new BeanHandler<ReservesBean>(ReservesBean.class),reserveId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rBeans;
	}

	public ReservesBean getSellerMag(String reserveId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "SELECT r.buyerPrice,u.userName AS buyerId,u.email AS sellerId,p.proId,p.title AS remark " +
				"FROM reserves as r " +
				"LEFT JOIN users  as u ON r.sellerId = u.userId " +
				"LEFT JOIN products as p ON p.proId = r.proId " +
				"WHERE reservId = ? ";
		ReservesBean rBeans = null;
		try {
			rBeans = runner.query(sql, new BeanHandler<ReservesBean>(ReservesBean.class),reserveId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rBeans;
	}


}
