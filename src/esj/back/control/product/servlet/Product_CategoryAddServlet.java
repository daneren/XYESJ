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

public class Product_CategoryAddServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7254577917935220884L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 以流的方式将结果响应到AJAX异步对象中
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();

		int flag;
		int id=Integer.parseInt(request.getParameter("typeId"));
		String name=request.getParameter("typeName");
		ProtypesBean protypesBean=new ProtypesBean();
		protypesBean.setFatherId(id);
		protypesBean.setTypeName(name);
	
		/*
		 *新增一个分类 
		 */
		ProtypesService service=new ProtypesServiceImpl();
		flag = service.addProtypes(protypesBean);
		
		/*
		 * 同步父分类
		 */
		if(id!=0)
		{
			ProtypesBeanService service2=new ProtypesBeanServiceimpl();
			ProtypesBean fatherProtypes=service2.findProtypesById(id);
			
			String childId=fatherProtypes.getChildId()+","
					+service.findProtypesByName(protypesBean).getTypeId();
			fatherProtypes.setChildId(childId);
			
			service.updateProtypesChildID(fatherProtypes);
		}
		
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
