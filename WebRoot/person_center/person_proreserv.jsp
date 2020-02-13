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
<!-- end fenye -->
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
		  		<h1>卖家中心-预约信息管理</h1>			  		
				<hr class="mhr">
				<div id="divTable">
				<%@include file="reserv_tabel.jsp" %>		
				 <div>
			  </div>			  
			</div>
		 </div>
		</div>

	  </div>
     <!-- start footer -->
     	<%@include file="footer.jsp" %>
     <!-- end footer -->

<div id="myModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal fade" style="display: none;">
    <div class="modal-dialog" role="document" style="width: 800px;">
       <div class="modal-content">
          <div class="modal-header">
             <button type="button" data-dismiss="modal" aria-hidden="true" class="close">×</button>
             <h4 id="myModalLabel" class="modal-title">预约详情</h4>
             
              &nbsp;一个商品只能卖给一个客户，选中一个客户，点击（卖给他/她），系统将会锁定交易信息，并自动退回其他客户对该商品的订单；选中对于任意一个客户订单，点击（拒绝他/她），则只会退回该客户的订单；若点击（退回全部订单）则退回对于该商品的所有订单；
            <br> &nbsp;操作后不可更改，请慎重
          </div>
          <div class="modal-body " id="rebody" style="height: 400px;overflow: scroll;"></div>
          <div class="modal-footer">
             <button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
             <button type="button" id="turnda" class="btn btn-primary" data-toggle="popover" title="确定退回全部订单？" data-content="确定退回全部订单？">退回全部订单</button> 
		 </div>
       </div>
    </div>
 </div>
 <script type="text/javascript">
 $(".turndownre").live("click",function(){
	var request = createAJAX();
 	 var method = "Post";   
   var url = "${pageContext.request.contextPath }/person_center/AllReserv?op=3&time="+new Date().getTime();
   	request.open(method,url);
   	//设置AJAX请求头为POST，他会将请求体中的汉字自动进行UTF-8的编码
    request.setRequestHeader("content-type","application/x-www-form-urlencoded");
    //NO3)
    var content = "&id="+this.id;
   	request.onreadystatechange = tocallBack;
    request.send(content);
    $("#myModal").modal('hide');
});

$(".acceptre").live("click",function(){
	var request = createAJAX();
 	 var method = "Post";   
   var url = "${pageContext.request.contextPath }/person_center/AllReserv?op=4&time="+new Date().getTime();
   	request.open(method,url);
   	//设置AJAX请求头为POST，他会将请求体中的汉字自动进行UTF-8的编码
    request.setRequestHeader("content-type","application/x-www-form-urlencoded");
    //NO3)
    var content = "&id="+this.id;
   	request.onreadystatechange = tocallBack;
    request.send(content);
    $("#myModal").modal('hide');
});

$("#turnda").click(function(){
	var request = createAJAX();
 	var method = "Post";   
    var url = "${pageContext.request.contextPath }/person_center/AllReserv?op=5&time="+new Date().getTime();
   	request.open(method,url);
   	//设置AJAX请求头为POST，他会将请求体中的汉字自动进行UTF-8的编码
    request.setRequestHeader("content-type","application/x-www-form-urlencoded");
    //NO3)
    var content = "&id="+"${proId}";
   	request.onreadystatechange = tocallBack;
    request.send(content);
    $("#myModal").modal('hide');
});

function tocallBack(){
	if(request.readyState == 4 && request.status == 200){
	      	  var nowStr = request.responseText;
	      	  document.getElementById("divTable").innerHTML = nowStr;
	}
}
</script> 
      
   <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</body>
</html>
