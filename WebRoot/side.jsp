<%@page import="esj.front.products.service.impl.XTagsServiceImpl"%>
<%@page import="esj.publicdoc.service.impl.TagsBeanServiceimpl"%>
<%@page import="esj.publicdoc.service.impl.ProtypesBeanServiceimpl"%>
<%@page import="esj.publicdoc.bean.ProtypesBean"%>
<%@page import="esj.front.products.service.impl.XProTypeServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
//获取父id为0的类别  存在pageContext作用域中
List<ProtypesBean> list = new XProTypeServiceImpl().getProtypesByfatherid(0);
pageContext.setAttribute("protypes", list);
//获取标签
pageContext.setAttribute("tags", new XTagsServiceImpl().getTagsBytimesDesc());
%>
<script type="text/javascript">

function show(show){
	
	document.getElementById(show).style.display = 'block';
	
}
function disp(show){
	setTimeout("disp()",2000);
	document.getElementById(show).style.display = 'none';
				
}

</script>
<style>
.menuhr{
margin-top: 5px;
margin-bottom: 5px;
}
</style>
<div class="col-md-3">
	<div class="menu_box">
   	  	<h3 class="menu_head">分类</h3>
   	     <ul class="nav1">
   	     <%-- 
   	     	<c:forEach items="${ protypes}" var="type">
   	     		<li onmousemove="javascript:show('showdiv${type.typeId}');" onmouseleave="javascript:disp('showdiv${type.typeId}');"> 
   	     		<c:if test="${type.childId != null }">
   	     		<a href='${pageContext.request.contextPath }/XSearch?searchvalue=${type.typeName}&typeid=${type.typeId}-${fn:replace(type.childId,",","-")}' target="_blank">${type.typeName}</a>
   	     		</c:if>
   	     		<c:if test="${type.childId == null }">
   	     		<a href="${pageContext.request.contextPath }/XSearch?searchvalue=${type.typeName}&typeid=${type.typeId}" target="_blank">${type.typeName}</a>
   	     		</c:if>
   	     		</li>
   	     	</c:forEach>	--%>
   	     	<%
   	     	for(ProtypesBean bean :list){
   	     		String typeids=bean.getTypeId()+"-";
   	     		out.print("<li onmousemove=\"javascript:show('showdiv"+bean.getTypeId()+"');\" onmouseleave=\"javascript:disp('showdiv"+bean.getTypeId()+"');\"> ");
   	     		if(bean.getChildId() != null ){
   	     			String[] childids = bean.getChildId().split(",");
   	     			if(childids != null){
   	     			typeids += bean.getChildId().replace(",", "-");
   	     				for(String childid:childids){
   	     					ProtypesBean beanchild = new ProtypesBeanServiceimpl().findProtypesById(Integer.parseInt(childid));
	   	     				if(beanchild.getChildId() != null){
	   	     					String[] childchildids = beanchild.getChildId().split("-");
	   	     					if(childchildids != null){
	   	     					typeids += ("-"+beanchild.getChildId()).replace(",", "-");
	   	     					}
	   	     				}
   	     				}
   	     			}
   	     			out.print("<a href=\"XProTypeSearch?searchvalue="+bean.getTypeName()+"&typeid="+typeids+"\" target=\"_blank\">"+bean.getTypeName()+"</a>");
   	     		}else{
   	     			out.print("<a href=\"XProTypeSearch?searchvalue="+bean.getTypeName()+"&typeid="+typeids+"\" target=\"_blank\">"+bean.getTypeName()+"</a>");
   	     		}
   	     		out.print("</li>");
   	     	}
   	     	%>   	     				
   	     						
	   	 </ul>
  	 </div>
  	<div class="side_banner">
	   <div class="banner_img"><img src="images/open.png" class="img-responsive" alt=""/></div>
	   <div class="banner_holder"> </div>
    </div>
    <div class="tags">
    	<h4 class="tag_head">标签搜索</h4>
         <ul class="tags_links">
         	<c:forEach begin="0" end="20" items="${tags }" var="tag" varStatus="status" >
	         <li><a href="${pageContext.request.contextPath }/XTagsSearch?tagname=${tag.tagName}" target="_blank">${tag.tagName }</a></li>
	         		
         	</c:forEach>
			
		</ul>
		<a href="${pageContext.request.contextPath }/XTagsSearch" class="link1" target="_blank">更多标签</a>
     </div>
     <%-- 
     <div class="tags">
      	<h4 class="tag_head">我发布的</h4>
      	 <ul class="article_links">
			<li><a href="#">Eleifend option congue nihil</a></li>
		  </ul>
		 <a href="#" class="link1">查看全部</a>
      </div>--%>
</div><!--end col-md-3 -->
<div class="col-md-9">
<div class="content_grid" style="position: relative;">
<%for(ProtypesBean bean : list){ %>
	<div onmousemove="javascript:show('showdiv<%=bean.getTypeId() %>');" onmouseleave="javascript:disp('showdiv<%=bean.getTypeId() %>');" id="showdiv<%=bean.getTypeId() %>" style="display: none; position: absolute; z-index:55555;left:-30px;"> 
		<div  style="background:rgba(255, 255, 255, 0.6)!important;filter:Alpha(opacity=60); background:#fff;padding-top:10px;padding-right:50px;min-height: 400px;min-width: 400px;">
		<% // 获得该父标签下的子标签id
		String[] childids = bean.getChildId().split(",");
		for(String id:childids){
			//根据子标签id获取该标签的信息
			ProtypesBean beanchild = new ProtypesBeanServiceimpl().findProtypesById(Integer.parseInt(id));
			if(beanchild.getChildId() != null ){
				out.print("<span><a href='XProTypeSearch?searchvalue="+bean.getTypeName()+" "+beanchild.getTypeName()+"&typeid="+beanchild.getTypeId()+"-"+beanchild.getChildId().replace(",", "-")+"' style='color: black;'>"+beanchild.getTypeName()+"</a></span><br><span>");
			}else{
				out.print("<span><a href='XProTypeSearch?searchvalue="+bean.getTypeName()+" "+beanchild.getTypeName()+"&typeid="+beanchild.getTypeId()+"' style='color: black;'>"+beanchild.getTypeName()+"</a></span><br><span>");
			}
			
			
			//out.print(beanchild.getChildId());
			//获得子标签下的子标签
			if(beanchild.getChildId() != null ){
				String[] childchildids = beanchild.getChildId().split(",");
				out.print("<center>");
				for(String childchildid:childchildids){
					//根据子标签id获取该标签的信息
					ProtypesBean beanchildchild = new ProtypesBeanServiceimpl().findProtypesById(Integer.parseInt(childchildid));
					out.print("&nbsp;<a href='XProTypeSearch?searchvalue="+bean.getTypeName()+" "+beanchild.getTypeName()+" "+beanchildchild.getTypeName()+"&typeid="+beanchildchild.getTypeId()+"' >"+beanchildchild.getTypeName()+"</a>&nbsp;");
				}
				out.print("</center></span>");
			}
			out.print("<hr class='menuhr'>");
		}
		%>
		</div>
	 </div>
<%} %>
</div>
</div>

