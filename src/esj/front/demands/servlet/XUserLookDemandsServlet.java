package esj.front.demands.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.front.demands.service.PUserDemandService;
import esj.front.demands.service.impl.PUserDemandServiceimpl;
import esj.front.demands.service.impl.XUserDemandServiceImpl;
import esj.publicdoc.bean.UserdemandsBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.UserdemandsBeanService;
import esj.publicdoc.service.impl.UserdemandsBeanServiceImpl;
import esj.util.DateHelper;
/**
 * .
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-7-9 下午7:09:50
 * @最后修改时间 2016-7-9 下午7:09:50
 * @描述
 * @version 1.0
 */
public class XUserLookDemandsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String op = request.getParameter("op");
		//获取当前用户
		UsersBean user = (UsersBean)request.getSession().getAttribute("user");
		PUserDemandService  pService = new PUserDemandServiceimpl();
		String id = request.getParameter("id");
		if(!"".equals(id) && id != null){
			UserdemandsBeanService beanService = new UserdemandsBeanServiceImpl();
			UserdemandsBean uBean = new UserdemandsBean();
			uBean.setDemandId(id);
			if("1".equals(op)){
				uBean.setState("已删除");
				uBean.setEdate(DateHelper.getDateTimeFormat());
			}else if("2".equals(op)){
				uBean.setState("已解决");
				uBean.setEdate(DateHelper.getDateTimeFormat());
			}
			beanService.changeUserdemandsState(uBean);
		}
		
		//获取未解决的需求
		List<UserdemandsBean> unsolveDemandslist = pService.getUnsolveDemandsByUserid(user.getUserId());
		request.setAttribute("unsolveDemands", unsolveDemandslist);
		//获得已解决的需求
		
		List<UserdemandsBean> solved =  pService.getsolvedDemandsByUserid(user.getUserId());
		request.setAttribute("solved", solved);
		request.getRequestDispatcher("person_myneed.jsp").forward(request, response);
		

	}

}
