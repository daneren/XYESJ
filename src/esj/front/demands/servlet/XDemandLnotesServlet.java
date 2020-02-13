package esj.front.demands.servlet;

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
import esj.publicdoc.bean.UserdemandsBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.impl.LnotesBeanServiceimpl;
import esj.publicdoc.service.impl.UserdemandsBeanServiceImpl;
import esj.publicdoc.service.impl.UsersBeanServiceimpl;
import esj.util.DateHelper;
import esj.util.GetIpAddr;

public class XDemandLnotesServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = request.getParameter("msg");
		String demandId = request.getParameter("demandId");
		UserdemandsBean demand = new UserdemandsBeanServiceImpl().findUserdemandsById(demandId);//获取收藏的信息
		UsersBean user =(UsersBean) request.getSession().getAttribute("user");//当前登录的用户
		UsersBean dUser = new UsersBeanServiceimpl().findUserById(demand.getUserId());//获取需求所属的用户
		LnotesBeanServiceimpl lnoser = new LnotesBeanServiceimpl();
		LnotesBean lnotesBean = new LnotesBean(null, user.getUserId(), demandId, msg, null, GetIpAddr.getIpAddr(request), null, "启用");
		String userlogAddr = (String) request.getSession().getAttribute("userlogAddr");//获得日志文件路径
		//向日志文件中插入一条记录
		LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] 给需求:"+demandId+"留言---"+msg);
		
		int count = lnoser.saveLnotes(lnotesBean);
		if(count == 1){
			response.sendRedirect("XDemandsInfo?demandsId="+demandId);
			//给商品所属的用户发送email
			EmailServiceimpl sendemial = new EmailServiceimpl();
			String proUrl = "http://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+"/XDemandsInfo?demandsId="+demandId;
			sendemial.sendEmail(dUser.getEmail(), "亲爱的"+dUser.getUserName()+"：<br>"+user.getUserName()+"给您的需求："+"[<a href='"+proUrl+"'>"+demand.getTitle()+"</a>]留言了。<br>留言内容："+msg, null, "湖科二手街-新的需求留言");
			
		}
	}

}
