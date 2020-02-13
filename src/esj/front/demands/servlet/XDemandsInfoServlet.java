package esj.front.demands.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.algorithm.search.Search;
import esj.front.demands.service.impl.XUserDemandServiceImpl;
import esj.front.util.LogsFileUtil;
import esj.publicdoc.bean.ProductsBean;
import esj.publicdoc.bean.UserdemandsBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.impl.UserdemandsBeanServiceImpl;
import esj.publicdoc.service.impl.UsersBeanServiceimpl;
import esj.util.DateHelper;
import esj.util.GetIpAddr;
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-7-13 ����11:15:25
 * @����޸�ʱ�� 2016-7-13 ����11:15:25
 * @����
 * @version 1.0
 */
public class XDemandsInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String demandsId = "";
		if(request.getParameter("demandsId")!=null&&request.getParameter("demandsId")!=""){
			demandsId = request.getParameter("demandsId");
			UserdemandsBean demand = new UserdemandsBeanServiceImpl().findUserdemandsById(demandsId);
			String userId = demand.getUserId();
			UsersBean demanduser = new UsersBeanServiceimpl().findUserById(userId);
			String keys = demand.getTagName();
			 if(demand.getTagName().contains(",")){
				 keys += demand.getTagName().replace(",", " ");
			 }
			//��ȡ�Ƽ�������
			List<UserdemandsBean> demandlist = new XUserDemandServiceImpl().searchDemands(keys);
			demandlist.addAll(Search.UserDemandCos(keys+demand.getDetails()+demand.getTitle()));
			List<UserdemandsBean> tempdemandlist= new ArrayList<UserdemandsBean>();  
		    for(UserdemandsBean i:demandlist){
		        if(!tempdemandlist.contains(i)){
		        	tempdemandlist.add(i);  
		        }
		    }
		    
			if(request.getSession().getAttribute("user")!=null){
				String userlogAddr = (String) request.getSession().getAttribute("userlogAddr");//�����־�ļ�·��
				//����־�ļ��в���һ����¼
				LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] �鿴������:"+demandsId+"---"+demand.getTitle()+"---"+demand.getDetails());
				
			}
			request.setAttribute("lnotes", new XUserDemandServiceImpl().getLnotesBydemandId(demandsId));
			request.setAttribute("demand", demand);
			request.setAttribute("demanduser", demanduser);
			request.setAttribute("demandlist", tempdemandlist);
			request.getRequestDispatcher("needsingle.jsp").forward(request, response);
			
		}else{
			response.sendError(404);
		}
		
		
		
	}

}
