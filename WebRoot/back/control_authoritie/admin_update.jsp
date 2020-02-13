<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="esj.publicdoc.service.impl.*"%>
<%@page import="esj.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String id2=request.getParameter("id");
	int id=Integer.parseInt(id2);
	pageContext.setAttribute("adminsBean", new AdminsBeanServiceimpl().findAdminsByAdminId(id));
	pageContext.setAttribute("types", new AuthoritiesBeanServiceimpl().findAllAuthorities());
	pageContext.setAttribute("STime", new DateHelper().getDateTimeFormat());
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<title>添加管理员</title>
</head>
<body>
	<div class="pd-20">
		<form action="" method="post" class="form form-horizontal" id="form-admin-add">
			
			<!-- 
				/**管理员编号*/
	private int adminId;
	/**管理员账号：手机号*/
	private String adminPhone;
	/**管理员名字*/
	private String adminName;
	/**管理员登陆密码*/
	private String adminPwd;
	/**管理员性别*/
	private String sex;
	/**管理员生日*/
	private String birthDay;
	/**管理员登陆日期*/
	private String rigistDay;
	/**管理员权限编号*/
	private int authId;
	/**管理员状态 1：启用，0禁用*/
	private String state;
			 -->
			
			<div class="row cl">
				<label class="form-label col-3">
					<span class="c-red">*</span>
					登陆账号：
				</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" value="${adminsBean.adminPhone}" placeholder="" id="adminPhone" name="adminPhone" datatype="*2-16" nullmsg="登陆账号不能为空"></div>
				<div class="col-4"></div>
			</div>
			
			
			<div class="row cl">
				<label class="form-label col-3">
					<span class="c-red">*</span>
					管理员姓名：
				</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" value="${adminsBean.adminName}" placeholder="" id="name" name="adminPhone" datatype="*2-16" nullmsg="管理员姓名不能为空"></div>
				<div class="col-4"></div>
			</div>

			<div class="row cl">
				<label class="form-label col-3">
					<span class="c-red">*</span>
					性别：
				</label>
				<div class="formControls col-5"> 
					<span class="select-box" style="width:150px;">
						<select class="select" name="sex" size="1" id="sex">	
								<option value="男"  id="nan"
								
								<c:if test="${男== adminsBean.sex}">selected="selected"</c:if>
								
								>男</option>
								<option value="女"  id="nv"
								
								<c:if test="${女== adminsBean.sex}">selected="selected"</c:if>
								
								>女</option>							
						</select>
					</span> 
				</div>
			</div>

			<div class="row cl">
				<label class="form-label col-3">
					<span class="c-red">*</span>
					登陆密码名称：
				</label>
				<div class="formControls col-5">
					<input  type="text" value="${adminsBean.adminPwd}"  class="input-text"  placeholder="" id="pw"></div>
				<div class="col-4"></div>
			</div>
			

			<div class="row cl">
				<label class="form-label col-3">权限：</label>
				<div class="formControls col-5"> 
					<span class="select-box" style="width:150px;">
						<select class="select" name="admin-role" size="1" id="selects">
							<c:forEach items="${types}" var="type">
						
								<option value="${type.authId}"  id="${type.authId}"
								
								<c:if test="${type.authId == adminsBean.authId}">selected="selected"</c:if>
								
								>
								${type.authName}</option>
							
							</c:forEach>	
						</select>
					</span> 
				</div>
			</div>
			
			<div class="row cl">
				<div class="col-9 col-offset-3">
					<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
					<input type="hidden" value="${adminsBean.adminId} " id="stime">
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
			form[0].submit();
			
			SendAJAX();
			
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
	

		var adminPhone = document.getElementById('adminPhone').value;
		var adminId=document.getElementById('stime').value;
		var sex=document.getElementById('sex').value;
		var authoritie=document.getElementById('selects').value;
		var pw=document.getElementById('pw').value;
		var name=document.getElementById('name').value;

		
	    var ajax = createAJAX();
	    var method = "GET";
	    var url = "${pageContext.request.contextPath}/back/control_authoritie/Admin_UpdateServlet?adminPhone="+adminPhone+"&adminId="+adminId+"&sex="+sex+"&authoritie="+authoritie+"&pw="+pw+"&name="+name+"&time="+new Date().getTime();
	    
	    ajax.open(method,url);
	    ajax.send(null);
	    
	    alert("更新管理员信息成功");
	    
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