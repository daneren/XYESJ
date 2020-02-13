package esj.front.usercenter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import esj.front.util.LogsFileUtil;
import esj.util.DateHelper;
import esj.util.GetIpAddr;

public class XUserLogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userlogAddr = (String) session.getAttribute("userlogAddr");//获得日志文件路径
		LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] 退出登录");//插入一天日志信息
		session.removeAttribute("user");
		session.invalidate();
		
		response.sendRedirect("login.jsp");
	}

}
