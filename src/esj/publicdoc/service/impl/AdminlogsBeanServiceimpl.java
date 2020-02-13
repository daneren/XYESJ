package esj.publicdoc.service.impl;

import java.util.List;



import esj.publicdoc.bean.AdminlogsBean;
import esj.publicdoc.dao.AdminlogsBeanDao;
import esj.publicdoc.dao.impl.AdminlogsBeanDaoimpl;
import esj.publicdoc.service.AdminlogsBeanService;
import esj.util.DateHelper;
import esj.util.IPToAddr;
import esj.util.Random100;
/**����Ա��־��ʵ����*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:27:21
 * @����޸�ʱ�� 2016-6-25 ����5:27:21
 * @����
 * @version 1.0
 */
public class AdminlogsBeanServiceimpl implements AdminlogsBeanService{
	private AdminlogsBeanDao dao = new AdminlogsBeanDaoimpl();
	public int saveAdminLogs(AdminlogsBean adminlogsBean) {
		AdminlogsBean log = adminlogsBean;
		log.setAlogId(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		log.setIpAddr(IPToAddr.jiexiip(log.getIp()));
		log.setTime(DateHelper.getDateTimeFormat());
		return dao.saveAdminLogs(log);
	}

	public List<AdminlogsBean> findAllAdminlogs() {
		return dao.findAllAdminlogs();
	}

	

	public AdminlogsBean findAdminlogsByLogId(String id) {
		return dao.findAdminlogsByLogId(id);
	}
	

}
