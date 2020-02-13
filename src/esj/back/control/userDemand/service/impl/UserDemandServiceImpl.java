package esj.back.control.userDemand.service.impl;

import esj.back.control.userDemand.dao.UserDemandDao;
import esj.back.control.userDemand.dao.impl.UserDemandDaoImpl;
import esj.back.control.userDemand.service.UserDemandService;
import esj.publicdoc.bean.UserdemandsBean;

public class UserDemandServiceImpl implements UserDemandService {

	public int deleteUserDemand(UserdemandsBean bean) {
		UserDemandDao dao= new UserDemandDaoImpl();
		int flag=0;
		flag=dao.deleteUserDemand(bean);
		
		return flag;
		
		
	}


}
