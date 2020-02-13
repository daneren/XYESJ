package esj.front.usercenter.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.front.usercenter.service.PUsersBeanService;
import esj.front.usercenter.service.impl.EmailServiceimpl;
import esj.front.usercenter.service.impl.PUsersBeanServiceimpl;
import esj.publicdoc.bean.ReservesBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.ReservesBeanService;
import esj.publicdoc.service.impl.ReservesBeanServiceimpl;
/**ԤԼ��Ʒ*/
public class SendEmailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�����ķ�ʽ�������Ӧ��AJAX�첽������
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
				
		String solemail = request.getParameter("solemail");//��������
		String proId = request.getParameter("id");//��Ʒ���
		String contact = request.getParameter("contact");//�����ϵ��ʽ
		String buyPrice = request.getParameter("buyPrice");//��ҳ���
		String remark = request.getParameter("remark");//��ע
		String solUserName = request.getParameter("solUName");//��������
		String solUserId = request.getParameter("solUId");//��������
		String proTitle = request.getParameter("title");//��Ʒ����
		if(!solemail.equals("") && solemail !=null ){
			if(proId != null && solUserName!= null && proTitle!=null && buyPrice!=null){
//				String proUrl = "http://localhost:8080:"+request.getContextPath()+"/";
				String proUrl = "http://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+"/";
				String qURL = proUrl+"person_center/AllReserv?op=1";
				//4.ƴ���ʼ�����
				String describe = "�װ���"+solUserName +"," +
						"����ԤԼ����ı���(<a href ='"+proUrl+"XProductInfo?proId="+proId+"'>"+proTitle+"</a>)," +
						"����<font size='20px;'>��"+ buyPrice+"</font>,����·����Ӵ�������<br>"+qURL +
								"<br>����<font color='red' size='20px;'>3</font>" +
						"��δ����ģ�ϵͳ�����Զ�ȡ���ö�����������������㣬�����½⡣";
				
				//5.�����ʼ�
				
				EmailServiceimpl sendemial = new EmailServiceimpl();
				sendemial.sendEmail(solemail, describe, null, "���ֽ�-������Ϣ");
				//6.���һ��ԤԼ��Ϣ
				ReservesBeanService rBeanService = new ReservesBeanServiceimpl();
				ReservesBean rBean = new ReservesBean();
				rBean.setBuyerId(((UsersBean)request.getSession().getAttribute("user")).getUserId());
				rBean.setBuyerPrice(Float.parseFloat(buyPrice));
				rBean.setProId(proId);
				rBean.setRemark(remark);
				rBean.setSellerId(solUserId);
				rBean.setState("ԤԼ��");
				
				int count = rBeanService.saveReserves(rBean);
				if(!"".equals(contact) && contact!=null){
					String userId = ((UsersBean)request.getSession().getAttribute("user")).getUserId();
					PUsersBeanService puService =  new PUsersBeanServiceimpl();
					puService.updatePhone(userId, contact);
				}
				//7.�����ɷ��� ԤԼ�ɹ�
				//8.ʧ�ܷ��� ԤԼʧ��
				if(count>0){
					pw.write("��ԤԼ");//�����ķ�ʽ��������������
				}else{
					pw.write("ԤԼʧ��");//�����ķ�ʽ��������������
				}
			}
			pw.flush();
			pw.close();
		}
	}

}
