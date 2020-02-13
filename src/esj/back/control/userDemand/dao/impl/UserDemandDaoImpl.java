package esj.back.control.userDemand.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import esj.back.control.userDemand.dao.UserDemandDao;
import esj.publicdoc.bean.UserdemandsBean;
import esj.util.JdbcSourceUtil;



public class UserDemandDaoImpl implements UserDemandDao {

	public int deleteUserDemand(UserdemandsBean bean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "delete from userdemands where demandId = ?;";
		Object[] obj = new Object[]{bean.getDemandId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
