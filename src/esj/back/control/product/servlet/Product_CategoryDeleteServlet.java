package esj.back.control.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.back.control.product.service.ProtypesService;
import esj.back.control.product.service.impl.ProtypesServiceImpl;
import esj.publicdoc.bean.ProtypesBean;
import esj.publicdoc.service.ProtypesBeanService;
import esj.publicdoc.service.impl.ProtypesBeanServiceimpl;

public class Product_CategoryDeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5026546228488143948L;

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

		// 以流的方式将结果响应到AJAX异步对象中
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter pw = response.getWriter();

				int flag;
				int id=Integer.parseInt(request.getParameter("id"));
				ProtypesBean protypesBean=new ProtypesBean();
				protypesBean.setTypeId(id);
			
				/*
				 *删除父类的子类 
				 */
				ProtypesBeanService service=new ProtypesBeanServiceimpl();
				ProtypesService service2=new ProtypesServiceImpl();
				
				ProtypesBean protypesBeanchildId=service.findProtypesById(id);
				int fatherId=protypesBeanchildId.getFatherId();
				/*
				 * fatherId==0,无需更新父类
				 */
				if(fatherId!=0)
				{
					ProtypesBean protypesBeanfather=service.findProtypesById(fatherId);
					String childId=protypesBeanfather.getChildId();
					childId=childId.replace(","+id, "");
					protypesBeanfather.setChildId(childId);
					
					service2.updateProtypesChildID(protypesBeanfather);
					
				}

				
				/*
				 * 删除子类
				 */
				flag = service.removeProtypes(protypesBean);
				
				
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
