package esj.back.control.authoritie.dao;

import java.util.List;

import esj.publicdoc.bean.AuthoritiesBean;
/**Ȩ�ޱ� ������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:25:58
 * @����޸�ʱ�� 2016-6-25 ����5:25:58
 * @����
 * @version 1.0
 */
public interface AuthoritiesBeanDao {

	/**����һ��   Ȩ��״̬*/
	public int updateStateAuthoritiesByID(AuthoritiesBean authoritiesBean);
	
	/**ɾ��һ��   Ȩ��״̬*/
	public int deleteAuthoritiesByID(AuthoritiesBean authoritiesBean);
	/**
	 * @���� ���¿�
	 * @desc ��ȡȨ�޵���ϸ��Ϣ ��menu���authority���л�ȡ�ֶ�
	 * @return
	 */
	public List<AuthoritiesBean> getAllAuthoritiesInfo();

}