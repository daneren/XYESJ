package esj.publicdoc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.publicdoc.bean.LnotesBean;
import esj.publicdoc.dao.LnotesBeanDao;
import esj.util.JdbcSourceUtil;

/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:29:18
 * @����޸�ʱ�� 2016-6-25 ����5:29:18
 * @���� ���Ա����
 * @version 1.0
 */
public class LnotesBeanDaoimpl implements LnotesBeanDao {

	public int saveLnotes(LnotesBean lnotesBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		if(lnotesBean.getRemark()==null){
			lnotesBean.setRemark("");
		}
		String sql = "INSERT INTO lnotes(leaveId,userId,proId,details,bdate,ip,ipAddr,state,remark) VALUES(?,?,?,?,?,?,?,?,?);";
		Object[] obj = new Object[]{lnotesBean.getLeaveId(),lnotesBean.getUserId(),lnotesBean.getProId(),lnotesBean.getDetails(),lnotesBean.getBdate(),lnotesBean.getIp(),lnotesBean.getIpAddr(),lnotesBean.getState(),lnotesBean.getRemark()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<LnotesBean> findAllLnotes() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from lnotes;";
		List<LnotesBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<LnotesBean>(LnotesBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int changeLnotesState(LnotesBean lnotesBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update lnotes set state =? where leaveId = ?;";
		Object[] obj = new Object[]{lnotesBean.getState(),lnotesBean.getLeaveId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
/**
 * �޸����Ե�����
 */
	public int updateLnotes(LnotesBean lnotesBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update lnotes set details =? where leaveId = ?;";
		Object[] obj = new Object[]{lnotesBean.getDetails(),lnotesBean.getLeaveId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public LnotesBean findLnotesById(String id) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from lnotes where broadcastId = ?;";
		Object[] obj = new Object[]{id};
		LnotesBean bean = null;
		try {
			bean = runner.query(sql, new BeanHandler<LnotesBean>(LnotesBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	

}
