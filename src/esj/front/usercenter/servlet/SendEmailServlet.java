package esj.front.usercenter.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.front.usercenter.service.PUsersBeanService;
import esj.front.usercenter.service.impl.EmailServiceimpl;
import esj.front.usercenter.service.impl.PUsersBeanServiceimpl;
import esj.publicdoc.bean.ReservesBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.ReservesBeanService;
import esj.publicdoc.service.impl.ReservesBeanServiceimpl;
/**预约商品*/
public class SendEmailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//以流的方式将结果响应到AJAX异步对象中
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
				
		String solemail = request.getParameter("solemail");//卖家邮箱
		String proId = request.getParameter("id");//商品编号
		String contact = request.getParameter("contact");//买家联系方式
		String buyPrice = request.getParameter("buyPrice");//买家出价
		String remark = request.getParameter("remark");//备注
		String solUserName = request.getParameter("solUName");//卖家姓名
		String solUserId = request.getParameter("solUId");//卖家姓名
		String proTitle = request.getParameter("title");//商品标题
		if(!solemail.equals("") && solemail !=null ){
			if(proId != null && solUserName!= null && proTitle!=null && buyPrice!=null){
//				String proUrl = "http://localhost:8080:"+request.getContextPath()+"/";
				String proUrl = "http://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+"/";
				String qURL = proUrl+"person_center/AllReserv?op=1";
				//4.拼接邮件内容
				String describe = "亲爱的"+solUserName +"," +
						"有人预约了你的宝贝(<a href ='"+proUrl+"XProductInfo?proId="+proId+"'>"+proTitle+"</a>)," +
						"出价<font size='20px;'>￥"+ buyPrice+"</font>,点击下方链接处理订单。<br>"+qURL +
								"<br>超过<font color='red' size='20px;'>3</font>" +
						"天未处理的，系统将会自动取消该订单，如给您带来不便，敬请谅解。";
				
				//5.发送邮件
				
				EmailServiceimpl sendemial = new EmailServiceimpl();
				sendemial.sendEmail(solemail, describe, null, "二手街-订单信息");
				//6.添加一条预约信息
				ReservesBeanService rBeanService = new ReservesBeanServiceimpl();
				ReservesBean rBean = new ReservesBean();
				rBean.setBuyerId(((UsersBean)request.getSession().getAttribute("user")).getUserId());
				rBean.setBuyerPrice(Float.parseFloat(buyPrice));
				rBean.setProId(proId);
				rBean.setRemark(remark);
				rBean.setSellerId(solUserId);
				rBean.setState("预约中");
				
				int count = rBeanService.saveReserves(rBean);
				if(!"".equals(contact) && contact!=null){
					String userId = ((UsersBean)request.getSession().getAttribute("user")).getUserId();
					PUsersBeanService puService =  new PUsersBeanServiceimpl();
					puService.updatePhone(userId, contact);
				}
				//7.操作成发送 预约成功
				//8.失败发送 预约失败
				if(count>0){
					pw.write("已预约");//以流的方式向浏览器输出内容
				}else{
					pw.write("预约失败");//以流的方式向浏览器输出内容
				}
			}
			pw.flush();
			pw.close();
		}
	}

}
