package esj.front.usercenter.service.impl;

import esj.front.usercenter.dao.impl.XUsersBeanDaoImpl;
import esj.front.usercenter.service.XUsersBeanService;
import esj.publicdoc.bean.UsersBean;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-27 上午10:40:13
 * @最后修改时间 2016-6-27 上午10:40:13
 * @描述 用户操作实现类
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
