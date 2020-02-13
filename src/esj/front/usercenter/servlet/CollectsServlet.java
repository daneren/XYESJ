package esj.front.usercenter.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import esj.front.usercenter.bean.ProCommBean;
import esj.front.usercenter.service.PCollectsBeanService;
import esj.front.usercenter.service.PReservesBeanService;
import esj.front.usercenter.service.impl.PCollectsBeanServiceimpl;
import esj.front.usercenter.service.impl.PReservesBeanServiceimpl;
import esj.publicdoc.bean.CollectsBean;
import esj.publicdoc.bean.ReservesBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.CollectsBeanService;
import esj.publicdoc.service.ReservesBeanService;
import esj.publicdoc.service.impl.CollectsBeanServiceimpl;
import esj.publicdoc.service.impl.ReservesBeanServiceimpl;
/**
 * 我关注的
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-7-1 下午12:30:58
 * @最后修改时间 2016-7-06 下午12:30:58
 * @描述：
 * @version 1.0
 */
public class CollectsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String buyerId = ((UsersBean) session.getAttribute("user")).getUserId();	
		String op = (String) request.getParameter("op");
		if(op.trim().equals("") || op == null){
			return;
		}
		
		PCollectsBeanService pCollectsBeanService = new PCollectsBeanServiceimpl();
		if(op.trim().equals("1")){
			//我关注的
			List<ProCommBean> uCollects = pCollectsBeanService.getUCollects(buyerId);		
			request.setAttribute("uCollects", uCollects);
		}else if(op.trim().equals("2")){
			//取消关注
			String collectId = (String) request.getParameter("id");
			//System.out.println(collectId);
			if(collectId !=null && !"".equals(collectId.trim())){
				CollectsBeanService cBeanService = new CollectsBeanServiceimpl();				
				CollectsBean cBean = new CollectsBean();
				cBean.setState("取消收藏");
				cBean.setCollectId(collectId);
				cBeanService.changeCollectState(cBean);
			}else{
				return;
			}			
			List<ProCommBean> uCollects = pCollectsBeanService.getUCollects(buyerId);		
			request.setAttribute("uCollects", uCollects);
			op = "1";			
		}
		request.setAttribute("op", op);
		request.getRequestDispatcher("person_care.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//判断是否登陆
		if(request.getSession().getAttribute("user") == null){
			return;
		}else{
			doGet(request, response);
		}
	}

}
