package esj.front.util;

import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

/**
 * 
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-6-25 ����8:36:01
 * @����޸�ʱ�� 2016-6-25 ����8:36:01
 * @������
 * @version 1.0
 */
public class SendMail {

	/**
	 * Title: ʹ��javamail�����ʼ� Description: ��ʾ���ʹ��javamail�����͵����ʼ������ʵ���ɷ��Ͷ฽��
	 * 
	 * @version 1.0
	 */

	String to = "";// �ռ���
	String from = "";// ������
	String username = "";
	String password = "";
	String filename = "";// �����ļ���
	String subject = "";// �ʼ�����
	String content = "";// �ʼ�����
	Vector file = new Vector();// �����ļ�����
	Multipart mp = null;//�ʼ����ģ�����Ӹ���
	

	/**
	 * <br>
	 * ����˵����Ĭ�Ϲ����� <br>
	 * ��������� <br>
	 * �������ͣ�
	 */
	public SendMail() {
	}

	/**
	 * <br>
	 * ����˵�������������ṩֱ�ӵĲ������� <br>
	 * ��������� <br>
	 * �������ͣ�
	 */
	public SendMail(String to, String from, String username, String password,
			String subject, String content) {
		this.to = to;
		this.from = from;
		this.username = username;
		this.password = password;
		this.subject = subject;
		this.content = content;
	}

	/**
	 * <br>
	 * ����˵�������õ�¼������У������ <br>
	 * ��������� <br>
	 * �������ͣ�
	 */
	public void setPassWord(String pwd) {
		this.password = pwd;
	}

	/**
	 * <br>
	 * ����˵�������õ�¼������У���û� <br>
	 * ��������� <br>
	 * �������ͣ�
	 */
	public void setUserName(String usn) {
		this.username = usn;
	}

	/**
	 * <br>
	 * ����˵���������ʼ�����Ŀ������ <br>
	 * ��������� <br>
	 * �������ͣ�
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * <br>
	 * ����˵���������ʼ�����Դ���� <br>
	 * ��������� <br>
	 * �������ͣ�
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * <br>
	 * ����˵���������ʼ����� <br>
	 * ��������� <br>
	 * �������ͣ�
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * <br>
	 * ����˵���������ʼ����� <br>
	 * ��������� <br>
	 * �������ͣ�
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * <br>
	 * ����˵����������ת��Ϊ���� <br>
	 * ���������String strText <br>
	 * �������ͣ�
	 */
	public String transferChinese(String strText) {
		try {
			strText = MimeUtility.encodeText(new String(strText.getBytes(),
					"GB2312"), "GB2312", "B");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strText;
	}

	/**
	 * <br>
	 * ����˵�����������������Ӹ��� <br>
	 * ��������� <br>
	 * �������ͣ�
	 */
	public void attachfile(String fname) {
		file.addElement(fname);
	}

	/**
	 * �����ļ����ģ�һ�㲻�ã���Ҫ���͸���ʱʹ�ô˷���
	 * @return
	 */
	public Multipart setMultipart() {
		// ����Multipart
		 this.mp = new MimeMultipart();

		// ��Multipart�������
		MimeBodyPart mbpContent = new MimeBodyPart();
		try {
			mbpContent.setText(content);
			// ��MimeMessage��ӣ�Multipart�������ģ�
			this.mp.addBodyPart(mbpContent);

			// ��Multipart��Ӹ���
			Enumeration efile = file.elements();
			while (efile.hasMoreElements()) {

				MimeBodyPart mbpFile = new MimeBodyPart();
				filename = efile.nextElement().toString();
				FileDataSource fds = new FileDataSource(filename);
				mbpFile.setDataHandler(new DataHandler(fds));
				mbpFile.setFileName(fds.getName());
				// ��MimeMessage��ӣ�Multipart��������
				this.mp.addBodyPart(mbpFile);

			}
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		file.removeAllElements();
		return this.mp;
	}

	/**
	 * <br>
	 * ����˵���������ʼ� <br>
	 * ��������� <br>
	 * �������ͣ�boolean �ɹ�Ϊtrue����֮Ϊfalse
	 */
	public boolean sendMail() {
		this.setemailmessage();
		// ����mail session
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.qq.com");
		props.put("mail.smtp.socketFactory.port", 465);
		props.put("mail.store.protocol", "smpt");// ����Э��
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		Session session = Session.getDefaultInstance(props,
				new Authenticator() {
					public PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {
			// ����MimeMessage ���趨������ֵ
			MimeMessage msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			subject = transferChinese(subject);
			msg.setSubject(subject);//�����ļ���������

			
			if(this.mp !=null){
				// ��Multipart���MimeMessage
				msg.setContent(mp);
			}else{
				msg.setContent(content, "text/html;charset=utf-8");// ���ñ����ʽ
			}			
			
			msg.setSentDate(new Date());
			// �����ʼ�
			Transport.send(msg);

		} catch (MessagingException mex) {
			mex.printStackTrace();
			Exception ex = null;
			if ((ex = mex.getNextException()) != null) {
				ex.printStackTrace();
			}
			return false;
		}
		return true;
	}

	/**
	 * <br>
	 * ����˵���������������ڲ��� <br>
	 * ��������� <br>
	 * �������ͣ�
	 */
	public void setemailmessage() {

		// this.setHost("smtp.qq.com");// smtp.mail.yahoo.com.cn
		this.setUserName("3128018773@qq.com");// ���������û���
		// this.setPassWord("xxk941020");// ������������
		this.setPassWord("puvltemwlujwdfja");// ������������

		this.setFrom("3128018773@qq.com");// ������

	}
}
