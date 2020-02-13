package esj.back.control.authoritie.servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.back.util.Authoritie_GroupComparator;
import esj.publicdoc.bean.AuthoritiesBean;
import esj.publicdoc.service.AuthoritiesBeanService;
import esj.publicdoc.service.impl.AuthoritiesBeanServiceimpl;

public class Authoritie_GroupServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		AuthoritiesBeanService service=new AuthoritiesBeanServiceimpl();
		
		List<AuthoritiesBean> list = service.findAllAuthorities();
		
		Collections.sort(list,new Authoritie_GroupComparator());
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/back/control_authoritie/authoritie_group.jsp").forward(request, response);
	}

}
