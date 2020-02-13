package esj.front.usercenter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.impl.UsersBeanServiceimpl;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-27 上午11:19:00
 * @最后修改时间 2016-6-27 上午11:19:00
 * @描述 用户注册servlet
 * @version 1.0
 */
public class XRegisterServlet extends HttpServlet {
private UsersBeanServiceimpl service = new UsersBeanServiceimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("nicheng");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		int count =service.saveUsers(new UsersBean(null, null, name, pwd, null, null, null, null, null, null, null, null, null, null, null, email, null));
		if(count == 1){
			response.sendRedirect("login.jsp");
		}else{
			
		}
	}

}
