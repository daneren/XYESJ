package esj.publicdoc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.publicdoc.bean.ProtypesBean;
import esj.publicdoc.dao.ProtypesBeanDao;
import esj.util.JdbcSourceUtil;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:29:58
 * @最后修改时间 2016-6-25 下午5:29:58
 * @描述 类别表操作
 * @version 1.0
 */
public class ProtypesBeanDaoimpl implements ProtypesBeanDao {

	public int saveProtypes(ProtypesBean bean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO protypes(typeName,fatherId,childId) VALUES(?,?,?);";
		Object[] obj = new Object[]{bean.getTypeName(),bean.getFatherId(),bean.getChildId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<ProtypesBean> findAllProtypes() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from protypes;";
		List<ProtypesBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<ProtypesBean>(ProtypesBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int removeProtypes(ProtypesBean bean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "delete from protypes where typeId = ?;";
		Object[] obj = new Object[]{bean.getTypeId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateProtypes(ProtypesBean bean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update lnotes set typeName =?,fatherId=?,childId=? where typeId = ?;";
		Object[] obj = new Object[]{bean.getTypeName(),bean.getFatherId(),bean.getChildId(),bean.getTypeId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public ProtypesBean findProtypesById(Integer id) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from protypes where typeId = ?;";
		Object[] obj = new Object[]{id};
		ProtypesBean bean = null;
		try {
			bean = runner.query(sql, new BeanHandler<ProtypesBean>(ProtypesBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	

}
