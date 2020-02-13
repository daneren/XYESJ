<%@page import="esj.front.products.service.impl.XProductsServiceImpl"%>
<%@page import="esj.publicdoc.service.impl.BroadcastsBeanServiceimpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>湖科二手街</title>
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
BroadcastsBeanServiceimpl bro = new BroadcastsBeanServiceimpl();
XProductsServiceImpl product = new XProductsServiceImpl();
pageContext.setAttribute("broadcasts", bro.findAllBroadcasts());
pageContext.setAttribute("newproducts", product.getNewProducts());
pageContext.setAttribute("graduateproducts", product.getGraduateProducts());
pageContext.setAttribute("pushproducts", product.getPushProductsById(null));
%>
<style type="text/css">

.title , .maijia{
	font-size: 0.8em;
}
.cart-left{
overflow:hidden;
text-overflow:ellipsis;
-o-text-overflow:ellipsis;
white-space:nowrap;
width:100%;
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
						<!-- start公告部分-->        			
				     <ul id="flexiselDemo3">
				     <c:forEach items="${broadcasts }" var="bc">
						<li>
							<a href="#" target="_blank"><img src="${bc.imgurl }" class="img-responsive" /></a>
							<div class="grid-flex">${bc.details }</div>
						</li>
						</c:forEach>
				     </ul><hr>
					<!-- end公告部分-->
					<!-- 最新商品-->
						<font class="f_1"><a href="XSearch?searchvalue=最新商品" target="_blank">最新商品</a></font><a target="_blank" href="XSearch?searchvalue=最新商品" class="link1 a_r1">更多</a>
						<div class="content_grid">
							<c:forEach begin="0" end="11" items="${newproducts }" var="newpro">
								<div class="col_1_of_3 span_1_of_4 simpleCart_shelfItem">
									<div class="inner_content clearfix">
								<div class="product_image" style="height: 180px;">
									<a class="cbp-vm-image" href="XProductInfo?proId=${newpro.proId }" title="${newpro.title }" target="_blank" >
										<c:if test="${fn:length(fn:split(newpro.photoAddr,',') )>1 }">
										<img src="${fn:substringBefore(newpro.photoAddr,',')}" class="img-responsive" alt="" style="height: 100%;width: 100%"/>	
										</c:if>
										<c:if test="${!fn:contains(newpro.photoAddr, ',') }">
										<img src="${newpro.photoAddr }" class="img-responsive" alt="" style="height: 100%;width: 100%"/>	
										</c:if>
									</a>
								  </div>
			                  </div>
		                    <div class="cbp-vm-details">
		                    <span class="amount item_price actual" style="float: none;">￥${newpro.dprice }</span><br>
								<div class="cart-left">
									<a href="XProductInfo?proId=${newpro.proId }" target="_blank" title="${newpro.title }">
									
									<span class="title">${newpro.title }</span>
									
									</a><br>
									<span class="title">发布时间：${fn:substring(newpro.bdate ,0,11)}</span>
								</div>
							</div><br></div>
							</c:forEach>
							<div class="clearfix"></div>
						</div>
						<!-- <h3 class="m_2">毕业季</h3> -->
						<hr>
						<font class="f_2"><a  href="XSearch?searchvalue=毕业季" target="_blank">毕业季</a></font><a href="XSearch?searchvalue=毕业季" target="_blank" href="#" class="link1 a_r1">更多</a>
						<div class="content_grid">
							<c:forEach begin="12" end="23" items="${graduateproducts }" var="gpro">
								<div class="col_1_of_3 span_1_of_4 simpleCart_shelfItem">
									<div class="inner_content clearfix">
								<div class="product_image" style="height: 180px;">
									<a class="cbp-vm-image" href="XProductInfo?proId=${gpro.proId }" title="${gpro.title }" target="_blank">
										<c:if test="${fn:length(fn:split(gpro.photoAddr,',') )>1 }">
										<img src="${fn:substringBefore(gpro.photoAddr,',')}" class="img-responsive"  style="height: 100%;width: 100%"/>	
										</c:if>
										<c:if test="${!fn:contains(gpro.photoAddr, ',') }">
										<img src="${gpro.photoAddr }" class="img-responsive" alt="" style="height: 100%;width: 100%"/>	
										</c:if>
									</a>
								  </div>
								    </div>
		                    <div class="cbp-vm-details">
		                    <span class="amount item_price actual" style="float: none;">￥${gpro.dprice }</span><br>
								<div class="cart-left">
									<a href="XProductInfo?proId=${gpro.proId }" target="_blank" title="${gpro.title }">
									<span class="title">${gpro.title }</span>
									</a><br><span class="title">发布时间：${fn:substring(gpro.bdate ,0,11) }</span>
								</div>
							</div><br></div>
							</c:forEach>

							<div class="clearfix"></div>
						</div>
						<!-- end 毕业季 -->
						<hr>
						<font class="f_2">猜你喜欢</font><a href="XSearch?searchvalue=猜你喜欢" target="_blank"class="link1 a_r1">更多</a>
						<div class="content_grid">
						
						
							<c:forEach begin="24" end="35" items="${pushproducts }" var="pushpro">
								<div class="col_1_of_3 span_1_of_4 simpleCart_shelfItem">
									<div class="inner_content clearfix">
								<div class="product_image" style="height: 180px;">
									<a class="cbp-vm-image" href="XProductInfo?proId=${pushpro.proId }" title="${pushpro.title }" target="_blank">
										<c:if test="${fn:length(fn:split(pushpro.photoAddr,',') )>1 }">
										<img src="${fn:substringBefore(pushpro.photoAddr,',')}" class="img-responsive"  style="height: 100%;width: 100%"/>	
										</c:if>
										<c:if test="${!fn:contains(pushpro.photoAddr, ',') }">
										<img src="${pushpro.photoAddr }" class="img-responsive" alt="" style="height: 100%;width: 100%"/>	
										</c:if>
									</a>
								  </div>
								    </div>
		                    <div class="cbp-vm-details">
		                    <span class="amount item_price actual" style="float: none;">￥${pushpro.dprice }</span><br>
								<div class="cart-left">
									<a href="XProductInfo?proId=${pushpro.proId }" target="_blank" title="${pushpro.title }">
									<span class="title">${pushpro.title }</span>
									</a><br><span class="title">发布时间：${fn:substring(pushpro.bdate ,0,11) }</span>
								</div>
							</div><br></div>
							</c:forEach>
										
							<div class="clearfix"></div>
						</div>
						<!-- end 猜你喜欢的 -->

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
