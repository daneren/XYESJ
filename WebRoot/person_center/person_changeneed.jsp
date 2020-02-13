<%@page import="esj.publicdoc.service.impl.ProtypesBeanServiceimpl"%>
<%@page import="esj.publicdoc.service.ProtypesBeanService"%>
<%@page import="esj.publicdoc.bean.ProtypesBean"%>
<%@page import="esj.publicdoc.bean.UserdemandsBean"%>
<%@page import="esj.publicdoc.bean.UsersBean"%>
<%@page import="esj.publicdoc.service.impl.UserdemandsBeanServiceImpl"%>
<%@page import="esj.publicdoc.service.UserdemandsBeanService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
UserdemandsBeanService uBeanService = new UserdemandsBeanServiceImpl();
ProtypesBeanService pbService = new ProtypesBeanServiceimpl();
UserdemandsBean userdemandsBean = null;
userdemandsBean = uBeanService.findUserdemandsById(request.getParameter("id"));
request.setAttribute("demand", userdemandsBean);

ProtypesBean pt = null;
pt =  pbService.findProtypesById(userdemandsBean.getTypeId());
request.setAttribute("pt", pt);

 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>个人中心-需求修改</title>
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
			  <div class="col-md-9"><br>
			  	 <form name="form3" id="form3" action="${pageContext.request.contextPath }/person_center/ChangeDem?id=${demand.demandId}" method="post" enctype="multipart/form-data">
					<input type="hidden" name="typetag" id="typetag"/>
					<input type="hidden" name="imgaddr" id="imgaddr" value="${pBean.photoAddr}"/>  	 	
					<h1>买家中心-修改我发布的需求</h1>
					<hr class="mhr">
					<label class="label-hint">你可以修改您未解决的需求信息</label><br><br>
					<br>
					<div class="row">
						<div class="col-sm-12">
							<div class="row" id="photo">
								<div class="col-xs-4 col-md-2">
									<label class="label-icon">照片</label>
								</div>
								<div id="divimg" class="col-xs-8 col-md-10">
									<c:if test="${fn:indexOf(demand.photoAddr,',')<=0 }">
										<img id="img0" src="${demand.photoAddr}" class="img-thumbnail img-icon imgs" title="点击更换图片" alt="点击更换图片" />
										<img  id="img1" src="imgs/none_img.png"  class="img-thumbnail img-icon imgs new" title="点击添加图片" alt="点击添加图片" />
									</c:if>
									<c:if test="${fn:indexOf(demand.photoAddr,',')>0 }">
										<c:forEach var="addr" items="${fn:split(demand.photoAddr,',')}" varStatus="status">
											<img id="img${status.index}" src="${addr}" class="img-thumbnail img-icon imgs" title="点击更换图片" alt="点击更换图片" />	
											<c:set var="count" value="${status.count}"></c:set>
										</c:forEach>
										<c:if test="${count<4 }">
											<img  id="img${count}" src="imgs/none_img.png"  class="img-thumbnail img-icon imgs new" title="点击添加图片" alt="点击添加图片" />
										</c:if>	
									</c:if>
									
								</div>
								<c:if test="${fn:indexOf(demand.photoAddr,',')<=0 }">
										<input name="inputimg0" type="file"  class="inputfile" id="inputimg0" style="height:0;width:0;z-index: -1;" />
										<input name="inputimg1" type="file"  class="inputfile new" id="inputimg1" style="height:0;width:0;z-index: -1;" />
								</c:if>
								<c:if test="${fn:indexOf(demand.photoAddr,',')>0 }">
									<c:forEach var="cc" begin="0" end="${count-1 }">
										<input name="inputimg${cc}" type="file"  class="inputfile" id="inputimg${cc}" style="height:0;width:0;z-index: -1;" />
									</c:forEach>
									<c:if test="${count<4 }">
										<input name="inputimg${count}" type="file"  class="inputfile new" id="inputimg${count}" style="height:0;width:0;z-index: -1;" />
									</c:if>	
								</c:if>
							</div>
						</div>
					</div>
							<span class="span-remind-show" id="rimg"></span>
							<hr>
							<hr>
							<div class="row">
								  <div class="col-xs-12 col-md-2">
									  <label class="label-form">需求标题</label>	
								  </div>
								  <div class="col-xs-6 col-md-10">
								  	<input type="text" class="form-control input-form" id="title"  name="title" placeholder="需求标题" readonly="readonly" value="${demand.title }"/>
								  </div>
							</div>
							<span class="span-remind-show"></span>
							<hr>
							<div class="row">
								  <div class="col-xs-12 col-md-2">
									<label class="label-form">商品类别</label>
									</div>
									<div class="col-xs-6 col-md-10">
										<div class="container-fluid">
											<div class="row">
												<div class="col-xs-12 col-md-4">
													<select  id="proType1" class="form-control select-form" style="margin-left: 0px;">
														<option id="t1" name="${pt.typeId}" selected="selected" disabled="disabled">${pt.typeName}</option>
													</select>
												</div>	
												<div class="col-xs-12 col-md-8"></div>					
											</div>
										</div>
									</div>
							</div>
							<span class="span-remind-show"></span>
							<hr>
							<div class="row">
								  <div class="col-xs-12 col-md-2">
									  <label class="label-form">标签</label>	
								  </div>
								  <div class="col-xs-6 col-md-10">
										<ul id="ultag" class="tags_links" style="margin-left: 10px;">
											<c:if test="${fn:indexOf(demand.tagName,',')>0}">
												<c:forEach var="tag" items="${fn:split(demand.tagName,',')}" varStatus="status">
													<li id="litag${status.count }" >${tag}
														<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
													</li>
												</c:forEach>
											</c:if>
										</ul>
										<div class="row">
											<div class="col-xs-12 col-md-10">
												<input type="text" class="form-control input-form" id="proTags" placeholder="选填项，长度不超过10个字符" />
											</div>
											<div class="col-xs-12 col-md-2">
												<input id="btntag" class="btn mbtn" type="button" value="添加标签" />				
											</div>
										</div>
									</div>
							</div>
							<span class="span-remind-show"></span>
							<hr>
							<div class="row">
								  <div class="col-xs-12 col-md-2">
									  <label class="label-form">需求详细描述</label>	
								  </div>
								  <div class="col-xs-6 col-md-10">
										<textarea id="details" name="details" onkeydown="countChar('details', 'counter');" onkeyup="countChar('details', 'counter');"  rows="4" cols="50" maxlength="250" style="width: 70%;margin-left: 15px;" placeholder="必填项，长度在30~250个字之间" >${demand.details }</textarea>										
										<span class="span-remind-show2" id="counter">${fn:length(demand.details)}/250</span>
									</div>
							</div>
							<span class="span-remind-show"></span>
							<hr>
								<%--结束日期  开始--%>
								<div class="row">
									<div class="col-xs-12 col-md-2">
										<label class="label-form">结束日期</label>
									</div>
									<div class="col-xs-12 col-md-10">
										<div class="container-fluid">
											<div class="row">
												<div class="col-xs-12 col-md-1">
													<label class="label-date">年</label>
												</div>
												<div class="col-xs-12 col-md-3">
													<select id="eDatey" name="eDatey" class="form-control select-form">
													    <c:forEach var="i" begin="2016" end="2020">
															<option id="y${i }" <c:if test="${fn:split(demand.edate ,'-')[0] == i}">selected="selected"</c:if> >${i }</option>
														</c:forEach>
														
													</select>
												</div>
												<div class="col-xs-12 col-md-1 " style="margin-left:-3.6em;">
													<label class="label-date">月</label>
												</div>
												<div class="col-xs-12 col-md-3">
													<select id="eDatem" name="eDatem" class="form-control select-form">
														<c:forEach var="i" begin="1" end="12">
															<option id="m${i}"  <c:if test="${fn:split(demand.edate ,'-')[1] == i}">selected="selected"</c:if> >${i}</option>
														</c:forEach>
													</select>
												</div>
												
												<div class="col-xs-12 col-md-1" style="margin-left:-3.6em;">
													<label class="label-date">日</label>
												</div>
												<div class="col-xs-12 col-md-3">
													<select id="eDated" name="eDated" class="form-control select-form">
														<c:forEach var="i" begin="1" end="31">
															<option id="d${i}" <c:if test="${fn:split(demand.edate ,'-')[2] == i}">selected="selected"</c:if> >${i}</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
									</div>
								</div>
								<span class="span-remind-show" id="rdate"></span>
									<%--结束日期  结束--%>
							<hr>
							<span class="span-remind-show" id="rsave"></span>
							<div class="row register-but">
							
								<input id="save" type="button" style="margin-left: 35%;"
									value="保存" />
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
  <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
  
  	<script type="text/javascript">
	var error3 = 0;//标签
	var error4 = 0;//描述
	var error8 = 0;//照片
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

