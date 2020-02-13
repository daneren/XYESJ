package esj.back.control.authoritie.service.impl;

import esj.back.control.authoritie.dao.AuthoritiesBeanDao;
import esj.back.control.authoritie.dao.impl.AuthoritiesBeanDaoImpl;
import esj.back.control.authoritie.service.AuthoritiesBeanService;
import esj.publicdoc.bean.AuthoritiesBean;

public class AuthoritiesBeanServiceImpl extends AuthoritiesBean implements
		AuthoritiesBeanService {
	
	AuthoritiesBeanDao authoritiesBeanDao=new AuthoritiesBeanDaoImpl();
	
	public int updateStateAuthoritiesByID(AuthoritiesBean authoritiesBean) {
		int count=0;
		count=authoritiesBeanDao.updateStateAuthoritiesByID(authoritiesBean);
		return count;
	}

	public int deleteAuthoritiesByID(AuthoritiesBean authoritiesBean) {
		int count=0;
		count=authoritiesBeanDao.deleteAuthoritiesByID(authoritiesBean);
		return count;
	}
}
