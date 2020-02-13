<%@page import="esj.publicdoc.service.impl.TagsBeanServiceimpl"%>
<%@page import="esj.publicdoc.service.impl.BroadcastsBeanServiceimpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>所有标签</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<!-- 标配 -->
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<script src="js/simpleCart.min.js"> </script>
<script src="js/jquery.min.js"></script>
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script src="js/jquery.easydropdown.js"></script>
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
<link href="css/magnific-popup.css" rel="stylesheet" type="text/css">
<link href="css/component.css" rel='stylesheet' type='text/css' />
<!-- 标配 -->
<script>
	$(document).ready(function() {
		$('.popup-with-zoom-anim').magnificPopup({
			type : 'inline',
			fixedContentPos : false,
			fixedBgPos : true,
			overflowY : 'auto',
			closeBtnInside : true,
			preloader : false,
			midClick : true,
			removalDelay : 300,
			mainClass : 'my-mfp-zoom-in'
		});
	});
</script>
<%
//获取标签
pageContext.setAttribute("tags", new XTagsServiceImpl().getTagsBytimesDesc());
%>
<style type="text/css">

.title , .maijia{
	font-size: 0.8em;
}


</style>
</head>

<body>


	<%@include file="header.jsp"%>

	<div class="main">
		<div class="content_box">
			<div class="container">
				<div class="row">

					<!-- start side -->
					<%@include file="side.jsp"%>
					<!-- end side -->


					<div class="col-md-9">
					<hr>
					<!-- 热门搜索标签-->
						<font class="f_1">热门搜索标签</font><a href="#" class="link1 a_r1">更多</a>
						<div class="tags">
				         <ul class="tags_links">
				         	<c:forEach begin="0" end="20" items="${tags }" var="tag" varStatus="status" >
					         <li><a href="${pageContext.request.contextPath }/XTagsSearch?tagname=${tag.tagName}" target="_blank">${tag.tagName }</a></li>
					         		
				         	</c:forEach>
							
						</ul>
				     </div>
						<!-- 所有标签 -->
						<hr>
						<font class="f_2">所有标签</font>
						<div class="tags">
				         <ul class="tags_links">
				         	<c:forEach items="${tags }" var="tag" varStatus="status" >
					         <li><a href="${pageContext.request.contextPath }/XTagsSearch?tagname=${tag.tagName}" target="_blank">${tag.tagName }</a></li>
					         		
				         	</c:forEach>
							
						</ul>
				     </div>
						<!-- end 所有标签 -->
						<hr>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- start footer -->
	<%@include file="footer.jsp"%>
	<!-- end footer -->
</body>
 <script type="text/javascript">
$(window).load(function() {
	$("#flexiselDemo3").flexisel({
		visibleItems: 1,
		animationSpeed: 1000,
		autoPlay: true,
		autoPlaySpeed: 3000,    		
		pauseOnHover: true,
		enableResponsiveBreakpoints: true,
		responsiveBreakpoints: { 
		portrait: { 
			changePoint:480,
			visibleItems: 1
		}, 
		landscape: { 
			changePoint:640,
			visibleItems: 2
		},
		tablet: { 
			changePoint:768,
			visibleItems: 3
				}
			}
		});
					    
	});
</script>
<script type="text/javascript" src="js/jquery.flexisel.js"></script>
</html>
