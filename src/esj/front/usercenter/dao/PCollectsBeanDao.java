package esj.front.usercenter.dao;

import java.util.List;

import esj.front.usercenter.bean.ProCommBean;

/**
 * �ҵ�Ը���嵥
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-7-1 ����1:12:31
 * @����޸�ʱ�� 2016-7-1 ����1:12:31
 * @������
 * @version 1.0
 */
public interface PCollectsBeanDao {
	/**��Ʒ������Ϣ*/
	/**proId,photoAddr,title,details,cprice,dprice,oprice,pstate,bdate,collectId
	 * */
	public List<ProCommBean> getUCollects(String buyerId);
	
	/**��ע������ԤԼ����*/
	/**ruCount,r.proId,cuCount
	 * */
	public List<ProCommBean> getProData(String buyerId);
	
}
