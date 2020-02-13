package esj.front.products.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.front.products.dao.XProTypeDao;
import esj.publicdoc.bean.ProtypesBean;
import esj.util.JdbcSourceUtil;

public class XProTypeDaoImpl implements XProTypeDao {

	

	public List<ProtypesBean> getProtypesByfatherid(int fid) {
		List<ProtypesBean> beans = null;
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from protypes where fatherId = ? ";
		Object[] obj = new Object[]{fid};
		try {
			beans = runner.query(sql, new BeanListHandler<ProtypesBean>(ProtypesBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beans;
	}

}
