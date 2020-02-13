package esj.front.usercenter.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.front.usercenter.bean.ProCommBean;
import esj.front.usercenter.service.PProductsBeanService;
import esj.front.usercenter.service.PReservesBeanService;
import esj.front.usercenter.service.impl.PProductsBeanServiceimpl;
import esj.front.usercenter.service.impl.PReservesBeanServiceimpl;
import esj.publicdoc.bean.UsersBean;

public class SDealingServlet extends HttpServlet {

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
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			String op = request.getParameter("op");
			if("".equals(op.trim()) || op == null){
				response.getWriter().println("<h1>404,页面没有找到</h1>");
				return;
			}
			PReservesBeanService pBeanService = new PReservesBeanServiceimpl();
			String userId = ((UsersBean)request.getSession().getAttribute("user")).getUserId();
			List<ProCommBean> pBeans = null;
			
			if("1".equals(op)){
				
			}else if("2".equals(op)){
				String reserveId = request.getParameter("id");
				if(!"".equals(reserveId.trim())&& reserveId != null){
					String[] s = reserveId.split(",");
					reserveId = s[0];
					String proId = s[1];
					pBeanService.updateReserveState(reserveId, "交易达成");
					PProductsBeanService ppService = new PProductsBeanServiceimpl();
					ppService.setProductStateByProId(proId, "已售出");
				}
				
			}else if("3".equals(op)){
				String reserveId = request.getParameter("id");
				
				if(!"".equals(reserveId.trim())&& reserveId != null){
					String[] s = reserveId.split(",");
					reserveId = s[0];
					String proId = s[1];
					PProductsBeanService ppService = new PProductsBeanServiceimpl();
					ppService.setProductStateByProId(proId, "出售中");
					pBeanService.updateReserveState(reserveId, "交易失败");
					pBeanService.updateReserveStates(proId, "已退回", "已预约");
					
				}
				
			}else{
				response.getWriter().println("<h1>404,页面没有找到</h1>");
				return;				
			}
			
			pBeans = pBeanService.getSellerDealing(userId);
			request.setAttribute("uDeal", pBeans);
			request.getRequestDispatcher("person_sdeal.jsp").forward(request, response);

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
			doPost(request, response);
	}

}
