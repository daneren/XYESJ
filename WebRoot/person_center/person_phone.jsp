<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人中心</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shape Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="${pageContext.request.contextPath }/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath }/js/simpleCart.min.js"> </script>
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath }/css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--webfont-->
<script src="${pageContext.request.contextPath }/js/jquery.easydropdown.js"></script>
<!-- Add fancyBox main JS and CSS files -->
<script src="${pageContext.request.contextPath }/js/jquery.magnific-popup.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/css/magnific-popup.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/person_center/css/style.css" rel='stylesheet' type='text/css' />
		<script>
			$(document).ready(function() {
				$('.popup-with-zoom-anim').magnificPopup({
					type: 'inline',
					fixedContentPos: false,
					fixedBgPos: true,
					overflowY: 'auto',
					closeBtnInside: true,
					preloader: false,
					midClick: true,
					removalDelay: 300,
					mainClass: 'my-mfp-zoom-in'
			});
		});
		</script>
</head>
  
<body>
<div class="header">	
      <%@ include file="person_head.jsp"%>
</div>
	</div>
	<div class="main">
	  <div class="content_box">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<!-- side begin -->
					<%@ include file="person_side.jsp"%>
					<!-- side end -->
				</div>
			  <div class="col-md-9"><br>					
			  	 <div class="container-fluid "> 			  	 	
					<h1>绑定手机号</h1>
					<hr class="mhr">					
					<form class="form-horizontal div-form">						
							<div class="row">
								  <div class="col-xs-12 col-md-2">
									  <label class="label-form">*原手机号</label>	
								  </div>
								  <div class="col-xs-6 col-md-10">
								  	<input type="text" class="form-control input-form" id="exampleInputName2" placeholder="您还没有绑定手机号，赶紧试试吧" readonly="readonly"/>
								  </div>
							</div>
							<!-- 如果默认使用  span-remind-hide 样式-->		
							<br>
							<div class="row">
								  <div class="col-xs-12 col-md-2">
									  <label class="label-form">*新手机号</label>	
								  </div>
								  <div class="col-xs-6 col-md-10">
								  	<input type="text" class="form-control input-form" id="exampleInputName2" placeholder="请输入11位手机号"/>
								  </div>
							</div>
							<span class="span-remind-show">*您输入的格式有误，请仔细检查后重新输入</span>
							<br>
							<div class="row">
								  <div class="col-xs-12 col-md-2">
									  <label class="label-form">*验证码</label>	
								  </div>
								  <div class="col-xs-6 col-md-10">
								  	<input type="text" class="form-control input-varcode" id="exampleInputName2" placeholder="请输入验证码"/>
								 	<input class="btn btn-default" type="button" value="获取验证码">
								 	<span>已发送至您的手机</span>
								  </div>
							</div>
							<span class="span-remind-show">*验证码错误</span>
							<br>
							<div class="row register-but">
								<input type="submit" style="margin-left: 35%;" value="保存"/>
							</div>
					</form>
				</div>
			  </div>
			</div>
		 </div>
		</div>

	  </div>
     <!-- start footer -->
     	<%@include file="footer.jsp" %>
     <!-- end footer -->
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>

  <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
</body>
</html>
