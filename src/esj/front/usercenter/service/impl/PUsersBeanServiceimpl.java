package esj.front.usercenter.service.impl;

import esj.front.usercenter.dao.PUsersBeanDao;
import esj.front.usercenter.dao.impl.PUsersBeanDaoimpl;
import esj.front.usercenter.service.PUsersBeanService;
import esj.publicdoc.bean.UsersBean;

public class PUsersBeanServiceimpl implements PUsersBeanService {
	private PUsersBeanDao pUsersBeanDao = new PUsersBeanDaoimpl();
	public int updateUserMsg(UsersBean usersBean) {
		if(usersBean == null){
			return -1;
		}
		return pUsersBeanDao.updateUserMsg(usersBean);
	}
	public int updateUserPwd(String npwd, String userId) {
		if(npwd.equals("") || userId.equals("") || npwd == null || userId== null){
			return -1;
		}
		return pUsersBeanDao.updatePwd(userId, npwd);
	}
	public int updatePhone(String userId, String userPhone) {
		if(userId.equals("") || userPhone.equals("") || userPhone == null || userId== null){
			return -1;
		}
		return pUsersBeanDao.updatePhone(userId, userPhone);
	}

}
