package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.CollectsBean;
/**�ղر� ������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:26:08
 * @����޸�ʱ�� 2016-6-25 ����5:26:08
 * @����
 * @version 1.0
 */
public interface CollectsBeanService {
	/**����һ��   �ղ���Ϣ*/
	public int saveCollects(CollectsBean CollectsBean );
	/**����ȫ�� �ղ���Ϣ*/
	public List<CollectsBean> findAllCollects();
	/**ɾ��һ�� �ղ���Ϣ*/
	public int changeCollectState(CollectsBean CollectsBean);
	/**���ݱ�ţ�����������   �ղ���Ϣ*/
	public CollectsBean findCollectsById(String id);
}
