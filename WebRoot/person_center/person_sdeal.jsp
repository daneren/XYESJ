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
<!-- Custom Theme files -->
 <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!--webfont-->
<script src="${pageContext.request.contextPath }/js/jquery.easydropdown.js"></script>
<!-- Add fancyBox main JS and CSS files -->
<script src="${pageContext.request.contextPath }/js/jquery.magnific-popup.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/css/magnific-popup.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/person_center/css/style.css" rel='stylesheet' type='text/css' />
<script src="../js/jquery-1.7.2.min.js"></script>

<!-- start fenye -->
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
  $(function(){
    $("div.holder").jPages({
      containerID : "movies",
      previous : "上一页",
      next : "下一页",
      perPage : 8,
      delay : 20
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
<!-- end fenye -->

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
		  		<h1>卖家中心-交易中的商品</h1>			  		
				<hr class="mhr">
				<div id="divTable">
				<div class="panel panel-default pn-reserv">
					<div id="content" class="defaults">
				  <div class="panel-body">
				    <p>待处理的交易信息</p>
				  </div>
				
				  <!-- Table -->
				  <table id="taball" class="table tb-reserv" >
				  
				  <thead>
				   <tr>
				   	<th>编号</th>
				   	<th>商品标题</th>
				   	<th>售价</th>
				   	<th>买家出价</th>
				   	<th>买家联系方式</th>
				   	<th>预约日期</th>
				   	<th>操作</th>
				   </tr></thead>
				   <tbody id="movies">
				   <c:forEach var="ars" items="${uDeal}" varStatus="status">
					   <tr>
					   	   <td>${status.index}</td>
						   <td><a href="${pageContext.request.contextPath }/XProductInfo?proId=${ars.proId }">${ars.title }</a></td>
						   <td>${ars.dprice }</td>
						   <td>${ars.buyerPrice }</td>
						   <c:if test="${!empty ars.pstate }">
						   		<td>${ars.pstate }</td>
						   </c:if>
						   <c:if test="${empty ars.pstate }">
						   		<td>${ars.ruCount}</td>
						   </c:if>
						   <td>${ars.bdate}</td>
						   <td id="td${ars.reservId}"><a href="javascript:if(confirm('您点击了交易成功，确定保存该信息吗?'))location='${pageContext.request.contextPath }/person_center/SellerDealing?op=2&id=${ars.reservId},${ars.proId}'" class="cuss">交易成功</a>|<a href="javascript:if(confirm('您点击了交易失败，确定保存该信息吗?'))location='${pageContext.request.contextPath }/person_center/SellerDealing?op=3&id=${ars.reservId},${ars.proId}'" class="fail">交易失败</a></td>
					   </tr>
				   </c:forEach>
				   </tbody>
				  </table>
				  <div class="holder"></div>
				  </div>
				</div>
				 <div>
				
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
