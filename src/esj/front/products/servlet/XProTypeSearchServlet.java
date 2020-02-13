package esj.front.products.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.algorithm.search.Search;
import esj.front.products.service.impl.XProductsServiceImpl;
import esj.front.util.LogsFileUtil;
import esj.util.DateHelper;
import esj.util.GetIpAddr;

public class XProTypeSearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		XProductsServiceImpl product = new XProductsServiceImpl();
		
		
		String searchvalue = "��������";
		String typeid = "1";
		if(request.getParameter("searchvalue") != null && request.getParameter("searchvalue") != ""){
			searchvalue = request.getParameter("searchvalue");
		}
		if(request.getParameter("typeid") !=null&&request.getParameter("typeid") !=""){
			typeid = request.getParameter("typeid");
		}
		//���ݴ����������ǰ����ո��/Ҫ�����Ƿֿ���������������
		
		request.setAttribute("prolist", product.searchProducts(searchvalue,typeid));
			
		
		if(request.getSession().getAttribute("user")!=null){
		String userlogAddr = (String) request.getSession().getAttribute("userlogAddr");//�����־�ļ�·��
		//����־�ļ��в���һ����¼
		LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] �鿴��Ʒ���:���--"+searchvalue);
		}
		request.setAttribute("searchvalue", searchvalue);
		request.getRequestDispatcher("apparel.jsp").forward(request, response);
	}

}
