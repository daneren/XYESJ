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
		// ���ɼ�����
		String validateCode = MD5Util.encode2hex(usersBean.getEmail());
		String LastActivateTime = DateUtil.CalDateTimeAdd(
				usersBean.getRigistDay(), 0, 0, 2, 0, 0, 0);
		usersBean.setRemark(validateCode + "," + LastActivateTime);
		usersBean.setState("88");
		// �����û�����
		int count = usersBeanDao.saveUsers(usersBean);
		if (count == 0) {
			return false;
		} else {
			// ��������
			StringBuffer sb = new StringBuffer(
					"����������Ӽ����˺ţ�48Сʱ��Ч����������ע���˺ţ�����ֻ��ʹ��һ�Σ��뾡�켤�</br>");
			sb.append("<a href=\"index.jsp?action=activate&email=");
			sb.append(usersBean.getEmail());
			sb.append("&validateCode=");
			sb.append(validateCode);
			sb.append("\">" + addr + "?action=activate&email=");
			sb.append(usersBean.getEmail());
			sb.append("&validateCode=");
			sb.append(validateCode);
			sb.append("</a>");

			// �����ʼ�
			SendMail sendMail = new SendMail();
			sendMail.setTo(usersBean.getEmail());
			sendMail.setContent(sb.toString());		
			sendMail.setSubject("���ֽ֣��˺ż���");
			
			sendMail.sendMail();

			return true;
		}
	}

	
	// /���ݼ������email����
	public boolean processActivate(String email, String validateCode)
			throws ServiceException, ParseException {

		pUsersBeanDao = new PUsersBeanDaoimpl();
		// ���ݷ��ʲ㣬ͨ��email��ȡ�û���Ϣ
		UsersBean usersBean = pUsersBeanDao.findUserByEmail(email);
		// ��֤�û��Ƿ����
		if (usersBean != null) {
			// ��֤�û�����״̬
			if (usersBean.getState().equals("88")) {
				// /û����
				String currentTime = DateUtil.getCurrentDatetime();//���ϵͳ��ǰʱ�䣺������ʱ����
				// ��֤�����Ƿ����
				
				String LastActivateTime = usersBean.getRemark().split(",")[1];
				// currentTime.before();
				if (DateUtil.beforeDatetime(currentTime, LastActivateTime)) {
					// ��֤�������Ƿ���ȷ
					String uValidateCode = usersBean.getRemark().split(",")[0];
					if (validateCode.equals(uValidateCode)) {
						// ����ɹ��� //�������û��ļ���״̬��Ϊ�Ѽ���
						usersBean.setState("1");//��״̬��Ϊ����
						int count = pUsersBeanDao.updateUser(usersBean.getEmail(), usersBean.getState());
						if(count != 0){
							return true;
						}
						//userDao.update(user);
					} else {
						throw new ServiceException("�����벻��ȷ");
					}
				} else {
					throw new ServiceException("�������ѹ��ڣ�");
				}
			} else {
				throw new ServiceException("�����Ѽ�����¼��");
			}
		} else {
			throw new ServiceException("������δע�ᣨ�����ַ�����ڣ���");
		}
		return false;

	}

	public boolean sendEmail(String email, String describe, String url,
			String subject) {
		boolean bool = false;
		// ��������
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
		// �����ʼ�
		SendMail sendMail = new SendMail();
		sendMail.setTo(email);
		sendMail.setContent(sb.toString());		
		sendMail.setSubject(subject);
		
		bool = sendMail.sendMail();
		return bool;
	}

}
