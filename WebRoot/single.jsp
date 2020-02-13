<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>${product.title }-商品详情</title>
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
<script type="text/javascript">
function createAJAX(){
    var ajax = null;
    try{
        ajax = new ActiveXObject("microsoft.xmlhttp");
    }catch(e1){
        try{
            ajax = new XMLHttpRequest();
        }catch(e2){
            alert("你的浏览器中不支持异步对象，请换浏览器");
        }
    }
    return ajax;
}

function shownum(type){
var cai = document.getElementById("cai");
var zan = document.getElementById("zan");
if(type=='zan'){
	var ajax = createAJAX();
	var method = "GET";
	var url = "${pageContext.request.contextPath}/XPraiseTreadServlet?type=zan&proId=${product.proId }&time="+new Date().getTime();
	ajax.open(method,url);
	ajax.send(null);
	ajax.onreadystatechange = function(){
	    if(ajax.readyState == 4){
	    		if(ajax.status==200){ //响应码
	                var str = ajax.responseText;
	    		if(str == 'yi'){
	    			alert('您已经点赞或者踩了该商品,请勿重复操作！');
	    		}else if(str == 'zanok'){
	    			zan.innerHTML="${pcount+1 }";
	    		}
	    	}
	    }
	}
}else if(type=='cai'){
	var ajax = createAJAX();
	var method = "GET";
	var url = "${pageContext.request.contextPath}/XPraiseTreadServlet?type=cai&proId=${product.proId }&time="+new Date().getTime();
	ajax.open(method,url);
	ajax.send(null);
	ajax.onreadystatechange = function(){
	    if(ajax.readyState == 4){
	    		if(ajax.status==200){ //响应码
	                var str = ajax.responseText;
	    		if(str == 'yi'){
	    			alert('您已经点赞或者踩了该商品,请勿重复操作！');
	    		}else if(str == 'caiok'){
	    			cai.innerHTML="${tcount+1 }";
	    		}
	    	}
	    }
	}
}
}
function collectpro(){
	var ajax = createAJAX();
	var method = "GET";
	var url = "${pageContext.request.contextPath}/XCollectProductServlet?proId=${product.proId }&time="+new Date().getTime();
	ajax.open(method,url);
	ajax.send(null);
	ajax.onreadystatechange = function(){
	    if(ajax.readyState == 4){
	    		if(ajax.status==200){ //响应码
	                var str = ajax.responseText;
	    		if(str == 'yi'){
	    			alert('您已经收藏了该商品,请勿重复操作');
	    		}else if(str == 'ok'){
	    			document.getElementById("shoucang").innerHTML="${collectcount+1 }";
	    		}
	    	}
	    }
	}
}
</script>
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
			    <div class="dreamcrub">
			   	 <ul class="breadcrumbs">
                    <li class="home">
                       <a href="index.jsp" title="Go to Home Page">首页</a>&nbsp;
                       <span>&gt;</span>
                    </li>
                    <li class="home">&nbsp;
                        ${product.title }&nbsp;
                        <span>&gt;</span>&nbsp;
                    </li>
                    <li class="home">
        			               商品详情
                    </li>
                </ul>
                <div class="clearfix"></div><hr>
			   </div>
			   <div class="singel_right">
			     <div class="labout span_1_of_a1">
				   <div class="flexslider">
					 <ul class="slides">
					 <c:if test="${fn:length(fn:split(product.photoAddr,',') )>1 }">
					 <c:forEach items="${ fn:split(product.photoAddr,',')}" var="addr">
						<li data-thumb="${addr }"><img src="${addr }" /></li>
					</c:forEach>	
					</c:if>	
					<c:if test="${!fn:contains(product.photoAddr, ',') }">
						<li data-thumb="${product.photoAddr }"><img src="${product.photoAddr }" /></li>
					</c:if>			
					 </ul>
				  </div>
			  </div>
			  <div class="cont1 span_2_of_a1 simpleCart_shelfItem">
				<h1>${product.title }</h1>
				<ul class="rating">
					<li><a class="product-rate">
					  	<c:forEach begin="1" end="${fn:split(product.startc,',')[0]}" varStatus="status">
					  		<label class="label1"></label>
					  		<c:set var="startsc" value="${status.count}"></c:set>
					  	</c:forEach>	
					  	<c:if test="${fn:split(product.startc,',')[1] >0 }">
					  		<label class="label3"></label>
						<label  class="label4" ></label>
						<c:set var="startsc" value="${startsc+1}"></c:set>
					  	</c:if>	
					  	<c:if test="${(5-startsc)>0}">
					  		<c:forEach begin="1" end="${5-startsc}">
					  			<label class="label2"></label>
					  		</c:forEach>   		
					</c:if>
					</a></li>
				   <li><a href="#lnotes1" id="anotes">&nbsp;${product.scores}分&nbsp;留言（${fn:length(lnotes) }条） 添加留言</a></li>
				   <div class="clearfix"></div>
			    </ul>
			    <hr>
			    <script type="text/javascript">
			    	$("#anotes").click(function(){
			    		$("#lnotes").click();
			    	});
			    </script>
			    <div class="price_single">
			           买进价格：<span class="reducedfrom">￥${product.oprice }</span>
				  售价：<span class="reducedfrom">￥${product.cprice }</span><br>
				  折扣价：<span class="amount item_price actual" style="float: none;">￥${product.dprice }</span><hr>
				</div>
				<h2 class="quick">发布人：${prouser.userName }</h2>
				<h2 class="quick">发布时间：${product.bdate }</h2>
				<h2 class="quick">结束时间：${product.edate }</h2>
				<h2 class="quick">商品标签：${product.tagName }</h2>
				<p class="quick_desc">描述：${product.details }</p><hr>
				<c:if test="${!empty user }">
				<a href="javascript:shownum('zan');" class="button cpns" >赞<span id="zan" >${pcount }</span></a>
				<a href="javascript:shownum('cai');" class="button cpns" >踩<span id="cai" >${tcount }</span></a>
				<a href="javascript:collectpro();" class="button cpns" >收藏<span id="shoucang">${collectcount }</span></a><br>
				</c:if>
				<c:if test="${empty user }">
				<a class="button cpns" >赞<span id="cai" >${pcount }</span></a>
				<a class="button cpns" >踩<span id="zan" >${tcount }</span></a>
				<a class="button cpns" >收藏<span>${collectcount }</span></a><font size="2px">&nbsp;&nbsp;请<a href="login.jsp" target="_blank">登录</a>后操作</font><br>
				</c:if>
				<c:if test="${!empty user }">
				<c:if test="${product.state =='出售中' }">
					<a  data-toggle="modal" data-target="#myModal" id="respro" class="button item_add cbp-vm-icon cbp-vm-add btn-lg">预约该宝贝</a><br><br>
				</c:if>
				<c:if test="${product.state =='交易中' }">
				<a  class="button item_add cbp-vm-icon cbp-vm-add">该宝贝正在交易中</a><br><br>
				</c:if>
				</c:if>
				<c:if test="${empty user }">
				<c:if test="${product.state =='交易中' }">
				<a class="button item_add cbp-vm-icon cbp-vm-add ">该宝贝正在交易中</a><br><br>
				</c:if>
				<c:if test="${product.state =='出售中' }">
				<a  id="respro1" class="button item_add cbp-vm-icon cbp-vm-add">预约该宝贝</a><br><br>
				</c:if>
				</c:if>
				<script type="text/javascript">
					$("#respro1").click(function(){
						var showtel = document.getElementById("showtel");
						showtel.style.display = 'block';
					});
				</script>
				<c:if test="${!empty user }">
					<p class="quick_desc" style="display: none;" id="showtel">预约成功，系统已通知卖家，正在等待卖家处理 <br>卖家邮箱：${prouser.email }<br>您也可以直接联系卖家，然后线下交易</p>
				</c:if>
				<c:if test="${empty user }">
					<p class="quick_desc" style="display: none;" id="showtel">您还未登录，<a href="login.jsp" target="_blank">登录</a>才能预约哦</p>
				</c:if>
			</div>
			<div class="clearfix"></div>
		   </div><hr>
		   <div class="sap_tabs">	
				     <div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
						  <ul class="resp-tabs-list">
						  	  <li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>商品详情</span></li>
							  <li id="lnotes" class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>留言板</span></li>
							  <div class="clear"></div>
						  </ul>				  	 
							<div class="resp-tabs-container">
							    <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
									<div class="facts"><br><br>
									${product.details }<hr>
									     <c:if test="${fn:length(fn:split(product.photoAddr,',') )>1 }">
										 <c:forEach items="${ fn:split(product.photoAddr,',')}" var="addr">
											<img src="${addr }" width="80%"/><br>
										</c:forEach>	
										</c:if>	
										<c:if test="${!fn:contains(product.photoAddr, ',') }">
											<img src="${product.photoAddr }" width="80%" /><br>
										</c:if>			       
							        </div>
							     </div>	
							      <div id="lnotes1" class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
									<div class="facts">
									  <ul class="tab_list">
									  <c:if test="${empty lnotes }">还没有用户留言哦，快来抢沙发吧！</c:if>
									  <c:if test="${!empty lnotes }">
									  <c:forEach items="${lnotes }" var="lnote">
									    <li><span>留言人：${fn:substring(lnote.remark,0,1) }** &nbsp;&nbsp;时间：${lnote.bdate}</span></li>
									    <li><p>	${lnote.details }</p></li>
									    <li><hr></li>
									   </c:forEach> 
									   </c:if>
									  </ul> 
									      <div class="contact-form">
									  	        <form method="post" action="XProLnotes" onsubmit="return checksubmit();">
											        <p class="comment-form-author"><label for="author">留言:</label>
											    	  <textarea name="msg" id="msg" cols="50" rows="3" style="width: 95%; height: 90px;" maxlength="250" ></textarea>
											    	  <input type="hidden" name="proId" value="${product.proId }"/>
											    	  <span>最长250个字</span>&nbsp;&nbsp;&nbsp;<span id="errormsg" style="color: red;"></span>
											        </p>
											         <c:if test="${empty scores}">
										        <ul id="ulstarts" class="rating" style="margin-top: 5px;">
										        	<li>评分：</li>
													<li>
													<a class="product-rate"><label id="ls1" class="label2" ></label></a>
													<a class="product-rate"><label id="ls2" class="label2"></label></a>
													<a class="product-rate"><label id="ls3" class="label2"></label></a>
													<a class="product-rate"><label id="ls4" class="label2"></label></a>
													<a class="product-rate"><label id="ls5" class="label2"></label></a>
													</a></li>
													<li id="lss">支持评分哦</li>
												   <div class="clearfix"></div>
											      </ul>
										      </c:if>
										     <c:if test="${!empty user }">
										     <input type="hidden" name="hid" id="hid"/>
									        <input name="submit" type="submit" id="submit" value="确认留言"/>
									         <script type="text/javascript">
									         	
									         	/**评分*/
										      	var cds = $("#ulstarts label");
										      	$("#ulstarts label").click(function(){
										      		var id = this.id;
										      		var i =0;
										      		for(i=0;i<cds.length;i++){
										      			if(cds[i].id == id){      				
										      				break;
										      			}
										      			$("#"+cds[i].id).attr("class","label1");
										      		}
										      		$("#"+id).attr("class","label1");
										      		i=i+1;
										      		var re = new Array( ${product.remark});
										      		
										      		$("#hid").val((i*2.0)+","+re);
										      		$("#lss").html("&nbsp;"+(i*2.0)+".0分");
										      		for(i;i<cds.length;i++){
										      			$("#"+cds[i].id).attr("class","label2");
										      		}
										      		
										      	});
										      </script>
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
					 <h3 class="like">你可能喜欢</h3>        			
				     <ul id="flexiselDemo3" style="height: 50%;">
				     <c:forEach items="${leisipros }" var="leisipro" begin="0" end="11">
				    <c:if test="${fn:length(fn:split(leisipro.photoAddr,',') )>1 }">	
					<li>
					<a href="XProductInfo?proId=${leisipro.proId }" target="_blank">
					<img src="${fn:substringBefore(leisipro.photoAddr,',')}" class="img-responsive" style="width: 100%;height: 80%"/></a>
					<hr><div class="protitle">
					<c:if test="${fn:length(leisipro.title)<16 }">${leisipro.title }</c:if>
					<c:if test="${fn:length(leisipro.title)>16 }">${fn:substring(leisipro.title,0,16) }</c:if>
					</div><div class="grid-flex"><p>￥${leisipro.dprice }</p>
					</div></li>
					</c:if>
					<c:if test="${!fn:contains(leisipro.photoAddr, ',') }">
					<li>
					<a href="XProductInfo?proId=${leisipro.proId }" target="_blank">
					<img src="${leisipro.photoAddr }" class="img-responsive" style="width: 100%;height: 80%"/></a>
					<hr><div><c:if test="${fn:length(leisipro.title)<16 }">${leisipro.title }</c:if> 
					<c:if test="${fn:length(leisipro.title)>16 }">${fn:substring(leisipro.title,0,16) }</c:if>
					</div><div class="grid-flex"><p>￥${leisipro.dprice }</p>
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

<%@include file="modal.jsp" %>
  <script src="js/bootstrap.js"></script>
</body>
</html>