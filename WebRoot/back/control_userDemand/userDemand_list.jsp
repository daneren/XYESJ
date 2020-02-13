
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />

	<link href="../css/H-ui.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/H-ui.admin.css" rel="stylesheet" type="text/css" />
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<link href="../lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

	<title>用户需求管理</title>
</head>
<body>


	<nav class="breadcrumb"> <i class="Hui-iconfont">&#xe67f;</i>
		首页
		<span class="c-gray en">&gt;</span>
		用户需求管理
		<span class="c-gray en">&gt;</span>
		用户需求管理
		<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" > <i class="Hui-iconfont">&#xe68f;</i>
		</a>
	</nav>
	
		<div class="cl pd-5 bg-1 bk-gray mt-20">
		<span class="r">
			共有数据： <strong>${fn:length(list) }</strong>
			条
		</span>
	</div>
	
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr>
					<th scope="col" colspan="12">用户需求列表</th>
				</tr>
				<tr class="text-c">
					<th width="25">
						<input type="checkbox" name="" value=""></th>
					<th width="40">ID</th>
					<th width="60">类别编号</th>
					<th width="60">标签名称</th>
					<th width="60">用户</th>
					<th width="60">需求标题</th>
					<th width="60">需求详情</th>
					<th width="130">发布日期</th>
					<th width="130">结束日期</th>
					<th width="60">图片地址</th>
					<th width="100">需求状态</th>
					<th width="100">操作</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="userDmand" items="${list}">
				<tr class="text-c">
					<td>
						<input type="checkbox" value="1" name=""></td>
					<td>${userDmand.demandId }</td>
					<td>${userDmand.typeId}</td>
					<td>
						${userDmand.tagName }
						<!--  <a class="maincolor" href="javascript:;" onclick="userDemand_tag_show('标签','userDemand_tag_show.jsp','500','500')" >${userDmand.tagName }</a>-->
					</td>
					<td>${userDmand.userId }</td>
					<td>${userDmand.title }</td>
					<td>
						${fn:substring(userDmand.details,0,10) }
						<!--  <a class="maincolor" title="${userDmand.details }" href="javascript:;" onclick="userDemand_tag_show('需求详情','userDemand_detail_show.jsp','500','500')" >${fn:substring(userDmand.details,0,10) }</a>-->
					</td>
					<td>${userDmand.bdate }</td>
					<td>${userDmand.edate }</td>
					<td>${userDmand.demandId }</td>
					<td class="td-status">
						<span class="label label-success radius">${userDmand.state }</span>
					</td>
					<td class="td-manage">
						<a 
							
							id='${userDmand.state }-${userDmand.demandId }'
							
							onClick="authoritie_group_state(this,id)"
							
							class="statechange" style="text-decoration:none" href="javascript:;" title="停用">
							
							<i class="Hui-iconfont" >修改状态</i>  
							
						</a>
						
						<a title="删除" href="javascript:;" onclick="del(this,'${userDmand.demandId }')" class="ml-5" style="text-decoration:none">
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
	<script type="text/javascript" src="../lib/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="../js/H-ui.js"></script>
	<script type="text/javascript" src="../js/H-ui.admin.js"></script>
	<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,2,3,4,5]}// 制定列不参与排序
	]
});


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

/*删除*/
function del(obj,id){

	
	layer.confirm('删除须谨慎，确认要删除吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
	
		var ajax = createAJAX();
	    var method = "GET";
	    var url = "${pageContext.request.contextPath}/back/control_userDemand/UserDemand_DeleteServlet?id="+id+"&time="+new Date().getTime();
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
	
	layer.confirm('确认要改为待解决吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		
		$(obj).parents("tr").find(".td-manage").prepend('<a id='+"'"+id_+"'"+'   onClick="authoritie_group_state(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">待解决</span>');
		$(obj).remove();
		layer.msg($(obj).parents("tr").find(".td-manage"),{icon: 5,time:1000});
		layer.msg('待解决!',{icon: 5,time:1000});
	});
}


/*权限-启用*/
function authoritie_group_start(obj,id,id_){
//authoritie_group_state(obj,id)
	layer.confirm('确认要改为已解决吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		$(obj).parents("tr").find(".td-manage").prepend('<a id='+"'"+id_+"'"+'   onClick="authoritie_group_state(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已解决</span>');
		$(obj).remove();
		layer.msg('已解决!', {icon: 5,time:1000});
	});
}

	function SendAJAX(obj,id,name){
		
		if(name=="已解决")
		{
			statename="待解决";
		}
		else
		{
			statename="已解决";
		}
		
	    var ajax = createAJAX();
	    var method = "GET";
	    var url = "${pageContext.request.contextPath}/back/control_userDemand/UserDemandChangeStateServlet?id="+id+"&state="+statename+"&time="+new Date().getTime();
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
							
							if(name=="已解决")
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