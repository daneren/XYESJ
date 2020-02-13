<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<div class="menu_box">
  	  	<h3 class="menu_head">买家中心</h3>
 		<ul class="nav1">				   	     		     		
 	     		<li><a href="${pageContext.request.contextPath }/person_center/ReservServlet?op=1">我买到的</a></li>
 	     		<li><a href="${pageContext.request.contextPath }/person_center/BDealing?op=1">交易中的</a></li>
 	     		<li><a href="${pageContext.request.contextPath }/person_center/CollectsServlet?op=1">我收藏的</a></li> 	     		
 	     		<li><a href="${pageContext.request.contextPath }/person_center/XUserLookDemands">我求购的</a></li>	
 	     		<li><a href="${pageContext.request.contextPath }/person_center/person_fabuneed.jsp">发布求购</a></li>
 	     				 	     		
   		 </ul>
</div>
<div class="category">
  	  	<h3 class="menu_head">卖家中心</h3>
		<ul class="nav1">				   	     		     		
 	     		<li><a href="${pageContext.request.contextPath }/person_center/SoldProServlet?op=1">我卖出的</a></li>   
 	     		<li><a href="${pageContext.request.contextPath }/person_center/SellerDealing?op=1">交易中的</a></li>
 	     		<li><a href="${pageContext.request.contextPath }/person_center/AllReserv?op=1">预约管理</a></li> 		 	     		
   				<li><a href="${pageContext.request.contextPath }/person_center/person_fabupro.jsp">发布商品 </a></li>     
   		</ul>
</div>

 <div class="category">
	<h3 class="menu_head">我的资料</h3>
    <ul class="category_nav">
 	     		<li><a href="${pageContext.request.contextPath }/person_center/person_msg.jsp">个人基础信息</a></li>
 	     		<li><a href="${pageContext.request.contextPath }/person_center/person_grow.jsp">个人成长信息</a></li>
 	     		<li><a href="${pageContext.request.contextPath }/person_center/person_pwd.jsp">修改密码</a></li>
 	     		<li><a href="${pageContext.request.contextPath }/person_center/person_phone.jsp">修改手机号</a></li>
   	</ul>
</div>

