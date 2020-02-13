package esj.publicdoc.service.impl;

import java.util.List;

import esj.publicdoc.bean.AuthoritiesBean;
import esj.publicdoc.dao.AuthoritiesBeanDao;
import esj.publicdoc.dao.impl.AuthoritiesBeanDaoimpl;
import esj.publicdoc.service.AuthoritiesBeanService;
/**Ȩ�ޱ� ������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:28:06
 * @����޸�ʱ�� 2016-6-25 ����5:28:06
 * @����
 * @version 1.0
 */
public class AuthoritiesBeanServiceimpl implements AuthoritiesBeanService {
private AuthoritiesBeanDao dao = new AuthoritiesBeanDaoimpl();
	public int saveAuthorities(AuthoritiesBean authoritiesBean) {
		return dao.saveAuthorities(authoritiesBean);
	}

	public List<AuthoritiesBean> findAllAuthorities() {
		return dao.findAllAuthorities();
	}

	public int changeAuthorityState(AuthoritiesBean authoritiesBean) {
		return dao.changeAuthorityState(authoritiesBean);
	}

	public int updateAuthorities(AuthoritiesBean authoritiesBean) {
		return dao.updateAuthorities(authoritiesBean);
	}

	public AuthoritiesBean findAuthoritiesById(Integer id) {
		return dao.findAuthoritiesById(id);
	}

	

}
