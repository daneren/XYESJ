<%@page import="esj.publicdoc.bean.ProtypesBean"%>
<%@page import="esj.publicdoc.service.impl.ProtypesBeanServiceimpl"%>
<%@page import="esj.publicdoc.service.ProtypesBeanService"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	ProtypesBeanService pbService = new ProtypesBeanServiceimpl();
	List<ProtypesBean> listpt =  pbService.findAllProtypes();
	//System.out.println(listpt);
	request.setAttribute("listpt", listpt);
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>个人中心-发布商品</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shape Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/js/simpleCart.min.js"> </script>
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--webfont-->
<script src="${pageContext.request.contextPath}/js/jquery.easydropdown.js"></script>
<!-- Add fancyBox main JS and CSS files -->
<script src="${pageContext.request.contextPath}/js/jquery.magnific-popup.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/magnific-popup.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/person_center/css/style.css" rel='stylesheet' type='text/css' />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/verify.js"></script>
<script src="${pageContext.request.contextPath}/person_center/js/jquery-1.7.2.min.js"></script>
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
textarea {
	padding: 10px;
	display: block;
	background: #fff;
	border: 1px solid #eee;
	outline: none;
	color: #9198A3;
	font-size: 0.8125em;
	-webkit-appearance: none;
	resize: none;
}
</style>
</head>

