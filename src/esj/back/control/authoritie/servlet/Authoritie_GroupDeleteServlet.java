package esj.back.control.authoritie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.back.control.authoritie.service.AuthoritiesBeanService;
import esj.back.control.authoritie.service.impl.AuthoritiesBeanServiceImpl;
import esj.publicdoc.bean.AuthoritiesBean;


public class Authoritie_GroupDeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// �����ķ�ʽ�������Ӧ��AJAX�첽������
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter pw = response.getWriter();
				int id;
				int flag;

				AuthoritiesBean authoritiesBean = new AuthoritiesBean();

				id = Integer.valueOf(request.getParameter("id"));
				authoritiesBean.setAuthId(id);

				AuthoritiesBeanService service = new AuthoritiesBeanServiceImpl();
				flag = service.deleteAuthoritiesByID(authoritiesBean);


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

}
