package esj.front.products.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.front.products.dao.XLnotesDao;
import esj.publicdoc.bean.LnotesBean;
import esj.util.JdbcSourceUtil;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-7-13 上午11:56:13
 * @最后修改时间 2016-7-13 上午11:56:13
 * @描述
 * @version 1.0
 */
public class XLnotesDaoImpl implements XLnotesDao{

	public List<LnotesBean> getLnotesByProId(String proId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select ln.leaveId,ln.userId,ln.proId,ln.details,ln.bdate,ln.ip," +
				"ln.ipAddr,ln.state,us.userName as remark from lnotes ln,users us " +
				"where ln.userId = us.userId and ln.proId=? and ln.state='启用' order by ln.leaveId desc";
		Object[] obj = new Object[]{proId};
		List<LnotesBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<LnotesBean>(LnotesBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public String getByProId(String proId, String userId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select  remark from lnotes where userId = ? and proId = ?";
		Object[] obj = new Object[]{userId,proId};
		String scores = "";
		LnotesBean lBean = null;
		try {
			lBean = runner.query(sql, new BeanHandler<LnotesBean>(LnotesBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(lBean!=null){
			return lBean.getRemark();
		}else{
			return "";
		}
		
	}

}
