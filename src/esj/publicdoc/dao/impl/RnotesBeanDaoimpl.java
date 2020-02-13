package esj.publicdoc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.publicdoc.bean.RnotesBean;
import esj.publicdoc.dao.RnotesBeanDao;
import esj.util.JdbcSourceUtil;
/**回复表  实现类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:30:23
 * @最后修改时间 2016-6-25 下午5:30:23
 * @描述 回复操作类
 * @version 1.0
 */


public class RnotesBeanDaoimpl implements RnotesBeanDao {

	public int saveRnotes(RnotesBean rnotesBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO rnotes( replyId,userId,leaveId,details,bdate,ip,ipAddr,state) VALUES (?,?,?,?,?,?,?,?);";
		Object[] obj = new Object[]{
				rnotesBean.getReplyId(),
				rnotesBean.getUserId(),
				rnotesBean.getLeaveId(),
				rnotesBean.getDetails(),
				rnotesBean.getBdate(),
				rnotesBean.getIp(),
				rnotesBean.getIpAddr(),
				rnotesBean.getState()
		};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<RnotesBean> findAllRnotes() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from rnotes;";
		List<RnotesBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<RnotesBean>(RnotesBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int changeRnotesState(RnotesBean rnotesBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		
		String sql = "UPDATE rnotes set  state=? where replyId = ?";
		
		Object[] obj = new Object[]{
				rnotesBean.getState(),
				rnotesBean.getReplyId()
		};
		
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateRnotes(RnotesBean rnotesBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		
		String sql = "UPDATE rnotes set details=?,bdate=?,state=? where replyId = ?";
		
		Object[] obj = new Object[]{
				rnotesBean.getDetails(),
				rnotesBean.getBdate(),
				rnotesBean.getState(),
				rnotesBean.getReplyId()
		};
		
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public RnotesBean findRnotesById(String id) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from rnotes where replyId = '"+id+"'";
		RnotesBean rnotesBean=null;
		try {
			
			rnotesBean=runner.query(sql, new BeanHandler<RnotesBean>(RnotesBean.class));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rnotesBean;
	}


}
