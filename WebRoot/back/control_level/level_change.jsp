<%@page import="esj.publicdoc.bean.UserlevelsBean"%>
<%@page import="esj.publicdoc.service.impl.UserlevelsBeanServiceimpl"%>
<%@page import="esj.publicdoc.service.UserlevelsBeanService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
UserlevelsBeanService service=new UserlevelsBeanServiceimpl();
UserlevelsBean userlevelsbean = service.findUserlevelsById((Integer.valueOf(request.getParameter("id"))));
pageContext.setAttribute("userlevelsBean", userlevelsbean);
%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../lib/html5.js"></script>
    <script type="text/javascript" src="../lib/respond.min.js"></script>
    <script type="text/javascript" src="../lib/PIE_IE678.js"></script>
    <![endif]-->
    <link href="../css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="../css/H-ui.admin.css" rel="stylesheet" type="text/css" />
    <link href="../lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
    <link href="../lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <style type="text/css">
        h2
        {
            text-align: center;
            text-shadow:5px 5px 10px red;
            size: 14px;
        }
    </style>
    <title>修改等级信息</title>
</head>
<body>
<h2 ><span>修改等级信息</span></h2>
<div class="mt-20">
    <nav class="breadcrumb">
   	<i class="Hui-iconfont">&#xe67f;</i>首页
    <span class="c-gray en">&gt;</span> 系统管理
    <span class="c-gray en">&gt;</span> 等级管理
    <span class="c-gray en">&gt;</span> 等级信息修改
    <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <form action="" method="post" class="form form-horizontal" id="form-article-add">
	<div class="row cl">
	<label class="form-label col-2">等级序号：</label>
		<div class="formControls col-2">
			<input type="text" class="input-text" value="${userlevelsBean.levelId}" placeholder="" id="levelid" name="levelid" disabled="disabled">
		</div>
	</div>
	<div class="row cl">
	<label class="form-label col-2">目前等级名称：</label>
		<div class="formControls col-2">
			<input type="text" class="input-text" value="${ userlevelsBean.levelName}" placeholder="" id="" name="" disabled="disabled">
		</div>
	<label class="form-label col-2">修改等级名称：</label>
		<div class="formControls col-2">
			<input type="text" class="input-text" value="" placeholder="请输入等级名称" id="levelname" name="levelname">
		</div>
	</div>
	<div class="row cl">
	<label class="form-label col-2">目前上限经验：</label>
		<div class="formControls col-2">
			<input type="text" class="input-text" value="${ userlevelsBean.upperLimit}" placeholder="" id="" name=""  disabled="disabled">
		</div>
	<label class="form-label col-2">修改上限经验：</label>
		<div class="formControls col-2">
			<input type="text" class="input-text" onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="只能输入数据" id="levelmaxnum" name="levelmaxnum">
		</div>
	</div>
	</form>
	 <div class="row cl">
        <div class="col-9 col-offset-3">
        <span id="msg"></span>
            <input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;保存&nbsp;&nbsp;" onclick="save()" style="margin-right: 10px;float: right;padding-right: 10px" href="javascript:location.replace(location.href);">
        </div>
    </div>
    
</div>
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="../lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../js/H-ui.js"></script>
<script type="text/javascript" src="../js/H-ui.admin.js"></script>
<script type="text/javascript">
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
				    
function save(){

	var levelid = $("#levelid").val();
	var levelname = $("#levelname").val();
	var levelmaxnum = $("#levelmaxnum").val();
	if(levelname != ""||levelmaxnum != ""){
	var ajax = createAJAX();
    var method = "GET";
    var url = "${pageContext.request.contextPath}/back/control_level/admin_savelevelsServlet?lid="+levelid+"&lname="+levelname+"&lmaxnum="+levelmaxnum+"&time="+new Date().getTime();
    ajax.open(method,url);
    ajax.send(null);
    ajax.onreadystatechange = function(){
        if(ajax.readyState == 4){
        		if(ajax.status==200){ //响应码
                    var nowStr = ajax.responseText;
                    window.close();
                    if(nowStr == "ok"){
                    	alert("修改成功");
                    	window.location.reload();
                    }else{
                    	alert("修改失败，请稍后再试");
                    }
        		}
        }
	}
	}else{
		
	alert("请输入完整的修改信息");
	}
	
}
</script>
</body>
</html>