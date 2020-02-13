package esj.publicdoc.service.impl;

import java.util.List;
import java.util.UUID;

import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.dao.UsersBeanDao;
import esj.publicdoc.dao.impl.UsersBeanDaoimpl;
import esj.publicdoc.service.UsersBeanService;
import esj.util.DateHelper;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:32:24
 * @最后修改时间 2016-6-25 下午5:32:24
 * @描述 用户表操作类
 * @version 1.0
 */
public class UsersBeanServiceimpl implements UsersBeanService {
private UsersBeanDao dao = new UsersBeanDaoimpl();

	public int saveUsers(UsersBean userBean) {
		userBean.setUserId(UUID.randomUUID().toString().replace("-", ""));
		userBean.setRigistDay(DateHelper.getDateTimeFormat());
		return dao.saveUsers(userBean);
	}

	public List<UsersBean> findAllUsers() {
		// TODO Auto-generated method stub
		return dao.findAllUsers();
	}

	

	public int updateUser(UsersBean userBean) {
		// TODO Auto-generated method stub
		return dao.updateUser(userBean);
	}

	public UsersBean findUserById(String id) {
		// TODO Auto-generated method stub
		return dao.findUserById(id);
	}

	public int changeUserState(UsersBean userBean) {
		// TODO Auto-generated method stub
		return dao.changeUserState(userBean);
	}

	


}
