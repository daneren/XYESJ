package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.BroadcastsBean;
/**����� ������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:26:02
 * @����޸�ʱ�� 2016-6-25 ����5:26:02
 * @����
 * @version 1.0
 */
public interface BroadcastsBeanService {
	/**����һ��   ������Ϣ*/
	public int saveBroadcasts(BroadcastsBean BroadcastsBean );
	/**����ȫ�� ������Ϣ*/
	public List<BroadcastsBean> findAllBroadcasts();
	/**ɾ��һ�� ������Ϣ*/
	public int changeBroadcastState(BroadcastsBean BroadcastsBean);
	/**����һ��   ������Ϣ*/
	public int updateBroadcasts(BroadcastsBean BroadcastsBean);
	/**���ݱ�ţ�����������   ������Ϣ*/
	public BroadcastsBean findBroadcastsById(String id);
}
