package esj.back.control.authoritie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.publicdoc.bean.AuthoritiesBean;
import esj.publicdoc.service.AuthoritiesBeanService;
import esj.publicdoc.service.impl.AuthoritiesBeanServiceimpl;

public class Authoritie_GroupAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 以流的方式将结果响应到AJAX异步对象中
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter pw = response.getWriter();

				int flag;

				AuthoritiesBean authoritiesBean = new AuthoritiesBean();
				//name="+name+"&menu
				authoritiesBean.setAuthName(request.getParameter("name"));
				authoritiesBean.setMenuList(request.getParameter("menu"));
				authoritiesBean.setState("已启用");
				System.out.println(authoritiesBean.getAuthName());
				System.out.println(authoritiesBean.getMenuList());

				AuthoritiesBeanService service = new AuthoritiesBeanServiceimpl();
				flag = service.saveAuthorities(authoritiesBean);

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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

	}

}
