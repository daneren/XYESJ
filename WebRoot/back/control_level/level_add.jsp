<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../lib/html5.js"></script>
    <script type="text/javascript" src="../lib/respond.min.js"></script>
   <!-- <script type="text/javascript" src="../lib/PIE_IE678.js"></script>-->
    <![endif]-->
    <link href="../css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="../css/H-ui.admin.css" rel="stylesheet" type="text/css" />
    <link href="../lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
    <link href="../lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>添加等级信息</title>
    <style type="text/css">
        h2
        {
            text-align: center;
            text-shadow:5px 5px 10px red;
            size: 14px;
        }
    </style>
</head>
<body>
<div class="pd-20">
    <h2 ><span>添加等级信息</span></h2>
    <form action="" method="post" class="form form-horizontal" id="form-member-add">
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>等级信息名称：</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" value="" placeholder="" id="level-name" name="level-name" datatype="*2-16" nullmsg="等级信息名不能为空">
            </div>
            <div class="col-4"> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>积分上限的值：</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" onkeyup="value=value.replace(/[^\d]/g,'')" id="level-values" name="level-values" datatype="*2-16" nullmsg="等级信息的值不能为空">
            </div>
            <div class="col-4"> </div>
        </div>
       <div class="row cl">
            <div class="col-9 col-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;" onclick="add()">
                <input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;返回&nbsp;&nbsp;" onclick="back()">
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
function back()
{
     window.location.href='member_level.jsp';
}
$(function(){
$('.skin-minimal input').iCheck({
    checkboxClass: 'icheckbox-blue',
    radioClass: 'iradio-blue',
    increaseArea: '20%'
   });

    $("#form-member-add").Validform({
    tiptype:2,
    callback:function(form){
     form[0].submit();
     var index = parent.layer.getFrameIndex(window.name);
     parent.$('.btn-refresh').click();
     parent.layer.close(index);
            }
        });
    });
function add()
{

	var levelname = $("#level-name").val();
	var levelvalues = $("#level-values").val();
	if(levelname != ""||levelvalues != ""){
	var ajax = createAJAX();
    var method = "GET";
    var url = "${pageContext.request.contextPath}/back/control_level/admin_getlevelsServlet?lname="+levelname+"&lvalues="+levelvalues+"&time="+new Date().getTime();
    ajax.open(method,url);
    ajax.send(null);
    //alert("ok");
    ajax.onreadystatechange = function(){
        if(ajax.readyState == 4){
        		if(ajax.status==200){ //响应码
                    var nowStr = ajax.responseText;
                    alert(nowStr);
                    //window.close();
                    if(nowStr == "ok"){
                    	alert("新增成功");
                    }else{
                    	alert("新增失败，请稍后再试");
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