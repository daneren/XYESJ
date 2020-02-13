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
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-7-9 ����7:09:50
 * @����޸�ʱ�� 2016-7-9 ����7:09:50
 * @����
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
		//��ȡ��ǰ�û�
		UsersBean user = (UsersBean)request.getSession().getAttribute("user");
		PUserDemandService  pService = new PUserDemandServiceimpl();
		String id = request.getParameter("id");
		if(!"".equals(id) && id != null){
			UserdemandsBeanService beanService = new UserdemandsBeanServiceImpl();
			UserdemandsBean uBean = new UserdemandsBean();
			uBean.setDemandId(id);
			if("1".equals(op)){
				uBean.setState("��ɾ��");
				uBean.setEdate(DateHelper.getDateTimeFormat());
			}else if("2".equals(op)){
				uBean.setState("�ѽ��");
				uBean.setEdate(DateHelper.getDateTimeFormat());
			}
			beanService.changeUserdemandsState(uBean);
		}
		
		//��ȡδ���������
		List<UserdemandsBean> unsolveDemandslist = pService.getUnsolveDemandsByUserid(user.getUserId());
		request.setAttribute("unsolveDemands", unsolveDemandslist);
		//����ѽ��������
		
		List<UserdemandsBean> solved =  pService.getsolvedDemandsByUserid(user.getUserId());
		request.setAttribute("solved", solved);
		request.getRequestDispatcher("person_myneed.jsp").forward(request, response);
		

	}

}
