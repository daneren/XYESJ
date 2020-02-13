package esj.front.products.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.front.products.service.impl.XProductsServiceImpl;
import esj.front.products.service.impl.XTagsServiceImpl;
import esj.front.util.LogsFileUtil;
import esj.publicdoc.bean.ProductsBean;
import esj.util.DateHelper;
import esj.util.GetIpAddr;
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-28 ����4:00:11
 * @����޸�ʱ�� 2016-6-28 ����4:00:11
 * @���� ͨ����ǩ������Ʒ
 * @version 1.0
 */
@SuppressWarnings("serial")
public class XTagsSearchServlet extends HttpServlet {
private XTagsServiceImpl tagser = new XTagsServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("tagname") != null &&request.getParameter("tagname") != ""){//��ǩ����  �б�ǩ
			String tagname = request.getParameter("tagname");
			//��tag�ĵ��������һ
			tagser.addOneTotimes(tagname);
			List<ProductsBean> prolist = new XProductsServiceImpl().getProByTag(tagname);
			String userlogAddr = (String) request.getSession().getAttribute("userlogAddr");//�����־�ļ�·��
			//����־�ļ��в���һ����¼
			LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] ����:�ؼ���---"+tagname);
			
			request.setAttribute("prolist", prolist);
			request.setAttribute("searchvalue", tagname);
			request.getRequestDispatcher("apparel.jsp").forward(request, response);
		}else{//û�б�ǩ   ��ʾȫ����ǩ
			//��һЩ����
			request.getRequestDispatcher("tags.jsp").forward(request, response);
		}
	}

}
