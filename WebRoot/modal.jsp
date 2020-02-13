<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal fade" style="display: none;">
    <div class="modal-dialog">
       <div class="modal-content">
          <div class="modal-header">
             <button type="button" data-dismiss="modal" aria-hidden="true" class="close">×</button>
             <h4 id="myModalLabel" class="modal-title">预约信息</h4>
          </div>
          <div class="modal-body">
          	<%--内容开始 --%>
          	<form>
	          <div class="form-group">
	            <label for="recipient-name" class="control-label">联系方式:</label>
	             <span style="font-size: 12;">为了方便卖家联系你，请输入您的有效手机号</span>
	            <input value="${user.userPhone}" type="text" class="form-control" id="contact" >

	          </div>
	          <div class="form-group">
	            <label for="message-text" class="control-label">出价:</label>
	            <span style="font-size: 12;">支持砍价哦，输入你想要入手该宝贝的价格吧，默认为商品售价</span>
	            <input
	             <c:if test="${!empty product.dprice }">value="${product.dprice}"
	             <c:set var="price" value="${product.dprice}"></c:set>
	             </c:if>
				  <c:if test="${empty product.dprice}">value="${product.cprice}" 
				   <c:set var="price" value="${product.cprice}"></c:set>
				  </c:if>
				  type="text" class="form-control" id="buyPrice">
				  <span style="font-size: 12;color: red;" id="rcprice"></span>
	          </div>
	          <div class="form-group">
	            <label for="message-text" class="control-label">备注:</label>
	           
	            <textarea class="form-control" id="remark" placeholder=""></textarea>
	          </div>
	        </form>
            <%--内容结束--%>
          </div>
          <div class="modal-footer">
             <button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
             <button type="button" id="reserves" class="btn btn-primary">确认预约</button>
          </div>
       </div>
    </div>
 </div>
<script type="text/javascript">
/**出价*/
	$("#buyPrice").blur(function(){
		var cprice1 =$("#buyPrice").val();//获得文本框中的值
		if($.trim(cprice1)){
		    var cprice = $.trim(cprice1);
			if($.isNumeric(cprice)){
				if(cprice>0){
					$("#rcprice").hide();
				}else{
					$("#rcprice").html("请输入大于0的数字哦");
					$("#rcprice").show();
					$("#buyPrice").val("${price}");
				}
			}else{
				$("#rcprice").html("您输入的内容不是数字，请重新输入一次吧");
				$("#rcprice").show();
				$("#buyPrice").val("${price}");
		    }
		}else{
			$("#rcprice").html("请输入商品要出售的价格");
			$("#rcprice").show();
			$("#buyPrice").val("${price}");
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

$("#reserves").click(function(){
	var solemail = "${prouser.email}";
	var uemail = "${user.email}";
	var showtel = document.getElementById("showtel");
	if(solemail.trim() == uemail.trim()){
		showtel.innerText = "您不能预约自己发布的商品哦";
		showtel.style.display = 'block';
		return;
	}
 	var request = createAJAX();
   var method = "Post";

   var contact = document.getElementById("contact").value;
   var buyPrice = $("#buyPrice").val();
   var remark = $("#remark").val();
   
   var url = "${pageContext.request.contextPath}/SendEmail?time="+new Date().getTime();
   	request.open(method,url);
   	//设置AJAX请求头为POST，他会将请求体中的汉字自动进行UTF-8的编码
    request.setRequestHeader("content-type","application/x-www-form-urlencoded");
    //NO3)
    var content = "&solemail=" + "${prouser.email}";
    content += "&remark="+remark;
   	content += "&solUName="+"${prouser.userName}";
   	content += "&solUId="+"${prouser.userId}";
   	content += "&title="+"${product.title}";
   	content += "&id=" +"${product.proId}";
   	content += "&contact="+contact;
   	content += "&buyPrice="+buyPrice;
   	request.onreadystatechange = function(){
       if(request.readyState == 4 && request.status == 200){
      	  var nowStr = request.responseText;
          var respro =  document.getElementById("respro");
          respro.innerText = nowStr+"";
       }
    }
    request.send(content);
     $("#myModal").modal('hide');
});

</script>