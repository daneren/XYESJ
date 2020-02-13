
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>个人中心</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content=" " />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="../css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--webfont-->
<script src="../js/jquery.easydropdown.js"></script>
<!-- Add fancyBox main JS and CSS files -->
<script src="../js/jquery.magnific-popup.js" type="text/javascript"></script>
<link href="../css/magnific-popup.css" rel="stylesheet" type="text/css">
<link href="../css/component.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel="stylesheet" type="text/css">
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


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../js/simpleCart.min.js"> </script>
<!-- Add fancyBox main JS and CSS files -->
<script src="../js/jquery.magnific-popup.js" type="text/javascript"></script>
<script src="../js/easyResponsiveTabs.js" type="text/javascript"></script>
		    <script type="text/javascript">
			    $(document).ready(function () {
			        $('#horizontalTab').easyResponsiveTabs({
			            type: 'default', //Types: default, vertical, accordion           
			            width: 'auto', //auto or any width like 600px
			            fit: true   // 100% fit in a container
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
			  		<h1>买家中心-我求购的</h1>
					<hr class="mhr">
					<!-- 标签页开始 -->
					<div class="sap_tabs">	
				      <div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
				      	<ul class="resp-tabs-list">
						  	  <li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>未解决${fn:length(unsolveDemands)}</span></li>
							  <li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>已解决${fn:length(solved)}</span></li>
							  <li class="resp-tab-item"><a href="person_fabuneed.jsp">发布需求</a></li>					
							  <div class="clear"></div>
						 </ul>	
						 <div class="resp-tabs-container">
						 	<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
						 		<div class="facts">
									<c:forEach items="${unsolveDemands }" var="demand">
									 <div class="cart-sec simpleCart_shelfItem">
											<div class="cart-item cyc">
												<c:if test="${!fn:contains(demand.photoAddr, ',') }">
												 <img src="${demand.photoAddr }" class="img-responsive" alt=""/>
												 </c:if>
												<c:if test="${fn:length(fn:split(demand.photoAddr,',') )>1 }">
												 	<img src="${fn:substringBefore(demand.photoAddr,',')}" class="img-responsive" alt=""/>	
												 </c:if>
												 
											</div>
										   <div class="cart-item-info">
											<h3><a href="${pageContext.request.contextPath}/XDemandsInfo?demandsId=${demand.demandId }" target="_blank">${demand.title }</a><span>发布时间：${demand.bdate }</span><span>结束时间：${demand.edate }</span></h3>
											<ul class="qty">
												<li><p>类别 : ${demand.remark }</p></li>
												<li><p>标签 : ${demand.tagName}</p></li>
											</ul>
											<div class="delivery">
												 <p>需求描述：${demand.details }</p>
												 <a class="button item_add  cbp-vm-add" href="person_changeneed.jsp?id=${demand.demandId }" target="_blank">修改</a>
												 <a class="button item_add  cbp-vm-add" href="javascript:if(confirm('确定删除该信息?'))location='${pageContext.request.contextPath }/person_center/XUserLookDemands?op=1&id=${demand.demandId }'" id="${demand.demandId }">删除该需求</a>
												 <a class="button item_add  cbp-vm-add" href="javascript:if(confirm('确定修改该信息?'))location='${pageContext.request.contextPath }/person_center/XUserLookDemands?op=2&id=${demand.demandId }'" >点击设置为已解决</a>
												 <span>状态：${demand.state }</span>
												 
												 <div class="clearfix"></div>
									        </div>	
										   </div>
										   <div class="clearfix"></div>
										   <hr>
									  </div>
									  </c:forEach>
							    </div>
							 </div>	
							  <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
									<div class="facts">
									  <c:forEach items="${solved}" var="solvd">
				 <div class="cart-sec simpleCart_shelfItem">
						<div class="cart-item cyc">
							<c:if test="${!fn:contains(solvd.photoAddr, ',') }">
							 <img src="${solvd.photoAddr }" class="img-responsive" alt=""/>
							 </c:if>
							<c:if test="${fn:length(fn:split(solvd.photoAddr,',') )>1 }">
							 	<img src="${fn:substringBefore(solvd.photoAddr,',')}" class="img-responsive" alt=""/>	
							 </c:if>
						</div>
					   <div class="cart-item-info">
						<h3><a href="${pageContext.request.contextPath}/XDemandsInfo?demandsId=${solvd.demandId }" target="_blanck">${solvd.title  }</a>
						<br><br>
						<span>发布时间：${solvd.bdate  }</span> <span>解决时间：${solvd.edate  }</span></h3>
						<br>
						<ul class="qty">
							<li><p>类别 : ${solvd.remark  }</p></li>
							<li><p>标签 : ${solvd.tagName  }</p></li>
						</ul>
						<div class="delivery">
							 <p>需求描述：${solvd.details  }</p>
							 <span>状态：${solvd.state  }</span>
							 
							 <div class="clearfix"></div>
				        </div>	
					   </div>
					   <div class="clearfix"></div>
					   <hr>
				  </div>
				  </c:forEach>       
							        </div>
							  </div>
						 </div>
				      </div>
					 </div>	
			  </div>
			</div>
		 </div>
		</div>

	  </div>
     <!-- start footer -->
     	<%@include file="footer.jsp" %>
     <!-- end footer -->
  <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</body>
</html>
