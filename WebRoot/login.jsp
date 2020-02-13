<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>湖科二手街用户登录</title>
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
			  	 <h3>新用户</h3>
				 <p>如果您还没有账号，请注册一个账号，注册登录之后您就可以更好的浏览商品，评论别人的商品，给商品点赞，还可以收藏自己喜欢的商品，联系卖家现在进行交易。</p>
				 <a class="acount-btn" href="register.jsp">申请一个新账号</a>
			   </div>
			   <div class="col-md-6 login-right" style="background-color: #fff;">
			  	<h3>老用户</h3>
				<p>如果您已经有账号了，请登录。</p>
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
								
				function login(){
					var email = document.getElementById("email");
					var pwd = document.getElementById("pwd");
					var yzm = document.getElementById("yzm");
					if(email.value == ''){
						email.focus();
						document.getElementById("emailerror").innerHTML = '*请填写账号';
						return false;
					}else if(pwd.value == ''){
						pwd.focus();
						document.getElementById("pwderror").innerHTML = '*请填写密码';
						return false;
					}else if(yzm.value == ''){
						yzm.focus();
						document.getElementById("yzmerror").innerHTML = '*请填写验证码';
						return false;
					}else{
						return true;
					}
				}
				
				</script>
				<form action="${pageContext.request.contextPath}/UserLogin" method="post" onsubmit="return login();">
				  <div>
					<span>账号：<label id="emailerror" style="color: red;">*${loginerror }</label></span>
					<input type="text" id = "email" name="email" placeholder="请输入邮箱"> 
				  </div>
				  <div>
					<span>密码：<label id="pwderror" style="color: red;">*</label></span>
					<input type="password" id="pwd" name="pwd"> 
				  </div>
				  <div>
					<span>验证码：<label id="yzmerror" style="color: red;">*${loginyzmerror }</label></span>
					<input type="text" id="yzm" name="yzm" style="width: 70%">
					<a href="javascript:reloadVerifyCode();"><img  id="safecode"  src="Captcha" style="width: 25%"/> </a>
				  </div>
				  <a class="forgot" href="forgetpwd.jsp">忘记密码？</a>
				  <input type="submit" value="登录">
			    </form>
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
