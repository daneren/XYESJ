<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
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
 <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--webfont-->
<script src="${pageContext.request.contextPath }/js/jquery.easydropdown.js"></script>
<!-- Add fancyBox main JS and CSS files -->
<script src="${pageContext.request.contextPath }/js/jquery.magnific-popup.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/css/magnific-popup.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/person_center/css/style.css" rel='stylesheet' type='text/css' />


<!-- start fanye -->
<script type="text/javascript" src="js/highlight.pack.js"></script>
  <script type="text/javascript" src="js/tabifier.js"></script>
  <script src="js/jPages.js"></script>
  <script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-28718218-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

  </script>

  <script>
  /* when document is ready */
  $(function() {

    /* initiate plugin assigning the desired button labels  */
    $("div.holder").jPages({
      containerID : "itemContainer",
      perPage:4,
      first       : "第一页",
      previous    : "上一页",
      next        : "下一页",
      last        : "最后一页"
    });

  });
  </script>

  <style type="text/css">
  .holder {
    margin: 15px 0;
  }

  .holder a {
    font-size: 12px;
    cursor: pointer;
    margin: 0 5px;
    color: #333;
  }

  .holder a:hover {
    background-color: #222;
    color: #fff;
  }

  .holder a.jp-previous { margin-right: 15px; }
  .holder a.jp-next { margin-left: 15px; }

  .holder a.jp-current, a.jp-current:hover {
    color: #FF4242;
    font-weight: bold;
  }

  .holder a.jp-disabled, a.jp-disabled:hover {
    color: #bbb;
  }

  .holder a.jp-current, a.jp-current:hover,
  .holder a.jp-disabled, a.jp-disabled:hover {
    cursor: default;
    background: none;
  }

  .holder span { margin: 0 5px; }
  </style>

<!-- end fanye -->


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
			  		<h1>买家中心-我收藏的</h1>			  		
					<hr class="mhr">
					<div class="limiter visible-desktop"> 
					<div id="content" class="defaults">
					  <ul id="itemContainer">
						<c:forEach var="cp" items="${uCollects}" varStatus="status">
						<li class="simpleCart_shelfItem">
						 <div class="cart-header${status.count}">
							 <a class="btn btn-trash" href="CollectsServlet?op=2&id=${cp.collectId }">
							 	<span class="glyphicon glyphicon-trash span-trash" aria-hidden="ture">取消收藏 </span>
							 </a>
							 	<c:if test="${cp.pstate == '已售出' }">
									<font style="font-size: 25;color: red;float: right;margin-right: 3em;">已售出</font>	
								</c:if>
							 <div class="cart-sec simpleCart_shelfItem">
									<div class="cart-item cyc">
										 <img src="${cp.photoAddr}" class="img-responsive" alt="">
									</div>
								   <div class="cart-item-info">
									<h3><br>
									  <a target="_blank" href="${pageContext.request.contextPath}/XProductInfo?proId=${cp.proId}">${cp.title}</a>						   
									       <span>${cp.details}</span>
									 </h3>
									 
									<ul class="qty">
										<li><p>有  <c:if test="${empty cp.cuCount}">0</c:if> <c:if test="${!empty cp.cuCount}">${cp.cuCount}</c:if> 人收藏了此商品</p></li>
										<li><p>有   <c:if test="${empty cp.ruCount}">0</c:if> <c:if test="${!empty cp.ruCount}">${cp.ruCount}</c:if> 人预约了此商品</p></li>
									</ul>
									<div class="delivery">
										 <p>原价 : ￥${cp.oprice}           现价 : ￥${cp.dprice}</p>
										 <span>添加收藏的日期：   ${cp.bdate}</span>
							        </div>
							        </div>
							  </div>
						 </div><div class="clearfix"></div>
						 </li>
			 </c:forEach>
			 
			 </ul>
			 <div class="holder"></div>
			 </div>
			 </div>
			 
			 <!-- 分页开始
			 <div class="clearfix"></div>
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
		 	</div> -->
		 	<!-- 分页结束 -->
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
