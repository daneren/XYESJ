<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
    <title>个人中心</title> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content=" " />
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
<script src="js/Chart.js"></script>
<script>

		var lineChartData = {
			labels : ["January","February","March","April","May","June","July"],
			datasets : [
				{
					fillColor : "rgba(220,220,220,0.5)",
					strokeColor : "rgba(220,220,220,1)",
					pointColor : "rgba(220,220,220,1)",
					pointStrokeColor : "#fff",
					data : [65,59,90,81,56,55,40]
				},
				{
					fillColor : "rgba(151,187,205,0.5)",
					strokeColor : "rgba(151,187,205,1)",
					pointColor : "rgba(151,187,205,1)",
					pointStrokeColor : "#fff",
					data : [28,48,40,19,96,27,100]
				}
			]
			
		}

	var myLine = new Chart(document.getElementById("canvas").getContext("2d")).Line(lineChartData);
	
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
					<h1>我的成长历程</h1>
					<hr class="mhr">					
					<div class="row">
						<!-- 中间 -->
						<div class="col-md-4 div-person-emp">
							 <div class="col-sm-12">
							 	<div class="row">
							 		<div class="col-xs-6 col-md-3">
										<img src="${pageContext.request.contextPath }/person_center/imgs/${user.iconAddr }" class="img-thumbnail div-icon" >
									</div>
									<div class="col-xs-8 col-md-9 ">
										<div class="row span-icon-head">										
											<span >hi ${user.userName },</span>
											<span class="span-icon-body">我的信誉：${user.creditPoints }分   信誉一般</span>
										</div>
										<div class="row span-icon-head" >
											<span >当前经验：${user.empirical }点  </span>
										</div>
										<div class="row span-icon-head" >
											<div class="col-xs-3 col-md-2">
												<span class="icon icon-orange" >V1</span>
												<span class="progress progress-bar mprogress-bar">
												  <span class="progress-bar progress-bar-danger " role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">											    
												  </span>
												</span>
											</div>
											<div class="col-xs-3 col-md-2" >
												<span class="icon icon-orange" style="font-size: 30px;margin-top: -0.5em;">V2</span>
												<span class="progress progress-bar mprogress-bar">
												  <span class="progress-bar progress-bar-danger " role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">											    
												  </span>
												</span>
											</div>
											<div class="col-xs-3 col-md-2">
												<span class="icon icon-orange">V3</span>
												<span class="progress progress-bar  mprogress-bar">
												  <span class="progress-bar progress-bar-danger " role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%">											    
												  </span>
												</span>
											</div>
											<div class="col-xs-3 col-md-2">
												<span class="icon icon-orange">V4</span>
												<span class="progress progress-bar mprogress-bar">
												  <span class="progress-bar progress-bar-danger " role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%">											    
												  </span>
												</span>
											</div>
											<div class="col-xs-3 col-md-2">
												<span class="icon icon-orange">V5</span>
												<span class="progress progress-bar  mprogress-bar">
												  <span class="progress-bar progress-bar-danger " role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%">											    
												  </span>
												</span>
											</div>
											<div class="col-xs-3 col-md-2">
												<span class="icon icon-orange">V6</span>	
											</div>										
										</div>
									</div>
									
								</div>
							</div>
							
						</div>

						<!-- 折线图开始 -->
						<div class="col-md-8 div-emp-chart">
							<img width="100%"  src="${pageContext.request.contextPath }/person_center/imgs/jingyan.png">
						</div>
						<!-- 折线图 结束-->
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
 <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</body>
</html>
