package esj.front.usercenter.dao;

import java.util.List;

import esj.publicdoc.bean.ProtypesBean;

/**
 * 
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-6-28 ����5:28:04
 * @����޸�ʱ�� 2016-6-28 ����5:28:04
 * @������
 * @version 1.0
 */
public interface PProtypesBeanDao {
	/**��������Ϣ
	 * ��ѯһ�������Ϣ������ fatherIdΪ0
	 * ��ѯ�������������Ϣ������ fatherIdΪ-1
	 * */
	public List<ProtypesBean> getProType(ProtypesBean protypesBean);
	
	/**�������ݼ��ϲ��������Ϣ��������������Ϊ���򷵻�  ��������ͬʱ�����Ĳ���
	 * @param typeIds ��ѯtypeId����typeIds���ϵ���������
	 * @param fatherIds ��ѯfatherId����fatherIds���ϵ���������
	 * 
	 * */
	public List<ProtypesBean> getByArray(String typeIds,String fatherIds);
}
