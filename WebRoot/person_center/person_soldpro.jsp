<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>个人中心</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content=" " />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
<script src="../js/jquery.min.js"></script>
<link href="../css/style.css" rel='stylesheet' type='text/css' />
<script src="../js/jquery.easydropdown.js"></script>
<script src="../js/jquery.magnific-popup.js" type="text/javascript"></script>
<link href="../css/magnific-popup.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="../js/simpleCart.min.js"> </script>
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
			  		<h1>卖家中心-我卖出的</h1>
					<hr class="mhr">
					<!-- 标签页开始 -->
					<div class="sap_tabs">	
				      <div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
				      	<ul class="resp-tabs-list">
				      		 <li class="resp-tab-item" aria-controls="tab_item-0" role="tab" id="tab1"><span>出售中${fn:length(pOnSale)}</span></li>	
						  	  <li class="resp-tab-item" aria-controls="tab_item-1" role="tab" id="tab2" ><span>已售出${fn:length(pSoldOut)}</span></li>
							  <a href="person_fabupro.jsp"> <li class="resp-tab-item" aria-controls="tab_item-2" role="tab" id="tab3"><span>发布商品</span></li></a>		
							  <div class="clear"></div>
						 </ul>	
					 <div class="resp-tabs-container">
						 <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
							<div class="facts">
								<div class="content_grid">
								 	<c:forEach var="ns" items="${pOnSale}" varStatus="status">
								 		<div class="col_1_of_3 span_1_of_4 simpleCart_shelfItem "> 
									  	    <a href="${pageContext.request.contextPath }/XProductInfo?proId=${ns.proId}" target="_blank">	
											   <div class="inner_content clearfix">
												<div class="product_image" style="height: 180px;width: 100%;">
													<c:if test="${fn:indexOf(ns.photoAddr,',')<=0 }">
														<img alt="加载失败" src="${ns.photoAddr}" class="img-responsive" style="width: 100%;height: 100%;"/>
													</c:if>
													<c:if test="${fn:indexOf(ns.photoAddr,',')>0 }">
														<img src="${fn:split(ns.photoAddr,',')[0]}" class="img-responsive" alt="加载失败" style="width: 100%;height: 100%;"/>		
													</c:if>												    	
												  </div>
							                    </div>
							                    <div class="pro-title">
							                    <a title="${ns.title }">${fn:substring(ns.title,0,11) }</a>
							                    </div><br>
							                 </a>
							                 <div class="product_container">														   												    
							                 <div class="div-thumbs">
												<span id="up1" class="glyphicon glyphicon-thumbs-up span-thumbs-up ups" aria-hidden="false sr-only">赞${ns.pCount}</span>
												<span id="down1" class="glyphicon glyphicon-thumbs-down span-thumbs-down donws" aria-hidden="false sr-only">踩${ns.nCount}</span>														
											 </div>
											  <div class="clearfix"></div>
											 <div class="div-thumbs">
											 	<span class="span-pro-p"><a href="${pageContext.request.contextPath }/person_center/AllReserv?op=1">预约人数：${ns.ruCount}</a></span>							
											 	<span class="span-pro-p"><a href="person_changepro.jsp?id=${ns.proId}">修改</a></span>
											 	<span class="span-pro-p"><a href="SoldProServlet?op=3&id=${ns.proId}">删除</a></span>
											 </div>
											</div>	
									    </div>
									    
								 		<c:if test="${status.count%4 ==0}">
								 			<hr>
								 			<div class="clearfix"></div>
								 		</c:if>
								 	</c:forEach>
								 	<div class="row nav">
								 		<span class="mnav-span">							 		
										  <ul class="pagination">
										    <li>
										      <a href="#" aria-label="Previous">
										        <span aria-hidden="true">&laquo;</span>
										      </a>
										    </li>
										    <c:forEach var="i" begin="1" end="5">
										    	 <li><a href="#">${i }</a></li>
										    </c:forEach>
										    <li>
										      <a href="#" aria-label="Next">
										        <span aria-hidden="true">&raquo;</span>
										      </a>
										    </li>
										  </ul>	
										</span>	
										<div class="clearfix"></div>							
								 	</div>
							 	</div>          
					        </div>
					</div>
					  <!-- 出售中，结束 -->    						 	
						 <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
						 		<!-- 已出售，开始 -->
								<div class="facts">
									<div class="content_grid">
									 	<c:forEach var="so" items="${pSoldOut}" varStatus="status">
									 		<div class="col_1_of_3 span_1_of_4 simpleCart_shelfItem "> 
										  	   <a href="${pageContext.request.contextPath }/XProductInfo?proId=${so.proId}" target="_blank">								
												   <div class="inner_content clearfix">
													<div class="product_image" style="height: 180px;width: 100%;">
														<c:if test="${fn:indexOf(so.photoAddr,',')<=0 }">
															<img alt="加载失败" src="${so.photoAddr}" class="img-responsive" style="width: 100%;height: 100%;"/>
														</c:if>
														<c:if test="${fn:indexOf(so.photoAddr,',')>0 }">
															<img src="${fn:split(so.photoAddr,',')[0]}" class="img-responsive" alt="加载失败" style="width: 100%;height: 100%;"/>		
														</c:if>
													  </div>
								                    </div>
								                    <div class="pro-title">
								                    <a title="${so.title }">${fn:substring(so.title,0,11) }</a>
								                    </div>
								                 </a>
								                 <div class="product_container">														   												    
								                 <div class="div-thumbs">
													<span id="up2" class="glyphicon glyphicon-thumbs-up span-thumbs-up ups" aria-hidden="false sr-only">赞${so.pCount}</span>
													<span id="down2" class="glyphicon glyphicon-thumbs-down span-thumbs-down downs" aria-hidden="false sr-only">踩${so.nCount}</span>													
												 </div>
												 <div class="clearfix"></div>
												 <div class="div-thumbs">												
												 	<span class="span-pro-p">成交价：￥${so.buyerPrice}</span>
												 	<span class="span-pro-p">成交日：${so.cjdate}</span>
												 	<span class="span-pro-p">关注:${so.cuCount}</span>
												 </div>
												</div>	
										    </div>
										    
									 		<c:if test="${status.count%4 ==0}">
									 			<hr>
									 			<div class="clearfix"></div>
									 		</c:if>
									 	</c:forEach>
									 	</div>          
							        </div>
							        <!-- 已出售，结束 -->
							 </div>	
						 </div>
				      </div>
					 </div>	
					<!-- 标签页结束 -->
			  </div>
			</div>
		 </div>
		</div>

	  </div>
    <!-- start footer -->
     	<%@include file="footer.jsp" %>
     <!-- end footer -->
     <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
</body>
</html>
