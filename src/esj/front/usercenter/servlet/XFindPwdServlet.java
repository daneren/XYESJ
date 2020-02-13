package esj.front.usercenter.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.front.usercenter.service.impl.EmailServiceimpl;
import esj.front.usercenter.service.impl.XUsersBeanServiceImpl;
import esj.util.Random100;

@SuppressWarnings("serial")
public class XFindPwdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("email");
		String yzm = request.getParameter("yzm");
		String captcha = (String) request.getSession().getAttribute("captcha");
		
		if(yzm.equals(captcha)){//��֤��������ȷ
			EmailServiceimpl sendemial = new EmailServiceimpl();
			String pwd = Random100.getRandomcharacters()+Random100.getrandom10000();
			String describe = "���ã����ĵ�½���������á�<br/>��������Ϊ��<b>"+pwd+"</b>�����½���ڸ��������޸����롣";
			sendemial.sendEmail(email, describe, null, "���ֽ��û������һ�");
			//�����ݿ����޸��û�������
			XUsersBeanServiceImpl userser = new XUsersBeanServiceImpl();
			int count = userser.changePwdByEmail(email, pwd);
			if(count == 1){
				pw.write("ok");//�����ķ�ʽ��������������
			}else{
				pw.write("error");//�����ķ�ʽ��������������
			}
		}else{
			pw.write("yzmerror");//�����ķ�ʽ��������������
		}
		pw.flush();
		pw.close();
		
		
	}

}
