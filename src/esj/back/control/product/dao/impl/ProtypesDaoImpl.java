package esj.back.control.product.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import esj.back.control.product.dao.ProtypesDao;
import esj.publicdoc.bean.ProtypesBean;
import esj.util.JdbcSourceUtil;

public class ProtypesDaoImpl implements ProtypesDao {

	public int addProtypes(ProtypesBean bean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO protypes(typeName,fatherId) VALUES(?,?);";
		Object[] obj = new Object[]{bean.getTypeName(),bean.getFatherId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateProtypesChildID(ProtypesBean bean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update protypes set childId=? where typeId = ?;";
		Object[] obj = new Object[]{bean.getChildId(),bean.getTypeId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public ProtypesBean findProtypesByName(ProtypesBean bean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from protypes where typeName = ?;";
		Object[] obj = new Object[]{bean.getTypeName()};
		ProtypesBean bean2 = null;
		try {
			bean2 = runner.query(sql, new BeanHandler<ProtypesBean>(ProtypesBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean2;
	}

	public int updateProtypes(ProtypesBean bean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update protypes set typeName =?,fatherId=? where typeId = ?;";
		Object[] obj = new Object[]{bean.getTypeName(),bean.getFatherId(),bean.getTypeId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
