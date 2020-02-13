<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>个人中心</title>
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
			  <div class="col-md-9"><br>
			  	 <div class="container-fluid"> 			  	 	
					<h1>个人基础信息</h1>
					<hr class="mhr">
					<label class="label-hint">亲爱的${user.userName },完善个人信息能够更好的体验系统功能哟</label><br><br>
					<form class="form-horizontal" id="form1" action="${pageContext.request.contextPath }/person_center/UserMsgServlet" method="post" enctype="multipart/form-data">						
							<div class="row">							
							 <div class="col-sm-12">
							 	<div class="row" id="photo">
									<div class="col-xs-4 col-md-2">
										<label class="label-icon">头像</label>
									</div>
									<div id="divimg" class="col-xs-8 col-md-10">
										<c:if test="${user.iconAddr !='' &&  user.iconAddr != null}">
											<img name="img1" id="img1" src="${pageContext.request.contextPath }/person_center/imgs/${user.iconAddr}"  class="img-thumbnail img-icon imgs" title="点击添加图片" alt="点击添加图片" />
											<input name="iconAddr" type="hidden" value="${user.iconAddr}">
										</c:if>
										<c:if test="${user.iconAddr =='' ||  user.iconAddr == null}">
											<img name="img1" id="img1" src="${pageContext.request.contextPath }/person_center/imgs/none_img.png"  class="img-thumbnail img-icon imgs" title="点击添加图片" alt="点击添加图片" />
										</c:if>
									</div>
									
									<input name="inputfile" type="file" id="inputfile" style="height:0;width:0;z-index: -1;" />
								</div> 
							 </div>
							</div>
							<hr>
							<div class="row">
								  <div class="col-xs-12 col-md-2">
									  <label class="label-form">真实姓名</label>	
								  </div>
								  <div class="col-xs-6 col-md-10">
								    <c:if test="${user.userName !='' && user.userName !=null}">
								      <input type="text" value="${user.userName}" readonly="readonly" name="userName" id="userName" class="form-control input-form" placeholder="真实姓名"/>
								    </c:if>
								    <c:if test="${user.userName =='' || user.userName == null }">
								  		<input type="text" name="userName" id="userName" class="form-control input-form" placeholder="真实姓名"/>
								  	</c:if>
								  </div>
							</div>
							<span id="ruserName" class="span-remind-show"></span>
							<hr>
							<div class="row">
								  <div class="col-xs-12 col-md-2">
									  <label class="label-form">性别</label>	
								  </div>
								  <div class="col-xs-6 col-md-10">
								  	<label class="label-radio radio-inline " style="margin-top: 7px;">
								  		<input type="radio" name="sex" id="sex" value="男"
								  		<c:if test="${user.sex =='男' ||  user.sex =='' || user.sex ==null }"> checked="checked"</c:if>>男
									</label>
									<label class="label-radio radio-inline " style="margin-top: 7px;">
									  <input type="radio" name="sex" id="sex" value="女" 
									  <c:if test="${user.sex =='女'}"> checked="checked"</c:if>>女
									</label>
								  </div>
							</div>
							<hr>
							<div class="row">
								<div class="col-xs-12 col-md-2">
									<label class="label-form">生日</label>	
								</div>
								<div class="col-xs-12 col-md-10">
									<div class="container-fluid">
										<div class="row">									
										    <div class="col-xs-12 col-md-1">
											  <label class="label-date">年</label>	
										    </div>
									  		<div class="col-xs-12 col-md-3">
											  <select id="eDatey" name="eDatey" class="form-control select-form"
											  <c:if test="${user.birthDay !='' && user.birthDay !=null}">
											  	disabled="disabled"
											  >
											  </c:if>
												  <option>请选择</option>
												  <c:forEach var="i" begin="1990" end="2016">
													  <option id="y${i}"
													  	<c:if test="${fn:split(user.birthDay,'-')[0] == i}">
													  		 selected="selected" 
													    </c:if>>${i }</option>
												  </c:forEach>
											  </select>
										  	</div>
										  	<div class="col-xs-12 col-md-1 " style="margin-left:-3.6em;">
													<label class="label-date">月</label>
												</div>
												<div class="col-xs-12 col-md-3">
													<select id="eDatem" name="eDatem" class="form-control select-form"
													<c:if test="${user.birthDay !='' && user.birthDay !=null}">
													  	disabled="disabled"
													  ></c:if>
														<c:forEach var="i" begin="1" end="12">
															<option id="m${i}"
															<c:if test="${fn:split(user.birthDay,'-')[1] == i}">
													  		 selected="selected"
													        </c:if>>${i }</option>
														</c:forEach>
													</select>
												</div>
												
												<div class="col-xs-12 col-md-1" style="margin-left:-3.6em;">
													<label class="label-date">日</label>
												</div>
												<div class="col-xs-12 col-md-3">
													<select id="eDated" name="eDated" class="form-control select-form"
													<c:if test="${user.birthDay !='' && user.birthDay !=null}">
													  	disabled="disabled"
													  ></c:if>
														
														<c:forEach var="i" begin="1" end="31">
															<option id="d${i}"
															<c:if test="${fn:split(user.birthDay,'-')[2] == i}">
													  			 selected='selected'
													        </c:if>>${i }</option>
														</c:forEach>
													</select>
												</div>
									  	</div>									  	
								  	</div>
								</div>								
							</div>
							<span id="rdate" class="span-remind-show"></span>
							<hr>					
							<div class="row">
								  <div class="col-xs-12 col-md-2">
									  <label class="label-form">*学校</label>	
								  </div>
								  <div class="col-xs-6 col-md-10">
								  	<select id="school" name="school" class="form-control input-form">
								  		<option>湖南科技大学</option>
									</select>
								  </div>
							</div>
							<hr>
							<div class="row">
								  <div class="col-xs-12 col-md-2">
									  <label class="label-form">学院</label>	
								  </div>
								  <div class="col-xs-6 col-md-10">
								  	
								  	<c:if test="${ user.department !='' && user.department !=null}">
								  <input id="depart" name="depart" value = "${ user.department}" readonly="readonly"  class="form-control input-form"/>
								  	</c:if>
								  	<c:if test="${ user.department =='' || user.department ==null}">
								  <input id="depart" name="depart"	type="text" class="form-control input-form" placeholder="保存后不可修改，请认真填写"/>
								  </c:if>
								  </div>
							</div>
							<span id="rdepart" class="span-remind-show"></span>
							<hr>
							<div class="row">
								  <div class="col-xs-12 col-md-2">
									  <label class="label-form">专业</label>	
								  </div>
								  <div class="col-xs-6 col-md-10">
								  	<input id="major" name="major" 
								  	<c:if test="${ user.major !=''&& user.major !=null}">
								  		value = "${ user.major}" readonly="readonly"
								  	</c:if>
								  	type="text" class="form-control input-form" placeholder="保存后不可修改，请认真填写"/>
								  </div>
							</div>
							<span id="rmajor" class="span-remind-show"></span>
							<hr>
							<div class="row">
								<div class="col-xs-12 col-md-2">
									<label class="label-form">入学年份</label>	
								</div>
								<div class="col-xs-12 col-md-10">
									<div class="container-fluid">
										<div class="row">									
										    <div class="col-xs-12 col-md-1">
											  <label class="label-date">年</label>	
										    </div>
									  		<div class="col-xs-12 col-md-3">
											  <select id="endy" name="endy" class="form-control select-form">
												 <option >请选择</option>
												  <c:forEach var="i" begin="2010" end="2017">
												    <option id="eny${i }"
												    <c:if test="${fn:split(user.entranceDay,'-')[0] == i}">
													  		 selected="selected"
													</c:if> >${i }</option>
												  </c:forEach>
											  </select>
										  	</div>
										  	
										  	<div class="col-xs-12 col-md-1 " style="margin-left:-3.6em;">
											  <label class="label-date">月</label>	
										    </div>
									  		<div class="col-xs-12 col-md-3">
											  <select id="endm" name="endm"  class="form-control select-form">
												  <c:forEach var="i" begin="1" end="12">
												    <option id="enm${i }"
												    <c:if test="${fn:split(user.entranceDay,'-')[1] == i}">
													  		 selected="selected"
													</c:if> >${i }</option>
												  </c:forEach>
											  </select>
										  	</div>		  	
										  	<div class="col-xs-12 col-md-1" style="margin-left:-3.6em;">
											  <label class="label-date">日</label>	
										    </div>
									  		<div class="col-xs-12 col-md-3">
											  <select id="endd" name="endd" class="form-control select-form">
												  <c:forEach var="i" begin="1" end="31">
												    <option id="end${i }"
												    <c:if test="${fn:split(user.entranceDay,'-')[2] == i}">
													  		 selected="selected"
													</c:if> >${i }</option>
												  </c:forEach>
											  </select>
										  	</div>
									  	</div>
								  	</div>
								</div>
							</div>
							<span id="rendy" class="span-remind-show"></span>
							<hr>
							<div class="row register-but">
								<input id="save" type="button" style="margin-left: 35%;" value="保存"/>
							</div>
					</form>
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
var error2 = 1;
var error3 = 1;
var error4 = 1;
var error8 = 1;

