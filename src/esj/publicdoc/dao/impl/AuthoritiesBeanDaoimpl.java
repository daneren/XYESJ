package esj.publicdoc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.back.control.authoritie.dao.impl.AuthoritiesBeanDaoImpl;
import esj.publicdoc.bean.AuthoritiesBean;
import esj.publicdoc.dao.AuthoritiesBeanDao;
import esj.util.JdbcSourceUtil;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:28:06
 * @最后修改时间 2016-6-25 下午5:28:06
 * @描述 权限表操作
 * @version 1.0
 */
public class AuthoritiesBeanDaoimpl implements AuthoritiesBeanDao {

	public int saveAuthorities(AuthoritiesBean authority) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO authorities(authName,menuList,state) VALUES(?,?,?);";
		Object[] obj = new Object[]{authority.getAuthName(),authority.getMenuList(),authority.getState()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<AuthoritiesBean> findAllAuthorities() {
		/*QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from authorities;";
		List<AuthoritiesBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<AuthoritiesBean>(AuthoritiesBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return new AuthoritiesBeanDaoImpl().getAllAuthoritiesInfo();
	}
/**
 * 修改权限的状态 
 */
	public int changeAuthorityState(AuthoritiesBean authoritiesBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update authorities set state =?  where authId = ?";
		Object[] obj = new Object[]{authoritiesBean.getState(),authoritiesBean.getAuthId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateAuthorities(AuthoritiesBean authoritiesBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update authorities set authName = ?,menuList = ? where authId=?;";
		int count = 0;
		Object[] obj = new Object[]{authoritiesBean.getAuthName(),authoritiesBean.getMenuList(),authoritiesBean.getAuthId()};
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public AuthoritiesBean findAuthoritiesById(Integer id) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from authorities where authId = ?;";
		Object[] obj = new Object[]{id};
		AuthoritiesBean bean = null;
		try {
			bean = runner.query(sql, new BeanHandler<AuthoritiesBean>(AuthoritiesBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	

}
