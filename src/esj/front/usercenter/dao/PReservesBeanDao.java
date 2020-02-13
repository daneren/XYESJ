package esj.front.usercenter.dao;

import java.util.List;

import esj.front.usercenter.bean.ProCommBean;
import esj.publicdoc.bean.ReservesBean;

/**
 * 
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-6-30 ����9:40:24
 * @����޸�ʱ�� 2016-7-15 ����21��56
 * @������
 * @version 1.0
 */
public interface PReservesBeanDao {
	/**���򵽵���Ʒ��ԤԼ�У�ԤԼ�ɹ���PReservesBean ��״̬����*/
	/**rstate ,COUNT(proId)as remark,sum(buyerPrice) as buyerPrice*/
	public List<ProCommBean> getPriceSum(String buyerId);
	
	
	/**���򵽵���Ʒ ��PReservesBean*/
	/**proId,title,sellerId,photoAddr,buyerPrice,cjdate,reservId
	 *  ORDER BY r.cjdate
	 */
	public List<ProCommBean> getUserBuy(String buyerId);
	
	/**��ԤԼ�е���Ʒ ��PReservesBean
	 * "SELECT proId,title,sellerId,photoAddr,buyerPrice,reservId,
	 * cprice,dprice,oprice 
	 * ORDER BY r.reservdate
	 */
	public List<ProCommBean> getUserReserve(String buyerId);	
	
	
	/**��ø����ҵģ�ȫ����ԤԼ����Ʒ����Ϣ
	 * SELECT r.proId,p.title,p.bdate,p.edate AS cjdate,p.dprice,
	 * COUNT(r.buyerId) AS ruCount 
	 * */
	public List<ProCommBean> getAllReserved(String sellerId);
	
	/**������Ʒ��Ų�ѯȫ��ԤԼ��Ϣ��ȫ����ԤԼ����Ʒ����Ϣ
	 * SELECT r.reservId,r.proId,r.buyerId,u.userName AS remark, 
	 * u.email,r.buyerPrice,r.reservdate
	 * */
	public List<ReservesBean> getDetailReserved(String proId);
	
	/**����ԤԼ��Ÿ���ԤԼ״̬
	 * */
	public int updateReserveState(String reserveId,String state);
	
	/**����ԤԼ��ţ�����ұ�� �����޸ĸ���ԤԼ״̬
	 * */
	public int updateTurndownReserve(String proId,String ostate,String nstate);
	
	/**�����ʼ������û���ԤԼ��ѡ��
	 * SELECT r.buyerPrice,u.userName AS buyerId,
	 * u.email AS sellerId,p.proId,p.title AS remark 
	 * */
	public ReservesBean getUserMag(String reserveId);
	
	/**
	 * ����--->�û���ԤԼ��Ϣ�������е�ԤԼ��Ϣ
	 * 
	 * */
	public List<ProCommBean> getSellerDealing(String sellerId);
	
	/**
	 * ���--->�û���ԤԼ��Ϣ�������е�ԤԼ��Ϣ
	 * 
	 * */
	public List<ProCommBean> getBuyerDealing(String buyerId);
	
	/**�����ʼ������������µ�ԤԼ��Ϣ
	 * SELECT r.buyerPrice,u.userName AS buyerId,
	 * u.email AS sellerId,p.proId,p.title AS remark 
	 * */
	public ReservesBean getSellerMag(String reserveId);

}
