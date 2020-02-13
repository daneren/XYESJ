package esj.front.products.servlet;

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
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.impl.LnotesBeanServiceimpl;
import esj.publicdoc.service.impl.ProductsBeanServiceImpl;
import esj.publicdoc.service.impl.UsersBeanServiceimpl;
import esj.util.DateHelper;
import esj.util.GetIpAddr;
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-7-13 ����12:13:00
 * @����޸�ʱ�� 2016-7-13 ����12:13:00
 * @���� ���û���Ʒ����
 * @version 1.0
 */
@SuppressWarnings("serial")
public class XProLnotesServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = request.getParameter("msg");
		String proId = request.getParameter("proId");
		ProductsBean pBean = new ProductsBeanServiceImpl().findProductsById(proId);//�����Ʒ����Ϣ
		UsersBean pUser = new UsersBeanServiceimpl().findUserById(pBean.getUserId());//��ȡ��Ʒ�������û�
		UsersBean user =(UsersBean) request.getSession().getAttribute("user");//��ȡ��ǰ��½���û�
		LnotesBeanServiceimpl lnoser = new LnotesBeanServiceimpl();
		LnotesBean lnotesBean = new LnotesBean(null, user.getUserId(), proId, msg, null, GetIpAddr.getIpAddr(request), null, "����");
		String userlogAddr = (String) request.getSession().getAttribute("userlogAddr");//�����־�ļ�·��
		String scores = request.getParameter("hid").trim();
		if(scores !="" && scores!=null){
			float os = Float.parseFloat(scores.split(",")[1]);
			float ns = Float.parseFloat(scores.split(",")[0]);
			int cs = Integer.parseInt(scores.split(",")[2]);
			cs+=1;
			os+=ns;
			scores = os+","+cs;
			XProductsService xService = new XProductsServiceImpl();
			xService.updateScore(scores, proId);
			lnotesBean.setRemark(ns+"");
		}
		
		int count = lnoser.saveLnotes(lnotesBean);
		if(count == 1){
			response.sendRedirect("XProductInfo?proId="+proId);
			//����־�ļ��в���һ����¼
			LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] ����Ʒ:"+proId+"����---"+msg);
			//����Ʒ�������û�����email
			EmailServiceimpl sendemial = new EmailServiceimpl();
			String proUrl = "http://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+"/XProductInfo?proId="+proId;
			sendemial.sendEmail(pUser.getEmail(), "�װ���"+pUser.getUserName()+"��<br>"+user.getUserName()+"��������Ʒ��"+"[<a href='"+proUrl+"'>"+pBean.getTitle()+"</a>]�����ˡ�<br>�������ݣ�"+msg, null, "���ƶ��ֽ�-�µ���Ʒ����");
			
		}
	}

}
