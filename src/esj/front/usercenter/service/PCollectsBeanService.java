package esj.front.usercenter.service;

import java.util.List;

import esj.front.usercenter.bean.ProCommBean;
/**
 * �ҵ�Ը���嵥
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-7-1 ����1:29:30
 * @����޸�ʱ�� 2016-7-1 ����1:29:30
 * @������
 * @version 1.0
 */
public interface PCollectsBeanService {
	/**��Ʒ������Ϣ*/
	/**proId,photoAddr,title,details,cprice,dprice,oprice,state,bdate
	 * */
	public List<ProCommBean> getUCollects(String buyerId);
	
	/**��ע������ԤԼ����*/
	/**ruCount,r.proId,cuCount
	 * */
	public List<ProCommBean> getProData(String buyerId);
}
