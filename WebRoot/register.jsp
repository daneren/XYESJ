<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>湖科二手街用户注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shape Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/component.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--webfont-->
<script src="js/jquery.easydropdown.js"></script>
<!-- Add fancyBox main JS and CSS files -->
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
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
<!----details-product-slider--->
<style type="text/css">
.login-right input[type="password"] {
    border: 1px solid #EEE;
    outline-color: #fb4d01;
    width: 96%;
    font-size: 0.8125em;
    padding: 0.5em;
}		
.login-left {
    padding: 1px;
}		
</style>
</head>
<body>
<%@include file="header.jsp" %>
    <div class="main">
	   <div class="container">
	   <div class="row">
	   	<div class="col-md-3">
			<div class="menu_box">
				 <h3 class="menu_head">你可能要做</h3>
				 <ul class="nav">
					 <li><a href="register.jsp">注册账号</a></li>
					 <li><a href="login.jsp">登录账户</a></li>
				</ul>
			</div>
		</div>
		<!-- start注册协议 -->
		<!-- end注册协议 -->
 			<div class="col-md-9">
			    <div class="dreamcrub">
                <ul class="previous">
                	<li><a href="index.jsp">回到主页</a></li>
                </ul>
                <div class="clearfix"></div>
			   </div>
			   <div class="account_grid">
			   <div class="col-md-6 login-left">
			  	 <h3>注册协议</h3>
				<p>【审慎阅读】您在申请注册流程中点击同意前，应当认真阅读以下协议。请您务必审慎阅读、充分理解协议中相关条款内容，其中包括：</p>
				<p>1、与您约定免除或限制责任的条款；</p>
				<p>2、与您约定法律适用和管辖的条款；</p>
				<p>3、其他以粗体下划线标识的重要条款。</p>
				<p>如您对协议有任何疑问，可向平台客服咨询。</p>
				<p>【特别提示】当您按照注册页面提示填写信息、阅读并同意协议且完成全部注册程序后，即表示您已充分阅读、理解并接受协议的全部内容。</p>
				<p>阅读协议的过程中，如果您不同意相关协议或其中任何条款约定，您应立即停止注册程序。</p>
<script type="text/javascript">
function tongyi(){
	var tongyi = document.getElementById("tongyi");//同意注册信息checkbox
	var zhucebtn = document.getElementById("zhucebtn");//确认注册按钮
	if(tongyi.checked){//选中
			zhucebtn.disabled=false;
			document.getElementById("email").disabled=false;
			document.getElementById("yanzhengma").disabled=false;
	}else{
			zhucebtn.disabled=true;
			document.getElementById("email").disabled=true;
			document.getElementById("yanzhengma").disabled=true;
	}
}
function register(){
	var email = document.getElementById("email");//输入手机号码
	var yanzhengma = document.getElementById("yanzhengma");//输入手机验证码
	var nicheng = document.getElementById("nicheng");//输入昵称
	var pwd = document.getElementById("pwd");//输入密码
	var repwd = document.getElementById("repwd");//输入确认密码
	var reg  = /^(?=.*[a-zA-Z]+)(?=.*[0-9]+)[a-zA-Z0-9]+$/;
	if(email.value == ''){
		document.getElementById("emailerror").innerHTML = '*邮箱输入错误';
		email.focus();
		return false;
	}else if(yanzhengma.value == ''){
		document.getElementById("yanzhengmaerror").innerHTML = '*请输入验证码';
		yanzhengma.focus();
		return false;
	}else if(nicheng.value == ''){
		document.getElementById("nichengerr").innerHTML = '*请输入昵称';
		nicheng.focus();
		return false;
	}else if(pwd.value == ''){
		document.getElementById("pwderror").innerHTML = '*请输入密码';
		pwd.focus();
		return false;
	}else if(pwd.value.length >13 && pwd.value.length < 6){
		document.getElementById("pwderror").innerHTML = '*密码长度 输入错误';
		pwd.focus();
		return false;
	}else if(!reg.test(pwd.value)){
		document.getElementById("pwderror").innerHTML = '*密码格式 输入错误';
		pwd.focus();
		return false;
	}else if(repwd.value == ''){
		document.getElementById("repwderror").innerHTML = '*请输入确认密码';
		repwd.focus();
		return false;
	}else if(pwd.value != repwd.value){
		document.getElementById("repwderror").innerHTML = '*两次密码输入不同，请重新输入';
		repwd.focus();
		return false;
	}else{
	return true;
	}
}
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

