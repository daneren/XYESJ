package esj.publicdoc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.publicdoc.bean.AdminlogsBean;
import esj.publicdoc.dao.AdminlogsBeanDao;
import esj.util.JdbcSourceUtil;

/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:27:21
 * @����޸�ʱ�� 2016-6-25 ����5:27:21
 * @���� ����Ա��־�������
 * @version 1.0
 */
public class AdminlogsBeanDaoimpl implements AdminlogsBeanDao{
	public int saveAdminLogs(AdminlogsBean adminlogsBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO adminlogs(alogId,adminId,time,ip,ipAddr,textAddr) VALUES (?,?,?,?,?,?);";
		Object[] obj = new Object[]{adminlogsBean.getAlogId(),adminlogsBean.getAdminId(),adminlogsBean.getTime(),adminlogsBean.getIp(),adminlogsBean.getIpAddr(),adminlogsBean.getTextAddr()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<AdminlogsBean> findAllAdminlogs() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from adminlogs;";
		List<AdminlogsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<AdminlogsBean>(AdminlogsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public AdminlogsBean findAdminlogsByLogId(String id) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from adminlogs where alogId = ?;";
		Object[] obj = new Object[]{id};
		AdminlogsBean bean = null;
		try {
			bean = runner.query(sql, new BeanHandler<AdminlogsBean>(AdminlogsBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	

}
