<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- start fenye -->
<script type="text/javascript" src="js/highlight.pack.js"></script>
  <script type="text/javascript" src="js/tabifier.js"></script>
  <script src="js/jPages.js"></script>

  <script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-28718218-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

  </script>

  <script>
  $(function(){
    $("div.holder").jPages({
      containerID : "movies",
      previous : "上一页",
      next : "下一页",
      perPage : 8,
      delay : 20
    });
  });
  </script>
  <style type="text/css">
  .holder {
    margin: 15px 0;
  }

  .holder a {
    font-size: 12px;
    cursor: pointer;
    margin: 0 5px;
    color: #333;
  }

  .holder a:hover {
    background-color: #222;
    color: #fff;
  }

  .holder a.jp-previous { margin-right: 15px; }
  .holder a.jp-next { margin-left: 15px; }

  .holder a.jp-current, a.jp-current:hover {
    color: #FF4242;
    font-weight: bold;
  }

  .holder a.jp-disabled, a.jp-disabled:hover {
    color: #bbb;
  }

  .holder a.jp-current, a.jp-current:hover,
  .holder a.jp-disabled, a.jp-disabled:hover {
    cursor: default;
    background: none;
  }

  .holder span { margin: 0 5px; }
  </style>
<!-- end fenye -->
<div class="panel panel-default pn-reserv">
  <!-- Default panel contents -->
  <div id="content" class="defaults">
  <div class="panel-body">
    <p>未处理的订单信息</p>
  </div>

  <!-- Table -->
  <table id="taball" class="table tb-reserv">
  
  <thead>
   <tr>
   	<th>编号</th>
   	<th>商品标题</th>
   	<th>发布日期</th>
   	<th>结束日期</th>
   	<th>售价</th>
   	<th>订单数</th>
   	<th>操作</th>
   </tr>
   </thead>
   <tbody id="movies">
   <c:forEach var="ars" items="${allReserv}" varStatus="status">
   
	   <tr>
	   	   <td>${status.index}</td>
		   <td><a href="${pageContext.request.contextPath}/XProductInfo?proId=${ars.proId}" target="_blank">${ars.title }</a></td>
		   <td>${ars.bdate }</td>
		   <td>${ars.cjdate }</td>
		   <td>${ars.dprice }</td>
		   <td>${ars.ruCount }</td>
		   <td id="td${ars.proId}"><a href="#" class="rea" id="${ars.proId}">查看预约详情</a></td>
	   </tr>
   </c:forEach>
   </tbody>
  </table>
  <div class="holder"></div>
  </div>
</div>
<script type="text/javascript">
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
$(".rea").click(function(){
	var request = createAJAX();

   var method = "Post";   
   var url = "${pageContext.request.contextPath }/person_center/AllReserv?op=2&time="+new Date().getTime();
   	request.open(method,url);
   	//设置AJAX请求头为POST，他会将请求体中的汉字自动进行UTF-8的编码
    request.setRequestHeader("content-type","application/x-www-form-urlencoded");
    //NO3)
    var content = "&id="+this.id;
   	request.onreadystatechange = function(){
       if(request.readyState == 4 && request.status == 200){
      	  var nowStr = request.responseText;
      	  document.getElementById("rebody").innerHTML = nowStr;
      	 
       }
    }
    request.send(content);
    $("#myModal").modal('show');
});


</script>