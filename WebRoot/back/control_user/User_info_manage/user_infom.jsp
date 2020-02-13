<%@page import="esj.back.user_info_manage.dao.impl.admin_usersbeandaoimpl"%>
<%@page import="esj.back.user_info_manage.dao.admin_usersbeandao"%>
<%@page import="esj.publicdoc.bean.UsersBean"%>
<%@page import="esj.publicdoc.service.impl.UsersBeanServiceimpl"%>
<%@page import="esj.publicdoc.service.UsersBeanService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
//admin_usersbeandao service=new admin_usersbeandaoimpl();
UsersBeanService  service = new UsersBeanServiceimpl();
//UsersBean usersbean = service.findUserByName(request.getParameter("name"));
UsersBean usersbean =service.findUserById(request.getParameter("id"));
pageContext.setAttribute("usersBean", usersbean);
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
    <script type="text/javascript" src="${pageContext.request.contextPath }/lib/html5.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/lib/respond.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/lib/PIE_IE678.js"></script>
    <![endif]-->
    <link href="${pageContext.request.contextPath }/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>用户查看</title>
</head>
<body>
<div class="cl pd-20" style=" background-color:#5bacb6">
    <img class="avatar size-XL l" src="${pageContext.request.contextPath }../../images/233.jpg">
    <dl style="margin-left:80px; color:#fff">
        <dt><span class="pl-10 f-12">积分：${usersBean.creditPoints}</span></dt>
        <dd class="pt-10 f-12" style="margin-left:0">${usersBean.remark}</dd>
    </dl>
</div>
<div class="pd-20">
    <table class="table">
        <tbody>
        <tr>
            <th class="text-r" width="80">昵称：</th>
            <td>${usersBean.userName}</td>
        </tr>
        <tr>
            <th class="text-r" width="80">性别：</th>
            <td>${usersBean.sex}</td>
        </tr>
        <tr>
            <th class="text-r">经验值：</th>
            <td>${usersBean.empirical}</td>
        </tr>
        <tr>
            <th class="text-r" width="100">手机号:</th>
            <td>${usersBean.userPhone}</td>
        </tr>
        <tr>
            <th class="text-r" width="100">注册时间：</th>
            <td>${usersBean.rigistDay}</td>
        </tr>
        <tr>
            <th class="text-r" width="100">学校：</th>
            <td>${usersBean.school}</td>
        </tr>
        <tr>
            <th class="text-r" width="100">邮箱：</th>
            <td>${usersBean.email}</td>
        </tr>
        <tr>
            <th class="text-r">状态：</th>
            <c:if test="${ usersBean.state=='1'}">
            	<td>可用</td>
            </c:if>
            <c:if test="${ usersBean.state=='0'}">
            	<td>停用</td>
            </c:if> 
        </tr>      
        </tbody>
    </table>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/H-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/H-ui.admin.js"></script>
</body>
</html>