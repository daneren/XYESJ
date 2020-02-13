package esj.front.usercenter.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import esj.front.usercenter.bean.ProCommBean;
import esj.front.usercenter.dao.PProductsBeanDao;
import esj.front.usercenter.dao.impl.PProductsBeanDaoimpl;
import esj.front.usercenter.service.PProductsBeanService;
import esj.publicdoc.bean.ProductsBean;

/**
 * 
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-6-26 ����8:16:07
 * @����޸�ʱ�� 2016-7-06 ����11��29
 * @������
 * @version 1.0
 */
public class PProductsBeanServiceimpl implements PProductsBeanService {
	private PProductsBeanDao pProductsBeanDao = new PProductsBeanDaoimpl();

	public List<ProductsBean> findProductByUserId(String userId) {
		if (userId == null || userId.trim().equals("")) {
			return null;
		}
		return pProductsBeanDao.findProductByUserId(userId);
	}

	public List<ProductsBean> findProduct(String userId, String op) {
		if (userId == null || userId.trim().equals("")) {
			return null;
		}
		//��ѯ�����е���Ʒ
		if (op.equals("1")) {
			op = "1";
			return pProductsBeanDao.findProduct(userId, "1");
		}
		//��ѯ������Ʒ
		if (op.equals("2")) {
			return pProductsBeanDao.findProduct(userId, "2");
		} 
		return null;
	}

	public Map<String,Integer> countProduct(String state) {
		if(state == null || state.trim().equals("")){
			return null;
		}
		List<ProductsBean> list = pProductsBeanDao.countProduct(state);
		if(list ==null){
			return null;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(ProductsBean p:list){
			map.put(p.getState(), p.getNcount());
		}		
		
		return map;
	}

	public List<ProCommBean> getSoldOut(String buyerId) {
		if(buyerId.equals("") || buyerId ==  null){
			return null;
		}
		return pProductsBeanDao.getSoldOut(buyerId);
	}

	public List<ProCommBean> getOnSale(String buyerId) {
		if(buyerId.equals("") || buyerId ==  null){
			return null;
		}
		return pProductsBeanDao.getOnSale(buyerId);
	}

	public int setProductStateByProId(String proId, String state) {
		
		return pProductsBeanDao.setProductStateByProId(proId, state);
	}

	public int updateProduct(ProductsBean productsBean) {
		if(productsBean == null){
			return -1;
		}
		return pProductsBeanDao.updateProduct(productsBean);
	}

}
