package esj.back.control.authoritie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.back.control.authoritie.service.AdminService;
import esj.back.control.authoritie.service.impl.AdminServiceImpl;
import esj.publicdoc.bean.AdminsBean;

public class Admin_AddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1675997750774966942L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * 		var adminPhone = document.getElementById('adminPhone').value;
		var rigistday=document.getElementById('adminPhone').value;
		var sex=document.getElementById('sex').value;
		var authoritie=document.getElementById('selects').value;
		var pw=document.getElementById('pw').value;
		 */
		// 以流的方式将结果响应到AJAX异步对象中
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();

		int flag;
		String state="已启用";
		
		AdminsBean adminsBean=new AdminsBean();
		 
		adminsBean.setAdminPhone(request.getParameter("adminPhone"));
		adminsBean.setRigistDay(request.getParameter("rigistday"));
		adminsBean.setSex(request.getParameter("sex"));
		adminsBean.setAdminPwd(request.getParameter("pw"));
		adminsBean.setAdminName(request.getParameter("name"));
		adminsBean.setAuthId(Integer.parseInt(request.getParameter("authoritie")));
		adminsBean.setState(state);
		
		//System.out.println(adminsBean.toString());

		AdminService service =new AdminServiceImpl();
		flag = service.addAdmin(adminsBean);

		if (flag == 1) {
			String msg = null;
			msg = String.valueOf(flag);
			
			pw.write(msg);// 以流的方式向浏览器输出内容
			pw.flush();
			pw.close();
		} else {
			String msg = null;
			msg = String.valueOf(flag);
			pw.write(msg);// 以流的方式向浏览器输出内容
			pw.flush();
			pw.close();
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
