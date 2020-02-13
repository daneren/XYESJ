package esj.back.levels_manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.publicdoc.bean.UserlevelsBean;
import esj.publicdoc.service.UserlevelsBeanService;
import esj.publicdoc.service.impl.UserlevelsBeanServiceimpl;

public class admin_getlevelsServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("sdsd");
		UserlevelsBeanServiceimpl  levelser = new UserlevelsBeanServiceimpl();
		PrintWriter pw = response.getWriter();	
		String lname = request.getParameter("lname");
		String lvalues = request.getParameter("lvalues");
		//System.out.println(lname+lvalues);
		int count = levelser.saveUserlevels(new UserlevelsBean(lname, Integer.parseInt(lvalues)));
		if(count == 1){
			pw.write("ok");
			//System.out.println("ok");
		}else{
			pw.write("error");
		}
		/**
		 *  
		 */
		pw.flush();
		pw.close();
		
		
		
	}
}
