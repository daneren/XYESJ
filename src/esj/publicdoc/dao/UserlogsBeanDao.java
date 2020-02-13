package esj.publicdoc.dao;

import java.util.List;

import esj.publicdoc.bean.UserlogsBean;

/**
 * 用户日志表操作类
 */
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:25:37
 * @最后修改时间 2016-6-25 下午5:25:37
 * @描述 用户日志表操作类
 * @version 1.0
 */
public interface UserlogsBeanDao {

	/** 保存一个 用户日志 */
	public int saveUserlogs(UserlogsBean userlogsBean);

	/** 查找全部 用户日志 */
	public List<UserlogsBean> findAllAdminlogs();

	/** 删除一个 用户日志 */
	public int removeUserlogs(UserlogsBean userlogsBean);

	/** 更新一个 用户日志 */
	public int updateUserlogs(UserlogsBean userlogsBean);

	/** 根据编号（主键）查找 用户日志 */
	public UserlogsBean findUserlogsById(String id);
}
