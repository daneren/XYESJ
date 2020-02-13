<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table id="${proId}" class="table tb-reserv" style="background-color: white;height:200px;  overflow: scroll;">
  <tr>
  	<th>编号</th>
  	<th>买家姓名</th>
  	<th>出价</th>
  	<th>留言</th>
  	<th>操作</th>
  </tr>
  <c:forEach var="ars" items="${detailRe}" varStatus="status">
   <tr>
   	   <td>${status.index}</td>
	   <td><a href="">${ars.state }</a></td>
	   <td>${ars.buyerPrice }</td>
	   <td style="width: 300px;">${ars.remark }</td>
	   <td><a href="#" class="tooltip-test acceptre "  title="点击后系统会自动取消该商品的其他订单"  id="1${ars.reservId},${ars.proId}">卖给他/她</a>|<a href="#" class="tooltip-test acceptre turndownre" id="2${ars.reservId}"  title="点击退回该订单">拒绝他/她</a></td>
   </tr>
  </c:forEach>
</table>

