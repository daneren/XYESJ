<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<li><a class="product-rate">
  	<c:forEach begin="1" end="${fn:split(product.startc,',')[0]}" varStatus="status">
  		<label class="label1"></label>
  		<c:set var="startsc" value="${status.count}"></c:set>
  	</c:forEach>	
  	<c:if test="${fn:split(product.startc,',')[1] >0 }">
  		<label class="label3"></label>
	<label  class="label4" ></label>
	<c:set var="startsc" value="${startsc+1}"></c:set>
  	</c:if>	
  	<c:if test="${(5-startsc)>0}">
  		<c:forEach begin="1" end="${5-startsc}">
  			<label class="label2"></label>
  		</c:forEach>   		
</c:if>
</a></li>
