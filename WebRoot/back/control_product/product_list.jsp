<%@page import="esj.back.util.Product_ListServletComparator"%>
<%@page import="esj.publicdoc.bean.ProductsBean"%>
<%@page import="esj.back.control.product.service.impl.ProductsServiceImpl"%>
<%@page import="esj.back.control.product.service.ProductsService"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
ProductsService service=new ProductsServiceImpl();

List<ProductsBean> list = service.findAllProducts();

Collections.sort(list,new Product_ListServletComparator());

request.setAttribute("list", list);
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
	<!--[if lt IE 9]>
	<script type="text/javascript" src="lib/html5.js"></script>
	<script type="text/javascript" src="lib/respond.min.js"></script>
	<script type="text/javascript" src="lib/PIE_IE678.js"></script>
	<![endif]-->
	<link href="../css/H-ui.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/H-ui.admin.css" rel="stylesheet" type="text/css" />
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<link href="../lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
	<!--[if IE 6]>
	<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
	<script>DD_belatedPNG.fix('*');</script>
	<![endif]-->
	<title>商品信息管理</title>
</head>
<body>

	<nav class="breadcrumb"> <i class="Hui-iconfont">&#xe67f;</i>
		首页
		<span class="c-gray en">&gt;</span>
		商品管理
		<span class="c-gray en">&gt;</span>
		商品信息管理
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
					<th scope="col" colspan="12">商品列表</th>
				</tr>
				<tr class="text-c">
					<th width="25">
						<input type="checkbox" name="" value=""></th>
					<th width="40">ID</th>
					<th width="60">卖家编号</th>
					<th width="60">商品类别</th>
					<th width="60">商品名称</th>
					<th width="130">发布时间</th>
					<th width="130">结束时间</th>
					<th width="60">浏览次数</th>
					<th width="40">赞</th>
					<th width="40">踩</th>
					<th width="100">商品状态</th>
					<th width="150">操作</th>
				</tr>
			</thead>
			<tbody>
				<!-- 
					/**商品编号*/
	private String proId;
	/**用户编号：卖家编号*/
	private String userId;
	/**类别编号*/
	private Integer typeId;
	/**标签名称*/
	private String tagName;
	/**商品名称*/
	private String title;
	/**商品描述*/
	private String details;
	/**照片地址*/
	private String photoAddr;
	/**商品买入价格*/
	private Float oprice;
	/**商品出售价格*/
	private Float cprice;
	/**商品折扣价*/
	private Float dprice;
	/**商品发布日期*/
	private String bdate;
	/**商品下架日期*/
	private String edate;
	/**商品状态*/
	private String state;
	/**商品差评数*/
	private Integer ncount;
	/**商品好评数*/
	private Integer pcount;
	/**商品浏览数*/
	private Integer vcount;
	/**预留字段*/
	private String remark;
	/**外键数组：用户表*/
	private List<UsersBean> users;
	/**外键数组：类别表*/
	private List<ProtypesBean> protypes;
				
				 -->
				<c:forEach var="products" items="${list}">
				<tr class="text-c">
					<td>
						<input type="checkbox" value="1" name=""></td>
					<td>${products.proId}</td>
					
					<td>
						<c:set value="${products.users}" var="users"/>
						<c:forEach var="user" items="${users}">
							${user.userName}
						</c:forEach>
					</td>
					
					<td>${products.typeId}</td>
					<td>
						${products.title}
						<!--  <a class="maincolor" href="javascript:;" onclick="product_show('添加标签','product_show.jsp','500','500')" >${products.title}</a>-->
					</td>
					<td>${products.bdate}</td>
					<td>${products.edate}</td>
					<td>${products.vcount}</td>
					<td>${products.pcount}</td>
					<td>${products.ncount}</td>
					<td class="td-status">
						<span class="label label-success radius">${products.state}</span>
					</td>
					<td class="td-manage">
					<!-- 
						<a style="text-decoration:none" onClick="product_stop(this,'10001')" href="javascript:;" title="停用">
							<i class="Hui-iconfont">&#xe631;</i>
						</a>
					 -->
					 
						<a 
							
							id='${products.state}-${products.proId}'
							
							onClick="authoritie_group_state(this,id)"
							
							class="statechange" style="text-decoration:none" href="javascript:;" title="停用">
							
							<i class="Hui-iconfont" >修改状态</i>  
							
						</a>
							
						<a title="删除" href="javascript:;" onclick="product_del(this,'${products.proId}')" class="ml-5" style="text-decoration:none">
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
	  {"orderable":false,"aTargets":[0,8]}// 制定列不参与排序
	]
});

/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/
/*商品-增加*/
function product_show(title,url,w,h){

	layer_show(title,url,w,h);

}

/*商品-删除*/
function product_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		var ajax = createAJAX();
	    var method = "GET";
	    var url = "${pageContext.request.contextPath}/back/control_product/Product_DeleteServlet?id="+id+"&time="+new Date().getTime();
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
	
	layer.confirm('确认要改变状态吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		
		$(obj).parents("tr").find(".td-manage").prepend('<a id='+"'"+id_+"'"+'   onClick="authoritie_group_state(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已出售</span>');
		$(obj).remove();
		layer.msg($(obj).parents("tr").find(".td-manage"),{icon: 5,time:1000});
		layer.msg('已停用!',{icon: 5,time:1000});
	});
}


/*权限-启用*/
function authoritie_group_start(obj,id,id_){
//authoritie_group_state(obj,id)
	layer.confirm('确认改变状态吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		$(obj).parents("tr").find(".td-manage").prepend('<a id='+"'"+id_+"'"+'   onClick="authoritie_group_state(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">出售中</span>');
		$(obj).remove();
		layer.msg('出售中!', {icon: 5,time:1000});
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
		
		if(name=="出售中")
		{
			statename="已出售";
		}
		else
		{
			statename="出售中";
		}
		
	    var ajax = createAJAX();
	    var method = "GET";
	    var url = "${pageContext.request.contextPath}/back/control_product/Product_StateChangeServlet?id="+id+"&state="+statename+"&time="+new Date().getTime();
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
							
							if(name=="出售中")
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