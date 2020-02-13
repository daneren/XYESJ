<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>忘记密码</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content=" " />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
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
<style type="text/css">
.login-right input[type="password"] {
    border: 1px solid #EEE;
    outline-color: #fb4d01;
    width: 96%;
    font-size: 0.8125em;
    padding: 0.5em;
}		
		
</style>
<!----details-product-slider--->
</head>
<body>
<%@include file="header.jsp" %>
   <div class="main">
	  <div class="content_box">
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
			  <div class="col-md-9">
			    <div class="dreamcrub">
                <ul class="previous">
                	<li><a href="index.jsp">回到主页</a></li>
                </ul>
                <div class="clearfix"></div>
			   </div>
			   <div class="account_grid">
			   <div class="col-md-6 login-left">
			  	 <h3>找回密码说明</h3>
				 <p>输入您注册的邮箱，我们会重置您的密码然后发一封邮件告诉您新的密码，请您登陆修改您的密码。</p>
				 
			   </div>
			   <div class="col-md-6 login-right" style="background-color: #fff;">
			  	<h3>找回密码</h3>
				<p>请输入您的邮箱，我们会重置您的密码。</p>
				<script type="text/javascript">
				//拿到浏览器的 Ajax 异步对象
				//创建AJAX异步对象
				function createAJAX(){
				        var ajax = null;
				        try{
				            //如果IE5=IE12的话
				            ajax = new ActiveXObject("microsoft.xmlhttp");
				        }catch(e1){
				            try{
				                //如果是非IE的话
				                ajax = new XMLHttpRequest();
				            }catch(e2){
				                alert("你的浏览器中不支持异步对象，请换浏览器");
				            }
				        }
				        return ajax;
				    }
								
				function findpwd(){
					var email = document.getElementById("email");
					var yzm = document.getElementById("yzm");
					if(email.value == ''){
						email.focus();
						document.getElementById("emailerror").innerHTML = '*请填写您的邮箱';
					}else if(yzm.value == ''){
						yzm.focus();
						document.getElementById("yzmerror").innerHTML = '*请填写验证码';
					}else{
						//NO1)创建AJAX异步对象
					    var ajax = createAJAX();
					    //NO2)准备发送请求
					    var method = "GET";
					    var url = "${pageContext.request.contextPath}/XFindPwdServlet?yzm="+yzm.value+"&email="+email.value+"&time="+new Date().getTime();
					    ajax.open(method,url);
					    //NO3)真正发送请求体的数据到服务器，如果请求体中无数据的话，就用null表示
					    ajax.send(null);
					        //NO4)AJAX异步对象不断监听服务器响应的状态0-1-2-3-【4】
					        //一定要状态变化后，才可触发function(){}函数
					        //如果状态永远是4-4-4-4-4，是不会触发function(){}函数的
					    ajax.onreadystatechange = function(){
					    	//如果状态码为4的话       浏览器响应完毕
					        if(ajax.readyState == 4){
					        		if(ajax.status==200){ //响应码
					        			//NO5)从AJAX异步对象中获取服务器响应的HTML数据
					                    var nowStr = ajax.responseText;
					        			if(nowStr == "ok"){
					        				//把时间显示在span的标签体内
						                    document.getElementById("msg").innerHTML = '我们已将重置后的密码发到您的邮箱，<a href="login.jsp">请登录</a>';
					        				}else if(nowStr == "yzmerror"){
					        				document.getElementById("yzmerror").innerHTML = '*验证码错误';
					        				}
					                    }
					        }
					    }
					}
				}
				
				</script>
				
				  <div>
					<span>邮箱：<label id="emailerror" style="color: red;">*</label></span>
					<input type="text" id = "email" name="email"> 
				  </div>
				  <div>
					<span>验证码：<label id="yzmerror" style="color: red;">*</label></span>
					<input type="text" id="yzm" name="yzm" style="width: 70%">
					<a href="javascript:reloadVerifyCode();"><img  id="safecode"  src="Captcha" style="width: 25%"/> </a>
					<hr>
				  </div>
				  <input type="submit" onclick="javascript:findpwd();" value="确认">
			    <label class="forgot" id="msg" style="color: red;"></label>
			   </div>	
			   <div class="clearfix"> </div>
			 </div>
		   </div>
		  </div>
	     </div>
	    </div>
	    </div>
		
        <%@include file="footer.jsp" %>
</body>
</html>		
<script type="text/javascript">
function reloadVerifyCode(){  
	var timenow = new Date().getTime();
	document.getElementById("safecode").src="${pageContext.request.contextPath }/Captcha?d="+timenow;
}
</script>
