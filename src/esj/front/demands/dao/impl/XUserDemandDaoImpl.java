package esj.front.demands.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.front.demands.dao.XUserDemandDao;
import esj.publicdoc.bean.LnotesBean;
import esj.publicdoc.bean.UserdemandsBean;
import esj.util.DateHelper;
import esj.util.JdbcSourceUtil;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-7-9 下午6:59:32
 * @最后修改时间 2016-7-9 下午6:59:32
 * @描述
 * @version 1.0
 */
public class XUserDemandDaoImpl implements XUserDemandDao {

	public List<UserdemandsBean> getUnsolveDemandsByUserid(String userId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		
		String sql = "select * from userdemands where userId = ? and state='待解决' order by demandId desc;";
		Object[] obj = new Object[]{userId};
		List<UserdemandsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<UserdemandsBean>(UserdemandsBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<UserdemandsBean> getNewUnsolveDemands() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String date = (Integer.parseInt(DateHelper.getDateTimeFormatDuan().replace("-", ""))-7)+"000000000";
		String sql = "select de.demandId,de.typeId,de.tagName,us.userName as userId,de.title,de.details,de.bdate,de.edate,de.state,de.photoAddr,de.remark from userdemands de ,users us where de.userId=us.userId and de.state='待解决' and demandId >='"+date+"' order by demandId desc;";
		
		List<UserdemandsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<UserdemandsBean>(UserdemandsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<UserdemandsBean> getNewGraduateUnsolveDemands() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select de.demandId,de.typeId,de.tagName,us.userName as userId,de.title,de.details,de.bdate,de.edate,de.state,de.photoAddr,de.remark from userdemands de ,users us where de.userId=us.userId and de.state='待解决' order by demandId desc;";
		
		List<UserdemandsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<UserdemandsBean>(UserdemandsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<UserdemandsBean> searchDemands(String keyWords) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		List<UserdemandsBean> list = new ArrayList<UserdemandsBean>();
		if(keyWords.contains(" ")){
			String[] keys = keyWords.split(" ");
			for(String key:keys){
				String sql = "select de.demandId,de.typeId,de.tagName,us.userName as userId,de.title,de.details,de.bdate,de.edate,de.state,de.photoAddr,de.remark from userdemands de ,users us where de.userId=us.userId and de.state='待解决' and title like '%"+key+"%' ORDER BY demandId desc;";
				try {
					
					list.addAll(runner.query(sql, new BeanListHandler<UserdemandsBean>(UserdemandsBean.class)));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			for(String key:keys){
				String sql = " select de.demandId,de.typeId,de.tagName,us.userName as userId,de.title,de.details,de.bdate,de.edate,de.state,de.photoAddr,de.remark from userdemands de ,users us where de.userId=us.userId and de.state='待解决' and  details like '%"+key+"%' ORDER BY demandId desc;";
				try {
					list.addAll(runner.query(sql, new BeanListHandler<UserdemandsBean>(UserdemandsBean.class)));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			for(String key:keys){
				String sql = "select de.demandId,de.typeId,de.tagName,us.userName as userId,de.title,de.details,de.bdate,de.edate,de.state,de.photoAddr,de.remark from userdemands de ,users us where de.userId=us.userId and de.state='待解决' and  tagName like '%"+key+"%' ORDER BY demandId desc;";
				try {
					list.addAll(runner.query(sql, new BeanListHandler<UserdemandsBean>(UserdemandsBean.class)));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else{
			String sql = "select de.demandId,de.typeId,de.tagName,us.userName as userId,de.title,de.details,de.bdate,de.edate,de.state,de.photoAddr,de.remark from userdemands de ,users us where de.userId=us.userId and de.state='待解决' and title like '%"+keyWords+"%' ORDER BY demandId desc;";
			try {
				list.addAll(runner.query(sql, new BeanListHandler<UserdemandsBean>(UserdemandsBean.class)));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String sql1 = "select de.demandId,de.typeId,de.tagName,us.userName as userId,de.title,de.details,de.bdate,de.edate,de.state,de.photoAddr,de.remark from userdemands de ,users us where de.userId=us.userId and de.state='待解决' and details like '%"+keyWords+"%' ORDER BY demandId desc;";
			try {
				list.addAll(runner.query(sql1, new BeanListHandler<UserdemandsBean>(UserdemandsBean.class)));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String sql2 = "select de.demandId,de.typeId,de.tagName,us.userName as userId,de.title,de.details,de.bdate,de.edate,de.state,de.photoAddr,de.remark from userdemands de ,users us where de.userId=us.userId and de.state='待解决' and tagName like '%"+keyWords+"%' ORDER BY demandId desc;";
			try {
				list.addAll(runner.query(sql2, new BeanListHandler<UserdemandsBean>(UserdemandsBean.class)));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		List<UserdemandsBean> productsBeanList= new ArrayList<UserdemandsBean>(new HashSet<UserdemandsBean>(list));  
	    
		
		
		return productsBeanList;
	}

	public List<LnotesBean> getLnotesBydemandId(String demandId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select ln.leaveId,ln.userId,ln.proId,ln.details,ln.bdate,ln.ip," +
				"ln.ipAddr,ln.state,us.userName as remark from lnotes ln,users us " +
				"where ln.userId = us.userId and ln.proId=? and ln.state='启用' order by ln.leaveId desc";
		Object[] obj = new Object[]{demandId};
		List<LnotesBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<LnotesBean>(LnotesBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
