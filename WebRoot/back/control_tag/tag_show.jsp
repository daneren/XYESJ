<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<link href="../lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
	<!--[if IE 6]>
	<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
	<script>DD_belatedPNG.fix('*');</script>
	<![endif]-->
	<title>修改标签</title>
</head>
<body>
	<div class="pd-20">
		<form action="" method="post" class="form form-horizontal" id="form-user-character-add" disabled>
			<div class="row cl">
				<label class="form-label col-3">
					<span class="c-red">*</span>
					标签编号：
				</label>
			</div>
			<div class="row cl">
				<label class="form-label col-3">
					<span class="c-red">*</span>
					标签名称：
				</label>
			</div>
			<div class="row cl">
				<label class="form-label col-3">
					<span class="c-red">*</span>
					使用次数：
				</label>
			</div>

			<div class="row cl">
				<label class="form-label col-3">
				<span class="c-red">*</span>
					类别：
					</label>

			</div>

			<div class="row cl">
				<label class="form-label col-3">
					<span class="c-red">*</span>
					热度：
				</label>
			</div>

			<div class="row cl">
				<label class="form-label col-3">
					<span class="c-red">*</span>
					加入时间：
				</label>
			</div>

			<div class="row cl">
				<label class="form-label col-3">
					<span class="c-red">*</span>
					状态：
				</label>
			</div>


			<div class="row cl">
				<div class="col-9 col-offset-3">
					<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
					&nbsp;&nbsp;
						&nbsp;&nbsp;
						&nbsp;&nbsp;
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="../lib/layer/1.9.3/layer.js"></script>
	<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="../lib/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="../js/H-ui.js"></script>
	<script type="text/javascript" src="../js/H-ui.admin.js"></script>
	<script>
$(function(){
	$(".permission-list dt input:checkbox").click(function(){
		$(this).closest("dl").find("dd input:checkbox").prop("checked",$(this).prop("checked"));
	});
	$(".permission-list2 dd input:checkbox").click(function(){
		var l =$(this).parent().parent().find("input:checked").length;
		var l2=$(this).parents(".permission-list").find(".permission-list2 dd").find("input:checked").length;
		if($(this).prop("checked")){
			$(this).closest("dl").find("dt input:checkbox").prop("checked",true);
			$(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",true);
		}
		else{
			if(l==0){
				$(this).closest("dl").find("dt input:checkbox").prop("checked",false);
			}
			if(l2==0){
				$(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",false);
			}
		}
		
	});
});
</script>
</body>
</html>