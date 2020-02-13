package esj.front.demands.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.front.products.service.XProductsService;
import esj.front.products.service.impl.XProductsServiceImpl;
import esj.front.usercenter.service.impl.EmailServiceimpl;
import esj.front.util.LogsFileUtil;
import esj.publicdoc.bean.LnotesBean;
import esj.publicdoc.bean.ProductsBean;
import esj.publicdoc.bean.UserdemandsBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.impl.LnotesBeanServiceimpl;
import esj.publicdoc.service.impl.UserdemandsBeanServiceImpl;
import esj.publicdoc.service.impl.UsersBeanServiceimpl;
import esj.util.DateHelper;
import esj.util.GetIpAddr;

public class XDemandLnotesServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = request.getParameter("msg");
		String demandId = request.getParameter("demandId");
		UserdemandsBean demand = new UserdemandsBeanServiceImpl().findUserdemandsById(demandId);//��ȡ�ղص���Ϣ
		UsersBean user =(UsersBean) request.getSession().getAttribute("user");//��ǰ��¼���û�
		UsersBean dUser = new UsersBeanServiceimpl().findUserById(demand.getUserId());//��ȡ�����������û�
		LnotesBeanServiceimpl lnoser = new LnotesBeanServiceimpl();
		LnotesBean lnotesBean = new LnotesBean(null, user.getUserId(), demandId, msg, null, GetIpAddr.getIpAddr(request), null, "����");
		String userlogAddr = (String) request.getSession().getAttribute("userlogAddr");//�����־�ļ�·��
		//����־�ļ��в���һ����¼
		LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] ������:"+demandId+"����---"+msg);
		
		int count = lnoser.saveLnotes(lnotesBean);
		if(count == 1){
			response.sendRedirect("XDemandsInfo?demandsId="+demandId);
			//����Ʒ�������û�����email
			EmailServiceimpl sendemial = new EmailServiceimpl();
			String proUrl = "http://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+"/XDemandsInfo?demandsId="+demandId;
			sendemial.sendEmail(dUser.getEmail(), "�װ���"+dUser.getUserName()+"��<br>"+user.getUserName()+"����������"+"[<a href='"+proUrl+"'>"+demand.getTitle()+"</a>]�����ˡ�<br>�������ݣ�"+msg, null, "���ƶ��ֽ�-�µ���������");
			
		}
	}

}
