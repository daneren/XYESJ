<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

	<link href="../css/H-ui.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/H-ui.admin.css" rel="stylesheet" type="text/css" />
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<link href="../lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

	<title>商品类别管理</title>
</head>
<body>

	<nav class="breadcrumb"> <i class="Hui-iconfont">&#xe67f;</i>
		首页
		<span class="c-gray en">&gt;</span>
		商品管理
		<span class="c-gray en">&gt;</span>
		商品类别管理
		<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" > <i class="Hui-iconfont">&#xe68f;</i>
		</a>
	</nav>
	
	<div class="cl pd-5 bg-1 bk-gray mt-20">
		<span class="l">
		
			<a href="javascript:;" onclick="product_category_add('新增商品类别','product_category_add.jsp','600','300')" class="btn btn-primary radius"> <i class="Hui-iconfont">&#xe600;</i>
				新增商品类别
			</a>

		</span>

	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr>
					<th scope="col" colspan="6">商品类别列表</th>
				</tr>
				<tr class="text-c">
					<th width="25">
						<input type="checkbox" name="" value=""></th>
					<th width="40">ID</th>
					<th width="60">类别名称</th>
					<th width="60">上级编号</th>
					<th width="130">子类编号</th>
					<th width="100">操作</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="protypes" items="${list}">
				<tr class="text-c">
					<td>
						 <input type="checkbox" value="1" name=""></td>
					<td>${protypes.typeId}</td>
					<td>${protypes.typeName}</td>
					<td>${protypes.fatherId}</td>
					<td>${protypes.childId}</td>
					<td class="td-manage">
						<a title="编辑" href="javascript:;" onclick="product_category_edit('修改','product_category_update.jsp?id=${protypes.typeId}','550','350')" class="ml-5" style="text-decoration:none">
							<i class="Hui-iconfont">&#xe6df;</i>
						</a>
						<a title="删除" href="javascript:;" onclick="product_category_del(this,'${protypes.typeId}')" class="ml-5" style="text-decoration:none">
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

/*商品类别-添加*/
function product_category_add(title,url,w,h){
	layer_show(title,url,w,h);
}

/*商品类别-修改*/
function product_category_edit(title,url,w,h){
	layer_show(title,url,w,h);
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

/*删除*/
function product_category_del(obj,id){

	
	layer.confirm('删除须谨慎，确认要删除吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
	
		var ajax = createAJAX();
	    var method = "GET";
	    var url = "${pageContext.request.contextPath}/back/control_product/Product_CategoryDeleteServlet?id="+id+"&time="+new Date().getTime();
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


</script>
</body>
</html>