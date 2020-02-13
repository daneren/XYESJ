package esj.back.control.tag.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.back.control.tag.service.impl.TagsBeanServiceImpl;
import esj.publicdoc.bean.TagsBean;

public class TagUpdataServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();

		int flag;
		
		TagsBean tagsBean=new TagsBean();

		tagsBean.setTagId(request.getParameter("tagId"));
		Integer str=Integer.parseInt(request.getParameter("typeId"));
		tagsBean.setTypeId(str);
		tagsBean.setBdate(request.getParameter("bdate"));
		tagsBean.setTagName(request.getParameter("tagName"));
		float score=Float.parseFloat(request.getParameter("times"));
		//float score_=score;
		tagsBean.setScore(score);
		
		//System.out.println(tagsBean);

		TagsBeanServiceImpl service=new TagsBeanServiceImpl();
		
		flag = service.updateTagsById(tagsBean);

		if (flag == 1) {
			String msg = null;
			msg = String.valueOf(flag);
			//System.out.println(flag);
			pw.write(msg);// 以流的方式向浏览器输出内容
			pw.flush();
			pw.close();
		} else {
			String msg = null;
			msg = String.valueOf(flag);
			pw.write(msg);// 以流的方式向浏览器输出内容
			pw.flush();
			pw.close();
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
