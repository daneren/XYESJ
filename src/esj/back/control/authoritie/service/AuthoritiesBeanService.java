package esj.back.control.authoritie.service;

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
public interface AuthoritiesBeanService {

	/**����һ��   Ȩ��״̬*/
	public int updateStateAuthoritiesByID(AuthoritiesBean authoritiesBean);
	
	/**ɾ��һ��   Ȩ��״̬*/
	public int deleteAuthoritiesByID(AuthoritiesBean authoritiesBean);
	

}
