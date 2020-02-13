package esj.front.usercenter.service.impl;

import esj.front.usercenter.dao.impl.XUsersBeanDaoImpl;
import esj.front.usercenter.service.XUsersBeanService;
import esj.publicdoc.bean.UsersBean;
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-27 ����10:40:13
 * @����޸�ʱ�� 2016-6-27 ����10:40:13
 * @���� �û�����ʵ����
 * @version 1.0
 */
public class XUsersBeanServiceImpl implements XUsersBeanService {
private XUsersBeanDaoImpl dao = new XUsersBeanDaoImpl();
	public boolean userLogin(String email,String pwd) {
		return dao.userLogin(email,pwd);
	}
	public String getUserIdByEmailAndPwd(String email, String pwd) {
		// TODO Auto-generated method stub
		return dao.getUserIdByEmailAndPwd(email, pwd);
	}
	public int changePwdByEmail(String email, String pwd) {
		// TODO Auto-generated method stub
		return dao.changePwdByEmail(email, pwd);
	}
	public String getPwdByUserId(String userId) {
		// TODO Auto-generated method stub
		return dao.getPwdByUserId(userId);
	}

}
