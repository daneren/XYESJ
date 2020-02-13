package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.AdminlogsBean;
/**管理员日志表操作类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:25:49
 * @最后修改时间 2016-6-25 下午5:25:49
 * @描述
 * @version 1.0
 */
public interface AdminlogsBeanService {
	/**保存一个   管理员日志*/
	public int saveAdminLogs(AdminlogsBean adminlogsBean);
	/**查找全部   管理员日志*/
	public List<AdminlogsBean> findAllAdminlogs();
	/**根据编号（主键）查找   管理员日志*/
	public AdminlogsBean findAdminlogsByLogId(String id);
}
