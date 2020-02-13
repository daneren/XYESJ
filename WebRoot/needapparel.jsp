<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
<title>	${searchvalue }-二手街求购搜索</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content=" " />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/simpleCart.min.js"> </script>
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/component.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--webfont-->
<script src="js/jquery.easydropdown.js"></script>
<!-- Add fancyBox main JS and CSS files -->
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>


<!-- start fanye -->
<script type="text/javascript" src="js/highlight.pack.js"></script>
  <script type="text/javascript" src="js/tabifier.js"></script>
  <script src="js/js.js"></script>
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
      perPage:16,
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

<link href="css/magnific-popup.css" rel="stylesheet" type="text/css">
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


<style type="text/css">
.cbp-vm-view-grid ul li {
background:#fff;
    width: 23.89999%;
    text-align: center;
    margin: 20px 0 0;
    display: inline-block;
    min-height: 200px;
    vertical-align: top;
    padding: 5px;
}
.cbp-vm-switcher ul li {
background:#fff;
}
.cbp-vm-view-list li {
    padding: 0 0 0 0;
    margin-bottom:20px;
    white-space: nowrap;
}
.cbp-vm-add {
    color: #fff;
    background: #7901FB;
    padding: 8px 10px;
    border-radius: 2px;
    margin: 0 0 0 0;
    display: inline-block;
    transition: background 0.2s;
    font-size: 0.8125em;
    font-family: 'Raleway', sans-serif;
}
.cbp-vm-view-list .cbp-vm-image {
    width: 20%;
}
.cbp-vm-view-grid .cbp-vm-details {
    max-width: 300px;
    min-height: 40px;
    margin: 0 auto;
    color: #555;
    font-size: 0.8125em;
    margin-top: 0;
    font-family: 'Raleway', sans-serif;
    line-height: 1.8em;
}

