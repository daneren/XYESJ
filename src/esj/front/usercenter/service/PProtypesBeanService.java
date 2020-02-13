package esj.front.usercenter.service;

import java.util.List;
import java.util.Map;

import esj.publicdoc.bean.ProtypesBean;

/**
 * 
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-6-28 ����5:33:54
 * @����޸�ʱ�� 2016-6-28 ����5:33:54
 * @������
 * @version 1.0
 */
public interface PProtypesBeanService {
	/**
	 * ��ѯ������ΪfatherId ������
	 * */
	public List<ProtypesBean> getProType(int fatherId);
	/**
	 * ��ѯ�����ΪtypeId ������
	 * */
	public ProtypesBean getProTypeByTypeId(int typeId);
	
	/**�������ϵͼ*/
	public Map<String,List<ProtypesBean>> getProTypeTree(String id);
	
	/**�������ݼ��ϲ��������Ϣ��������������Ϊ���򷵻�  ��������ͬʱ�����Ĳ���
	 * @param typeIds ��ѯtypeId����typeIds���ϵ���������
	 * @param fatherIds ��ѯfatherId����fatherIds���ϵ���������
	 * 
	 * */
	public List<ProtypesBean> getByArray(String typeIds,String fatherIds);
	
}
