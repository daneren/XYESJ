<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title> ${demand.title }-求购详情</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content=" " />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<script src="js/simpleCart.min.js"> </script>
<script src="js/jquery.min.js"></script>
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script src="js/jquery.easydropdown.js"></script>
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
<link href="css/component.css" rel='stylesheet' type='text/css' />
<link href="css/magnific-popup.css" rel="stylesheet" type="text/css">
<script src="/js/jquery-1.7.2.min.js"></script>
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
<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
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
  <%@include file="needheader.jsp"%>
	
	<div class="main">
	  <div class="content_box">
		<div class="container">
			<div class="row">
			<!-- start side -->
					<%@include file="side.jsp"%>
					<!-- end side -->
			  
			  <div class="col-md-9">
			    <div class="dreamcrub">
			   	 <ul class="breadcrumbs">
                    <li class="home">
                       <a href="lookforneed.jsp" title="Go to Home Page">首页</a>&nbsp;
                       <span>&gt;</span>
                    </li>
                    <li class="home">&nbsp;
                        ${demand.title }&nbsp;
                        <span>&gt;</span>&nbsp;
                    </li>
                    <li class="home">
        			               求购详情
                    </li>
                </ul>
                <ul class="previous">
                </ul>
                <div class="clearfix"></div><hr>
			   </div>
			   <div class="singel_right">
			     <div class="labout span_1_of_a1">
				   <div class="flexslider">
					 <ul class="slides">
					 <c:if test="${empty  demand.photoAddr }">
					 <li data-thumb="images/none_img.png"><img src="images/none_img.png" /></li>
					</c:if>
					<c:if test="${!empty  demand.photoAddr }">
						<c:if test="${fn:length(fn:split(demand.photoAddr,',') )>1 }">
						 <c:forEach items="${ fn:split(demand.photoAddr,',')}" var="addr">
							<li data-thumb="${addr }"><img src="${addr }" /></li>
						</c:forEach>	
						</c:if>	
						<c:if test="${!fn:contains(demand.photoAddr, ',') }">
						
							<li data-thumb="${demand.photoAddr }"><img src="${demand.photoAddr }" /></li>
						
						</c:if>		
					</c:if>			
					 </ul>
				  </div>
			  </div>
			  <div class="cont1 span_2_of_a1 simpleCart_shelfItem">
				<h1> ${demand.title }</h1>
				<ul class="rating">
				   <li><a href="#lnotes1" id="anotes">留言（${fn:length(lnotes) }条） 添加留言</a></li>
				   <div class="clearfix"></div><hr>
				   <script type="text/javascript">
			    	$("#anotes").click(function(){
			    		$("#lnotes").click();
			    	});
			    </script>
			    </ul>
				<h2 class="quick">发布时间：${demand.bdate }</h2>
				<h2 class="quick">结束时间：${demand.edate }</h2>
				<h2 class="quick">发布人: ${demanduser.userName }</h2>
				<h2 class="quick">求购标签: ${demand.tagName }</h2>
				<p class="quick_desc">求购描述：${demand.details }</p><hr>
				<a href="javascript:showtelnum();" class="button item_add cbp-vm-icon cbp-vm-add" >联系发布人</a><br><br>
				<c:if test="${!empty user }">
				<p class="quick_desc" style="display: none;" id="showtel">发布人电话：${demanduser.userPhone } <br>发布人邮箱:${demanduser.email }<br>您可以联系发布人，或者给发布人留言，然后线下交易</p>
			
				</c:if>
				<c:if test="${empty user }">
				<p class="quick_desc" style="display: none;" id="showtel">您还未登录，<a href="login.jsp" target="_blank">登录</a>后您可以联系发布人</p>
				</c:if>
			</div>
			<div class="clearfix"></div>
		   </div><hr>
		   <div class="sap_tabs">	
				     <div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
						  <ul class="resp-tabs-list">
						  	  <li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>求购详情</span></li>
							  <li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>留言板</span></li>
							  <div class="clear"></div>
						  </ul>				  	 
							<div class="resp-tabs-container">
							    <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
									<div class="facts"><br><br>
									${demand.details }<hr>
									<c:if test="${!empty demand.photoAddr }">
									     <c:if test="${fn:length(fn:split(demand.photoAddr,',') )>1 }">
										 <c:forEach items="${ fn:split(demand.photoAddr,',')}" var="addr">
											<img src="${addr }" width="80%"/><br>
										</c:forEach>	
										</c:if>	
										<c:if test="${!fn:contains(demand.photoAddr, ',') }">
											<img src="${demand.photoAddr }" width="80%" /><br>
										</c:if>	
										</c:if>		       
							        </div>
							     </div>	
							      <div id="lnotes1"  class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
									<div class="facts">
									  <ul class="tab_list">
									  <c:if test="${empty lnotes }">还没有用户留言哦，快来抢沙发吧！</c:if>
									  <c:if test="${!empty lnotes }">
									  <c:forEach items="${lnotes }" var="lnote">
									    <li><span>留言人：${lnote.remark }   时间：${lnote.bdate}</span></li>
									    <li><p>	${lnote.details }</p></li>
									    <li><hr></li>
									   </c:forEach> 
									   </c:if>
									  </ul> 
									      <div class="contact-form">
									  	        <form method="post" action="XDemandLnotesServlet" onsubmit="return checksubmit();">
											        <p class="comment-form-author"><label for="author">留言:</label>
											    	  <textarea name="msg" id="msg" cols="50" rows="3" style="width: 95%; height: 90px;" maxlength="250" ></textarea>
											    	  <span>最长250个字</span>&nbsp;&nbsp;&nbsp;<span id="errormsg" style="color: red;"></span>
											    	  <input type="hidden" name="demandId" value="${demand.demandId }"/>
											        </p>
											        <c:if test="${!empty user }">
											        <input name="submit" type="submit" id="submit" value="确认留言">
											        </c:if>
											        <c:if test="${empty user }">
											        		请您<a href="login.jsp" target="_blank">登录</a>后留言
											        </c:if>
										        </form>
									       </div>
								     </div>  
							     </div>	
							 </div>
					      </div>
					 </div>	
					 <h3 class="like">类似求购</h3>        			
				      <ul id="flexiselDemo3" style="height: 50%">
				     <c:forEach items="${demandlist }" var="leisidemand" begin="0" end="11">
				    <c:if test="${fn:length(fn:split(leisidemand.photoAddr,',') )>1 }">	
					<li>
					<a href="XDemandsInfo?demandsId=${leisidemand.demandId }" target="_blank">
					<img src="${fn:substringBefore(leisidemand.photoAddr,',')}" class="img-responsive" style="width: 100%;height: 80%"/></a>
					<hr><div class="protitle">
					<c:if test="${fn:length(leisidemand.title)<16 }">${leisidemand.title }</c:if>
					<c:if test="${fn:length(leisidemand.title)>16 }">${fn:substring(leisidemand.title,0,16) }</c:if>
					</div></li>
					</c:if>
					<c:if test="${!fn:contains(leisidemand.photoAddr, ',') }">
					<li>
					<a href="XDemandsInfo?demandsId=${leisidemand.demandId }" target="_blank">
					<img src="${leisidemand.photoAddr }" class="img-responsive" style="width: 100%;height: 80%"/></a>
					<hr><div><c:if test="${fn:length(leisidemand.title)<16 }">${leisidemand.title }</c:if> 
					<c:if test="${fn:length(leisidemand.title)>16 }">${fn:substring(leisidemand.title,0,16) }</c:if>
					</div></li>
					</c:if>
						
						 </c:forEach>
				     </ul>
				    <script type="text/javascript">
				    function trim(s){//去掉前后空格
	   					 return s.replace(/(^\s*)|(\s*$)/g, "");
						}
				    function checksubmit(){//检验留言
				    	var msg = document.getElementById("msg");
				    	var errormsg = document.getElementById("errormsg");
				    	if(trim(msg.value) == ''){
				    		errormsg.innerHTML = '请填写留言';
				    		msg.focus();
				    		return false;
				    	}else{
				    		return true;
				    	}
				    	
				    }
				    function showtelnum(){//显示卖家电话号码
				    	var showtel = document.getElementById("showtel");
				    	showtel.style.display = 'block';
				    
				    }
					 $(window).load(function() {
						$("#flexiselDemo3").flexisel({
							visibleItems: 3,
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
				   
			</div>
		 </div>
		</div>
	    </div>

	</div>
	<!-- start footer -->
	<%@include file="footer.jsp"%>
	<!-- end footer -->
<script defer src="js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
	<script>
// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    controlNav: "thumbnails"
  });
});
</script>
</body>
</html>