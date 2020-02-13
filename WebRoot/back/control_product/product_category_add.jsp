<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="esj.publicdoc.service.impl.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	pageContext.setAttribute("menus", new ProtypesBeanServiceimpl().findAllProtypes());
	pageContext.setAttribute("types", new ProtypesBeanServiceimpl().findAllProtypes());
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../lib/html5.js"></script>
    <script type="text/javascript" src="../lib/respond.min.js"></script>
   <!-- <script type="text/javascript" src="../lib/PIE_IE678.js"></script>-->
    <![endif]-->
    <link href="../css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="../css/H-ui.admin.css" rel="stylesheet" type="text/css" />
    <link href="../lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
    <link href="../lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>添加商品类别</title>
    <style type="text/css">
        h2
        {
            text-align: center;
            text-shadow:5px 5px 10px red;
            size: 14px;
        }
    </style>
</head>
<body>
<div class="pd-20">
    <h2 ><span>添加商品类别</span></h2>
    <form action="" method="post" class="form form-horizontal" id="form-member-add">
	<div class="row cl" >
			<label class="form-label col-2">商品类别名称：</label>
				<div class="formControls col-8">
					<input type="text" class="input-text" value="" placeholder="" id="name"  datatype="*4-16" nullmsg="用户账户不能为空"></div>
				</div>

			<br>	
					
			<div class="row cl">
				<label class="form-label col-3">父类别：</label>
				<div class="formControls col-5"> 
					<span class="select-box" style="width:150px;">
						<select class="select" name="admin-role" size="1" id="selects">
							<option value="0" >最上级分类</option>
							<c:forEach items="${types}" var="type">
						
								<option value="${type.typeId}"  id="${type.typeId}">${type.typeName}</option>
							
							</c:forEach>	
						</select>
					</span> 
				</div>
			</div>
				
			</div>
	<div class="row cl">
            <div class="col-9 col-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
                <input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;返回&nbsp;&nbsp;" onclick="back()">
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../lib/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="../lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="../lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="../js/H-ui.js"></script>
<script type="text/javascript" src="../js/H-ui.admin.js"></script>
<script type="text/javascript">
    function back()
    {
        window.location.href='member_level.jsp';
    }
    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        $("#form-member-add").Validform({
            tiptype:2,
            callback:function(form){
            	
            	
            	SendAJAX()
            	
                form[0].submit();
                var index = parent.layer.getFrameIndex(window.name);
                parent.$('.btn-refresh').click();
                parent.layer.close(index);
            }
        });
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
	
	
	function SendAJAX(){

		var typeName;
		var typeId;	
		typeId=document.getElementById("selects").value;
		typeName=document.getElementById("name").value;
	    var ajax = createAJAX();
	    var method = "GET";
	    //http://127.0.0.1:8080/XYESJ/back/control_product/Product_CategoryAddServlet?typeId=1&typeName=test
	    var url = "${pageContext.request.contextPath}/back/control_product/Product_CategoryAddServlet?typeId="+typeId+"&typeName="+typeName+"&time="+new Date().getTime();
	   // var url = "http://127.0.0.1:8080/XYESJ/back/control_product/Product_CategoryAddServlet?typeId=1&typeName=test";
	    alert(url);
	    ajax.open(method,url);
	    ajax.send(null);
	    ajax.onreadystatechange = function(){
	    
	        if(ajax.readyState == 4){
	        
	        		if(ajax.status==200){ //响应码

	                    var flag = ajax.responseText;
	
						 return flag;
							
	        		}
	        }
	       
		}
		
	}
</script>
</body>
</html>