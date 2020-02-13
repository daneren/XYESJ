package esj.front.usercenter.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.front.usercenter.dao.impl.PUsersBeanDaoimpl;
import esj.front.usercenter.service.impl.EmailServiceimpl;
import esj.publicdoc.bean.UsersBean;
import esj.util.Random100;
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-26 ����7:57:31
 * @����޸�ʱ�� 2016-6-26 ����7:57:31
 * @���� ����ע���ȡ��֤��
 * @version 1.0
 */
@SuppressWarnings("serial")
public class XRegisterGetCaptchaServlet extends HttpServlet {
private PUsersBeanDaoimpl dao = new PUsersBeanDaoimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�����ķ�ʽ�������Ӧ��AJAX�첽������
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
				
		
		String type = request.getParameter("type");
		if("email".equals(type)){
			String email = request.getParameter("email");
			UsersBean user = dao.findUserByEmail(email);
			if(user == null){
				String captcha = Random100.getrandom10000();
				request.getSession().setAttribute("captcha", captcha);
				EmailServiceimpl sendemial = new EmailServiceimpl();
				String describe = "���ã���ӭ��ע����ֽ֡�<br/>����������֤��Ϊ��<b>"+captcha+"</b>���뾡�����ע�ᡣ";
				sendemial.sendEmail(email, describe, null, "���ֽ�ע��");
				//System.out.println(request.getSession().getAttribute("captcha"));
				pw.write("*��֤���Ѿ����͵����������У��뾡����ա�");//�����ķ�ʽ��������������
			}else{
				pw.write("*�������Ѿ�ע�ᣬ��<a href='login.jsp'>��¼</a>���߸�����������");//�����ķ�ʽ��������������
				
			}
			pw.flush();
			pw.close();
		}else if("captcha".equals(type)){
			String captcha = request.getParameter("captcha");
			String msg = "��֤�����";
			if(captcha.equals((String)request.getSession().getAttribute("captcha"))){
				msg="��֤����ȷ";
			}
			pw.write(msg);//�����ķ�ʽ��������������
			pw.flush();
			pw.close();
		}
		
	}

}
