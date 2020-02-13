package esj.back.levels_manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import esj.publicdoc.bean.UserlevelsBean;
import esj.publicdoc.dao.impl.UserlevelsBeanDaoimpl;
import esj.publicdoc.service.UserlevelsBeanService;
import esj.publicdoc.service.impl.UserlevelsBeanServiceimpl;
/**
 * 
 * @author qingsong
 *
 */
public class admin_savelevelsServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public admin_savelevelsServlet() {
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
		UserlevelsBeanServiceimpl  levelser = new UserlevelsBeanServiceimpl();
		PrintWriter pw = response.getWriter();
		
		String lid = request.getParameter("lid");
		String lname = request.getParameter("lname");
		String lmaxnum = request.getParameter("lmaxnum");
		
		int count = levelser.updateUserlevels(new UserlevelsBean(Integer.parseInt(lid), lname, Integer.parseInt(lmaxnum), null));
		if(count == 1){
			pw.write("ok");
		}else{
			pw.write("error");
		}
		/**
		 *  
		 */
		pw.flush();
		pw.close();
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
