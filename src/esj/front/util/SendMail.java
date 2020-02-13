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
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-6-25 下午8:36:01
 * @最后修改时间 2016-6-25 下午8:36:01
 * @描述：
 * @version 1.0
 */
public class SendMail {

	/**
	 * Title: 使用javamail发送邮件 Description: 演示如何使用javamail包发送电子邮件。这个实例可发送多附件
	 * 
	 * @version 1.0
	 */

	String to = "";// 收件人
	String from = "";// 发件人
	String username = "";
	String password = "";
	String filename = "";// 附件文件名
	String subject = "";// 邮件主题
	String content = "";// 邮件内容
	Vector file = new Vector();// 附件文件集合
	Multipart mp = null;//邮件正文，课添加附件
	

	/**
	 * <br>
	 * 方法说明：默认构造器 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	public SendMail() {
	}

	/**
	 * <br>
	 * 方法说明：构造器，提供直接的参数传入 <br>
	 * 输入参数： <br>
	 * 返回类型：
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
	 * 方法说明：设置登录服务器校验密码 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	public void setPassWord(String pwd) {
		this.password = pwd;
	}

	/**
	 * <br>
	 * 方法说明：设置登录服务器校验用户 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	public void setUserName(String usn) {
		this.username = usn;
	}

	/**
	 * <br>
	 * 方法说明：设置邮件发送目的邮箱 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * <br>
	 * 方法说明：设置邮件发送源邮箱 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * <br>
	 * 方法说明：设置邮件主题 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * <br>
	 * 方法说明：设置邮件内容 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * <br>
	 * 方法说明：把主题转换为中文 <br>
	 * 输入参数：String strText <br>
	 * 返回类型：
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
	 * 方法说明：往附件组合中添加附件 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	public void attachfile(String fname) {
		file.addElement(fname);
	}

	/**
	 * 设置文件正文，一般不用，需要发送附件时使用此方法
	 * @return
	 */
	public Multipart setMultipart() {
		// 构造Multipart
		 this.mp = new MimeMultipart();

		// 向Multipart添加正文
		MimeBodyPart mbpContent = new MimeBodyPart();
		try {
			mbpContent.setText(content);
			// 向MimeMessage添加（Multipart代表正文）
			this.mp.addBodyPart(mbpContent);

			// 向Multipart添加附件
			Enumeration efile = file.elements();
			while (efile.hasMoreElements()) {

				MimeBodyPart mbpFile = new MimeBodyPart();
				filename = efile.nextElement().toString();
				FileDataSource fds = new FileDataSource(filename);
				mbpFile.setDataHandler(new DataHandler(fds));
				mbpFile.setFileName(fds.getName());
				// 向MimeMessage添加（Multipart代表附件）
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
	 * 方法说明：发送邮件 <br>
	 * 输入参数： <br>
	 * 返回类型：boolean 成功为true，反之为false
	 */
	public boolean sendMail() {
		this.setemailmessage();
		// 构造mail session
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.qq.com");
		props.put("mail.smtp.socketFactory.port", 465);
		props.put("mail.store.protocol", "smpt");// 设置协议
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
			// 构造MimeMessage 并设定基本的值
			MimeMessage msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			subject = transferChinese(subject);
			msg.setSubject(subject);//设置文件主题主题

			
			if(this.mp !=null){
				// 向Multipart添加MimeMessage
				msg.setContent(mp);
			}else{
				msg.setContent(content, "text/html;charset=utf-8");// 设置编码格式
			}			
			
			msg.setSentDate(new Date());
			// 发送邮件
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
	 * 方法说明：主方法，用于测试 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	public void setemailmessage() {

		// this.setHost("smtp.qq.com");// smtp.mail.yahoo.com.cn
		this.setUserName("3128018773@qq.com");// 您的邮箱用户名
		// this.setPassWord("xxk941020");// 您的邮箱密码
		this.setPassWord("puvltemwlujwdfja");// 您的邮箱密码

		this.setFrom("3128018773@qq.com");// 发送者

	}
}
