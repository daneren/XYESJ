package esj.front.demands.dao.impl;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.front.demands.dao.PUserDemandDao;
import esj.publicdoc.bean.UserdemandsBean;
import esj.util.JdbcSourceUtil;

public class PUserDemandDaoimpl implements PUserDemandDao {

	public int updateDemand(UserdemandsBean userdemandsBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update userdemands set tagName=?,details=?,photoAddr=?,edate=? where demandId = ?;";
		Object[] obj = new Object[]{
				userdemandsBean.getTagName(),
				userdemandsBean.getDetails(),
				userdemandsBean.getPhotoAddr(),
				userdemandsBean.getEdate(),
				userdemandsBean.getDemandId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public List<UserdemandsBean> getsolvedDemandsByUserid(String userId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select ud.demandId,ud.typeId,ud.tagName," +
				"ud.userId,ud.title,ud.details,ud.bdate," +
				"ud.edate,ud.state,ud.photoAddr," +
				" pt.typeName AS remark from userdemands as ud,protypes AS pt " +
				"where ud.typeId = pt.typeId and ud.userId = ? and ud.state='已解决'  " +
				"order by ud.demandId desc;";
		Object[] obj = new Object[]{userId};
		List<UserdemandsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<UserdemandsBean>(UserdemandsBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<UserdemandsBean> getUnsolveDemandsByUserid(String userId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select ud.demandId,ud.typeId,ud.tagName," +
				"ud.userId,ud.title,ud.details,ud.bdate," +
				"ud.edate,ud.state,ud.photoAddr," +
				" pt.typeName AS remark from userdemands as ud,protypes AS pt " +
				"where ud.typeId = pt.typeId and ud.userId = ? and ud.state='待解决'  " +
				"order by ud.demandId desc;";
		Object[] obj = new Object[]{userId};
		List<UserdemandsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<UserdemandsBean>(UserdemandsBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	

}
