package esj.front.usercenter.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.front.usercenter.bean.ProCommBean;
import esj.front.usercenter.service.PReservesBeanService;
import esj.front.usercenter.service.impl.EmailServiceimpl;
import esj.front.usercenter.service.impl.PProductsBeanServiceimpl;
import esj.front.usercenter.service.impl.PReservesBeanServiceimpl;
import esj.publicdoc.bean.ReservesBean;
import esj.publicdoc.bean.UsersBean;

@SuppressWarnings("serial")
public class AllReservServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		
		String op = request.getParameter("op");
		if(op.trim().equals("") || op == null){
			return;
		}
		PReservesBeanService pBeanService = new PReservesBeanServiceimpl();
		String userId = ((UsersBean)request.getSession().getAttribute("user")).getUserId();
		//userId = "a840e541c87c41089843ad1bf226a0a1";
		List<ProCommBean> allReserv = pBeanService.getAllReserved(userId);
		request.setAttribute("allReserv", allReserv);
		if("1".equals(op)){
			request.getRequestDispatcher("person_proreserv.jsp").forward(request, response);
		}else if("2".equals(op)){
			String proId = request.getParameter("id");
			List<ReservesBean> detailRe = pBeanService.getDetailReserved(proId);
			request.setAttribute("proId",proId );
			request.setAttribute("detailRe", detailRe);
			request.getRequestDispatcher("reserv_modal.jsp").forward(request, response);
			
		}else if("3".equals(op)){
			String reserveId = request.getParameter("id");
			reserveId = reserveId.substring(1);
			int count = pBeanService.updateReserveState(reserveId, "���˻�");
			request.getRequestDispatcher("reserv_tabel.jsp").forward(request, response);
			
		}else if("4".equals(op)){
			String reserveId = request.getParameter("id");
			reserveId = reserveId.substring(1);
			String[] s = reserveId.split(",");
			reserveId =s[0];
			String proId = s[1];
			int count = pBeanService.acceptReserv(proId, reserveId, "������");
			//������Ʒ�����Ʒ״̬Ϊ������
			new PProductsBeanServiceimpl().setProductStateByProId(proId, "������");
			//���ʼ�
			String proUrl = "http://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+"/";
			ReservesBean rBean = pBeanService.getUserMag(reserveId);
			sendEmailToUser(proId, rBean.getRemark(),
					rBean.getBuyerPrice()+"", rBean.getSellerId(),
					rBean.getBuyerId(), proUrl);
			
			request.getRequestDispatcher("reserv_tabel.jsp").forward(request, response);
			
		}else if("5".equals(op)){
			String proId = request.getParameter("id");
			int count = pBeanService.turndownAllReserv(proId, "��ԤԼ", "���˻�");
			request.getRequestDispatcher("reserv_tabel.jsp").forward(request, response);
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	/**���ʼ�*/
	public void sendEmailToUser(String proId, String proTitle,String buyPrice,String UEmail,String solUserName,String proUrl){
		
		String qURL = proUrl+"person_center/AllReserv?op=1";
		//4.ƴ���ʼ�����
		String describe = "�װ���"+solUserName +"," +
				"��ԤԼ�ı���(<a href ='"+proUrl+"XProductInfo?proId="+proId+"'>"+proTitle+"</a>),������ѡ����" +
				"�۸�<font size='20px;'>��"+ buyPrice+"</font>,����·����Ӵ�������<br>"+qURL +
						"<br>����<font color='red' size='20px;'>3</font>" +
				"��δ����ģ�ϵͳ�����Զ�ȡ���ö�����������������㣬�����½⡣";
		
		//5.�����ʼ�
		
		EmailServiceimpl sendemial = new EmailServiceimpl();
		sendemial.sendEmail(UEmail, describe, null, "���ֽ�-������Ϣ");
	}

}
