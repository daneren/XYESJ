package esj.front.usercenter.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.front.usercenter.service.impl.XUserLogsServiceImpl;
import esj.front.usercenter.service.impl.XUsersBeanServiceImpl;
import esj.front.util.LogsFileUtil;
import esj.publicdoc.bean.UserlogsBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.impl.UserlevelsBeanServiceimpl;
import esj.publicdoc.service.impl.UserlogsBeanServiceimpl;
import esj.publicdoc.service.impl.UsersBeanServiceimpl;
import esj.util.DateHelper;
import esj.util.GetIpAddr;
import esj.util.Random100;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-27 上午11:18:46
 * @最后修改时间 2016-6-27 上午11:18:46
 * @描述 用户登录servlet
 * @version 1.0
 */
@SuppressWarnings("serial")
public class XUserLoginServlet extends HttpServlet {
	
private XUsersBeanServiceImpl service = new XUsersBeanServiceImpl();
private UsersBeanServiceimpl userservice = new UsersBeanServiceimpl();
private XUserLogsServiceImpl xlogservice = new XUserLogsServiceImpl();
private UserlogsBeanServiceimpl logservice = new UserlogsBeanServiceimpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String captcha = request.getParameter("yzm");
		String captcha2 = (String) request.getSession().getAttribute("captcha");
		boolean flag = service.userLogin(email, pwd);
		
		if(captcha.equals(captcha2)){
			if(flag){
				UsersBean user = userservice.findUserById(service.getUserIdByEmailAndPwd(email, pwd));
				String logsId = DateHelper.getDateTimeForNumber()+Random100.getrandom100();//日志id
				String userId = service.getUserIdByEmailAndPwd(email, pwd);
				
				//在session中保存user
				request.getSession().setAttribute("user", user);
				//在userlogs表中创建一条用户操作记录数据
				int count = logservice.saveUserlogs(new UserlogsBean(logsId, userId, GetIpAddr.getIpAddr(request), null, null, null));
				if(count == 1){//创建成功
					String userlogAddr = xlogservice.getlogfileNameByLogsId(logsId);//根据日志id获取日志文件名
					//在session中保存用户日志路径
					request.getSession().setAttribute("userlogAddr", userlogAddr);
					//向日志文件中插入一条记录
					LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] 登录成功");
				}
				
				response.sendRedirect("index.jsp");
			}else{
				request.setAttribute("loginerror", "用户名或者密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("loginyzmerror", "验证码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

}
