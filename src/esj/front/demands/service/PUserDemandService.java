package esj.front.demands.service;

import java.util.List;

import esj.publicdoc.bean.UserdemandsBean;

/**
 * 
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-7-18 ����8:55:51
 * @����޸�ʱ�� 2016-7-18 ����8:55:51
 * @������
 * @version 1.0
 */
public interface PUserDemandService {
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
