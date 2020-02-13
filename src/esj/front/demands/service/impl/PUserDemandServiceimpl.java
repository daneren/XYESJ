package esj.front.demands.service.impl;

import java.util.List;

import esj.front.demands.dao.PUserDemandDao;
import esj.front.demands.dao.impl.PUserDemandDaoimpl;
import esj.front.demands.service.PUserDemandService;
import esj.publicdoc.bean.UserdemandsBean;

public class PUserDemandServiceimpl implements PUserDemandService{
	PUserDemandDao pUserDemandDao = new PUserDemandDaoimpl();
	public int updateDemand(UserdemandsBean userdemandsBean) {
		if(userdemandsBean == null){
			return -1;
		}
		return pUserDemandDao.updateDemand(userdemandsBean);
	}
	
	public List<UserdemandsBean> getUnsolveDemandsByUserid(String userId) {
		if(userId == null || "".equals(userId)){
			return null;
		}
		return pUserDemandDao.getUnsolveDemandsByUserid(userId);
	}

	public List<UserdemandsBean> getsolvedDemandsByUserid(String userId) {
		if(userId == null || "".equals(userId)){
			return null;
		}
		return pUserDemandDao.getsolvedDemandsByUserid(userId);
	}

}
