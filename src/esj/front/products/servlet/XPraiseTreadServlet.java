package esj.front.products.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.front.products.service.impl.XProductsServiceImpl;
import esj.front.util.LogsFileUtil;
import esj.publicdoc.bean.PraiseTreadBean;
import esj.publicdoc.bean.ProductsBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.impl.ProductsBeanServiceImpl;
import esj.util.DateHelper;
import esj.util.GetIpAddr;

public class XPraiseTreadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String type = request.getParameter("type");
		String userId = ((UsersBean)request.getSession().getAttribute("user")).getUserId();
		if("zan".equals(type)){
			String proId = request.getParameter("proId");
			boolean isport = new XProductsServiceImpl().isTreadOrPraise(userId, proId);
			if(!isport){//该用户没有给次商品点赞或踩
				//给点赞和踩表添加数据
				int count = new XProductsServiceImpl().praiseProduct(new PraiseTreadBean(null, proId, 0, userId, null));
				//给商品的赞加一
				new XProductsServiceImpl().updateProductPcount(proId, 0);
				ProductsBean pro = new ProductsBeanServiceImpl().findProductsById(proId);
				String userlogAddr = (String) request.getSession().getAttribute("userlogAddr");//获得日志文件路径
				//向日志文件中插入一条记录
				LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] 赞了商品:"+proId+"---"+pro.getTitle()+"---"+pro.getTitle());
				
				if(count == 1){
					pw.write("zanok");
				}else{
					pw.write("error");
				}
			}else{
				pw.write("yi");
			}
		}else if("cai".equals(type)){
			String proId = request.getParameter("proId");
			boolean isport = new XProductsServiceImpl().isTreadOrPraise(userId, proId);
			if(!isport){//该用户没有给次商品点赞或踩
				//给点赞和踩表添加数据
				int count = new XProductsServiceImpl().treadProduct(new PraiseTreadBean(null, proId, 1, userId, null));
				//给商品的赞加一
				new XProductsServiceImpl().updateProductNcount(proId, 0);
				ProductsBean pro = new ProductsBeanServiceImpl().findProductsById(proId);
				String userlogAddr = (String) request.getSession().getAttribute("userlogAddr");//获得日志文件路径
				//向日志文件中插入一条记录
				LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] 踩了商品:"+proId+"---"+pro.getTitle()+"---"+pro.getTitle());
				
				if(count == 1){
					pw.write("caiok");
				}else{
					pw.write("error");
				}
			}else{
				pw.write("yi");
			}
		}
		pw.flush();
		pw.close();
	}

}
