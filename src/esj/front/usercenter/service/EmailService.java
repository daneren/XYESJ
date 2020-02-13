package esj.front.usercenter.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.ParseException;

import esj.front.util.ServiceException;
import esj.publicdoc.bean.UsersBean;
/**
 * 
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-6-25 ����9:27:47
 * @����޸�ʱ�� 2016-6-25 ����9:27:47
 * @������
 * @version 1.0
 */
public interface EmailService {
	/**
	 * ����ע�� �������ʼ�
	 * @param usersBean �û����������
	 * @param addr  �û����ע�����ת��ҳ��/servlet �ĵ�ַ ���� http://localhost:8080/XYESJ/registerservlet...
	 * @return
	 */
	public boolean  processRigister(UsersBean usersBean,String addr);
	 /**
     * ����ע�᣺ �����
     * @param email �����ַ
     * @param validateCode �����루user��remark�ֶΣ�
     * @throws ParseException 
     */
	public boolean processActivate(String email , String validateCode)throws ServiceException, ParseException;
	/**
	 * �����ʼ���ͨ�÷���
	 * @param email �����ʼ��� �����ַ ���� XXXXXXXX@qq.com
	 * @param describe �ʼ����������� ���磺����һ���µ���Ϣ������·����Ӳ鿴��
	 * @param url Ҫ���ӵ�ҳ���ַ������  http://localhost:8080/xyesj/index.jsp��param1=zzy&param2=123&name=����
	 * @param subject �ʼ����� ���磺���ֽ֣�����Ϣ
	 * @return ���ͳɹ�����true
	 */
	public boolean sendEmail(String email,String describe,String url,String subject);
}
