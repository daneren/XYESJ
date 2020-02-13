<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="container"> 
    <div class="header-top">
     	<div class="header-bar">
     	<div class="container-fluid">
			 <!-- Brand and toggle get grouped for better mobile display -->
   <div class="navbar-header">
     <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">首页</a>
   </div>

   <!-- Collect the nav links, forms, and other content for toggling -->
   <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
     <ul class="nav navbar-nav">
       <li><a href="${pageContext.request.contextPath}/lookforneed.jsp" target="_blank">求购中心</a></li>
		<li><a href="${pageContext.request.contextPath }/person_center/CollectsServlet?op=1" target="_blank">我的收藏</a></li>
		<li><a href="${pageContext.request.contextPath }/person_center/person_fabupro.jsp" target="_blank">发布商品</a></li>
		<li><a href="${pageContext.request.contextPath}/person_center/ReservServlet?op=1" target="_blank">我买到的</a></li>
     </ul>
     <ul class="nav navbar-nav navbar-right">
      <c:if test="${empty user }">
		 <li><a href="login.jsp">【登陆】</a></li>
	</c:if>
	<c:if test="${!empty user }">
		<li class="dropdown1">
         <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">【${user.userName }】 <span class="caret"></span></a>
         <ul class="dropdown-menu">
           <li><a href="${pageContext.request.contextPath}/person_center/person_fabuneed.jsp">发布求购</a></li>
           <li><a href="${pageContext.request.contextPath }/person_center/XUserLookDemands">我的求购</a></li>
           <li role="separator" class="divider"></li>
           <li><a href="${pageContext.request.contextPath }/person_center/person_msg.jsp">个人资料</a></li>
         </ul>
       </li>
		
	</c:if>
       <li class="dropdown1">
         <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">卖家中心 <span class="caret"></span></a>
         <ul class="dropdown-menu">
           <li><a href="${pageContext.request.contextPath }/person_center/SoldProServlet?op=1">我卖出的</a></li>
           <li><a href="${pageContext.request.contextPath }/person_center/SellerDealing?op=1">交易中</a></li>
           <li><a href="${pageContext.request.contextPath }/person_center/AllReserv?op=1">预约管理</a></li>
         </ul>
       </li>
       <c:if test="${!empty user }">
       <li><a href="${pageContext.request.contextPath}/XUserLogout">【退出】</a></li>
       </c:if>
     </ul>
   </div><!-- /.navbar-collapse -->
 </div><!-- /.container-fluid -->		
</div>
       <div class="clearfix"></div>
</div>    
 </div>