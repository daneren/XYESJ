package esj.front.usercenter.dao;

import esj.publicdoc.bean.UsersBean;
/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-6-26 下午1:48:59
 * @最后修改时间 2016-6-26 下午1:48:59
 * @描述：
 * @version 1.0
 */
public interface PUsersBeanDao {
	/**
	 * 邮箱验证之：根据邮箱地址查找用户
	 * @param email
	 * @return
	 */
	public UsersBean findUserByEmail(String email);
	/**
	 * 邮箱验证之：通过邮箱更改用户的状态
	 * @param usersBean
	 * @return
	 */
	public int updateUser(String email,String state);
	/**
	 * 更新用户信息，包括：姓名，学校，学院，专业，生日，入学日期,性别
	 * @param usersBean
	 * @return
	 */
	public int updateUserMsg(UsersBean usersBean);
	
	/**
	 * 修改登陆密码 
	 * @param userId
	 * @param npwd 新密码
	 * @return
	 */
	public int updatePwd(String userId,String npwd);
	
	/**
	 * 修改手机号
	 * @param userId
	 * @param npwd 新密码
	 * @return
	 */
	public int updatePhone(String userId,String userPhone);
	

}
