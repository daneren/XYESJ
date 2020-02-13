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
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-26 下午7:57:31
 * @最后修改时间 2016-6-26 下午7:57:31
 * @描述 邮箱注册获取验证码
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
		//以流的方式将结果响应到AJAX异步对象中
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
				String describe = "您好，欢迎您注册二手街。<br/>您的邮箱验证码为：<b>"+captcha+"</b>，请尽快完成注册。";
				sendemial.sendEmail(email, describe, null, "二手街注册");
				//System.out.println(request.getSession().getAttribute("captcha"));
				pw.write("*验证码已经发送到您的邮箱中，请尽快查收。");//以流的方式向浏览器输出内容
			}else{
				pw.write("*此邮箱已经注册，请<a href='login.jsp'>登录</a>或者改用其他邮箱");//以流的方式向浏览器输出内容
				
			}
			pw.flush();
			pw.close();
		}else if("captcha".equals(type)){
			String captcha = request.getParameter("captcha");
			String msg = "验证码错误";
			if(captcha.equals((String)request.getSession().getAttribute("captcha"))){
				msg="验证码正确";
			}
			pw.write(msg);//以流的方式向浏览器输出内容
			pw.flush();
			pw.close();
		}
		
	}

}
