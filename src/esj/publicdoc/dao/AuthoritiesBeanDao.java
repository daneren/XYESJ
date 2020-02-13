package esj.publicdoc.dao;

import java.util.List;

import esj.publicdoc.bean.AuthoritiesBean;
/***/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:25:58
 * @����޸�ʱ�� 2016-6-25 ����5:25:58
 * @���� Ȩ�ޱ� ������
 * @version 1.0
 */
public interface AuthoritiesBeanDao {
	/**����һ��   Ȩ����Ϣ*/
	public int saveAuthorities(AuthoritiesBean authoritiesBean );
	/**����ȫ�� Ȩ����Ϣ*/
	public List<AuthoritiesBean> findAllAuthorities();
	/**�޸�Ȩ�޵�״̬*/
	public int changeAuthorityState(AuthoritiesBean authoritiesBean);
	/**����һ��   Ȩ����Ϣ*/
	public int updateAuthorities(AuthoritiesBean authoritiesBean);
	/**���ݱ�ţ�����������   Ȩ����Ϣ*/
	public AuthoritiesBean findAuthoritiesById(Integer id);
}
