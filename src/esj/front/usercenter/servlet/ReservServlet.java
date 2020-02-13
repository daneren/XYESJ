package esj.front.usercenter.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import esj.front.usercenter.bean.ProCommBean;
import esj.front.usercenter.service.PReservesBeanService;
import esj.front.usercenter.service.impl.EmailServiceimpl;
import esj.front.usercenter.service.impl.PReservesBeanServiceimpl;
import esj.publicdoc.bean.ReservesBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.ReservesBeanService;
import esj.publicdoc.service.impl.ReservesBeanServiceimpl;
/**
 * 查看我买过的商品
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-7-1 上午1:01:18
 * @最后修改时间 2016-7-06 上午1:01:18
 * @描述：
 * @version 1.0
 */
public class ReservServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String buyerId = ((UsersBean) session.getAttribute("user")).getUserId();		
		String op = (String) request.getParameter("op");
		buyerId = ((UsersBean) session.getAttribute("user")).getUserId();
		if(op.trim().equals("") || op == null){
			return;
		}
		
		PReservesBeanService pBeanService = new PReservesBeanServiceimpl();
		if("1".equals(op)){
			//预约成功的
			List<ProCommBean> uBuy = pBeanService.getUserBuy(buyerId);			
			request.setAttribute("uBuy", uBuy);
			//预约中			
			List<ProCommBean> uReserves = pBeanService.getUserReserve(buyerId);			
			request.setAttribute("uReserves", uReserves);
			op = "1";
			request.setAttribute("op", op);
			request.getRequestDispatcher("person_buypro.jsp").forward(request, response);			
			
		}else if(op.trim().equals("3")){
			//预约中 取消预约
			String reservId = (String) request.getParameter("id");
			if(!reservId.trim().equals("") && reservId !=null){
				ReservesBeanService rBeanService = new ReservesBeanServiceimpl();
				ReservesBean rBean = new ReservesBean();
				rBean.setState("取消预约");
				rBean.setReservId(reservId);
				rBeanService.removeReserves(rBean);
				response.getWriter().println("取消成功");
				return;
			}else{
				return;
			}
			
		}else if("4".equals(op)){
			String reserveId = (String) request.getParameter("id");
			ReservesBean rBean = pBeanService.getSellerMag(reserveId);
			if(rBean != null){
				String proUrl = "http://www.arice.ren:80:"+request.getContextPath()+"/";
				String qURL = proUrl+"person_center/AllReserv?op=1";
				//4.拼接邮件内容
				String describe = "亲爱的"+rBean.getBuyerId() +",您的客户提醒了你一下：" +
						"宝贝链接(<a href ='"+proUrl+"XProductInfo?proId="+rBean.getProId()+"'>"+rBean.getRemark()+"</a>)," +
						"出价<font size='20px;'>￥"+ rBean.getBuyerPrice()+"</font>,赶快处理吧。<br>"+qURL +
								"<br>超过<font color='red' size='20px;'>3</font>" +
						"天未处理的，系统将会自动取消该订单，如给您带来不便，敬请谅解。";
				
				//5.发送邮件
				EmailServiceimpl sendemial = new EmailServiceimpl();
				sendemial.sendEmail(rBean.getSellerId(), describe, null, "二手街-订单提醒");
				response.getWriter().println("提醒成功");
				return;
			}
			
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
