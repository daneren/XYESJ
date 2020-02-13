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
		
		if(yzm.equals(captcha)){//验证码输入正确
			EmailServiceimpl sendemial = new EmailServiceimpl();
			String pwd = Random100.getRandomcharacters()+Random100.getrandom10000();
			String describe = "您好，您的登陆密码已重置。<br/>重置密码为：<b>"+pwd+"</b>，请登陆后在个人中心修改密码。";
			sendemial.sendEmail(email, describe, null, "二手街用户密码找回");
			//在数据库中修改用户的密码
			XUsersBeanServiceImpl userser = new XUsersBeanServiceImpl();
			int count = userser.changePwdByEmail(email, pwd);
			if(count == 1){
				pw.write("ok");//以流的方式向浏览器输出内容
			}else{
				pw.write("error");//以流的方式向浏览器输出内容
			}
		}else{
			pw.write("yzmerror");//以流的方式向浏览器输出内容
		}
		pw.flush();
		pw.close();
		
		
	}

}
