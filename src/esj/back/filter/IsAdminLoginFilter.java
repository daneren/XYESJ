package esj.back.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.publicdoc.bean.AdminsBean;
import esj.publicdoc.bean.UsersBean;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-7-15 下午6:40:47
 * @最后修改时间 2016-7-15 下午6:40:47
 * @描述 判断admin是否登录
 * @version 1.0
 */
public class IsAdminLoginFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//1.转换
				HttpServletRequest httprequest = (HttpServletRequest)request;
				HttpServletResponse httpresponse = (HttpServletResponse)response;
				
				//2.获取url地址
				String path = httprequest.getRequestURI();
				
				//3.login.jsp 访问， loginServlet 允许访问
				String action = path.substring(path.lastIndexOf("/")+1, path.length());

				if(action.endsWith("admin_back_login")|| action.endsWith("welcome.jsp")||action.endsWith("login.psd")||action.endsWith("login.jsp")||action.endsWith("js")||action.endsWith("gif")||action.endsWith("css")||action.endsWith("png")||action.endsWith("jpg")||action.endsWith("ico")){
					//放行
					chain.doFilter(httprequest, httpresponse);
				}else{
					//判断是否登陆
					AdminsBean admin = (AdminsBean) httprequest.getSession().getAttribute("admin");
					if(admin != null){ //登陆
						chain.doFilter(httprequest, httpresponse);
					}else{//没有登陆
						httpresponse.sendRedirect("login.jsp");
					}
				}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
