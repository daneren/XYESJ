package esj.front.usercenter.service.impl;

import java.util.List;

import esj.front.usercenter.bean.ProCommBean;
import esj.front.usercenter.dao.PCollectsBeanDao;
import esj.front.usercenter.dao.impl.PCollectsBeanDaoimpl;
import esj.front.usercenter.service.PCollectsBeanService;

public class PCollectsBeanServiceimpl implements PCollectsBeanService {
	private PCollectsBeanDao pCollectsBeanDao = new PCollectsBeanDaoimpl();
	
	public List<ProCommBean> getUCollects(String buyerId) {
		if(buyerId.equals("") || buyerId ==  null){
			return null;
		}
		return pCollectsBeanDao.getUCollects(buyerId);
	}

	public List<ProCommBean> getProData(String buyerId) {
		if(buyerId.equals("") || buyerId ==  null){
			return null;
		}
		return pCollectsBeanDao.getProData(buyerId);
	}

}