function countChar(textareaName,spanName)
{
	document.getElementById(spanName).innerHTML = document.getElementById(textareaName).value.length+"/"+250;
}
var imglist = "";
	var imgid = "img0";
	var imgcount = $(".imgs").length;
	$(".imgs").live("click",function(){
	    imgid = this.id;
	   	if(!$(this).hasClass("new")){
	   	 	$(this).addClass("new");
	   	 } 
		$("#input"+imgid).click();
	});
	$(".inputfile").live("change",function() {
		PreviewImage(this);
		 
		var co = imgcount -1;
		if(imgcount <4 && imgid.trim() == ("img"+co)){
			$("#divimg").append("<img id='img"+imgcount+"' src='imgs/none_img.png'  class='img-thumbnail img-icon imgs new' title='点击添加图片' alt='点击添加图片'/>");		
			$("#photo").append("<input name='inputimg"+imgcount+"' class='inputfile new' id='inputimg"+imgcount+"' type='file' style='height:0;width:0;z-index: -1;' />");
			imgcount ++;
		}	
		if(imgcount>1){
			error8 = 0;
			$("#rimg").hide();
		}
	});

/**预览图片*/

function PreviewImage(imgFile) {
	var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;
	if (!pattern.test(imgFile.value) && imgFile.value != "") {
		alert("系统仅支持jpg/jpeg/png/gif/bmp格式的照片！");
		imgFile.focus();
	} else {
		var path;
		if (document.all)//IE
		{
			imgFile.select();
			path = document.selection.createRange().text;
			document.getElementById(imgid).style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src=\""
					+ path + "\")";//使用滤镜效果
					
		} else//FF
		{
			path = URL.createObjectURL(imgFile.files[0]);
			document.getElementById(imgid).src = path;
		}
	}
}

