package esj.publicdoc.dao;

import java.util.List;

import esj.publicdoc.bean.RnotesBean;
/**�ظ��� ������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:26:37
 * @����޸�ʱ�� 2016-6-25 ����5:26:37
 * @���� �ظ��� ������
 * @version 1.0
 */
public interface RnotesBeanDao {
	/**����һ��   �ظ���Ϣ*/
	public int saveRnotes(RnotesBean RnotesBean );
	/**����ȫ�� �ظ���Ϣ*/
	public List<RnotesBean> findAllRnotes();
	/**ɾ��һ�� �ظ���Ϣ*/
	public int changeRnotesState(RnotesBean RnotesBean);
	/**����һ��   �ظ���Ϣ*/
	public int updateRnotes(RnotesBean RnotesBean);
	/**���ݱ�ţ�����������   �ظ���Ϣ*/
	public RnotesBean findRnotesById(String id);
}
