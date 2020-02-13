package esj.front.usercenter.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.ParseException;

import esj.front.util.ServiceException;
import esj.publicdoc.bean.UsersBean;
/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-6-25 下午9:27:47
 * @最后修改时间 2016-6-25 下午9:27:47
 * @描述：
 * @version 1.0
 */
public interface EmailService {
	/**
	 * 邮箱注册 ：发送邮件
	 * @param usersBean 用户输入的数据
	 * @param addr  用户点击注册后跳转的页面/servlet 的地址 例如 http://localhost:8080/XYESJ/registerservlet...
	 * @return
	 */
	public boolean  processRigister(UsersBean usersBean,String addr);
	 /**
     * 邮箱注册： 激活处理
     * @param email 邮箱地址
     * @param validateCode 激活码（user的remark字段）
     * @throws ParseException 
     */
	public boolean processActivate(String email , String validateCode)throws ServiceException, ParseException;
	/**
	 * 发送邮件的通用方法
	 * @param email 接收邮件的 邮箱地址 例如 XXXXXXXX@qq.com
	 * @param describe 邮件的内容描述 例如：您有一条新的消息，点击下方链接查看：
	 * @param url 要链接的页面地址，例如  http://localhost:8080/xyesj/index.jsp？param1=zzy&param2=123&name=猪猪
	 * @param subject 邮件主题 例如：二手街：新消息
	 * @return 发送成功返回true
	 */
	public boolean sendEmail(String email,String describe,String url,String subject);
}