<body>
	<!-- start head -->
	<div class="header">
		<%@ include file="person_head.jsp"%>
	</div>
	<!-- end head -->
	<div class="main">
		<div class="content_box">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<!-- side begin -->
						<%@ include file="person_side.jsp"%>
						<!-- side end -->
					</div>
					<div class="col-md-9">
						<br>
						<form name="form1" id="form1" action="${pageContext.request.contextPath }/person_center/FubuProServlet" method="post" enctype="multipart/form-data">
					
					  	<div class="container-fluid">
					  	
							<h1>卖家中心-发布商品</h1>
							<hr class="mhr">
							<label class="label-hint">请填写你要发布的商品信息</label><br>
							<br>
							
							 <%@include file="uploadimg.jsp" %>
								<hr>
								
								<div class="row">
									<div class="col-xs-12 col-md-2">
										<label class="label-form">商品名称</label>
									</div>
									<div class="col-xs-6 col-md-10">
										<input type="text" class="form-control input-form" id="protitle" name="protitle" placeholder="必填项，不超过30字符" />
										
									</div>
								</div>
								<span class="span-remind-show" id="rpt"></span>
								<hr>
								<%--商品类别和标签  开始--%>
								<%@include file="typetag.jsp" %>
								
								<%--商品类别和标签  结束--%>
								
								<hr>
								<div class="row">
									<div class="col-xs-12 col-md-2">
										<label class="label-form">商品详情</label>
									</div>
									<div class="col-xs-6 col-md-10">
										<textarea id="details" name="details" onkeydown="countChar('details', 'counter');" onkeyup="countChar('details', 'counter');"  rows="4" cols="50" maxlength="250" style="width: 70%;margin-left: 15px;" placeholder="必填项，长度在30~250个字之间" ></textarea>										
										<span class="span-remind-show2" id="counter">0/250</span>
									</div>
									
								</div>
								
								<span class="span-remind-show" id="rdetails"></span>
								<hr>
								<div class="row">
									<div class="col-xs-12 col-md-2">
										<label class="label-form">购进价格</label>
									</div>
									<div class="col-xs-6 col-md-10">
										<input type="text" class="form-control input-form" id="oprice" name="oprice"
											style="width: 30%;" placeholder="必填项，只能是数字" />
									</div>
								</div>
								<span class="span-remind-show" id="roprice"></span>
								
								<hr>
								<div class="row">
									<div class="col-xs-12 col-md-2">
										<label class="label-form">售价</label>
									</div>
									<div class="col-xs-6 col-md-10">
										<input type="text" class="form-control input-form" id="cprice" name="cprice"
											style="width: 30%;" placeholder="必填项，只能是数字" />
									</div>
								</div>
								<span class="span-remind-show" id="rcprice"></span>
								<hr>
								<div class="row">
									<div class="col-xs-12 col-md-2">
										<label class="label-form">折后价</label>
									</div>
									<div class="col-xs-6 col-md-10">
										<input type="text" class="form-control input-form" id="dprice" name="dprice"
											style="width: 30%;" placeholder="选填项，默认与售价相同" />
									</div>
								</div>
								<span class="span-remind-show" id="rdprice"></span>
								<hr>
									<%--结束日期  开始--%>
									<%@include file="enddate.jsp" %>
									<%--结束日期  结束--%>
								<hr>
								<span class="span-remind-show" id="rsave"></span>
								<div class="row register-but">
								
									<input id="save" type="button" style="margin-left: 35%;"
										value="保存" />
								</div>
								<input type="hidden" name="typetag" id="typetag"/>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- start footer -->
	<%@include file="footer.jsp"%>
	<!-- end footer -->

	<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
	<script type="text/javascript">
	var error1 = 1;//标题
	var error2 = 1;//类别
	var error3 = 0;//标签
	var error4 = 1;//描述
	var error5 = 1;//原价
	var error6 = 1;//现价
	var error7 = 1;//折扣价
	var error8 = 1;//照片
	var error9 = 1;//暂无
	$("#proType2").hide();	
	$("#proType3").hide();	
	
	/**商品名称*/
	$("#protitle").blur(function(){
		var title = $("#protitle").val();//获得文本框中的值
		if($.trim(title)){
			if(title.length<=30){
				$("#rpt").hide();
				error1 = 0;
			}else{
				$("#rpt").html("最多输入30个字哟");				
				$("#rpt").show();
				error1 = 1;
			}
		}else{
			$("#rpt").html("商品名称不能为空哦，赶紧输入吧");
			$("#rpt").show();
			error1 = 1;
		}
	});
	

	/**商品描述*/
	$("#details").blur(function(){
		var details = $("#details").val();//获得文本框中的值
		if($.trim(details)){
			if(details.length<=250){
				if(details.length<30){
					$("#rdetails").html("最少要输入30个字哟");
					$("#rdetails").show();
					error4 = 1;
				}else{
					$("#rdetails").hide();
					error4 = 0;
				}
				
			}else{
				$("#rdetails").html("最多输入250个字哟");
				$("#rdetails").show();
				error4 = 1;
			}
		}else{
			$("#rdetails").html("商品名称不能为空哦，赶紧输入吧");
			$("#rdetails").show();
			error4 = 1;
		}
	});
	
	/**商品原价*/
	$("#oprice").blur(function(){
		var oprice1 =$("#oprice").val();//获得文本框中的值
		if($.trim(oprice1)){
		    var oprice = $.trim(oprice1);
			if($.isNumeric(oprice)){
				if(oprice>0){
					$("#roprice").hide();
					error5 = 0;
				}else{
					$("#roprice").html("请输入大于0的数字哦");
					$("#roprice").show();
					error5 = 1;
				}
			}else{
				$("#roprice").html("您输入的内容不是数字，请检查后重新输入一次吧");
				$("#roprice").show();
				error5 = 1;
		    }
		}else{
			$("#roprice").html("请输入商品买入时的价格");
			$("#roprice").show();
			error5 = 1;
		}
		
	});
	/**商品售价*/
	$("#cprice").blur(function(){
		var cprice1 =$("#cprice").val();//获得文本框中的值
		if($.trim(cprice1)){
		    var cprice = $.trim(cprice1);
			if($.isNumeric(cprice)){
				if(cprice>0){
					$("#rcprice").hide();
					error6 = 0;
				}else{
					$("#rcprice").html("请输入大于0的数字哦");
					$("#rcprice").show();
					error6 = 1;
				}
			}else{
				$("#rcprice").html("您输入的内容不是数字，请检查后重新输入一次吧");
				$("#rcprice").show();
				error6 = 1;
		    }
		}else{
			$("#rcprice").html("请输入商品要出售的价格");
			$("#rcprice").show();
			error6 = 1;
		}		
	});
	/**商品折扣价*/
	$("#dprice").blur(function(){
		var dprice1 =$("#dprice").val();//获得文本框中的值
		if($.trim(dprice1)){
		    var dprice = $.trim(dprice1);
			if($.isNumeric(dprice)){
				if(dprice>0){
					$("#rdprice").hide();
					error7 = 0;
				}else{
					$("#rdprice").html("请输入大于0的数字哦");
					$("#rdprice").show();
					error7 = 1;
				}
			}else{
				$("#rdprice").html("您输入的内容不是数字，请检查后重新输入一次吧");
				$("#rdprice").show();
				error7 = 1;
		    }
		}else{		
			$("#rdprice").hide();
			error7 = 0;
		}		
	});

	/**提交表单*/
	$("#save").click(function(){
		if(imgcount <=1){
			$("#rimg").html("只少要上传一张照片哦");
			$("#rimg").show();
			error8 = 1;
		}else if(imgcount>1){
			error8 = 0;
			$("#rimg").hide();
		}
		if(error1 == 1){
			$("#protitle").blur();
		}
		if(error2 == 1){
			$("#proType1").change();
		}
		if(error4 == 1){
			$("#details").blur();
		}
		if(error5 == 1){
			$("#oprice").blur();
		}
		if(error6 == 1){
			$("#cprice").blur();
		}
		if(error7 == 1){
			$("#dprice").blur();
		}

		if(error1 ==1||error2 ==1 ||error4 ==1||error5 ==1||error6 ==1||error7 ==1 ||error8 == 1){
			$("#rsave").html("页面中还有错误，修正后再保存吧");
			$("#rsave").show();	
			return;	
		}
		//提交
		var child = $("#ultag").children("li");
		var tags = "";
		if(child != null || child.length >0){
			tags = $.trim(child.get(0).innerText);
			for(var i=1;i<child.length;i++){
				var c= child.get(i);
				var ct = $.trim(c.innerText);
				tags += ","+ct;
			}
		}
		var types = seltype;
		$("#typetag").val(types+"/"+tags);
		if(confirm('确定保存该信息?')){
		$("#form1").submit();
		}
    	
	});

function countChar(textareaName,spanName)
{
	document.getElementById(spanName).innerHTML = document.getElementById(textareaName).value.length+"/"+250;
}
</script>
</body>
</html>
