package esj.front.demands.service.impl;

import java.util.List;

import esj.front.demands.dao.impl.XUserDemandDaoImpl;
import esj.front.demands.service.XUserDemandService;
import esj.publicdoc.bean.LnotesBean;
import esj.publicdoc.bean.UserdemandsBean;
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-7-9 ����7:00:28
 * @����޸�ʱ�� 2016-7-9 ����7:00:28
 * @���� 
 * @version 1.0
 */
public class XUserDemandServiceImpl implements XUserDemandService {
private XUserDemandDaoImpl dao = new XUserDemandDaoImpl();
	public List<UserdemandsBean> getUnsolveDemandsByUserid(String userId) {
		// TODO Auto-generated method stub
		return dao.getUnsolveDemandsByUserid(userId);
	}
	public List<UserdemandsBean> getNewUnsolveDemands() {
		// TODO Auto-generated method stub
		return dao.getNewUnsolveDemands();
	}
	public List<UserdemandsBean> getNewGraduateUnsolveDemands() {
		// TODO Auto-generated method stub
		return dao.getNewGraduateUnsolveDemands();
	}
	public List<UserdemandsBean> searchDemands(String keyWords) {
		// TODO Auto-generated method stub
		return dao.searchDemands(keyWords);
	}
	public List<LnotesBean> getLnotesBydemandId(String demandId) {
		// TODO Auto-generated method stub
		return dao.getLnotesBydemandId(demandId);
	}

}
