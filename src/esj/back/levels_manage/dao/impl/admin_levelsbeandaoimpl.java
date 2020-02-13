package esj.back.levels_manage.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import esj.back.levels_manage.dao.admin_levelsbeandao;
import esj.publicdoc.bean.UserlevelsBean;
import esj.util.JdbcSourceUtil;

public class admin_levelsbeandaoimpl implements admin_levelsbeandao{

	public int addlevels(UserlevelsBean serserlevelsBean) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deletelevels(UserlevelsBean serserlevelsBean) {
		// TODO Auto-generated method stub
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "delete from userlevels where levelId = ?;";
		Object[] obj = new Object[]{serserlevelsBean.getLevelId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updatelevels(UserlevelsBean serserlevelsBean) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int searchlevels(UserlevelsBean serserlevelsBean) {
		// TODO Auto-generated method stub
	
		return 0;
	}

}
