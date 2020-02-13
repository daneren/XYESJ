<%@page import="esj.publicdoc.dao.impl.ProtypesBeanDaoimpl"%>
<%@page import="esj.publicdoc.service.impl.TagsBeanServiceimpl"%>
<%@page import="esj.util.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	pageContext.setAttribute("types", new ProtypesBeanDaoimpl().findAllProtypes());
	pageContext.setAttribute("CurrentTime", new DateHelper().getDateTimeForNumber()+new Random100().getrandom100());
	pageContext.setAttribute("STime", new DateHelper().getDateTimeFormat());
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link href="../css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="../css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="../lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="../lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>添加标签</title>
</head>
<body>
<div class="pd-20">
	<form action="" method="post" class="form form-horizontal" id="form-admin-add">
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>标签名称：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="" placeholder="" id="user-name" name="user-name" datatype="*2-16" nullmsg="用户名不能为空">
			</div>
			<div class="col-4"> </div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-3">类别：</label>
			<div class="formControls col-5"> 
				<span class="select-box" style="width:150px;">
					<select class="select" name="admin-role" size="1" id="selects">
						<c:forEach items="${types}" var="type">
					
							<option value="${type.typeId}"  id="${type.typeId}">${type.typeName}</option>
						
						</c:forEach>	
					</select>
				</span> 
			</div>
		</div>
				
		
		<div class="row cl">
			<div class="col-9 col-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
				<input type="hidden" value="${CurrentTime} " id="currenttime">
				<input type="hidden" value="${STime} " id="stime">
				&nbsp;&nbsp;
				&nbsp;&nbsp;
				&nbsp;&nbsp;
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="../lib/Validform/5.3.2/Validform.min.js"></script> 
<script type="text/javascript" src="../lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="../js/H-ui.js"></script> 
<script type="text/javascript" src="../js/H-ui.admin.js"></script> 
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-admin-add").Validform({
		tiptype:2,
		callback:function(form){
		
		SendAJAX()
		
			form[0].submit();
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
});
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
	
	
	function SendAJAX(){
		
	
		var tagId;
		var tagName;
		var typeId;	
		var bdate;

		
		typeId=document.getElementById("selects").value;
		//alert(typeId);
		tagId=document.getElementById("currenttime").value;
		//alert(tagId);
		tagName=document.getElementById("user-name").value;
		//alert(tagName);
		bdate=document.getElementById("stime").value;
		//alert(bdate);
		
		
	    var ajax = createAJAX();
	    var method = "GET";
	    //INSERT INTO tags( tagId,tagName,times,typeId,score,bdate,state) VALUES (?,?,?,?,?,?,?);
	    var url = "${pageContext.request.contextPath}/back/control_tag/TagAddServlet?typeId="+typeId+"&tagId="+tagId+"&tagName="+tagName+"&bdate="+bdate+"&time="+new Date().getTime();
	    
	    ajax.open(method,url);
	    ajax.send(null);
		
		alert("增加标签成功");
		
	    ajax.onreadystatechange = function(){
	    
	        if(ajax.readyState == 4){
	        
	        		if(ajax.status==200){ //响应码

	                    var flag = ajax.responseText;
	                    if(flag==1)
						{
							layer.msg('已删除!',{icon:1,time:1000});
						}
						else
						{
							layer.msg('删除失败!',{icon:1,time:1000});
						}	
						 return flag;
							
	        		}
	        }
	       
		}
		
	}
</script>
</body>
</html>