﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<LINK rel="Bookmark" href="/favicon.ico" >
	<LINK rel="Shortcut Icon" href="/favicon.ico" />

	<link href="../css/H-ui.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/H-ui.admin.css" rel="stylesheet" type="text/css" />
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<link href="../lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
	<!--[if IE 6]>
	<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
	<script>DD_belatedPNG.fix('*');</script>
	<![endif]-->
	<title>管理员列表</title>
</head>
<body>
	<nav class="breadcrumb"> <i class="Hui-iconfont">&#xe67f;</i>
		首页
		<span class="c-gray en">&gt;</span>
		管理员管理
		<span class="c-gray en">&gt;</span>
		管理员列表
		<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" > <i class="Hui-iconfont">&#xe68f;</i>
		</a>
	</nav>
	<div class="pd-20">

		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l">

				<a href="javascript:;" onclick="admin_add('添加标签','admin_add.jsp','550','550')" class="btn btn-primary radius">
					<i class="Hui-iconfont">&#xe600;</i>
					添加管理员
				</a>
			</span>
		</div>
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="9">员工列表</th>
				</tr>
				<tr class="text-c">
					<th width="25">
						<input type="checkbox" name="" value=""></th>
					<th width="40">ID</th>
					<th width="150">登录名</th>
					<th width="200">手机</th>
					<th>角色</th>
					<th width="200">加入时间</th>
					<th width="200">状态</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody> 
			
				
				<c:forEach var="AdminsBean" items="${list}" varStatus="status">
					<tr class="text-c">
					<td>
						<input type="checkbox" value="1" name=""></td>
					<td>${ AdminsBean.adminId}</td>
					<td>
						<a  href="javascript:;" onclick="layer_show('管理员编辑','admin_show.jsp','800','500')" class="ml-5" style="text-decoration:none">
							${ AdminsBean.adminName}
						</a>
					</td>
					<td>${ AdminsBean.adminPhone}</td>
					<td>${ AdminsBean.authId}</td>
					<td>${ AdminsBean.rigistDay}</td>
					<td class="td-status">
						<span class="label label-success radius">${ AdminsBean.state}</span>
					</td>
					<td class="td-manage">
						<a 
							
							id='${ AdminsBean.state}-${ AdminsBean.adminId}'
							
							onClick="authoritie_group_state(this,id)"
							
							class="statechange" style="text-decoration:none" href="javascript:;" title="停用">
							
							<i class="Hui-iconfont" >修改状态</i>  
							
						</a>
							
							
						<a title="编辑" href="javascript:;" onclick="layer_show('管理员编辑','admin_update.jsp?id=${ AdminsBean.adminId}','800','500')" class="ml-5" style="text-decoration:none">
							<i class="Hui-iconfont">&#xe6df;</i>
						</a>
						<a title="删除" href="javascript:;" onclick="admin_del(this,'${ AdminsBean.adminId}')" class="ml-5" style="text-decoration:none">
							<i class="Hui-iconfont">&#xe6e2;</i>
						</a>
					</td>
				</tr>
				</c:forEach>
				
				

			</tbody>

		</table>
	</div>
	<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="../lib/layer/1.9.3/layer.js"></script>
	<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="../lib/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="../js/H-ui.js"></script>
	<script type="text/javascript" src="../js/H-ui.admin.js"></script>
	<script type="text/javascript">
/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/
/*管理员-增加*/
function admin_add(title,url,w,h){

	layer_show(title,url,w,h);
}
/*管理员-删除*/
function admin_del(obj,id){
		layer.confirm('管理员删除须谨慎，确认要删除吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
	
		var ajax = createAJAX();
	    var method = "GET";
	    var url = "${pageContext.request.contextPath}/back/control_authoritie/Admin_DeleteServlet?id="+id+"&time="+new Date().getTime();
	    ajax.open(method,url);
	    ajax.send(null);
	    ajax.onreadystatechange = function(){
	    
	        if(ajax.readyState == 4){
	        
	        		if(ajax.status==200){ //响应码

	                    var flag = ajax.responseText;
	                    if(flag==1)
						{
							$(obj).parents("tr").remove();
							layer.msg('已删除!',{icon:1,time:1000});
						}
						else
						{
							alert("失敗"+flag);
							layer.msg('删除失败!',{icon:1,time:1000});
						}		
	        		}
	        }
		}
	});
}
/*管理员-编辑*/
function admin_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}

/*权限-状态*/
function authoritie_group_state(obj,id){

	var str=id,str1=id;
	//alert(str);
	
	var astr=str.split('-');
	var name=astr[0];
	var id=astr[1];
	
	SendAJAX(obj,id,name,str1);

}

/*权限-停用*/
function authoritie_group_stop(obj,id,id_){
	
	layer.confirm('确认要停用吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		
		$(obj).parents("tr").find(".td-manage").prepend('<a id='+"'"+id_+"'"+'   onClick="authoritie_group_state(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已停用</span>');
		$(obj).remove();
		layer.msg($(obj).parents("tr").find(".td-manage"),{icon: 5,time:1000});
		layer.msg('已停用!',{icon: 5,time:1000});
	});
}


/*权限-启用*/
function authoritie_group_start(obj,id,id_){
//authoritie_group_state(obj,id)
	layer.confirm('确认要开启吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		$(obj).parents("tr").find(".td-manage").prepend('<a id='+"'"+id_+"'"+'   onClick="authoritie_group_state(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
		$(obj).remove();
		layer.msg('已启用!', {icon: 5,time:1000});
	});
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
			 }
		}
		 return ajax;
	}	
	
	
	function SendAJAX(obj,id,name){
		
		if(name=="已启用")
		{
			statename="已禁用";
		}
		else
		{
			statename="已启用";
		}
		
	    var ajax = createAJAX();
	    var method = "GET";
	    var url = "${pageContext.request.contextPath}/back/control_authoritie/AdminChangeStateServlet?id="+id+"&state="+statename+"&time="+new Date().getTime();
	    ajax.open(method,url);
	    ajax.send(null);
	    ajax.onreadystatechange = function(){
	    
	        if(ajax.readyState == 4){
	        
	        		if(ajax.status==200){ //响应码

	                    var flag = ajax.responseText;
	                    if(flag==1)
						{
							//id=id+"-"+statename;
							//alert(str+""+"id="+id+"name="+name);
							
							var str=statename+"-"+id;
							
							//alert(str);
							
							if(name=="已启用")
							{
								authoritie_group_stop(obj,'10001',str);
							}
							else
							{
								authoritie_group_start(obj,'10001',str);
							}	
						}
						else
						{
							alert("失敗"+flag);
						}
						
						
	        		}
	        }
		}
		
	}
</script>
</body>
</html>