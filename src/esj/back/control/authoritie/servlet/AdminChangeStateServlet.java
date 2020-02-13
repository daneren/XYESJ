package esj.back.control.authoritie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.publicdoc.bean.AdminsBean;
import esj.publicdoc.service.AdminsBeanService;
import esj.publicdoc.service.impl.AdminsBeanServiceimpl;

public class AdminChangeStateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		int id;
		int flag;

		AdminsBean adminsBean=new AdminsBean();
		String id2=request.getParameter("id");
		id2=id2.trim();
		id = Integer.valueOf(id2);
		adminsBean.setAdminId(id);
		adminsBean.setState(request.getParameter("state"));
		//System.out.println(authoritiesBean.getAuthId());
		//System.out.println(authoritiesBean.getState());

		AdminsBeanService service =new AdminsBeanServiceimpl();
		flag = service.updateAdminsState(adminsBean);

		if (flag == 1) {
			String msg = null;
			msg = String.valueOf(flag);
			//System.out.println(flag);
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
