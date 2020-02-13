package esj.publicdoc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.publicdoc.bean.CollectsBean;
import esj.publicdoc.dao.CollectsBeanDao;
import esj.util.JdbcSourceUtil;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:29:04
 * @最后修改时间 2016-6-25 下午5:29:04
 * @描述 收藏表操作
 * @version 1.0
 */
public class CollectsBeanDaoimpl implements CollectsBeanDao {

	public int saveCollects(CollectsBean CollectsBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO collects(collectId,collects.userId,collects.proId,collects.bdate) values(?,?,?,?);";
		Object[] obj = new Object[]{CollectsBean.getCollectId(),CollectsBean.getUserId(),CollectsBean.getProId(),CollectsBean.getBdate()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<CollectsBean> findAllCollects() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from collects;";
		List<CollectsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<CollectsBean>(CollectsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int changeCollectState(CollectsBean CollectsBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update collects set state = ? where collectId = ?";
		Object[] obj = new Object[]{CollectsBean.getState(),CollectsBean.getCollectId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	


	public CollectsBean findCollectsById(String id) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from collects where collectId = ?;";
		Object[] obj = new Object[]{id};
		CollectsBean bean = null;
		try {
			bean = runner.query(sql, new BeanHandler<CollectsBean>(CollectsBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	
}
