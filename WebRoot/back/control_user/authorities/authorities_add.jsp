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
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../lib/html5.js"></script>
    <script type="text/javascript" src="../lib/respond.min.js"></script>
    <script type="text/javascript" src="../lib/PIE_IE678.js"></script>
    <![endif]-->
    <link href="${pageContext.request.contextPath }/back/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/back/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/back/lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/back/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
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
    <title>添加权限节点</title>
</head>
<body>
<div class="pd-20">
<h2 ><span>添加权限信息</span></h2>
    <form action="" method="post" class="form form-horizontal" id="form-admin-add">
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>权限编号：</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" value="" placeholder="" id="user-name" name="user-name" datatype="*2-16" nullmsg="权限编号不能为空">
            </div>
            <div class="col-4"> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>权限名称：</label>
            <div class="formControls col-5">
                <input type="password" placeholder="" autocomplete="off" value="" class="input-text" datatype="*6-20" nullmsg="权限名称不能为空">
            </div>
            <div class="col-4"> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>用户编号：</label>
            <div class="formControls col-5">
                <input type="password" placeholder="" autocomplete="off" class="input-text Validform_error"  datatype="*" nullmsg="用户编号不能为空" recheck="newpassword" id="newpassword2" name="newpassword2">
            </div>
            <div class="col-4"> </div>
        </div>

        <div class="row cl">
            <label class="form-label col-3">状态</label>
            <div class="formControls col-5">
                <span class="select-box inline">
                <select name="" class="select">
                    <option value="0">关闭</option>
                    <option value="1">开启</option>
                </select></span>
            </div>
            <div class="col-4"> </div>
        </div>
        <div class="row cl">
            <div class="col-9 col-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;返回&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/lib/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/js/H-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/js/H-ui.admin.js"></script>
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
                var index = parent.layer.getFrameIndex(window.name);
                parent.$('.btn-refresh').click();
                parent.layer.close(index);
            }
        });
    });
</script>
</body>
</html>