function getyzm(){
var btngetyzm = document.getElementById("btngetyzm");
var email = document.getElementById("email");//输入手机号码
var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
if(email.value == ''|| !myreg.test(email.value) ){
		document.getElementById("emailerror").innerHTML = '*邮箱输入有误';
		email.focus();
	}else{
		btngetyzm.hidden=true; 
    var ajax = createAJAX();
    var method = "GET";
    var url = "${pageContext.request.contextPath}/RegisterGetCaptcha?type=email&email="+email.value+"&time="+new Date().getTime();
    ajax.open(method,url);
    ajax.send(null);
    ajax.onreadystatechange = function(){
        if(ajax.readyState == 4){
        		if(ajax.status==200){ //响应码
                    var nowStr = ajax.responseText;
                    document.getElementById("emailerror").innerHTML = nowStr+"";
        		}
        }
    }
		
	}
}
function checkyzm(){
	var yanzhengma = document.getElementById("yanzhengma");
	
    var ajax = createAJAX();
    var method = "GET";
    var url = "${pageContext.request.contextPath}/RegisterGetCaptcha?type=captcha&captcha="+yanzhengma.value+"&time="+new Date().getTime();
    ajax.open(method,url);
    ajax.send(null);
    ajax.onreadystatechange = function(){
        if(ajax.readyState == 4){
        		if(ajax.status==200){ 
                    var nowStr = ajax.responseText;
                    document.getElementById("yanzhengmaerror").innerHTML = nowStr;
                    if(nowStr == '验证码正确'){
                    	document.getElementById("nicheng").disabled=false;
                    	document.getElementById("pwd").disabled=false;
                    	document.getElementById("repwd").disabled=false;
                    }
        		}
        }
    }

}	
function checkrepwd(){
	var pwd = document.getElementById("pwd");//输入密码
	var repwd = document.getElementById("repwd");//输入确认密码
	if(pwd.value != repwd.value){
		document.getElementById("repwderror").innerHTML = '*两次密码输入不同，请重新输入';
		repwd.focus();
	}
}
function checkpwdgeshi(){
	var pwd = document.getElementById("pwd");//输入密码
	var reg  = /^(?=.*[a-zA-Z]+)(?=.*[0-9]+)[a-zA-Z0-9]+$/; 
	if(pwd.value.length >13 || pwd.value.length < 6){
		document.getElementById("pwderror").innerHTML = '*密码长度 输入错误';
	}else if(!reg.test(pwd.value)){
		document.getElementById("pwderror").innerHTML = '*密码格式 输入错误';
	}else{
		document.getElementById("pwderror").innerHTML = '*';
	}
}
</script>
				 <a class="news-letter" href="#">
					<label class="checkbox"><input type="checkbox" name="checkbox" id="tongyi" onclick="javascript:tongyi();"><i> </i>同意协议</label>
				 </a>
			   </div>
			   <div class="col-md-6 login-right" style="background-color: #fff;">
			  	<h3>注册信息</h3>
				
				<form action="${pageContext.request.contextPath}/Register" method="post" onsubmit="return register();">
				  <div>
					<span>邮箱：<label id="emailerror" style="color: red;">*请同意左边协议之后再进行邮箱注册</label></span>
					<input type="text" id = "email" name="email" style="width: 70%" disabled="disabled"> 
					<a href="javascript:getyzm();" id="btngetyzm" >获取验证码</a>
				  </div>
				  <div>
					<span>验证码：<label id="yanzhengmaerror" style="color: red;">*</label></span>
					<input type="text" id="yanzhengma" name="yanzhengma" onblur="javascript:checkyzm();" disabled="disabled"> 
				  </div>
				  <div>
					<span>昵称：<label id="nichengerr" style="color: red;">*</label></span>
					<input type="text" id = "nicheng" name="nicheng" disabled="disabled"> 
				  </div>
				  <div>
					<span>密码：<label id="pwderror" style="color: red;">*</label></span>
					<input type="password" id = "pwd" name="pwd" onblur="javascript:checkpwdgeshi();" disabled="disabled" placeholder="只能由英文字母和数字组成，且大于6位小于13位" > 
				  </div>
				  <div>
					<span>确认密码：<label id="repwderror" style="color: red;">*</label></span>
					<input type="password" id = "repwd" name="repwd" onblur="javascript:checkrepwd();" disabled="disabled"> 
				  </div>
				  <input type="submit" value="注册" id="zhucebtn" disabled="disabled">
			    </form>
			   </div>	
			   <div class="clearfix"> </div>
			 </div>
		   </div>
		   </div>
	     </div>
	    </div>
<%@include file="footer.jsp" %>
</body>
</html>		