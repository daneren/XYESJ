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
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-7-15 ����6:40:47
 * @����޸�ʱ�� 2016-7-15 ����6:40:47
 * @���� �ж�admin�Ƿ��¼
 * @version 1.0
 */
public class IsAdminLoginFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//1.ת��
				HttpServletRequest httprequest = (HttpServletRequest)request;
				HttpServletResponse httpresponse = (HttpServletResponse)response;
				
				//2.��ȡurl��ַ
				String path = httprequest.getRequestURI();
				
				//3.login.jsp ���ʣ� loginServlet �������
				String action = path.substring(path.lastIndexOf("/")+1, path.length());

				if(action.endsWith("admin_back_login")|| action.endsWith("welcome.jsp")||action.endsWith("login.psd")||action.endsWith("login.jsp")||action.endsWith("js")||action.endsWith("gif")||action.endsWith("css")||action.endsWith("png")||action.endsWith("jpg")||action.endsWith("ico")){
					//����
					chain.doFilter(httprequest, httpresponse);
				}else{
					//�ж��Ƿ��½
					AdminsBean admin = (AdminsBean) httprequest.getSession().getAttribute("admin");
					if(admin != null){ //��½
						chain.doFilter(httprequest, httpresponse);
					}else{//û�е�½
						httpresponse.sendRedirect("login.jsp");
					}
				}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
