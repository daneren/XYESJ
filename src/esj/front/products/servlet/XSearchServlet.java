package esj.front.products.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.algorithm.search.Search;
import esj.front.products.service.impl.XProductsServiceImpl;
import esj.front.util.LogsFileUtil;
import esj.publicdoc.bean.ProductsBean;
import esj.util.DateHelper;
import esj.util.GetIpAddr;

/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-28 ����1:36:57
 * @����޸�ʱ�� 2016-6-28 ����1:36:57
 * @���� �߿���������������
 * @version 1.0
 */
@SuppressWarnings("serial")
public class XSearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		XProductsServiceImpl product = new XProductsServiceImpl();
		
		
		String searchvalue = "��������";
		if(request.getParameter("searchvalue") != null && request.getParameter("searchvalue") != ""){
			searchvalue = request.getParameter("searchvalue");
		}
		//���ݴ����������ǰ����ո��/Ҫ�����Ƿֿ���������������
		if("������Ʒ".equals(searchvalue)){
			request.setAttribute("prolist", product.getNewProducts());
		}else if("��ҵ��".equals(searchvalue)){
			request.setAttribute("prolist", product.getGraduateProducts());
		}else if("����ϲ��".equals(searchvalue)){
			request.setAttribute("prolist", product.getGraduateProducts());
		}else{
			//request.setAttribute("prolist", product.searchProducts(searchvalue,typeid));
			List<ProductsBean> list = product.searchProducts(searchvalue,null);
			list.addAll(Search.ProductCos(searchvalue));
			//ȥ�ظ�
			List<ProductsBean> tempList= new ArrayList<ProductsBean>();  
		    for(ProductsBean i:list){
		        if(!tempList.contains(i)){
		            tempList.add(i);  
		        }  
		    }  
			request.setAttribute("prolist", tempList);
		}
		if(request.getSession().getAttribute("user")!=null){
		String userlogAddr = (String) request.getSession().getAttribute("userlogAddr");//�����־�ļ�·��
		//����־�ļ��в���һ����¼
		LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] ������Ʒ:�ؼ���---"+searchvalue);
		}
		request.setAttribute("searchvalue", searchvalue);
		request.getRequestDispatcher("apparel.jsp").forward(request, response);
		
		
	}

}
