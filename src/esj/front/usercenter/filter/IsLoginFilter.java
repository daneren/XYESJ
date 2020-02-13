package esj.front.usercenter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.publicdoc.bean.UsersBean;
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-27 ����2:58:12
 * @����޸�ʱ�� 2016-6-27 ����2:58:12
 * @���� �ж��û��Ƿ��¼
 * @version 1.0
 */
public class IsLoginFilter implements Filter{
	public void init(FilterConfig filterConfig) throws ServletException {
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

		if(action.endsWith("js")||action.endsWith("gif")||action.endsWith("css")||action.endsWith("png")||action.endsWith("jpg")||action.endsWith("ico")){
			//����
			chain.doFilter(httprequest, httpresponse);
		}else{
			//�ж��Ƿ��½
			UsersBean user = (UsersBean) httprequest.getSession().getAttribute("user");
			if(user != null){ //��½
				chain.doFilter(httprequest, httpresponse);
			}else{//û�е�½
				httpresponse.sendRedirect("../login.jsp");
			}
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
