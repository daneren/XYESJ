package esj.publicdoc.service.impl;

import java.util.List;

import esj.publicdoc.bean.UserlogsBean;
import esj.publicdoc.dao.UserlogsBeanDao;
import esj.publicdoc.dao.impl.UserlogsBeanDaoimpl;
import esj.publicdoc.service.UserlogsBeanService;
import esj.util.DateHelper;
import esj.util.IPToAddr;
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:31:55
 * @����޸�ʱ�� 2016-6-25 ����5:31:55
 * @���� �û���¼��־������
 * @version 1.0
 */
public class UserlogsBeanServiceimpl implements UserlogsBeanService {
	private UserlogsBeanDao dao = new UserlogsBeanDaoimpl();
	
	public int saveUserlogs(UserlogsBean userlogsBean) {
		userlogsBean.setIpAddr(IPToAddr.jiexiip(userlogsBean.getIp()));
		userlogsBean.setTextAddr(userlogsBean.getUserId()+"#"+DateHelper.getDateTimeForNumber()+".log");
		return dao.saveUserlogs(userlogsBean);
	}

	public List<UserlogsBean> findAllAdminlogs() {
		// TODO Auto-generated method stub
		return dao.findAllAdminlogs();
	}

	public int removeUserlogs(UserlogsBean userlogsBean) {
		// TODO Auto-generated method stub
		return dao.removeUserlogs(userlogsBean);
	}

	public int updateUserlogs(UserlogsBean userlogsBean) {
		// TODO Auto-generated method stub
		return dao.updateUserlogs(userlogsBean);
	}

	public UserlogsBean findUserlogsById(String id) {
		// TODO Auto-generated method stub
		return dao.findUserlogsById(id);
	}

	

}
