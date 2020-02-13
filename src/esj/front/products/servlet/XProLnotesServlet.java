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
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-7-13 下午12:13:00
 * @最后修改时间 2016-7-13 下午12:13:00
 * @描述 给用户商品留言
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
		ProductsBean pBean = new ProductsBeanServiceImpl().findProductsById(proId);//获得商品的信息
		UsersBean pUser = new UsersBeanServiceimpl().findUserById(pBean.getUserId());//获取商品所属的用户
		UsersBean user =(UsersBean) request.getSession().getAttribute("user");//获取当前登陆的用户
		LnotesBeanServiceimpl lnoser = new LnotesBeanServiceimpl();
		LnotesBean lnotesBean = new LnotesBean(null, user.getUserId(), proId, msg, null, GetIpAddr.getIpAddr(request), null, "启用");
		String userlogAddr = (String) request.getSession().getAttribute("userlogAddr");//获得日志文件路径
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
			//向日志文件中插入一条记录
			LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] 给商品:"+proId+"留言---"+msg);
			//给商品所属的用户发送email
			EmailServiceimpl sendemial = new EmailServiceimpl();
			String proUrl = "http://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+"/XProductInfo?proId="+proId;
			sendemial.sendEmail(pUser.getEmail(), "亲爱的"+pUser.getUserName()+"：<br>"+user.getUserName()+"给您的商品："+"[<a href='"+proUrl+"'>"+pBean.getTitle()+"</a>]留言了。<br>留言内容："+msg, null, "湖科二手街-新的商品留言");
			
		}
	}

}
