<%@page import="esj.util.DateHelper"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
Properties props=System.getProperties(); //系统属性
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />

<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>我的桌面</title>
</head>
<body>
<div class="pd-20" style="padding-top:20px;">
  <p class="f-20 text-success">欢迎使用 湖科二手街后台管理系统</p>
  <table class="table table-border table-bordered table-bg">
    <thead>
      <tr>
        <th colspan="7" scope="col">信息统计</th>
      </tr>
      <tr class="text-c">
        <th>统计</th>
        <th>图片库</th>
        <th>商品库</th>
        <th>用户</th>
        <th>管理员</th>
      </tr>
    </thead>
    <tbody>
      <tr class="text-c">
        <td>总数</td>
        <td>737</td>
        <td>419</td>
        <td>12</td>
        <td>2</td>
      </tr>
      <tr class="text-c">
        <td>今日</td>
        <td>86</td>
        <td>63</td>
        <td>0</td>
        <td>0</td>
      </tr>
      <tr class="text-c">
        <td>昨日</td>
        <td>131</td>
        <td>107</td>
        <td>0</td>
        <td>0</td>
      </tr>
      <tr class="text-c">
        <td>本周</td>
        <td>364</td>
        <td>314</td>
        <td>0</td>
        <td>0</td>
      </tr>
      <tr class="text-c">
        <td>本月</td>
        <td>737</td>
        <td>419</td>
        <td>12</td>
        <td>2</td>
      </tr>
    </tbody>
  </table>
  <table class="table table-border table-bordered table-bg mt-20">
    <thead>
      <tr>
        <th colspan="2" scope="col">服务器信息</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th width="200">服务器计算机名</th>
        <td><span id="lbServerName">http://121.42.212.211/</span></td>
      </tr>
      <tr>
        <td>服务器IP地址</td>
        <td><%=request.getRemoteAddr() %></td>
      </tr>
      <tr>
        <td>服务器域名</td>
        <td><%=request.getServerName()  %></td>
      </tr>
      <tr>
        <td>服务器端口 </td>
        <td><%=request.getLocalPort()%></td>
      </tr>
      
      <tr>
        <td>本文件所在文件夹 </td>
        <td><%=props.getProperty("user.home") %></td>
      </tr>
      <tr>
        <td>服务器操作系统 </td>
        <td><%=props.getProperty("os.name") %></td>
      </tr>
      <tr>
        <td>服务器的语言种类 </td>
        <td>Chinese (People's Republic of China)</td>
      </tr>
      <tr>
        <td>服务器当前时间 </td>
        <td><%=DateHelper.getDateTimeFormat() %></td>
      </tr>
      <tr>
        <td>CPU 总数 </td>
        <td><%=Runtime.getRuntime().availableProcessors() %></td>
      </tr>
      <tr>
        <td>虚拟内存 </td>
        <td><%=Runtime.getRuntime().totalMemory() %>M</td>
      </tr>
      <tr>
        <td>当前程序占用内存 </td>
        <td>3.29M</td>
      </tr>
      <tr>
        <td>当前Session数量 </td>
        <td>1</td>
      </tr>
      <tr>
        <td>当前SessionID </td>
        <td><%=session.getId() %></td>
      </tr>
    </tbody>
  </table>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script>

</body>
</html>