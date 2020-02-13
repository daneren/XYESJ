package esj.back.control.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.back.util.Product_CategoryServletComparator;
import esj.publicdoc.bean.ProtypesBean;
import esj.publicdoc.service.ProtypesBeanService;
import esj.publicdoc.service.impl.ProtypesBeanServiceimpl;


public class Product_CategoryServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4642610529322921296L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		ProtypesBeanService service=new ProtypesBeanServiceimpl();
		
		List<ProtypesBean> list = service.findAllProtypes();
		
		Collections.sort(list,new Product_CategoryServletComparator());
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/back/control_product/product_category.jsp").forward(request, response);
	}


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