/**结束日期*/

$("#eDatem").live("change",function(){
	var m = $("#eDatem").val();
	var y = $("#eDatey").val();
	$("#eDated option").remove();
	for(var i=1; i<=31;i++){
		$("#eDated").append("<option id="+i+">"+i+"</option>");

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
$("#eDatey").live("change",function(){
	var y = $("#eDatey").val();
	if(y=="请选择"){
		$("#rdate").html("请选择年份");
		$("#rdate").show();
		error8 = 1;
	}else{
		error8 = 0;
		$("#rdate").hide();
		$("#eDatem").change();
	}
});

/**添加商品标签*/	

$("#btntag").click(function(){
	var proTags = $("#proTags").val();//获得文本框中的值
	if(proTags.trim()){
		var child = $("#ultag").children("li");
		if(proTags.length<10){
			$("#rproTags").hide();
			
			if(child.length >= 5){
				$("#rproTags").html("最多添加5个标签哟");
				$("#rproTags").show();
				error3 = 0;
			}else{
				var op = 1;
				for(var i=0;i<child.length;i++){
					var c= child.get(i);
					var ct = c.innerText;
					if(proTags.trim() == ct.trim()){
						$("#rproTags").html("已经添加过该标签了");
						$("#rproTags").show();
						op = 0;
						error3 = 0;
						break;
					}
				}
				if(op == 1){
				    len = child.length+1;
					$("#ultag").append("<li  id='litag"+len+"'>"+proTags.trim()+" <span class='glyphicon glyphicon-remove' aria-hidden='true'></span></li>");
				    $("#rproTags").hide();
				    error3 = 0;
				}				
			}
		}else{
			$("#rproTags").html("最多输入10个字哟");
			$("#rproTags").show();
			error3 = 0;
		}
	}else{
		$("#rproTags").html("标签名不能为空哟");
		$("#rproTags").show();
		error3 = 0;
	}
});	

/**删除标签*/

$("#ultag li span").live("click",function(){
		var parentid = $(this).parent().attr("id");
		$("#"+parentid).remove();
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
		if(error4 == 1){
			$("#details").blur();
		}

		if(error4 ==1||error8 == 1){
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
		
		var imgs = $(".imgs");
		for(var i =0;i<imgs.length;i++){
			if(!$(imgs[i]).hasClass("new")){
				imglist += $(imgs[i]).attr("id")+",";
				$(imgs[i]).removeClass("new");
			}
		}
		var types = "${pt.typeId}";
		$("#imgaddr").val("${demand.photoAddr}");
		$("#typetag").val(types+"/"+tags+"/"+imglist);
		$("#form3").submit();
	});
</script>
</body>
</html>