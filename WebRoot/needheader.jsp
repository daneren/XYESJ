<%@page import="esj.publicdoc.bean.UsersBean"%>
<%@page import="esj.front.products.service.impl.XProductsServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String userId="";
if(session.getAttribute("user")!=null){
userId = ((UsersBean)session.getAttribute("user")).getUserId();
pageContext.setAttribute("resercount", new XProductsServiceImpl().getReserveCountByUserId(userId));
pageContext.setAttribute("pricecount", new XProductsServiceImpl().getReservePriceCountByUserId(userId));
}

%>
<style>
.ula a{
color: #fff;
}
.dropdown .selected, .dropdown li {
    display: block;
    font-size: 100%;
    overflow: hidden;
    white-space: nowrap;
    text-transform: uppercase;
    font-weight:normal;
    min-width: -moz-min-content;
    }
.dropdown {
    position: relative;
    width: 60px;
    cursor: pointer;
    font-weight: 200;
    background: none;
    padding: 16px 0px 8px;
    color: #fff;
    -webkit-user-select: none;
    -moz-user-select: none;
    user-select: none;
    min-width: -moz-min-content;
}
</style>
	<div class="header" >
      <div class="container"> 
        <div class="header-top">
         	<div class="header-bar">
         	<div class="container-fluid">
			    <div class="navbar-header">
			      <a class="navbar-brand" href="index.jsp" target="_blank">首页</a>
			    </div>
			
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			    
			      <ul class="nav navbar-nav ula">
			      <li><a href="${pageContext.request.contextPath}/lookforneed.jsp" target="_blank">求购中心</a></li>
			      <li><a href="${pageContext.request.contextPath }/person_center/CollectsServlet?op=1" target="_blank">我的收藏</a></li>
			       <li><a href="${pageContext.request.contextPath }/person_center/person_fabupro.jsp" target="_blank">发布商品</a></li>
			      <li><a href="${pageContext.request.contextPath}/person_center/ReservServlet?op=1" target="_blank">我买到的</a></li>
			      </ul>
			      
			      <ul class="nav navbar-nav ula navbar-right">
			      <c:if test="${empty user }">
			        <li><a href="login.jsp" target="_blank">【登陆】</a></li>
			         <li><a href="register.jsp" target="_blank">【注册】</a></li>
			        </c:if>
			        <c:if test="${!empty user }">
			        <li><div class="lang_list">
			         <select onchange="window.location=this.value;" tabindex="4" class="dropdown">
						<option class="label">${user.userName }</option>
						<option value="${pageContext.request.contextPath}/person_center/person_fabuneed.jsp">发布求购</option>
						<option value="${pageContext.request.contextPath }/person_center/XUserLookDemands">我的求购</option>
						<option value="${pageContext.request.contextPath }/person_center/person_msg.jsp">个人资料</option>
					  </select>
					  </div>
			        </li>
			        </c:if>
			        <li>&nbsp;&nbsp;&nbsp;&nbsp;</li>
					
			        <li><div class="lang_list">
			         <select onchange="window.location=this.value;" tabindex="4" class="dropdown">
						<option class="label">卖家中心</option>
						<option value="${pageContext.request.contextPath }/person_center/SoldProServlet?op=1">我卖出的</option>
						<option value="${pageContext.request.contextPath }/person_center/SellerDealing?op=1">交易中</option>
						<option value="${pageContext.request.contextPath }/person_center/AllReserv?op=1">预约管理</option>
					  </select>
					  </div>
			        </li>
			         <c:if test="${!empty user }">
			         <li>&nbsp;&nbsp;&nbsp;&nbsp;</li>
			        <li><a href="${pageContext.request.contextPath}/XUserLogout">退出</a></li>
			        </c:if>
			       </ul>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->		
		 </div>
          <div class="clearfix"></div>
		 </div>    
		 
		 <div class="banner_wrap">
		 <c:if test="${!empty user }">
			<div class="bannertop_box">
   		 		<ul class="login">
			     <li><a href="${pageContext.request.contextPath}/person_center/person_msg.jsp" target="_blank">${user.userName }</a></li>
			   <div class='clearfix'></div>
   		 		</ul>
   		 		<div class="cart_bg">
	   		 	  <ul class="cart">
	   		 		 <a href="${pageContext.request.contextPath }/person_center/ReservServlet?op=1" target="_blank">
					    <h4>
					    <i class="cart_icon"> </i>
					    <p> <a class="simpleCart_empty">我预约的商品</a>(<span id="simpleCart_quantity">${resercount}</span>)</p>
					    <p>总价: <span id="simpleCart_total">￥${pricecount }</span></p>
					    <div class="clearfix"> </div></h4>
					 </a>
				     <div class="clearfix"> </div>
                  </ul>
	   		 	</div>
			  	<ul class="quick_access">
   		 			<li class="view_cart"><a href="${pageContext.request.contextPath }/person_center/ReservServlet?op=1" target="_blank">我的预约</a></li>
   		 			<div class='clearfix'></div>
   		 		</ul>
   		 	</div>
   		 	  </c:if>
   		 	  <!-- 搜索 -->
   		 	<div class="banner_right">
   		 		<form action="XSearchDemands" method="get">
   		 		<div class="search">
   		 		<c:if test="${!empty searchvalue}">
	  			   <input type="text" name="searchvalue" value="${searchvalue }"  onBlur="if (this.value == '') {this.value = '${searchvalue }';}">
	  			 </c:if>
	  			 <c:if test="${empty searchvalue}">
	  			   <input type="text" name="searchvalue"  value="" onBlur="if (this.value == '') {this.value = '';}">
	  			 </c:if>
				   <input type="submit" value="">
	  			</div>
	  			</form>
   		 	</div>
   		 	<div class='clearfix'></div>
	    </div><!-- end banner_wrap -->
	   
	   </div>
	   </div>