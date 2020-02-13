package esj.publicdoc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.publicdoc.bean.BroadcastsBean;
import esj.publicdoc.dao.BroadcastsBeanDao;
import esj.util.JdbcSourceUtil;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:46:10
 * @最后修改时间 2016-6-25 下午5:46:10
 * @描述 公告表操作
 * @version 1.0
 */
public class BroadcastsBeanDaoimpl implements BroadcastsBeanDao {

	public int saveBroadcasts(BroadcastsBean broadcast) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO broadcasts(broadcastId,broadcasts.details,broadcasts.imgurl) VALUES(?,?,?);";
		Object[] obj = new Object[]{broadcast.getBroadcastId(),broadcast.getDetails(),broadcast.getImgurl()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<BroadcastsBean> findAllBroadcasts() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from broadcasts;";
		List<BroadcastsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<BroadcastsBean>(BroadcastsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int changeBroadcastState(BroadcastsBean broadcastsBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update broadcasts set state= ? where broadcastId = ?";
		Object[] obj = new Object[]{broadcastsBean.getState(),broadcastsBean.getBroadcastId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateBroadcasts(BroadcastsBean broadcastsBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update broadcasts set details = ?,imgurl = ? where broadcastId=?;";
		Object[] obj = new Object[]{broadcastsBean.getDetails(),broadcastsBean.getImgurl(),broadcastsBean.getBroadcastId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public BroadcastsBean findBroadcastsById(String id) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from broadcasts where broadcastId = ?;";
		Object[] obj = new Object[]{id};
		BroadcastsBean bean = null;
		try {
			bean = runner.query(sql, new BeanHandler<BroadcastsBean>(BroadcastsBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	

}
