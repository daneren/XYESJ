package esj.front.usercenter.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.front.usercenter.service.PTagsBeanService;
import esj.front.usercenter.service.impl.PTagsBeanServiceimpl;
import esj.publicdoc.bean.TagsBean;

public class TagsServlet extends HttpServlet {

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
		doPost(request, response);
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
		request.setCharacterEncoding("utf-8");
		
		String typeId = request.getParameter("id");
		if(!"".equals(typeId.trim())|| typeId != null){
			PTagsBeanService pBeanService = new PTagsBeanServiceimpl();
			List<TagsBean> list = pBeanService.getTagsByTyList(typeId, 5);
			PrintWriter out = response.getWriter();
			int i = 2;
			for(TagsBean tag:list){
				if(!"可小刀".equals(tag.getTagName())){
					out.print("<li id='litag"+i+"' >"+tag.getTagName()+"<span class='glyphicon glyphicon-remove' aria-hidden='true'></span></li>");
				}
				i++;
			}
			out.print("<li id='litag1' >可小刀<span class='glyphicon glyphicon-remove' aria-hidden='true'></span></li>");

			return;
		}
		
	}

}
