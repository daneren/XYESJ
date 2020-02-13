package esj.back.user_info_manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import esj.back.user_info_manage.dao.admin_adminbeandao;
import esj.back.user_info_manage.dao.impl.admin_adminbeandaoimpl;
import esj.front.util.LogsFileUtil;
import esj.publicdoc.bean.AdminsBean;
import esj.util.DateHelper;
import esj.util.GetIpAddr;

public class admin_back_login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("textml;charset=UTF-8");
		String type = "";
		if( request.getParameter("type") != ""||  request.getParameter("type") != null){
			type = request.getParameter("type");
		}
		if("logout".equals(type)){
			HttpSession session = request.getSession();
			session.removeAttribute("admin");
			session.invalidate();
			response.sendRedirect("login.jsp");
		}else{
		PrintWriter pwd = response.getWriter();
		String pw;
		String zh;
		int flag;
		admin_adminbeandao service =new admin_adminbeandaoimpl();
		zh =request.getParameter("zh");
		AdminsBean adminbean=service.findAdminsByAdminId(zh);
		pw=request.getParameter("pw");
		if(adminbean==null)
		{
			//JOptionPane.showMessageDialog(null, "账号不存在，请重新输入！");
			
			pwd.print("<script language='javascript'>alert('Account is not found, please enter again!');window.location.href='login.jsp';</script>");
			//response.sendRedirect("login.jsp");
			//request.getRequestDispatcher("/back/login.jsp").forward(request, response);
		}
		else
		{
			if(adminbean.getAdminPwd().equalsIgnoreCase(pw))
			{	request.getSession().setAttribute("admin",adminbean );
				//JOptionPane.showMessageDialog(null, "登录成功！");
				pwd.print("<script language='javascript'>window.location.href='/XYESJ/back/Jquery_bg/bg.jsp?authid="+adminbean.getAuthId()+"';</script>");
				
				//request.getRequestDispatcher("/back/Jquery_bg/bg.jsp").forward(request, response);
			}
			else
			{
				//JOptionPane.showMessageDialog(null, "密码错误!");
				pwd.print("<script language='javascript'>alert('PASSWORD ERROR!');window.location.href='login.jsp';</script>");
//				response.sendRedirect("login.jsp");
				//request.getRequestDispatcher("/back/login.jsp").forward(request, response);
			}
		}
		}
	}


}
