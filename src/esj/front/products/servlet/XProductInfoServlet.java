package esj.front.products.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esj.algorithm.search.Search;
import esj.front.products.service.XLnotesService;
import esj.front.products.service.impl.XLnotesServiceImpl;
import esj.front.products.service.impl.XProductsServiceImpl;
import esj.front.util.LogsFileUtil;
import esj.publicdoc.bean.LnotesBean;
import esj.publicdoc.bean.ProductsBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.impl.ProductsBeanServiceImpl;
import esj.publicdoc.service.impl.UsersBeanServiceimpl;
import esj.util.DateHelper;
import esj.util.GetIpAddr;

public class XProductInfoServlet extends HttpServlet {
private ProductsBeanServiceImpl proser = new ProductsBeanServiceImpl();
private UsersBeanServiceimpl userser = new UsersBeanServiceimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String proId = "";
		if(request.getParameter("proId")!= ""&&request.getParameter("proId")!= null){
			 proId=request.getParameter("proId");
			 ProductsBean pro = proser.findProductsById(proId);
			 String prouserId = pro.getUserId();
			 UsersBean prouser = userser.findUserById(prouserId);
			 XLnotesService xService = new XLnotesServiceImpl();
			 List<LnotesBean> lnotes = xService.getLnotesByProId(proId);
			 int pcount = new XProductsServiceImpl().getPraiseCountByProId(proId);
			 int tcount = new XProductsServiceImpl().getTreadCountByProId(proId);
			 int collectcount = new XProductsServiceImpl().collectCountByProId(proId);
			 //对关键字处理
			 String keys = pro.getTagName();
			 if(pro.getTagName().contains(",")){
				 keys += pro.getTagName().replace(",", " ");
			 }
			 List<ProductsBean> leisipros = new XProductsServiceImpl().searchProducts(keys,pro.getTypeId()+"");//推荐相类似的商品
			 leisipros.addAll(Search.ProductCos(keys+pro.getTitle()+pro.getDetails()));
			 //去重复
			 List<ProductsBean> templeisipros= new ArrayList<ProductsBean>();  
			    for(ProductsBean i:leisipros){
			        if(!templeisipros.contains(i)){
			        	templeisipros.add(i);  
			        }  
			    } 
			 if(request.getSession().getAttribute("user")!=null){
				 String scores = xService.getByProId(proId,((UsersBean)request.getSession().getAttribute("user")).getUserId());
				 if(scores!=null){
					 request.setAttribute("scores", scores);
				 }else{
					 request.setAttribute("scores", "");
				 }
				String userlogAddr = (String) request.getSession().getAttribute("userlogAddr");//获得日志文件路径
				//向日志文件中插入一条记录
				LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] 查看了商品:"+proId+"---"+pro.getTitle()+"---"+pro.getTitle());
				
			 }
			 request.setAttribute("product", pro);
			 request.setAttribute("prouser", prouser);
			 request.setAttribute("lnotes", lnotes);
			 request.setAttribute("pcount", pcount);
			 request.setAttribute("tcount", tcount);
			 request.setAttribute("collectcount", collectcount);
			 request.setAttribute("leisipros", templeisipros);
			 request.getRequestDispatcher("single.jsp").forward(request, response);
		}else{
			 response.sendError(404);
		}
	}
}
