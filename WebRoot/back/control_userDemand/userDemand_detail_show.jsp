﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  <link href="../lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
  <!--[if IE 6]>
  <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
  <script>DD_belatedPNG.fix('*');</script>
  <![endif]-->
  <title>标签列表</title>
</head>
<body>
  <div class="cl pd-20" style=" background-color:#5bacb6">
    <img class="avatar size-XL l" src="images/user.png">
    <dl style="margin-left:80px; color:#fff">
      <dt>
        <span class="f-18">需求名称</span>
        <span class="pl-10 f-12">时间</span>
      </dt>
     
    </dl>
  </div>
  <div class="pd-20">
    <p>描述</p>
  </div>
  <script type="text/javascript" src="../js/jquery.min.js"></script>
  <script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
  <script type="text/javascript" src="../lib/layer/1.9.3/layer.js"></script>
  <script type="text/javascript" src="../lib/My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
  <script type="text/javascript" src="../js/H-ui.js"></script>
  <script type="text/javascript" src="../js/H-ui.admin.js"></script>

</body>
</html>