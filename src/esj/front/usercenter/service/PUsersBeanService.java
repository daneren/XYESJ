package esj.front.usercenter.service;

import esj.publicdoc.bean.UsersBean;

/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-6-29 下午11:28:17
 * @最后修改时间 2016-6-29 下午11:28:17
 * @描述：
 * @version 1.0
 */
public interface PUsersBeanService {
	/**
	 * 更新用户信息，包括：姓名，学校，学院，专业，生日，入学日期,性别
	 * @param usersBean
	 * @return
	 */
	public int updateUserMsg(UsersBean usersBean);
	/**
	 * 修改登录密码
	 * @param opwd 原始密码
	 * @param npwd 新密码
	 * @param userId 用户编号
	 * @return
	 */
	public int updateUserPwd(String npwd,String userId);
	
	/**
	 * 修改手机号
	 * @param userId
	 * @param npwd 新密码
	 * @return
	 */
	public int updatePhone(String userId,String userPhone);
}
