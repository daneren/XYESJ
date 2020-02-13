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
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-28 下午1:36:57
 * @最后修改时间 2016-6-28 下午1:36:57
 * @描述 边框类别点击过后的搜索
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
		
		
		String searchvalue = "寝室神器";
		if(request.getParameter("searchvalue") != null && request.getParameter("searchvalue") != ""){
			searchvalue = request.getParameter("searchvalue");
		}
		//数据传过来可能是包含空格和/要把他们分开来进行搜索处理
		if("最新商品".equals(searchvalue)){
			request.setAttribute("prolist", product.getNewProducts());
		}else if("毕业季".equals(searchvalue)){
			request.setAttribute("prolist", product.getGraduateProducts());
		}else if("猜你喜欢".equals(searchvalue)){
			request.setAttribute("prolist", product.getGraduateProducts());
		}else{
			//request.setAttribute("prolist", product.searchProducts(searchvalue,typeid));
			List<ProductsBean> list = product.searchProducts(searchvalue,null);
			list.addAll(Search.ProductCos(searchvalue));
			//去重复
			List<ProductsBean> tempList= new ArrayList<ProductsBean>();  
		    for(ProductsBean i:list){
		        if(!tempList.contains(i)){
		            tempList.add(i);  
		        }  
		    }  
			request.setAttribute("prolist", tempList);
		}
		if(request.getSession().getAttribute("user")!=null){
		String userlogAddr = (String) request.getSession().getAttribute("userlogAddr");//获得日志文件路径
		//向日志文件中插入一条记录
		LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] 搜索商品:关键字---"+searchvalue);
		}
		request.setAttribute("searchvalue", searchvalue);
		request.getRequestDispatcher("apparel.jsp").forward(request, response);
		
		
	}

}