/**入学年份*/
$("#endy").change(function(){
	var y = $("#endy").val();
	
	if(y=="请选择"){
		$("#rendy").html("请选择入学日期");
		$("#rendy").show();
		error4 = 1;
	}else{
		error4 = 0;
		$("#endm").change();
		$("#rendy").hide();
	}
});
/**生成日期*/
$("#endm").change(function(){
	var m = $("#endm").val();
	var y = $("#endd").val();
	$("#endd option").remove();
	for(var i=1; i<=31;i++){
		$("#endd").append("<option>"+i+"</option>");
		if(m == 2 && i==29 && y%4==0){
			break;
		}
		if(m == 2 && i==28 && y%4 != 0){
			break;
		}
		if((m == 2||m==4||m==6||m==9||m==11)&& i==30 ){
			break;
		}
	
	}
});

/**真实姓名*/
$("#userName").blur(function(){
	var userName = $("#userName").val();//获得文本框中的值
	if($.trim(userName)){
		if(userName.length<10){
			$("#ruserName").hide();
			error1 = 0;
		}else{
			$("#ruserName").html("最多输入12个字哟");				
			$("#ruserName").show();
			error1 = 1;
		}
	}else{
		$("#ruserName").html("请输入真实姓名");
		$("#ruserName").show();
		error1 = 1;
	}
});
$("#depart").blur(function(){
	var depart = $("#depart").val();//获得文本框中的值
	if($.trim(depart)){
		if(depart.length<25){
			$("#rdepart").hide();
			error2 = 0;
		}else{
			$("#rdepart").html("最多输入25个字哟");				
			$("#rdepart").show();
			error2 = 1;
		}
	}else{
		$("#rdepart").html("请输入学院");
		$("#rdepart").show();
		error2= 1;
	}

});
$("#major").blur(function(){
	var major = $("#major").val();//获得文本框中的值
	if($.trim(major)){
		if(major.length<25){
			$("#rmajor").hide();
			error3 = 0;
		}else{
			$("#rmajor").html("最多输入25个字哟");				
			$("#rmajor").show();
			error3 = 1;
		}
	}else{
		$("#rmajor").html("请输入专业");
		$("#rmajor").show();
		error3= 1;
	}
});
/**生日*/
$("#eDatey").change(function(){
	var y = $("#eDatey").val();
	
	if(y=="请选择"){
		$("#rdate").html("请选择出生日期");
		$("#rdate").show();
		error8 = 1;
	}else{
		error8 = 0;
		$("#eDatem").change();
		$("#rdate").hide();
	}
});
/**生日*/
$("#eDatem").change(function(){
	var m = $("#eDatem").val();
	var y = $("#eDatey").val();
	$("#eDated option").remove();
	for(var i=1; i<=31;i++){
		$("#eDated").append("<option>"+i+"</option>");

		if(m == 2 && i==28 && y%4==0){
			break;
		}
		if(m == 2 && i==29 && y%4 != 0){
			break;
		}
		if((m==4||m==6||m==9||m==11)&& i==30 ){
			break;
		}
	
	}
});


