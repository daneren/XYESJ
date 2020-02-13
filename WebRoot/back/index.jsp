<%@page import="esj.publicdoc.service.impl.AuthoritiesBeanServiceimpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("authorities", new AuthoritiesBeanServiceimpl().findAllAuthorities());
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="/favicon.ico" >
<LINK rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="skin/default/skin.css" rel="stylesheet" type="text/css" id="skin" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<![endif]-->

<link href="${pageContext.request.contextPath }/back/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/back/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/back/skin/default/skin.css" rel="stylesheet" type="text/css" id="skin" />
<link href="${pageContext.request.contextPath }/back/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/back/css/style.css" rel="stylesheet" type="text/css" />

<title>湖科二手街-后台管理</title>
</head>
<body>
<header class="Hui-header cl"> <a class="Hui-logo l"  href="">湖科二手街后台</a> 
	<ul class="Hui-userbar">
		<li><c:forEach items="${authorities }" var="auth"><c:if test="${auth.authId == admin.authId }">${auth.authName }</c:if></c:forEach></li>
		<li class="dropDown dropDown_hover"><a href="#" class="dropDown_A">${ admin.adminName }<i class="Hui-iconfont">&#xe6d5;</i></a>
			<ul class="dropDown-menu radius box-shadow">
				<li><a href="admin_back_login?type=logout">切换账户</a></li>
				<li><a href="admin_back_login?type=logout">退出</a></li>
			</ul>
		</li>
		<li id="Hui-skin" class="dropDown right dropDown_hover"><a href="javascript:;" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
			<ul class="dropDown-menu radius box-shadow">
				<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
				<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
				<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
				<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
				<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
				<li><a href="javascript:;" data-val="orange" title="绿色">橙色</a></li>
			</ul>
		</li>
	</ul>
	<a aria-hidden="false" class="Hui-nav-toggle" href="#"></a> </header>
<aside class="Hui-aside">
	<input runat="server" id="divScrollValue" type="hidden" value="" />
	<div class="menu_dropdown bk_2">
	
					
	
		<dl id="menu-comments">	
			<dt><i class="Hui-iconfont">&#xe622;</i> 用户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<c:forEach items="${MenuList}" var="MenuList" begin="0" end="4">
	
						<c:if test="${fn:contains(AuthoritiesMenuList, MenuList.menuId) && MenuList.menuId!='3' }">			
							<li><a _href="${MenuList.menuUrl}" href="javascript:;">${MenuList.menuName}</a></li>
						</c:if>	
				
					</c:forEach>
				</ul>
			</dd>
		</dl>
		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<c:forEach items="${MenuList}" var="MenuList" begin="5" end="5">
	
						<c:if test="${fn:contains(AuthoritiesMenuList, MenuList.menuId)}">			
							<li><a _href="${MenuList.menuUrl}" href="javascript:;">${MenuList.menuName}</a></li>
						</c:if>	
				
					</c:forEach>
				</ul>
			</dd>
		</dl>
		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 标签管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<c:forEach items="${MenuList}" var="MenuList" begin="6" end="6">
	
						<c:if test="${fn:contains(AuthoritiesMenuList, MenuList.menuId)}">			
							<li><a _href="${MenuList.menuUrl}" href="javascript:;">${MenuList.menuName}</a></li>
						</c:if>	
				
					</c:forEach>

				</ul>
			</dd>
		</dl>
		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 商品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<c:forEach items="${MenuList}" var="MenuList" begin="7" end="8">
	
						<c:if test="${fn:contains(AuthoritiesMenuList, MenuList.menuId)}">			
							<li><a _href="${MenuList.menuUrl}" href="javascript:;">${MenuList.menuName}</a></li>
						</c:if>	
				
					</c:forEach>					

				</ul>
			</dd>
		</dl>

		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 需求管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<c:forEach items="${MenuList}" var="MenuList" begin="9" end="9">
	
						<c:if test="${fn:contains(AuthoritiesMenuList, MenuList.menuId)}">			
							<li><a _href="${MenuList.menuUrl}" href="javascript:;">${MenuList.menuName}</a></li>
						</c:if>	
				
					</c:forEach>

				</ul>
			</dd>
		</dl>	

		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 权限管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<c:forEach items="${MenuList}" var="MenuList" begin="10" end="11">
	
						<c:if test="${fn:contains(AuthoritiesMenuList, MenuList.menuId)}">			
							<li><a _href="${MenuList.menuUrl}" href="javascript:;">${MenuList.menuName}</a></li>
						</c:if>	
				
					</c:forEach>

				</ul>
			</dd>
		</dl>
		
		
	<!--  
		<dl id="menu-comments">	
			<dt><i class="Hui-iconfont">&#xe622;</i> 用户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a _href="control_user/rnotes/rnotes_manage.jsp" href="javascript:;">评论管理</a></li>
					<li><a _href="control_user/blacklist_manage/blacklist_manage.jsp" href="javascript:void(0)">黑名单管理</a></li>
					<li><a _href="control_user/authorities/authorities_manage.jsp" href="javascript:void(0)">用户权限管理</a></li>
					<li><a _href="control_user/lnotes_manage/lnotes_manage.jsp" href="javascript:void(0)">留言管理</a></li>
					<li><a _href="control_user/User_info_manage/user_info_manage.jsp" href="javascript:void(0)">用户信息管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a _href="control_level/member_level.jsp" href="javascript:void(0)">等级管理</a></li>
				</ul>
			</dd>
		</dl>
				<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 标签管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a _href="control_tag/Tag_ListServlet" href="javascript:void(0)">标签管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 商品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a _href="control_product/Product_CategoryServlet" href="javascript:void(0)">商品类别管理</a></li>
					<li><a _href="control_product/Product_ListServlet" href="javascript:void(0)">商品信息管理</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 需求管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a _href="control_userDmand/UserDmand_ListServlet" href="javascript:void(0)">用户需求管理</a></li>
				</ul>
			</dd>
		</dl>	

		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 权限管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a _href="control_authoritie/Admin_listServlet" href="javascript:void(0)">管理员管理</a></li>
					<li><a _href="control_authoritie/Authoritie_GroupServlet" href="javascript:void(0)">权限组管理</a></li>
				</ul>
			</dd>
		</dl>
		
		-->
	</div>
</aside>
<div class="dislpayArrow"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active"><span title="我的桌面" data-href="welcome.jsp">我的桌面</span><em></em></li>
			</ul>
		</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
	</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="welcome.jsp"></iframe>
		</div>
	</div>
</section>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript">
/*资讯-添加*/
function article_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
</script> 
</body>
</html>