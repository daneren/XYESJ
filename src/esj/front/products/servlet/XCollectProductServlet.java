package esj.front.products.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.back.control.product.service.impl.ProductsServiceImpl;
import esj.front.products.service.impl.XProductsServiceImpl;
import esj.front.util.LogsFileUtil;
import esj.publicdoc.bean.CollectsBean;
import esj.publicdoc.bean.ProductsBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.impl.ProductsBeanServiceImpl;
import esj.util.DateHelper;
import esj.util.GetIpAddr;
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-7-17 ����12:30:50
 * @����޸�ʱ�� 2016-7-11 ����12:30:50
 * @���� �ղ���Ʒ
 * @version 1.0
 */
public class XCollectProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String proId = request.getParameter("proId");
		String userId = ((UsersBean)request.getSession().getAttribute("user")).getUserId();
		boolean isCollect = new XProductsServiceImpl().isCollected(userId, proId);
		if(!isCollect){//û���ղ�
			int count = new XProductsServiceImpl().collectProduct(new CollectsBean(null, userId, proId, null, "����"));
			ProductsBean pro = new ProductsBeanServiceImpl().findProductsById(proId);
			String userlogAddr = (String) request.getSession().getAttribute("userlogAddr");//�����־�ļ�·��
			//����־�ļ��в���һ����¼
			LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] �ղ�����Ʒ:"+proId+"---"+pro.getTitle()+"---"+pro.getTitle());
			if(count == 1){
				pw.write("ok");
			}else{
				pw.write("error");
			}
		}else{
			pw.write("yi");
		}
		
		pw.flush();
		pw.close();
	}

}
