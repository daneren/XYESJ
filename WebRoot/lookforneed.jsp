<%@page import="esj.publicdoc.service.impl.UserdemandsBeanServiceImpl"%>
<%@page import="esj.front.demands.service.impl.XUserDemandServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
pageContext.setAttribute("newneeds", new XUserDemandServiceImpl().getNewUnsolveDemands());
pageContext.setAttribute("graduateneeds", new XUserDemandServiceImpl().getNewGraduateUnsolveDemands());
pageContext.setAttribute("needtypes", new ProtypesBeanServiceimpl().findAllProtypes());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>科大二手街-	求购浏览</title>
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


	<%@include file="needheader.jsp"%>

	<div class="main">
		<div class="content_box">
			<div class="container">
				<div class="row">
					<!-- start side -->
					<%@include file="side.jsp"%>
					<!-- end side -->


					<div class="col-md-9 cart-items">
					<!-- 最新商品-->
						<font class="f_1">最新发布的求购</font><a href="XSearchDemands?searchvalue=最新发布的需求" target="_blank" class="link1 a_r1">更多</a>
						<div class="content_grid">
						<div class="cart-header">
					  	 <hr>
					  	 <c:forEach begin="0" end="7" items="${newneeds }" var="nn">
						 <div class="cart-sec simpleCart_shelfItem">
						 <a href="XDemandsInfo?demandsId=${nn.demandId }" target="_blank">
								<div class="cart-item cyc">
									<c:if test="${empty nn.photoAddr }">
									 <img src="images/none_img.png" class="img-responsive" title="${nn.title }"/>
									 </c:if>
									 <c:if test="${!empty nn.photoAddr }">
									 <c:if test="${fn:length(fn:split(nn.photoAddr,',') )>1 }">
									 <img src="${fn:substringBefore(nn.photoAddr,',')}" class="img-responsive" title="${nn.title }"/>
									 </c:if>
									 <c:if test="${!fn:contains(nn.photoAddr, ',') }">
									<img src="${nn.photoAddr }" class="img-responsive" title="${nn.title }"/>	
									</c:if>
									</c:if>
								</div>
							</a>
							   <div class="cart-item-info">
								<h3><a href="XDemandsInfo?demandsId=${nn.demandId }" target="_blank">${nn.title }</a><span>发布时间：${nn.bdate }</span><span>结束时间：${nn.edate }</span></h3>
								<ul class="qty">
									<li><p>发布人 : ${nn.userId }</p></li>
									<li><p>类别 : 
									<c:forEach items="${needtypes }" var="type">
									<c:if test="${type.typeId==nn.typeId }">${type.typeName }</c:if>
									</c:forEach>
									</p></li>
									<li><p>标签 : ${nn.tagName }</p></li>
								</ul>
								<div class="delivery">
									 <p>需求描述：${nn.details }</p>
									 
									 <div class="clearfix"></div>
						        </div>	
							   </div>
							   <div class="clearfix"></div>
							   <hr>
						  </div>
						  </c:forEach>
							<div class="clearfix"></div>
						</div>
						<!-- <h3 class="m_2">热点需求</h3> -->
						<font class="f_2">热点求购</font><a href="XSearchDemands?searchvalue=热点需求" target="_blank" class="link1 a_r1">更多</a>
						<div class="content_grid">
							<c:forEach begin="12" end="35" items="${graduateneeds }" var="gn">
								<div class="col_1_of_3 span_1_of_4 simpleCart_shelfItem">
									<div class="inner_content clearfix">
								<div class="product_image" style="height: 180px;">
								<a class="cbp-vm-image" href="XDemandsInfo?demandsId=${gn.demandId }" target="_blank" title="${gn.title }">
									<c:if test="${empty gn.photoAddr }">
									<img src="images/none_img.png" class="img-responsive" style="height: 100%;width: 100%"/>
									</c:if>
									 <c:if test="${!empty gn.photoAddr }">
									 <c:if test="${fn:length(fn:split(gn.photoAddr,',') )>1 }">
									 <img src="${fn:substringBefore(gn.photoAddr,',')}" class="img-responsive" title="${gn.title }" style="height: 100%;width: 100%"/>
									 </c:if>
									 <c:if test="${!fn:contains(gn.photoAddr, ',') }">
									<img src="${gn.photoAddr }" class="img-responsive" title="${gn.title }" style="height: 100%;width: 100%"/>	
									</c:if>
									</c:if>
									</a>
								  </div>
			                  </div>
		                    <div class="cbp-vm-details">
								<div class="cart-left">
									<a href="XDemandsInfo?demandsId=${gn.demandId }" target="_blank" title="${gn.title }${gn.details }">
									<span class="title">${gn.title }</span>
									<span class="title">${gn.details }</span>
									</a><br>
									<a href="#">
									<span class="maijia">发布人：${gn.userId }</span>
									</a>
								</div>
								
							</div>
								</div>
							</c:forEach>

							<div class="clearfix"></div>
						</div>
						<!-- end 热点需求 -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- start footer -->
	<%@include file="footer.jsp"%>
	<!-- end footer -->
</body>
</html>
