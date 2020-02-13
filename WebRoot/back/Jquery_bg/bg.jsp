<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String authid=request.getParameter("authid");
	pageContext.setAttribute("authid", authid);
	///back/Jquery_bg/SelectMenuServlet
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
	<META HTTP-EQUIV="Refresh" CONTENT="3; URL=../SelectMenuServlet?id=${authid}"/>
<title>加载页面  </title>

<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />

<!--å¿è¦æ ·å¼-->
<link rel="stylesheet" type="text/css" href="css/component.css" />

<!--[if IE]>
	<script src="js/html5.js"></script>
	<![endif]-->
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<h1 class="main-title">Welcome<span class="thin">   ${admin.adminName }</span></h1>
				</div>

				<!--<nav class="codrops-demos">
					<a class="current-demo" href="bg.html">Demo 1</a>
					&lt;!&ndash;<a href="index2.html">Demo 2</a>
					<a href="index3.html">Demo 3</a>
					<a href="index4.html">Demo 4</a>&ndash;&gt;
				</nav>-->
			</div>
		</div><!-- /container -->
		<script src="js/TweenLite.min.js"></script>
		<script src="js/EasePack.min.js"></script>
		<script src="js/rAF.js"></script>
		<script src="js/demo-1.js"></script>
	</body>
</html>