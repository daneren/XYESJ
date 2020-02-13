package esj.front.usercenter.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import esj.front.usercenter.dao.XUserLogsDao;
import esj.publicdoc.bean.UserlogsBean;
import esj.util.JdbcSourceUtil;

public class XUserLogsDaoImpl implements XUserLogsDao {

	public String getlogfileNameByLogsId(String logsId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from userlogs where ulogId = '"+logsId+"'";
		UserlogsBean userlogsBean=null;
		try {
			userlogsBean=runner.query(sql, new BeanHandler<UserlogsBean>(UserlogsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userlogsBean.getTextAddr();
	}

	
}
