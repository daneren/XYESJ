package esj.publicdoc.service;

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
public interface AuthoritiesBeanService {
	/**����һ��   Ȩ����Ϣ*/
	public int saveAuthorities(AuthoritiesBean authoritiesBean );
	/**����ȫ�� Ȩ����Ϣ*/
	public List<AuthoritiesBean> findAllAuthorities();
	/**ɾ��һ�� Ȩ����Ϣ*/
	public int changeAuthorityState(AuthoritiesBean authoritiesBean);
	/**����һ��   Ȩ����Ϣ*/
	public int updateAuthorities(AuthoritiesBean authoritiesBean);
	/**���ݱ�ţ�����������   Ȩ����Ϣ*/
	public AuthoritiesBean findAuthoritiesById(Integer id);
}
