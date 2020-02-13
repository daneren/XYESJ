package esj.front.usercenter.dao;

import java.util.List;

import esj.front.usercenter.bean.ProCommBean;
import esj.publicdoc.bean.ProductsBean;

/**
 * 
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-7-1 ����11:17:35
 * @����޸�ʱ�� 2016-7-1 ����11:17:35
 * @������
 * @version 1.0
 */
public interface PProductsBeanDao {
	/**���۳�*/
	/**proId,title,pCount,nCount,photoAddr,cjdate,
	 * buyerPrice,ruCount,cuCount
	 *  ORDER BY p.bdate
	 * 
	 */
	public List<ProCommBean> getSoldOut(String buyerId);
	

	/**�����е���Ʒ*/
	/**proId,title,pCount,nCount,photoAddr,ruCount  ORDER BY p.bdate;
	 */
	public List<ProCommBean> getOnSale(String buyerId);
	
	/**
	 * �����û���������Ʒ��Ϣ
	 * @param userId
	 * @return
	 */
	public List<ProductsBean> findProductByUserId(String userId);
	
	/**
	 * �����û�������Ʒ״̬������Ʒ��Ϣ
	 * @param userId
	 * @param state
	 * @return
	 */
	public List<ProductsBean> findProduct(String userId,String state);
	
	/**
	 * ������Ʒ״̬������Ʒ��
	 * @param state �ö��Ÿ���
	 * @return
	 */
	public List<ProductsBean> countProduct(String state);
	
	public int setProductStateByProId(String proId, String state);
	
	/**
	 * �޸���Ʒ��Ϣ
	 * @param 
	 * @return
	 */
	public int updateProduct(ProductsBean productsBean);
	
	
	
}
