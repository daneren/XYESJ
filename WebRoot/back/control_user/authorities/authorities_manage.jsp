<%@page import="esj.publicdoc.bean.AuthoritiesBean"%>
<%@page import="esj.publicdoc.service.impl.AuthoritiesBeanServiceimpl"%>
<%@page import="esj.publicdoc.service.AuthoritiesBeanService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
AuthoritiesBeanService service=new AuthoritiesBeanServiceimpl();
List<AuthoritiesBean> list =service.findAllAuthorities();
pageContext.setAttribute("list", list);
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
    <link href="${pageContext.request.contextPath }/back/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/back/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/back/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/back/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>权限管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 权限管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>


    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l"> <a href="javascript:;" onclick="admin_permission_add('添加权限节点','authorities_add.jsp','','500')" class="btn btn-primary radius">
            <i class="Hui-iconfont">&#xe600;</i> 添加权限节点
        </a></span>
        <%--<span class="r">共有数据：<strong>2</strong> 条</span>
    --%>
    </div>
    <div class="mt-20">
	    <table class="table table-border table-bordered table-bg table-hover table-sort">
	        <thead>
	        <tr>
	            <th scope="col" colspan="7">权限节点</th>
	        </tr>
	        <tr class="text-c">
	            <th width="25"><input type="checkbox" name="" value=""></th>
	            <th width="40">权限序号</th>
	            <th width="200">权限名称</th>
	            <th>菜单列表</th>
	            <th>状态</th>
	            <th width="100">操作</th>
	        </tr>
	        </thead>
	        <tbody>
	        	<c:forEach var="authoritiesBean" items="${list }" varStatus="status">
		        	<tr class="text-c">
			            <td><input type="checkbox" value="1" name=""></td>
			            <td>${authoritiesBean.authId}</td>
			            <td>${authoritiesBean.authName}</td>
			            <td>${authoritiesBean.menuList}</td>
			            <c:if test="${authoritiesBean.state=='已启用'}">
			            <td class="td-status"><span class="label label-success radius">已启用</span></td>
			            <td class="td-manage">
			            <a style="text-decoration:none" onClick="member_stop(this,'${authoritiesBean.authId}')" href="javascript:;" title="停用">
			            <i class="Hui-iconfont">&#xe631;</i></a></td>
			           	</c:if>
			           	<c:if test="${ authoritiesBean.state =='已停用'}">
			            <td class="td-status"><span class="label label-defaunt radius">已停用</span></td>
			            <td class="td-manage">
			            <a style="text-decoration:none" onClick="member_start(this,'${authoritiesBean.authId}')" href="javascript:;" title="启用">
			            <i class="Hui-iconfont">&#xe6e1</i></a></td>
			           	</c:if> 
			            </td>
		      		</tr>
		        </c:forEach>
	        </tbody>
	    </table>
    </div>
    <div class="row cl">
        <div class="col-9 col-offset-3">
            <input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;返回&nbsp;&nbsp;" onclick="back()" style="margin-right: 10px;float: right;padding-right: 10px">
        </div>
    </div>
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="../lib/layer/1.9.3/layer.js"></script>
	<script type="text/javascript" src="../lib/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="../js/H-ui.js"></script>
	<script type="text/javascript" src="../js/H-ui.admin.js"></script>
<%--<script type="text/javascript" src="${pageContext.request.contextPath }/back/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/js/H-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/js/H-ui.admin.js"></script>
--%><script type="text/javascript">
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
    /*
     参数解释：
     title	标题
     url		请求的url
     id		需要操作的数据id
     w		弹出层宽度（缺省调默认值）
     h		弹出层高度（缺省调默认值）
     */
    /*管理员-权限-添加*/
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
    function admin_permission_add(title,url,w,h){
        layer_show(title,url,w,h);
    }
    /*管理员-权限-编辑*/
    function admin_permission_edit(title,url,id,w,h){
        layer_show(title,url,w,h);
    }

    /*管理员-权限-删除*/
    function admin_permission_del(obj,id){
        layer.confirm('角色删除须谨慎，确认要删除吗？',function(index){
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }
       /*用户-停用*/
    function member_stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){
        	var ajax = createAJAX();
		    var method = "GET";
		    alert(id);
		    var url = "${pageContext.request.contextPath}/servlet/admin_authoritieschangestateServlet?id="+id+"&state="+"已停用"+"&time="+new Date().getTime();
		    alert(url);
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
		    var url = "${pageContext.request.contextPath}/servlet/admin_authoritieschangestateServlet?id="+id+"&state="+"已启用"+"&time="+new Date().getTime();
		    alert(url);
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
</script>
</body>
</html>