/**提交表单*/
$("#save").click(function(){	
		
	if(error1 ==1||error2 ==1 ||error3 ==1||error4 ==1||error8 ==1){
		alert(error1+","+error2+","+error3+","+error4+","+error8);
		if(!$.trim($("#userName").val())){
			$("#ruserName").html("姓名不能为空哦");	
			$("#ruserName").show();
			alert("name");
		}
		if(!$.trim($("#depart").val())){
			$("#rdepart").html("学院不能为空哦");	
			$("#rdepart").show();
		}
		if(!$.trim($("#major").val())){
			$("#rmajor").html("专业不能为空哦");	
			$("#rmajor").show();
		}
		if($("#eDatey").val() == "请选择"){
			$("#eDatey").html("请选择出生日期");	
			$("#eDatey").show();
		}
		if($("#endy").val()=="请选择"){
			$("#rendy").html("请选择入学年份");	
			$("#rendy").show();		
		}		
		$("#rsave").html("页面中还有错误，修正后再保存吧");
		$("#rsave").show();	
		return;	
	}else{
		//提交alert("baocun");
		
    	$("#form1").submit();	
	}

});
/**头像*/
$("#img1").live("click",function(){
	$("#inputfile").click();
});
$("#inputfile").live("change",function() {
    PreviewImage(this);
});

/**预览图片*/
function PreviewImage(imgFile) {
	var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;
	if (!pattern.test(imgFile.value)) {
		alert("系统仅支持jpg/jpeg/png/gif/bmp格式的照片！");
		imgFile.focus();
	} else {
		var path;
		if (document.all)//IE
		{
			imgFile.select();
			path = document.selection.createRange().text;
			document.getElementById("img1").style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src=\""
					+ path + "\")";//使用滤镜效果
		} else//FF
		{
			path = URL.createObjectURL(imgFile.files[0]);
			document.getElementById("img1").src = path;
		}
	}
}


</script>

</body>
</html>
