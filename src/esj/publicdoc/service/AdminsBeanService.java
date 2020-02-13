package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.AdminsBean;
/**管理员表 操作类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:25:54
 * @最后修改时间 2016-6-25 下午5:25:54
 * @描述
 * @version 1.0
 */
public interface AdminsBeanService {
	/**保存一个   管理员信息*/
	public int saveAdmins(AdminsBean adminsBean);
	/**查找全部  管理员信息*/
	public List<AdminsBean> findAllAdmins();
	/**删除一个  管理员信息*/
	public int updateAdminsState(AdminsBean adminsBean);
	/**更新一个   管理员信息*/
	public int updateAdmins(AdminsBean adminsBean);
	/**根据编号（主键）查找   管理员信息*/
	public AdminsBean findAdminsByAdminId(Integer id);
}
