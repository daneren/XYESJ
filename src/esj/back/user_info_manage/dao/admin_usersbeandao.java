package esj.back.user_info_manage.dao;

import java.util.List;

import esj.back.bean.coutsbean;
import esj.publicdoc.bean.UsersBean;

public interface admin_usersbeandao {
	public int userschangestate(UsersBean userBean);
	public List<UsersBean> blacklistUsers();
	public UsersBean findUserByName(String name);
	public coutsbean coutpproduct(String id);
	public coutsbean coutpdemands(String id);
	public coutsbean coutbproduct(String id);
	public coutsbean coutrproduct(String id);
}
