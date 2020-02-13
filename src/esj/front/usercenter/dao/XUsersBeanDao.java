package esj.front.usercenter.dao;

import esj.publicdoc.bean.UsersBean;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-27 上午10:34:28
 * @最后修改时间 2016-6-27 上午10:34:28
 * @描述 用户数据库操作接口
 * @version 1.0
 */
public interface XUsersBeanDao {

	/**
	 * 用户登录查询
	 */
	public boolean userLogin(String email,String pwd);
	/**
	 * 根据邮箱和密码找到用户id
	 */
	public String getUserIdByEmailAndPwd(String email,String pwd);
	/**
	 * 根据邮箱修改用户的密码
	 */
	public int changePwdByEmail(String email,String pwd);
	/**
	 * 根据userid查找pwd
	 */
	public String getPwdByUserId(String userId);
}
