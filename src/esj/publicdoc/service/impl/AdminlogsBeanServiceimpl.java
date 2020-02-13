package esj.publicdoc.service.impl;

import java.util.List;



import esj.publicdoc.bean.AdminlogsBean;
import esj.publicdoc.dao.AdminlogsBeanDao;
import esj.publicdoc.dao.impl.AdminlogsBeanDaoimpl;
import esj.publicdoc.service.AdminlogsBeanService;
import esj.util.DateHelper;
import esj.util.IPToAddr;
import esj.util.Random100;
/**管理员日志表实现类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:27:21
 * @最后修改时间 2016-6-25 下午5:27:21
 * @描述
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
