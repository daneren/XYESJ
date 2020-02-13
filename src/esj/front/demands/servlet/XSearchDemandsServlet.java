package esj.front.demands.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.algorithm.search.Search;
import esj.front.demands.service.impl.XUserDemandServiceImpl;
import esj.front.util.LogsFileUtil;
import esj.publicdoc.bean.UserdemandsBean;
import esj.util.DateHelper;
import esj.util.GetIpAddr;

public class XSearchDemandsServlet extends HttpServlet {
	XUserDemandServiceImpl deser = new XUserDemandServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchvalue = "����,����,�ľ�";
		if(request.getParameter("searchvalue") != null && request.getParameter("searchvalue") != ""){
			searchvalue = request.getParameter("searchvalue");
		}
		if(request.getSession().getAttribute("user")!=null){
			String userlogAddr = (String) request.getSession().getAttribute("userlogAddr");//�����־�ļ�·��
			//����־�ļ��в���һ����¼
			LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] ��������:�ؼ���---"+searchvalue);
		}
		if("���·���������".equals(searchvalue)){
			request.setAttribute("demands", deser.getNewUnsolveDemands());
		}else if("�ȵ�����".equals(searchvalue)){
			request.setAttribute("demands", deser.getNewGraduateUnsolveDemands());
		}else{
			request.setAttribute("demands", deser.searchDemands(searchvalue));
		}
		request.setAttribute("searchvalue", searchvalue);
		//request.setAttribute("demands", Search.UserDemandCos(searchvalue));
		
		request.getRequestDispatcher("needapparel.jsp").forward(request, response);
	}

}
