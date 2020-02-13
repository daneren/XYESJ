<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人中心</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
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
					<h1>修改密码</h1>
					<hr class="mhr">					
					<form class="form-horizontal div-form" id="pwdform" name="pwdform" action="${pageContext.request.contextPath}/person_center/UserPwdServlet" method="post">						
						<div class="row">
						<input id="type" name="type" type="hidden" value="changepwd"/>
							  <div class="col-xs-12 col-md-2">
								  <label class="label-form">*原始密码</label>	
							  </div>
							  <div class="col-xs-6 col-md-10">
							  	<input id="opwd" name="opwd" type="password" class="form-control input-form" id="exampleInputName2" placeholder="请输入原密码"/>
							  </div>
						</div>
						<!-- 如果默认使用  span-remind-hide 样式-->
						<span  id="ropwd" class="span-remind-show"></span>
						<hr>
						<div class="row">
							  <div class="col-xs-12 col-md-2">
								  <label class="label-form">*新密码</label>	
							  </div>
							  <div class="col-xs-6 col-md-10">
							  	<input id="npwd1" name="npwd1" type="password" class="form-control input-form" id="exampleInputName2" placeholder="只能由英文字母和数字组成，且大于6位小于13位"/>
							  </div>
						</div>
						<span id="rnpwd1" class="span-remind-show"></span>
						<br>
						<div class="row">
							  <div class="col-xs-12 col-md-2">
								  <label class="label-form">*确认密码</label>	
							  </div>
							  <div class="col-xs-6 col-md-10">
							  	<input id="npwd2" name="npwd2" type="password" class="form-control input-form" id="exampleInputName2" placeholder="请再次输入新密码"/>
							  </div>
						</div>
						<span id="rnpwd2" class="span-remind-show"></span>
						<br>
						
					</form>
					<div class="row register-but">
							<input type="button" id="tijiaobaocun" style="margin-left: 35%;" value="保存"/>
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
<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
<script type="text/javascript">
var error1 = 0;
var error2 = 0;
var error3 = 0;
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
$("#tijiaobaocun").click(function(){
	var reg = /^[a-z0-9_-]{6,18}$/;
	var opwd = $("#opwd").val();
	var repwd1 = $("#npwd1").val();
	var repwd2 = $("#npwd2").val();
	
	if(!reg.test(opwd)){
		$("#ropwd").html("您的输入包含非法字符，密码只能由字母和数字组成，大于6位小于3位哦");
		$("#ropwd").show();
	}else if(!reg.test(repwd1)){
		$("#rnpwd1").html("您的输入包含非法字符，密码只能由字母和数字组成，大于6位小于3位哦");
		$("#rnpwd1").show();
	}else if(!reg.test(repwd2)){
		$("#rnpwd2").html("您的输入包含非法字符，密码只能由字母和数字组成，大于6位小于3位哦");
		$("#rnpwd2").show();
	}else{
		//异步传输  检测原密码是否正确
		var ajax = createAJAX();
	    var method = "GET";
	    var url = "${pageContext.request.contextPath}/person_center/UserPwdServlet?type=changepwd&npwd1="+repwd1+"&time="+new Date().getTime();
	    ajax.open(method,url);
	    ajax.send(null);
	   
	    ajax.onreadystatechange = function(){
	        if(ajax.readyState == 4){
	        		if(ajax.status==200){ //响应码
	                    var nowStr = ajax.responseText;
		        		if(nowStr != "ok"){//原密码输入错误
		        			alert("修改失败，请稍候再试");
		        			$("#ropwd").show();
		        		}else{
		        			 alert("修改成功");
		        			$("#opwd").val("");
		        			$("#npwd1").val("");
		        			$("#npwd2").val("");
		        		}
	        		}
	        }
	    }
	}
	
});


$("input[type='password']").blur(function(){
var reg = /^[a-z0-9_-]{6,18}$/;
	var id = this.id;
	var val =  this.value
	if(reg.test(val)){
		if(id=="opwd"){
			error1 = 0;
			$("#ropwd").hide();
			//异步传输  检测原密码是否正确
			var ajax = createAJAX();
		    var method = "GET";
		    var url = "${pageContext.request.contextPath}/person_center/UserPwdServlet?type=checkoldpwd&oldpwd="+val+"&time="+new Date().getTime();
		    ajax.open(method,url);
		    ajax.send(null);
		    ajax.onreadystatechange = function(){
		        if(ajax.readyState == 4){
		        		if(ajax.status==200){ //响应码
		                    var nowStr = ajax.responseText;
			        		if(nowStr == "ok"){
			        			$("#ropwd").html("");
			        			$("#ropwd").show()
			        		}else{
			        			$("#ropwd").html("原密码错误");
			        			$("#ropwd").show();
			        		}
		        		}
		        }
		    }
		}else if(id == "npwd1"){
			$("#rnpwd1").hide();
			error2 = 0;
		}else if(id == "npwd2"){
			error3 = 0;
			$("#rnpwd2").hide();
		}
	}else{
		if(id=="opwd"){
			error1 = 1;
			$("#ropwd").html("您的输入包含非法字符，密码只能由字母和数字组成，大于6位小于3位哦");
			$("#ropwd").show();
		}else if(id == "npwd1"){
			error2 = 1;
			$("#rnpwd1").html("您的输入包含非法字符，密码只能由字母和数字组成，大于6位小于3位哦");
			$("#rnpwd1").show();
		}else if(id == "npwd2"){
			error3 = 1;
			$("#rnpwd2").html("您的输入包含非法字符，密码只能由字母和数字组成，大于6位小于3位哦");
			$("#rnpwd2").show();
		}	
	}
});


</script>


</body>
</html>
