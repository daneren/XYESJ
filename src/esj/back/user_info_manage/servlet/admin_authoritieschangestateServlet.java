package esj.back.user_info_manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.publicdoc.bean.AuthoritiesBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.dao.AuthoritiesBeanDao;
import esj.publicdoc.dao.UsersBeanDao;
import esj.publicdoc.dao.impl.AuthoritiesBeanDaoimpl;
import esj.publicdoc.dao.impl.UsersBeanDaoimpl;

public class admin_authoritieschangestateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public admin_authoritieschangestateServlet() {
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
		PrintWriter pw = response.getWriter();
		int id;
		int flag;
		String state;
		id = Integer.valueOf(request.getParameter("id"));
		System.out.println(id);
		state=request.getParameter("state");
		AuthoritiesBean authoritiesBean = new AuthoritiesBean();
		authoritiesBean.setAuthId(id);
		authoritiesBean.setState(state);
		AuthoritiesBeanDao service = new AuthoritiesBeanDaoimpl();
		flag = service.changeAuthorityState(authoritiesBean);
		if (flag == 1) {
			String msg = null;
			msg = String.valueOf(flag);
			//System.out.println(flag);
			pw.write(msg);// �����ķ�ʽ��������������
			pw.flush();
			pw.close();
		} else {
			String msg = null;
			msg = String.valueOf(flag);
			pw.write(msg);// �����ķ�ʽ��������������
			pw.flush();
			pw.close();
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