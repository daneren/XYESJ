package esj.front.products.dao;

import java.util.List;

import esj.publicdoc.bean.CollectsBean;
import esj.publicdoc.bean.PraiseTreadBean;
import esj.publicdoc.bean.ProductsBean;
import esj.publicdoc.bean.ReservesBean;

/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-7-9 ����3:41:23
 * @����޸�ʱ�� 2016-7-9 ����3:41:23
 * @���� ��Ʒ��ѯ
 * @version 1.0
 */
public interface XProductDao {
	/**���ݹؼ���������Ʒ*/
	public List<ProductsBean> searchProducts(String keyWords,String typeid);
	/**��ó��������·�������Ʒ����,Ҳ�������·�����*/
	public List<ProductsBean> getNewProducts();
	/**��ñ�ҵ����ѧ����������Ʒ,����ʱ��˳��*/
	public List<ProductsBean> getGraduateProducts();
	/**����id��ȡ��Ʒ����Ϣ��Ȼ��������ص���Ʒ*/
	public List<ProductsBean> getPushProductsById(String id);
	/**�������Ʒ�Ĵ���*/
	public int getPraiseCountByProId(String proId);
	/**��ò���Ʒ�Ĵ���*/
	public int getTreadCountByProId(String proId);
	/**����Ʒ����*/
	public int praiseProduct(PraiseTreadBean  ptb);
	/**����Ʒ����*/
	public int treadProduct(PraiseTreadBean  ptb);
	
	/**����Ʒ����޴�����һ*/
	public int updateProductPcount(String proId,int pcount);
	/**����Ʒ��Ĳȴ�����һ*/
	public int updateProductNcount(String proId,int ncount);
	
	/**��֤����Ʒ�Ƿ��ѱ����û��޻����*/
	public boolean isTreadOrPraise(String userId,String proId);
	/**��ȡ��Ʒ���ղ���*/
	public int collectCountByProId(String proId);
	/**�жϸ��û��Ƿ��ղ��˸���Ʒ*/
	public boolean isCollected(String userId,String proId);
	/**�ղظ���Ʒ*/
	public int collectProduct(CollectsBean collect);
	/**����userId��ȡ���û�ԤԼ����Ʒ��*/
	public int getReserveCountByUserId(String userId);
	/**����userId��ȡ���û�ԤԼ��������Ʒ���ܼ۸�*/
	public double getReservePriceCountByUserId(String userId);
	
	/***
	 * ����Tag������Ʒ
	 */
	public List<ProductsBean> getProByTag(String tag);

	/**
	 *���ߣ���־�� 
	 * ��������,��������������*/
	public int updateScore(String score,String proId);
}
