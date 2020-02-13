package esj.back.user_info_manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.back.levels_manage.dao.admin_levelsbeandao;
import esj.back.levels_manage.dao.impl.admin_levelsbeandaoimpl;
import esj.publicdoc.bean.LnotesBean;
import esj.publicdoc.bean.UserlevelsBean;
import esj.publicdoc.dao.LnotesBeanDao;
import esj.publicdoc.dao.impl.LnotesBeanDaoimpl;

public class admin_lnoteschangestateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public admin_lnoteschangestateServlet() {
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
		state=request.getParameter("state");
		LnotesBean lnotesBean = new LnotesBean();
		lnotesBean.setLeaveId(id+"");
		lnotesBean.setState(state);
		LnotesBeanDao service = new LnotesBeanDaoimpl();
		flag = service.changeLnotesState(lnotesBean);
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
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