ul.women_pagenation.dc_paginationA.dc_paginationA06 {
	float:none;
	padding:0;
	list-style:none;
}
.cart-left{
overflow:hidden;
text-overflow:ellipsis;
-o-text-overflow:ellipsis;
white-space:nowrap;
width:100%;
}
.pages {
    float: right;
    width: 100%;
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
			  <div class="col-md-9">
			    <div class="dreamcrub">
			   	 <ul class="breadcrumbs">
                    <li class="home">
                       <a href="index.jsp" title="返回首页">首页</a>&nbsp;
                       <span>&gt;</span>
                    </li>
                    <li class="home">&nbsp;
                       	${searchvalue }&nbsp;
                    </li> 
                </ul>
                <div class="clearfix"></div>
			   </div><!--end dreamcrub -->
			   <!--start 条件搜索
			   <div class="mens-toolbar" style="background-color: #fff;border-width: 1px;border-bottom-style: groove;border-top-style: ridge;font-size: 0.8em;">
			   	<div style="border-bottom-width: 1px;border-bottom-style:dotted;padding-bottom: 5px;padding-top: 5px;">
               	   <span>热点需求：</span>
               	</div>
               	<div style="border-bottom-width: 1px;border-bottom-style:dotted;padding-bottom: 5px;padding-top: 5px;">
               	   <span>发布时间：</span>
               	   <span><a href="">今天</a></span>
               	   <span><a href="">本周</a></span>
               	   <span><a href="">本月</a></span>
               	</div>
               	<div class="clearfix"></div>
			   </div> -->
			   <!--end 条件搜索 -->
			   <div class="mens-toolbar"><!-- 
                 <div class="sort">
               	   <div class="sort-by">
		            <label>按</label>
		            <select>
		              <option value="">Position </option>
		              <option value="">Name</option>
		              <option value="">Price</option>
		            </select>
		            <label>排序</label>
		            <a href=""><img src="images/arrow2.gif" alt="" class="v-middle"></a>
                   </div>
    		     </div>	end mens-toolbar -->	
		        </div>	<!-- end mens-toolbar -->
		         <script type="text/javascript">
		        
		        function displayshow(){
		        	$(".showinfodiv").each(function(){
		        		$(this).hide();
		        	});
		        	
		        }
 				function showinfo(){
 					$(".showinfodiv").each(function(){
		        		$(this).show();
		        	});
		        }
		        </script>
				<div id="cbp-vm" class="cbp-vm-switcher cbp-vm-view-grid">
					<div class="cbp-vm-options">
						<a href="javascript:displayshow();" onclick="displayshow()" class="cbp-vm-icon cbp-vm-grid cbp-vm-selected" data-view="cbp-vm-view-grid" title="grid">Grid View</a>
						<a href="javascript:show();" onclick="showinfo()" class="cbp-vm-icon cbp-vm-list" data-view="cbp-vm-view-list" title="list">List View</a>
					</div>
					
			<div class="pages"> 
			<div class="clearfix"></div>  
        	 <div class="limiter visible-desktop"> 
        	  <div id="content" class="defaults">
        	 <div class="holder"></div>
					<ul id="itemContainer">
					<c:forEach items="${demands }" var="demand" >
					  <li class="simpleCart_shelfItem">
							<a class="cbp-vm-image" href="XDemandsInfo?demandsId=${demand.demandId }" target="_blank">
							<div class="inner_content clearfix">
								<div class="product_image" style="height: 180px;">
									<c:if test="${empty demand.photoAddr }">
									 <img src="images/none_img.png" class="img-responsive" title="${demand.title }" style="height: 100%;width: 100%"/>
									 </c:if>
									 <c:if test="${!empty demand.photoAddr }">
									 <c:if test="${fn:length(fn:split(demand.photoAddr,',') )>1 }">
									 <img src="${fn:substringBefore(demand.photoAddr,',')}" class="img-responsive" title="${demand.title }" style="height: 100%;width: 100%"/>
									 </c:if>
									 <c:if test="${!fn:contains(demand.photoAddr, ',') }">
									<img src="${demand.photoAddr }" class="img-responsive" title="${demand.title }" style="height: 100%;width: 100%"/>	
									</c:if>
									</c:if>
								  </div>
			                </div>
		                    </a>
							<div class="cbp-vm-details"  style="width: 100%;font-size: 1em;">
							<div class="cart-left">
							<a href="XDemandsInfo?demandsId=${demand.demandId }" target="_blank">
							<span class="title">${demand.title }</span></a>
							</div>
							<br>
							<a href="#"><span class="title">发布人： ${demand.userId }</span></a><br>
							<div id="showinfodiv" class="showinfodiv" name="showinfodiv" style="display:none;width: 80%;">
							<span class="title">发布时间：${demand.bdate }</span><br>
						    <span class="title">求购描述：${demand.details }</span><br>
						    <span class="title">标签:
						    <c:forTokens items="${demand.tagName }" var="obj" delims=",">
						    <a href="${pageContext.request.contextPath }/XTagsSearch?tagname=${obj}" target="_blank">${obj }</a>
						    </c:forTokens></span>
						    </div>
							</div>
							
						</li>
						</c:forEach>
					</ul><div class="holder"></div>
				</div></div></div><div class="clearfix"></div>
			</div>
			
		 
		 </div>
		</div>
		<!-- start分页 --><!--
			<div style="margin-top: 20px;" class="col-md-9">
				<ul class="women_pagenation dc_paginationA dc_paginationA06">
					<li><a href="#">上一页</a></li>
			       <li class="active"><a href="#">1</a></li>
			       <li><a href="#">2</a></li>
			       <li><a href="#">3</a></li>
			       <li><a href="#">4</a></li>
			       <li><a href="#">5</a></li>
			       <li><a href="#">6</a></li>
			       <li><a href="#">下一页</a></li>
			       <li><a>共6页</a></li>
		  	     </ul>
		  	     </div><div class="clearfix"></div>
			</div>
				 end分页 -->
	   </div>
	  </div>
	  </div>

    <!-- start footer -->
	<%@include file="footer.jsp"%>
	<!-- end footer -->
<script src="js/cbpViewModeSwitch.js" type="text/javascript"></script>
 <script src="js/classie.js" type="text/javascript"></script>
</body>
</html>		