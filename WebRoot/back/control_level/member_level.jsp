<%@page import="esj.publicdoc.bean.UserlevelsBean"%>
<%@page import="esj.publicdoc.service.impl.UserlevelsBeanServiceimpl"%>
<%@page import="esj.publicdoc.service.UserlevelsBeanService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
UserlevelsBeanService service=new UserlevelsBeanServiceimpl();
List<UserlevelsBean> list = service.findAllAdminlogs();
pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../lib/html5.js"></script>
    <script type="text/javascript" src="../lib/respond.min.js"></script>
<!--    <script type="text/javascript" src="../lib/PIE_IE678.js"></script>-->
    <![endif]-->
    <link href="../css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="../css/H-ui.admin.css" rel="stylesheet" type="text/css" />
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
    <title>等级管理</title>
</head>

<body>
<h2 ><span>等级管理</span></h2>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 系统管理
    <span class="c-gray en">&gt;</span> 等级管理
    <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="cl pd-5 bg-1 bk-gray mt-20">
    <table class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th width="25"><input type="checkbox" name="" value=""></th>
            <th width="80">序号</th>
            <th width="150">等级名称</th>
            <th width="100">积分上限</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="userlevelsBean" items="${list }" varStatus="status">
        	<tr class="text-c">
            <td><input type="checkbox" value="1" name=""></td>
            <td>${ userlevelsBean.levelId}</td>
            <td> ${ userlevelsBean.levelName}</td>
            <td>${ userlevelsBean.upperLimit}</td>
            <td class="td-manage">
            <a title="修改等级信息" href="javascript:;" onclick="level_change('修改等级信息','level_change.jsp?id=${userlevelsBean.levelId}','','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
            <a title="删除" href="javascript:;" onclick="member_del(this,'${userlevelsBean.levelId}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
            </td>
      		</tr>
        </c:forEach>
        </tbody>
    </table>
    <span class="l">
        <a href="javascript:;" onclick="level_add('添加等级信息','level_add.jsp','','510')"class="btn btn-primary radius">
        <i class="Hui-iconfont">&#xe600;</i> 添加等级信息</a>
    </span>
    <div class="row cl">
        <div class="col-9 col-offset-3">
            <input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;返回&nbsp;&nbsp;" onclick="back()" style="margin-right: 10px;float: right;padding-right: 10px">
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
    function back()
    {
        window.location.href='../welcome.jsp';
    }
   /* $(function(){
        $('.table-sort').dataTable({
            "aaSorting": [[ 1, "desc" ]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
            ]
        });
        $('.table-sort tbody').on( 'click', 'tr', function () {
            if ( $(this).hasClass('selected') ) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });
    });*/
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
    function level_add(title,url,w,h)
    {
        layer_show(title,url,w,h);
    }
    function level_change(title,url,w,h)
    {
        layer_show(title,url,w,h);
    }
    function level_set(title,url,w,h)
    {
        layer_show(title,url,w,h);
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
	        var ajax = createAJAX();
		    var method = "GET";
		    var url = "${pageContext.request.contextPath}/servlet/admin_deleteslevelServlet?id="+id+"&time="+new Date().getTime();
		    ajax.open(method,url);
		    ajax.send(null);
		    ajax.onreadystatechange = function(){
		        if(ajax.readyState == 4){    
		        		if(ajax.status==200){ //响应码
		                    var flag = ajax.responseText;
		                     $(obj).parents("tr").remove();
            				layer.msg('已删除!',{icon:1,time:1000});
            				}}}
		        		});	       
    }
</script>
</body>
</html>
