package esj.front.usercenter.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import esj.front.usercenter.bean.ProCommBean;
import esj.front.usercenter.service.PProductsBeanService;
import esj.front.usercenter.service.PReservesBeanService;
import esj.front.usercenter.service.impl.PProductsBeanServiceimpl;
import esj.front.usercenter.service.impl.PReservesBeanServiceimpl;
import esj.publicdoc.bean.ProductsBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.ProductsBeanService;
import esj.publicdoc.service.UsersBeanService;
import esj.publicdoc.service.impl.ProductsBeanServiceImpl;
import esj.publicdoc.service.impl.UsersBeanServiceimpl;
/**
 * 
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-7-6 ����11:13:59
 * @����޸�ʱ�� 2016-7-6 ����11:13:59
 * @������
 * @version 1.0
 */
public class SoldProServlet extends HttpServlet {

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
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String buyerId =((UsersBean) session.getAttribute("user")).getUserId();	
		String op = (String) request.getParameter("op");
		if(op.trim().equals("") || op == null){
			return;
		}
		
		PProductsBeanService pProductsBeanService = new PProductsBeanServiceimpl();
		if(op.trim().equals("3")){
			//op = 3ɾ��һ����¼
			String id = (String)request.getParameter("id");
			if(!id.trim().equals("")&& id !=null){
				ProductsBeanService productsBeanService = new ProductsBeanServiceImpl();
				ProductsBean pBean = new ProductsBean();
				pBean.setState("��ɾ��");
				pBean.setProId(id);
				productsBeanService.changeProductsState(pBean);
			}			
		}
		op = "1";
		List<ProCommBean> pOnSale = pProductsBeanService.getOnSale(buyerId);
		request.setAttribute("pOnSale", pOnSale);
		List<ProCommBean> pSoldOut = pProductsBeanService.getSoldOut(buyerId);
		request.setAttribute("pSoldOut", pSoldOut);
		request.setAttribute("op", op);
		request.getRequestDispatcher("person_soldpro.jsp").forward(request, response);    
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ж��Ƿ��½
		if(request.getSession().getAttribute("user") == null){
			return;
		}else{
			doGet(request, response);
		}
	}

}
