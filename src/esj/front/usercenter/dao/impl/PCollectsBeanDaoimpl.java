package esj.front.usercenter.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.front.usercenter.bean.ProCommBean;
import esj.front.usercenter.dao.PCollectsBeanDao;
import esj.util.JdbcSourceUtil;

public class PCollectsBeanDaoimpl implements PCollectsBeanDao {

	public List<ProCommBean> getUCollects(String buyerId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "SELECT p.proId,p.photoAddr,p.title, " +
				" p.details,p.cprice, c.collectId, p.dprice,p.oprice," +
				" p.state as pstate,c.bdate,cu.cuCount,ru.ruCount " +
				" FROM (SELECT COUNT(cc.userId)AS cuCount,cc.proId  " +
						"FROM collects as cc  GROUP BY cc.proId) AS cu, " +
				"collects AS c " +
				"LEFT JOIN (SELECT COUNT(rr.buyerId)AS ruCount,rr.proId  " +
							"FROM reserves as rr  GROUP BY rr.proId) AS ru ON c.proId = ru.proId " +
				"LEFT JOIN products AS p ON c.proId = p.proId " +
				"WHERE c.userId =?" +
				"AND c.state = '∆Ù”√' AND c.proId = cu.proId ;";
		//System.out.println(sql);
		List<ProCommBean> pBeans = null;
		try {
			pBeans = runner.query(sql, new BeanListHandler<ProCommBean>(ProCommBean.class),buyerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pBeans;
	}

	public List<ProCommBean> getProData(String buyerId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "SELECT COUNT(r.buyerId) AS ruCount,r.proId," +
				" COUNT(c.userId) AS cuCount " +
				" from reserves as r,collects as c " +
				" where r.proId = c.proId AND r.proId IN( " +
				" SELECT proId FROM collects WHERE buyerId = ?)" +
				" GROUP BY r.proId ORDER BY r.proId;";
		//System.out.println(sql);
		List<ProCommBean> pBeans = null;
		try {
			pBeans = runner.query(sql, new BeanListHandler<ProCommBean>(ProCommBean.class),buyerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pBeans;
	}

}
