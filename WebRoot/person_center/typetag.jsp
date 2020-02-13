<%@page import="esj.publicdoc.service.impl.ProtypesBeanServiceimpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<div class="row">
<div class="col-xs-12 col-md-2">
	<label class="label-form">商品类别</label>
</div>
<div class="col-xs-6 col-md-10">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 col-md-4">
				<select  id="proType1" class="form-control select-form"
					style="margin-left: 0px;">
					<option>请选择</option>
					<c:forEach var="t" items="${listpt }">					
						<c:if test="${t.fatherId == 0}">
						<option id="t1" class="${t.childId}" name="${t.typeId}">${t.typeName}</option>
						</c:if>
					</c:forEach>
					
				</select>
			</div>
			<div class="col-xs-12 col-md-4">
				<select  id="proType2" class="form-control select-form">
					
					<c:forEach var="t" items="${listpt }">	
						<c:if test="${t.fatherId != 0}">						
							<option hidden="hidden" id="t1" class="${t.childId}" name="${t.typeId}">${t.typeName}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<div class="col-xs-12 col-md-4" style="margin-left: -20px;">
					<select id="proType3" class="form-control select-form">
					
					<c:forEach var="t" items="${listpt }">					
						<c:if test="${t.fatherId != 0 && empty(t.childId)}">
							<option hidden="hidden" id="t1" class="${t.childId}" name="${t.typeId}">${t.typeName}</option>
						</c:if>
					</c:forEach>
					</select>
				</div>

			</div>

		</div>
	</div>
</div>
<span class="span-remind-show" id="rproType"></span>
<hr>
<div class="row">
	<div class="col-xs-12 col-md-2">
		<label class="label-form">标签</label>
	</div>
	<div class="col-xs-6 col-md-10">
		<ul id="ultag" class="tags_links" style="margin-left: 10px;">
			<li id="litag1" >可小刀<span class="glyphicon glyphicon-remove" aria-hidden="true"></span></li>
		</ul>
		<div class="row">
			<div class="col-xs-12 col-md-10">
				<input type="text" class="form-control input-form" id="proTags" placeholder="选填项，长度不超过10个字符" />
			</div>
			<div class="col-xs-12 col-md-2">
				<input id="btntag" class="btn mbtn" type="button" value="添加标签" />				
			</div>
		</div>
	</div>
</div>

<span class="span-remind-show" id="rproTags" style="color: #FF9103;"></span>
<script type="text/javascript">

/**商品类别*/
var ty = "t2";
var seltype = "";
var cid2 = "";
var ctypes;
$("#proType1").change(function(){
	var s = $("#proType1").val();//获得文本框中的值
	seltype = $("#proType1 option:selected").attr("name");
		if(s == "请选择"){
			$("#rproType").html("请给商品分个类吧");
			$("#rproType").show();
			$("#proType2").hide();	
			$("#proType3").hide();	
			error2 = 1;
		}else if(s !="其他"){
			cid2 = $("#proType1 option:selected").attr("class");
			//有子类
			if($.trim(cid2) != ""){
				ctypes = seltype;
				doajax();
				ty = "t2";
				$("#t1").click();
				$("#proType2").show();
				
				seltype = $("#proType2 option:selected").attr("name");
				cid2 = $("#proType2 option:selected").attr("class");
				if($("#proType2").val() !="其他" && $.trim(cid2)!=""){
					$("#proType3").show();	
					ty = "t3";	
					$("#t1").click();
				}else{
					$("#proType3").hide();
				}
				
			}
			$("#rproType").hide();			
			error2 = 0;				
		}else{
			$("#proType2").hide();	
			$("#proType3").hide();	
			error2 = 0;
		}		
});
$("#proType2").live("change",function(){
	seltype = $("#proType2 option:selected").attr("name");
	cid2 = $("#proType2 option:selected").attr("class");
	if($("#proType2").val() !="其他" && $.trim(cid2)!=""){
		ty = "t3";
		$("#t1").click();
		$("#proType3").show();	
		seltype = $("#proType3 option:selected").attr("name");
		$("#proType3").change();				
	}else{
		$("#proType3").hide();	
	}

});
$("#proType3").live("change",function(){
	seltype = $("#proType3 option:selected").attr("name");
});

$("#t1").live("click", function(){
	var cid;		
	var obj;
	var index = 0;	
	if(ty == "t2"){
		cid = $("#proType1 option:selected").attr("class");
		obj = $("#proType2").children("option");
	}else if(ty == "t3"){
		cid = $("#proType2 option:selected").attr("class");
		obj = $("#proType3").children("option");
	}
	var cids = cid.split(",");
	
	for(var j=-1;j<obj.length;j++){				
			if($.inArray($(obj[j]).attr("name"),cids)>=0){
				if(index == 0){
					index = 1;
					obj[j].selected = true;
				}else{
					obj[j].selected = false;
				}
				$(obj[j]).show();
			}else{
				$(obj[j]).hide();
			}		
	}
	
});

/**添加商品标签*/	

$("#btntag").click(function(){
	var proTags = $("#proTags").val();//获得文本框中的值
	if(proTags.trim()){
		var child = $("#ultag").children("li");
		if(proTags.length<10){
			$("#rproTags").hide();
			
			if(child.length >= 8){
				$("#rproTags").html("最多添加8个标签哟");
				$("#rproTags").show();
				error3 = 0;
			}else{
				var op = 1;
				for(var i=0;i<child.length;i++){
					var c= child.get(i);
					var ct = c.innerText;
					if(proTags.trim() == ct.trim()){
						$("#rproTags").html("已经添加过该标签了");
						$("#rproTags").show();
						op = 0;
						error3 = 0;
						break;
					}
				}
				if(op == 1){
				    len = child.length+1;
					$("#ultag").append("<li  id='litag"+len+"'>"+proTags.trim()+" <span class='glyphicon glyphicon-remove' aria-hidden='true'></span></li>");
				    $("#rproTags").hide();
				    error3 = 0;
				}				
			}
		}else{
			$("#rproTags").html("最多输入10个字哟");
			$("#rproTags").show();
			error3 = 0;
		}
	}else{
		$("#rproTags").html("标签名不能为空哟");
		$("#rproTags").show();
		error3 = 0;
	}
});	

function createAJAX(){
    var request;
    try{
        //如果IE5=IE12的话
        request = new ActiveXObject("microsoft.xmlhttp");
    }catch(e1){
        try{
            //如果是非IE的话
            request = new XMLHttpRequest();
        }catch(e2){
            alert("你的浏览器中不支持异步对象，请换浏览器");
        }
    }
    return request;       	        	
}

/**删除标签*/
$("#ultag li span").live("click",function(){
		var parentid = $(this).parent().attr("id");
		$("#"+parentid).remove();
});



function doajax(){
	var request = createAJAX();
	var method = "Post";   
    var url = "${pageContext.request.contextPath }/person_center/Tags?time="+new Date().getTime();
   	request.open(method,url);
   	//设置AJAX请求头为POST，他会将请求体中的汉字自动进行UTF-8的编码
    request.setRequestHeader("content-type","application/x-www-form-urlencoded");
    //NO3)
    var content = "&id="+ctypes;
   	request.onreadystatechange = function(){
       if(request.readyState == 4 && request.status == 200){
      	  var nowStr = request.responseText;
      	  $("#ultag li").remove();
      	  $("#ultag").append(nowStr);
      	 }
    }
    request.send(content);
    $("#myModal").modal('show');

}
</script>