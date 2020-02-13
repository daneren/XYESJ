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
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-28 下午4:00:11
 * @最后修改时间 2016-6-28 下午4:00:11
 * @描述 通过标签搜索商品
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
		if(request.getParameter("tagname") != null &&request.getParameter("tagname") != ""){//标签搜索  有标签
			String tagname = request.getParameter("tagname");
			//改tag的点击次数加一
			tagser.addOneTotimes(tagname);
			List<ProductsBean> prolist = new XProductsServiceImpl().getProByTag(tagname);
			String userlogAddr = (String) request.getSession().getAttribute("userlogAddr");//获得日志文件路径
			//向日志文件中插入一条记录
			LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] 搜索:关键字---"+tagname);
			
			request.setAttribute("prolist", prolist);
			request.setAttribute("searchvalue", tagname);
			request.getRequestDispatcher("apparel.jsp").forward(request, response);
		}else{//没有标签   显示全部标签
			//做一些处理
			request.getRequestDispatcher("tags.jsp").forward(request, response);
		}
	}

}
