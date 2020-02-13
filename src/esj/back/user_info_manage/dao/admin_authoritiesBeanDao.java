package esj.back.user_info_manage.dao;

import java.util.List;

import esj.publicdoc.bean.AuthoritiesBean;
import esj.publicdoc.bean.MenusBean;

public interface admin_authoritiesBeanDao {
	public List<MenusBean> findmenuname(String menulist);

}
