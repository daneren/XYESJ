package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.LnotesBean;
/**���Ա� ������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:26:12
 * @����޸�ʱ�� 2016-6-25 ����5:26:12
 * @����
 * @version 1.0
 */
public interface LnotesBeanService {
	/**����һ��   ������Ϣ*/
	public int saveLnotes(LnotesBean LnotesBean );
	/**����ȫ�� ������Ϣ*/
	public List<LnotesBean> findAllLnotes();
	/**ɾ��һ�� ������Ϣ*/
	public int changeLnotesState(LnotesBean LnotesBean);
	/**����һ��   ������Ϣ*/
	public int updateLnotes(LnotesBean LnotesBean);
	/**���ݱ�ţ�����������   ������Ϣ*/
	public LnotesBean findLnotesById(String id);
}
