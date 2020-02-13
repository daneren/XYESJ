package esj.front.usercenter.service.impl;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.mail.internet.ParseException;

import esj.front.usercenter.dao.PUsersBeanDao;
import esj.front.usercenter.dao.impl.PUsersBeanDaoimpl;
import esj.front.util.DateUtil;
import esj.front.util.MD5Util;
import esj.front.util.SendMail;
import esj.front.util.ServiceException;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.dao.UsersBeanDao;
import esj.publicdoc.dao.impl.UsersBeanDaoimpl;

public class EmailServiceimpl implements
		esj.front.usercenter.service.EmailService {
	private UsersBeanDao usersBeanDao;
	private PUsersBeanDao pUsersBeanDao;

	public boolean processRigister(UsersBean usersBean, String addr) {
		usersBeanDao = new UsersBeanDaoimpl();
		pUsersBeanDao = new PUsersBeanDaoimpl();
		// 生成激活码
		String validateCode = MD5Util.encode2hex(usersBean.getEmail());
		String LastActivateTime = DateUtil.CalDateTimeAdd(
				usersBean.getRigistDay(), 0, 0, 2, 0, 0, 0);
		usersBean.setRemark(validateCode + "," + LastActivateTime);
		usersBean.setState("88");
		// 保存用户数据
		int count = usersBeanDao.saveUsers(usersBean);
		if (count == 0) {
			return false;
		} else {
			// 生成链接
			StringBuffer sb = new StringBuffer(
					"点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
			sb.append("<a href=\"index.jsp?action=activate&email=");
			sb.append(usersBean.getEmail());
			sb.append("&validateCode=");
			sb.append(validateCode);
			sb.append("\">" + addr + "?action=activate&email=");
			sb.append(usersBean.getEmail());
			sb.append("&validateCode=");
			sb.append(validateCode);
			sb.append("</a>");

			// 发送邮件
			SendMail sendMail = new SendMail();
			sendMail.setTo(usersBean.getEmail());
			sendMail.setContent(sb.toString());		
			sendMail.setSubject("二手街：账号激活");
			
			sendMail.sendMail();

			return true;
		}
	}

	
	// /传递激活码和email过来
	public boolean processActivate(String email, String validateCode)
			throws ServiceException, ParseException {

		pUsersBeanDao = new PUsersBeanDaoimpl();
		// 数据访问层，通过email获取用户信息
		UsersBean usersBean = pUsersBeanDao.findUserByEmail(email);
		// 验证用户是否存在
		if (usersBean != null) {
			// 验证用户激活状态
			if (usersBean.getState().equals("88")) {
				// /没激活
				String currentTime = DateUtil.getCurrentDatetime();//获得系统当前时间：年月日时分秒
				// 验证链接是否过期
				
				String LastActivateTime = usersBean.getRemark().split(",")[1];
				// currentTime.before();
				if (DateUtil.beforeDatetime(currentTime, LastActivateTime)) {
					// 验证激活码是否正确
					String uValidateCode = usersBean.getRemark().split(",")[0];
					if (validateCode.equals(uValidateCode)) {
						// 激活成功， //并更新用户的激活状态，为已激活
						usersBean.setState("1");//把状态设为激活
						int count = pUsersBeanDao.updateUser(usersBean.getEmail(), usersBean.getState());
						if(count != 0){
							return true;
						}
						//userDao.update(user);
					} else {
						throw new ServiceException("激活码不正确");
					}
				} else {
					throw new ServiceException("激活码已过期！");
				}
			} else {
				throw new ServiceException("邮箱已激活，请登录！");
			}
		} else {
			throw new ServiceException("该邮箱未注册（邮箱地址不存在）！");
		}
		return false;

	}

	public boolean sendEmail(String email, String describe, String url,
			String subject) {
		boolean bool = false;
		// 生成链接
		StringBuffer sb = new StringBuffer();
		StringBuffer sbb = new StringBuffer();
		sb.append(describe);
		if(url != null){
			sb.append("</br>");
			sb.append("<a href=\"");
			sb.append(url); 
			sb.append("\">" + url);
			sb.append("</a>");
		}
		// 发送邮件
		SendMail sendMail = new SendMail();
		sendMail.setTo(email);
		sendMail.setContent(sb.toString());		
		sendMail.setSubject(subject);
		
		bool = sendMail.sendMail();
		return bool;
	}

}
