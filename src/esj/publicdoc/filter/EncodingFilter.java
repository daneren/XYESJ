package esj.publicdoc.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.filter:EncodingFilter.java ȫ�ֱ�������
 * @version 1.0
 * @data 2016-5-13
 */
public class EncodingFilter implements Filter {
	// ��������ĳ�Ա����
	private String encoding;

	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("bm");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);//��getû��Ч
		response.setContentType("text/html;charset=" + encoding);
		// �ж��Ƿ���Ҫ��װ
		HttpServletRequest req = (HttpServletRequest) request;
		
		if (req.getMethod().equals("GET")) {
			request = new MyRequest(req);
		}
		// ������װ���ʵ��
		// ����
		chain.doFilter(request, response);
	}
	public void destroy() {
	}
}

// ������װ��
class MyRequest extends HttpServletRequestWrapper {
	
	public MyRequest(HttpServletRequest request) {
		//��ȡ���ݿ⣬����ȡ�����ݷŵ�����
		super(request);
	}

	// ��ǿgetParamter
	@Override
	public String getParameter(String name) {
		String val = super.getParameter(name);
		if(val != null&&val !=""){
			try {
				val = new String(val.getBytes("ISO-8859-1"),
						super.getCharacterEncoding());

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		return val;
	}
}
