package esj.front.usercenter.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.front.usercenter.service.PUsersBeanService;
import esj.front.usercenter.service.impl.PUsersBeanServiceimpl;
import esj.front.usercenter.service.impl.XUsersBeanServiceImpl;
import esj.publicdoc.bean.UsersBean;
/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-6-30 上午12:24:09
 * @最后修改时间 2016-6-30 上午12:24:09
 * @描述：
 * @version 1.0
 */
public class UserPwdServlet extends HttpServlet {
private XUsersBeanServiceImpl xuserser = new XUsersBeanServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		UsersBean user = (UsersBean)request.getSession().getAttribute("user");
		String type = request.getParameter("type");
		if("checkoldpwd".equals(type)){
			String oldpwd = request.getParameter("oldpwd");
			String pwd = xuserser.getPwdByUserId(user.getUserId());
			if(oldpwd.equals(pwd)){
				pw.write("ok");
			}else{
				pw.write("error");
			}
			
		}else if("changepwd".equals(type)){
			String npwd = request.getParameter("npwd1");
			
			PUsersBeanService pBeanService = new PUsersBeanServiceimpl();
			int count = pBeanService.updateUserPwd(npwd,user.getUserId());
			if(count>0){
				pw.write("ok");
			}else{
				pw.write("error");
			}
			
			//request.getRequestDispatcher("person_pwd.jsp").forward(request, response);
		}
		pw.flush();
		pw.close();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

}
