package esj.front.usercenter.service;

import java.util.List;
import java.util.Map;

import esj.front.usercenter.bean.ProCommBean;
import esj.publicdoc.bean.ProductsBean;

/**
 * 
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-7-1 ����11:31:42
 * @����޸�ʱ�� 2016-7-1 ����11:31:42
 * @������
 * @version 1.0
 */
public interface PProductsBeanService {
	/**
	 * �����û���������Ʒ��Ϣ
	 * @param userId
	 * @return
	 */
	public List<ProductsBean> findProductByUserId(String userId);

	/**
	 * �����û�������Ʒ״̬������Ʒ��Ϣ
	 * @param userId
	 * @param op
	 * @return
	 */
	public List<ProductsBean> findProduct(String userId,String op);
	
	/**
	 * ������Ʒ��״̬��ѯ��Ʒ������
	 * @param state
	 * @return
	 */
	public Map<String,Integer>  countProduct(String state);
	
	/**���۳�*/
	/**proId,title,pCount,nCount,photoAddr,cjdate,buyerPrice,ruCount,cuCount ORDER BY p.bdate
	 * 
	 */
	public List<ProCommBean> getSoldOut(String buyerId);
	

	/**�����е���Ʒ*/
	/**proId,title,pCount,nCount,photoAddr,ruCount  ORDER BY p.bdate;
	 */
	public List<ProCommBean> getOnSale(String buyerId);
	
	public int setProductStateByProId(String proId, String state);
	
	/**
	 * �޸���Ʒ��Ϣ
	 * @param 
	 * @return
	 */
	public int updateProduct(ProductsBean productsBean);
	
	
}
