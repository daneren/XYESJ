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
 <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<link href="../css/style.css" rel='stylesheet' type='text/css' />
<script src="../js/jquery.easydropdown.js"></script>
<script src="../js/jquery.magnific-popup.js" type="text/javascript"></script>
<link href="../css/magnific-popup.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="../js/simpleCart.min.js"> </script>
<script src="../js/jquery.magnific-popup.js" type="text/javascript"></script>
<script src="../js/easyResponsiveTabs.js" type="text/javascript"></script>

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
      perPage:   4,
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
		  		 <h1>买家中心-我买到的</h1>
				<hr class="mhr">
				<!--标签页开始 -->
				<div class="sap_tabs">	
			      <div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
			      	<ul class="resp-tabs-list">
					  	 <li id="li1" class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>预约中${fn:length(uReserves)}</span></li>
					  	 <li id="li2" class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>我买到的${fn:length(uBuy)}</span></li>
					  	  
						  <div class="clear"></div>
					 </ul>	
					 <div class="resp-tabs-container">
					 	<!-- 预约中，开始 --> 
						 <div class="tab-1 resp-tab-content" id="content2" aria-labelledby="tab_item-0">
							<div class="facts">
								<div id="content" class="defaults">
								  <ul id="itemContainer">
								 	<c:forEach var="ur" items="${uReserves}" varStatus="status">
								 		<div class="col_1_of_3 span_1_of_4 simpleCart_shelfItem "> 
									  	   <a href="${pageContext.request.contextPath }/XProductInfo?proId=${ur.proId }" target="_blank">
											   <div class="inner_content clearfix">
													<div class="product_image" style="height: 180px;width: 100%;">
														<c:if test="${fn:indexOf(ur.photoAddr,',')<=0 }">
															<img alt="加载失败" src="${ur.photoAddr}" class="img-responsive" style="width: 100%;height: 100%;"/>
														</c:if>
														<c:if test="${fn:indexOf(ur.photoAddr,',')>0 }">
															<img src="${fn:split(ur.photoAddr,',')[0]}" class="img-responsive" alt="加载失败" style="width: 100%;height: 100%;"/>		
														</c:if>														    	
													</div>
							                    </div>
							                    <div class="pro-title">
							                    	${fn:substring(ur.title,0,12) }
							                    </div>
												<div class="clearfix"></div>
							                    <div class="div-thumbs">												
											 		<span class="span-pro-p ">售价：￥${ur.dprice }</span><br>
											 		<span class="span-pro-p ">我出价：￥${ur.buyerPrice }</span>
												 </div>
							               </a>
							               <div class="product_container">														   												    			    
											  <div class="clearfix"></div>
											  
											 <div class="div-thumbs">												
											 	<span class="span-pro-p span-heart-empty"><a href="#" class="cancel" id="${ur.reservId }">取消预约</a></span>
											 	<span class="span-pro-p span-heart"><a href="#" class="alertslle" id= "${ur.reservId}">提醒卖家</a></span>
											 </div>
										 </div>	
									    </div>
								 	</c:forEach>
								 	<div class="clearfix"></div>
								 	</ul>
								 	<div class="holder"></div>
								 	</div>
						        </div>
							</div>
						   <!-- 预约中，结束 -->     
						   <div class="tab-1 resp-tab-content" id="content1"  aria-labelledby="tab_item-1">
					 		<!-- 买过的，开始 -->
							<div class="facts">
								<div class="content_grid">
								 	<c:forEach var="ub" items="${uBuy}" varStatus="status">
								 		<div class="col_1_of_3 span_1_of_4 simpleCart_shelfItem "> 
									  	   <a href="${pageContext.request.contextPath}/XProductInfo?proId=${ub.proId}" target="_blank">
											   <div class="inner_content clearfix">
												<div class="product_image" style="height: 180px;width: 100%;">
												<c:if test="${fn:indexOf(ub.photoAddr,',')<=0 }">
													<img alt="加载失败" src="${ub.photoAddr}" class="img-responsive" style="width: 100%;height: 100%;"/>
												</c:if>
												<c:if test="${fn:indexOf(ub.photoAddr,',')>0 }">
													<img src="${fn:split(ub.photoAddr,',')[0]}" class="img-responsive" alt="加载失败" style="width: 100%;height: 100%;"/>		
												</c:if>															    	
												  </div>
												</div>
							                    <div class="pro-title">
							                    	${fn:substring(ub.title,0,12) }
							                    </div><br>
							                 </a>
							                 <div class="product_container">														   												    
											 	 <div class="clearfix"></div>
												 <div class="div-thumbs">												
												 	<span class="span-pro-p">成交价：￥${ub.buyerPrice}</span>
												 	<span class="span-pro-p">成交日：${ub.cjdate}</span>
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
						  <!-- 买过的，结束 -->   
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
<script type="text/javascript">
function createAJAX(){
    var request;
    try{
        //如果IE5=IE12的话
        request = new ActiveXObject("microsoft.xmlhttp");
    }catch(e1){
        try{
            //如果是非IE的话
            request = new XMLHttpRequest();
        }catch(e2){
            alert("你的浏览器中不支持异步对象，请换浏览器");
        }
    }
    
    return request;       	        	
}
var request ="";
var url = "";
var content ="";
$(".cancel").click(function(){

url = "${pageContext.request.contextPath}/person_center/ReservServlet?op=3&time="+new Date().getTime();
content = "&id="+this.id;
 request = createAJAX();
   var method = "Post";   
   request.open(method,url);
   	//设置AJAX请求头为POST，他会将请求体中的汉字自动进行UTF-8的编码
    request.setRequestHeader("content-type","application/x-www-form-urlencoded");
    //NO3)
   	request.onreadystatechange = toReadychange1;
    request.send(content);

});
$(".alertslle").click(function(){
 
var url = "${pageContext.request.contextPath}/person_center/ReservServlet?op=4&time="+new Date().getTime();
content = "&id="+this.id;
 request = createAJAX();
   var method = "Post";   
   request.open(method,url);
   	//设置AJAX请求头为POST，他会将请求体中的汉字自动进行UTF-8的编码
    request.setRequestHeader("content-type","application/x-www-form-urlencoded");
    //NO3)
   	request.onreadystatechange = toReadychange2;
    
    request.send(content);
});

function toReadychange1(){
 	if(request.readyState == 4 && request.status == 200){
      	  var nowStr = request.responseText;    
      	  alert(nowStr);
      	  window.location.href='${pageContext.request.contextPath }/person_center/ReservServlet?op=1';
    }
}
function toReadychange2(){
 	if(request.readyState == 4 && request.status == 200){
      	  var nowStr = request.responseText;    
      	  alert(nowStr)
    }
}
</script>
<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
</body>
</html>
