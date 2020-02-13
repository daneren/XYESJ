package esj.back.user_info_manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.back.user_info_manage.dao.admin_usersbeandao;
import esj.back.user_info_manage.dao.impl.admin_usersbeandaoimpl;
import esj.publicdoc.bean.RnotesBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.dao.RnotesBeanDao;
import esj.publicdoc.dao.UsersBeanDao;
import esj.publicdoc.dao.impl.RnotesBeanDaoimpl;
import esj.publicdoc.dao.impl.UsersBeanDaoimpl;
import esj.publicdoc.service.UsersBeanService;
import esj.publicdoc.service.impl.UsersBeanServiceimpl;

public class admin_userschangestateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public admin_userschangestateServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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

		doPost(request, response);
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

		response.setContentType("textml;charset=UTF-8");
		PrintWriter pwd = response.getWriter();
		String id;
		//String pw;
		//String zh;
		int flag;
		String state;
		id =request.getParameter("id");
		//pw=request.getParameter("pw");
		//System.out.println(zh);
		state=request.getParameter("state");
		//System.out.println(pw);
		UsersBean usersBean = new UsersBean();
		//usersBean.setUserName(name);
		usersBean.setUserId(id);
		usersBean.setState(state);
		//admin_usersbeandao service = new admin_usersbeandaoimpl();
		UsersBeanService service=new UsersBeanServiceimpl();
		flag = service.changeUserState(usersBean);
		if (flag == 1) {
			String msg = null;
			msg = String.valueOf(flag);
			//System.out.println(flag);
			pwd.write(msg);// 以流的方式向浏览器输出内容
			pwd.flush();
			pwd.close();
		} else {
			String msg = null;
			msg = String.valueOf(flag);
			pwd.write(msg);// 以流的方式向浏览器输出内容
			pwd.flush();
			pwd.close();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
