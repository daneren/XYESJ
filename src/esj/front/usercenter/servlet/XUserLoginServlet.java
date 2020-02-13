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
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-27 ����11:18:46
 * @����޸�ʱ�� 2016-6-27 ����11:18:46
 * @���� �û���¼servlet
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
				String logsId = DateHelper.getDateTimeForNumber()+Random100.getrandom100();//��־id
				String userId = service.getUserIdByEmailAndPwd(email, pwd);
				
				//��session�б���user
				request.getSession().setAttribute("user", user);
				//��userlogs���д���һ���û�������¼����
				int count = logservice.saveUserlogs(new UserlogsBean(logsId, userId, GetIpAddr.getIpAddr(request), null, null, null));
				if(count == 1){//�����ɹ�
					String userlogAddr = xlogservice.getlogfileNameByLogsId(logsId);//������־id��ȡ��־�ļ���
					//��session�б����û���־·��
					request.getSession().setAttribute("userlogAddr", userlogAddr);
					//����־�ļ��в���һ����¼
					LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] ��¼�ɹ�");
				}
				
				response.sendRedirect("index.jsp");
			}else{
				request.setAttribute("loginerror", "�û��������������");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("loginyzmerror", "��֤�����");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

}
