package esj.front.usercenter.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import esj.front.usercenter.bean.ProCommBean;
import esj.front.usercenter.service.PReservesBeanService;
import esj.front.usercenter.service.impl.EmailServiceimpl;
import esj.front.usercenter.service.impl.PReservesBeanServiceimpl;
import esj.publicdoc.bean.ReservesBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.ReservesBeanService;
import esj.publicdoc.service.impl.ReservesBeanServiceimpl;
/**
 * �鿴���������Ʒ
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-7-1 ����1:01:18
 * @����޸�ʱ�� 2016-7-06 ����1:01:18
 * @������
 * @version 1.0
 */
public class ReservServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String buyerId = ((UsersBean) session.getAttribute("user")).getUserId();		
		String op = (String) request.getParameter("op");
		buyerId = ((UsersBean) session.getAttribute("user")).getUserId();
		if(op.trim().equals("") || op == null){
			return;
		}
		
		PReservesBeanService pBeanService = new PReservesBeanServiceimpl();
		if("1".equals(op)){
			//ԤԼ�ɹ���
			List<ProCommBean> uBuy = pBeanService.getUserBuy(buyerId);			
			request.setAttribute("uBuy", uBuy);
			//ԤԼ��			
			List<ProCommBean> uReserves = pBeanService.getUserReserve(buyerId);			
			request.setAttribute("uReserves", uReserves);
			op = "1";
			request.setAttribute("op", op);
			request.getRequestDispatcher("person_buypro.jsp").forward(request, response);			
			
		}else if(op.trim().equals("3")){
			//ԤԼ�� ȡ��ԤԼ
			String reservId = (String) request.getParameter("id");
			if(!reservId.trim().equals("") && reservId !=null){
				ReservesBeanService rBeanService = new ReservesBeanServiceimpl();
				ReservesBean rBean = new ReservesBean();
				rBean.setState("ȡ��ԤԼ");
				rBean.setReservId(reservId);
				rBeanService.removeReserves(rBean);
				response.getWriter().println("ȡ���ɹ�");
				return;
			}else{
				return;
			}
			
		}else if("4".equals(op)){
			String reserveId = (String) request.getParameter("id");
			ReservesBean rBean = pBeanService.getSellerMag(reserveId);
			if(rBean != null){
				String proUrl = "http://www.arice.ren:80:"+request.getContextPath()+"/";
				String qURL = proUrl+"person_center/AllReserv?op=1";
				//4.ƴ���ʼ�����
				String describe = "�װ���"+rBean.getBuyerId() +",���Ŀͻ���������һ�£�" +
						"��������(<a href ='"+proUrl+"XProductInfo?proId="+rBean.getProId()+"'>"+rBean.getRemark()+"</a>)," +
						"����<font size='20px;'>��"+ rBean.getBuyerPrice()+"</font>,�Ͽ촦��ɡ�<br>"+qURL +
								"<br>����<font color='red' size='20px;'>3</font>" +
						"��δ����ģ�ϵͳ�����Զ�ȡ���ö�����������������㣬�����½⡣";
				
				//5.�����ʼ�
				EmailServiceimpl sendemial = new EmailServiceimpl();
				sendemial.sendEmail(rBean.getSellerId(), describe, null, "���ֽ�-��������");
				response.getWriter().println("���ѳɹ�");
				return;
			}
			
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
