package esj.front.usercenter.service.impl;

import java.util.List;

import esj.front.usercenter.bean.ProCommBean;
import esj.front.usercenter.dao.PReservesBeanDao;
import esj.front.usercenter.dao.impl.PReservesBeanDaoimpl;
import esj.front.usercenter.service.PReservesBeanService;
import esj.publicdoc.bean.ReservesBean;

public class PReservesBeanServiceimpl implements PReservesBeanService {
	private PReservesBeanDao pReservesBeanDao = new PReservesBeanDaoimpl();
	public List<ProCommBean> getPriceSum(String buyerId) {
		if(buyerId.equals("") || buyerId ==  null){
			return null;
		}
		return pReservesBeanDao.getPriceSum(buyerId);
	}

	public List<ProCommBean> getUserReserve(String buyerId) {
		if(buyerId.equals("") || buyerId ==  null){
			return null;
		}
		return pReservesBeanDao.getUserReserve(buyerId);
	}

//	public List<ProCommBean> getProData(String buyerId) {
//		if(buyerId.equals("") || buyerId ==  null){
//			return null;
//		}
//		return pReservesBeanDao.getProData(buyerId);
//	}

	public List<ProCommBean> getUserBuy(String buyerId) {
		if(buyerId.equals("") || buyerId ==  null){
			return null;
		}
		return pReservesBeanDao.getUserBuy(buyerId);
	}

	public List<ProCommBean> getAllReserved(String sellerId) {
		if(sellerId.equals("") || sellerId ==  null){
			return null;
		}
		return pReservesBeanDao.getAllReserved(sellerId);
	}

	public List<ReservesBean> getDetailReserved(String proId) {
		if(proId.equals("") || proId ==  null){
			return null;
		}
		return pReservesBeanDao.getDetailReserved(proId);
	}

	public int updateReserveState(String reserveId, String state) {
		if(reserveId.equals("") || reserveId ==  null ||state.equals("") || state ==  null){
			return -1;
		}
		return pReservesBeanDao.updateReserveState(reserveId, state);
	}

	public int acceptReserv(String proId, String reserveId,String state) {
		if(reserveId.equals("") || reserveId ==  null ||proId.equals("") || proId ==  null){
			return -1;
		}
		int count = 0;
		
		count = pReservesBeanDao.updateReserveState(reserveId,state);
		//System.out.println(count);
		count += pReservesBeanDao.updateTurndownReserve(proId, "预约中", "已退回");
		return count;
	}

	public int turndownAllReserv(String proId, String ostate, String nstate) {
		if(proId.equals("") || proId ==  null 
				||ostate.equals("") || ostate ==  null
				||nstate.equals("") || nstate ==  null){
			return -1;
		}
		return pReservesBeanDao.updateTurndownReserve(proId, ostate, nstate);
	}

	public ReservesBean getUserMag(String reserveId) {
		if(reserveId.equals("") || reserveId ==  null){
			return null;
		}
		return pReservesBeanDao.getUserMag(reserveId);
	}

	public List<ProCommBean> getSellerDealing(String sellerId) {
		if(sellerId.equals("") || sellerId ==  null){
			return null;
		}
		return pReservesBeanDao.getSellerDealing(sellerId);
	}

	public int updateReserveStates(String proId, String ostate, String nstate) {
		if(proId.equals("") || proId ==  null ||ostate.equals("") || ostate ==  null || nstate.equals("") || nstate ==  null){
			return -1;
		}
		return pReservesBeanDao.updateTurndownReserve(proId, ostate, nstate);
	}

	public List<ProCommBean> getBuyerDealing(String buyerId) {
		if(buyerId.equals("") || buyerId ==  null){
			return null;
		}
		return pReservesBeanDao.getBuyerDealing(buyerId);
	}

	public ReservesBean getSellerMag(String reserveId) {
		if(reserveId.equals("") || reserveId ==  null){
			return null;
		}
		return pReservesBeanDao.getSellerMag(reserveId);
	}
	

	
	

}
