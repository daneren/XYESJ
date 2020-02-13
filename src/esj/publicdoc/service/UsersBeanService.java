package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.UsersBean;
/**
 * 用户表操作类
 */
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:25:42
 * @最后修改时间 2016-6-25 下午5:25:42
 * @描述
 * @version 1.0
 */
public interface UsersBeanService {
	/**保存一个   用户*/
	public int saveUsers(UsersBean userBean);
	/**查找全部   用户*/
	public List<UsersBean> findAllUsers();
	/**删除一个  用户*/
	public int changeUserState(UsersBean userBean);
	/**更新一个   用户*/
	public int updateUser(UsersBean userBean);
	/**根据编号（主键）查找   用户*/
	public UsersBean findUserById(String id);
}
