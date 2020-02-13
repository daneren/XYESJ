<%@page import="esj.publicdoc.service.LnotesBeanService"%>
<%@page import="esj.publicdoc.bean.LnotesBean"%>
<%@page import="esj.publicdoc.service.impl.LnotesBeanServiceimpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
LnotesBeanService service=new LnotesBeanServiceimpl();
List<LnotesBean> list =service.findAllLnotes();
pageContext.setAttribute("list", list);
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
    <script type="text/javascript" src="${pageContext.request.contextPath }/lib/html5.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/lib/respond.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/lib/PIE_IE678.js"></script>
    <![endif]-->
    <link href="${pageContext.request.contextPath }/back/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/back/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/back/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>留言管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>用户中心 <span class="c-gray en">&gt;</span> 用户管理<span class="c-gray en">&gt;</span>留言管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
    <%--<div class="text-c"> 日期范围：
        <input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px;">
        -
        <input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:120px;">
        <input type="text" class="input-text" style="width:250px" placeholder="输入用户名称、积分、等级" id="" name="">
        <button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
    <span class="r">共有数据：<strong>3</strong> 条</span>
    --%></div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="" value=""></th>
                <th width="80">编号</th>
                <th width="100">用户编号</th>
                <th width="40">商品编号</th>
                <th width="300">内容</th>
                <th width="150">日期</th>
                <th width="">IP</th>
                <th width="130">IP地址</th>
                <th width="70">状态</th>
                <th width="100">操作</th>
            </tr>
            </thead>
            <tbody>
				<c:forEach var="lnotesBean" items="${list }" varStatus="status">
	        	<tr class="text-c">
	            <td><input type="checkbox" value="1" name=""></td>
	            <td></td>
	            <td>${lnotesBean.userId}</td>
	            <td>${lnotesBean.proId}</td>
	            <td>${lnotesBean.details}</td>
	            <td>${lnotesBean.bdate}</td>
	            <td>${lnotesBean.ip}</td>
	            <td>${lnotesBean.ipAddr}</td>
	            <c:if test="${ lnotesBean.state =='启用'}">
	            <td class="td-status"><span class="label label-success radius">已启用</span></td>
	            <td class="td-manage">
	            <a style="text-decoration:none" onClick="member_stop(this,'${lnotesBean.leaveId}')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>
	            
	            </td>
	           	</c:if>
	           	<c:if test="${ lnotesBean.state =='禁用'}">
	            <td class="td-status"><span class="label label-defaunt radius">已停用</span></td>
	            <td class="td-manage">
	            <a style="text-decoration:none" onClick="member_start(this,'${lnotesBean.leaveId}')" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1</i></a>
	            
	            </td>
	           	</c:if> 
	      		</tr>
	        	</c:forEach>
            </tbody>
        </table>
        <div class="row cl">
            <div class="col-9 col-offset-3">
                <input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;返回&nbsp;&nbsp;" onclick="back()" style="margin-right: 10px;float: right;padding-right: 10px">
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/js/H-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/js/H-ui.admin.js"></script>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,2,3,4,5]}// 制定列不参与排序
	]
});
    function back()
    {
        window.location.href='../../welcome.jsp';
    }
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
	}}
return ajax;
}
    /*用户-添加*/
    function member_add(title,url,w,h){
        layer_show(title,url,w,h);
    }
    /*用户-查看*/
    function member_show(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
    /*用户-停用*/
    function member_stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){
        	var ajax = createAJAX();
		    var method = "GET";
		    var url = "${pageContext.request.contextPath}/servlet/admin_lnoteschangestateServlet?id="+id+"&state=禁用&time="+new Date().getTime();
		    ajax.open(method,url);
		    ajax.send(null);
		    ajax.onreadystatechange = function(){
		        if(ajax.readyState == 4){    
		        		if(ajax.status==200){ //响应码
		                    var flag = ajax.responseText;
            				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
            				$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
            				$(obj).remove();
            				layer.msg('已停用!',{icon: 5,time:1000});
            				}}}
        });
    }

    /*用户-启用*/
    function member_start(obj,id){
        layer.confirm('确认要启用吗？',function(index){
        var ajax = createAJAX();
		    var method = "GET";
		    var url = "${pageContext.request.contextPath}/servlet/admin_lnoteschangestateServlet?id="+id+"&state=启用&time="+new Date().getTime();
		    ajax.open(method,url);
		    ajax.send(null);
		    ajax.onreadystatechange = function(){
		        if(ajax.readyState == 4){    
		        		if(ajax.status==200){ //响应码
		                    var flag = ajax.responseText;
            				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
           					$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
            				$(obj).remove();
           					layer.msg('已启用!',{icon: 6,time:1000});
           					}}}
        });
    }
    /*用户-编辑*/
    function member_edit(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
    /*密码-修改*/
    function change_password(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }
</script>
</body>
</html>