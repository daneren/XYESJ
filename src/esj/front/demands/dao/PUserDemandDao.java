package esj.front.demands.dao;

import java.util.List;

import esj.publicdoc.bean.UserdemandsBean;
/**
 * 
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-7-18 ����8:53:02
 * @����޸�ʱ�� 2016-7-18 ����8:53:02
 * @������
 * @version 1.0
 */
public interface PUserDemandDao {
	/**
	 * �޸���Ʒ��Ϣ
	 * @param 
	 * @return
	 */
	public int updateDemand(UserdemandsBean userdemandsBean);
	
	/**
	 * ����userid��ȡ�û����� �ѽ����
	 * @return
	 */
	public List<UserdemandsBean> getsolvedDemandsByUserid(String userId);
	/**
	 * ����userid��ȡ�û����� δ�����
	 * @return
	 */
	public List<UserdemandsBean> getUnsolveDemandsByUserid(String userId);
}
