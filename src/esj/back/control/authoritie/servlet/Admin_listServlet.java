package esj.back.control.authoritie.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.publicdoc.bean.AdminsBean;
import esj.publicdoc.service.AdminsBeanService;
import esj.publicdoc.service.impl.AdminsBeanServiceimpl;

public class Admin_listServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			AdminsBeanService service=new AdminsBeanServiceimpl();
			
			List<AdminsBean> list = service.findAllAdmins();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/back/control_authoritie/admin_list.jsp").forward(request, response);
		
	}


}
