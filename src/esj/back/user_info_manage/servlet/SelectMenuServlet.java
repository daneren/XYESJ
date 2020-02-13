package esj.back.user_info_manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.publicdoc.bean.MenusBean;
import esj.publicdoc.service.AuthoritiesBeanService;
import esj.publicdoc.service.MenusBeanService;
import esj.publicdoc.service.impl.AuthoritiesBeanServiceimpl;
import esj.publicdoc.service.impl.MenusBeanServiceimpl;

public class SelectMenuServlet extends HttpServlet {

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
	 * @throws IOException if an error occurred						MenusBeanDaoimpl
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		AuthoritiesBeanService service=new AuthoritiesBeanServiceimpl();
		String id2=request.getParameter("id");
		int id=Integer.parseInt(id2);
		String AuthoritiesMenuList=service.findAuthoritiesById(id).getMenuList();	
		
		
		MenusBeanService service2=new MenusBeanServiceimpl();
		List<MenusBean> MenuList = service2.findAllMenus();
		
		request.setAttribute("AuthoritiesMenuList", AuthoritiesMenuList);
		request.setAttribute("MenuList", MenuList);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		//response.sendRedirect("../index.jsp");
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
