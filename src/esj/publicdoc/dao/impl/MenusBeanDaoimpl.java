package esj.publicdoc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.publicdoc.bean.MenusBean;
import esj.publicdoc.dao.MenusBeanDao;
import esj.util.JdbcSourceUtil;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:29:32
 * @最后修改时间 2016-6-25 下午5:29:32
 * @描述 菜单表操作
 * @version 1.0
 */
public class MenusBeanDaoimpl implements MenusBeanDao {

	public int saveMenus(MenusBean bean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO menus(menuName,menuURL) VALUES(?,?);";
		Object[] obj = new Object[]{bean.getMenuName(),bean.getMenuUrl()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<MenusBean> findAllMenus() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from menus;";
		List<MenusBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<MenusBean>(MenusBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int changeMenusState(MenusBean MenusBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update lnotes set state =? where menuId = ?;";
		Object[] obj = new Object[]{MenusBean.getState(),MenusBean.getMenuId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateMenus(MenusBean MenusBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update lnotes set menuName =?,menuURL=? where menuId = ?;";
		Object[] obj = new Object[]{MenusBean.getMenuName(),MenusBean.getMenuUrl(),MenusBean.getMenuId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public MenusBean findMenusById(Integer id) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from broadcasts where broadcastId = ?;";
		Object[] obj = new Object[]{id};
		MenusBean bean = null;
		try {
			bean = runner.query(sql, new BeanHandler<MenusBean>(MenusBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}


}
