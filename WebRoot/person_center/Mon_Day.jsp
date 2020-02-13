<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<div class="col-xs-12 col-md-1 " style="margin-left:-3.6em;">
	<label class="label-date">月</label>
</div>
<div class="col-xs-12 col-md-3">
	<select id="eDatem" name="eDatem" class="form-control select-form">
		<c:forEach var="i" begin="1" end="12">
			<option id="m${i}">${i}</option>
		</c:forEach>
	</select>
</div>

<div class="col-xs-12 col-md-1" style="margin-left:-3.6em;">
	<label class="label-date">日</label>
</div>
<div class="col-xs-12 col-md-3">
	<select id="eDated" name="eDated" class="form-control select-form">
		
		<c:forEach var="i" begin="1" end="31">
			<option id="d${i}">${i}</option>
		</c:forEach>
	</select>
</div>
<script type="text/javascript">

/**生成日期*/
$("#eDatem").change(function(){
	var m = $("#eDatem").val();
	var y = $("#eDatey").val();
	$("#eDated option").remove();
	for(var i=1; i<=31;i++){
		$("#eDated").append("<option>"+i+"</option>");

		if(m == 2 && i==28 && y%4==0){
			break;
		}
		if(m == 2 && i==29 && y%4 != 0){
			break;
		}
		if((m==4||m==6||m==9||m==11)&& i==30 ){
			break;
		}
	
	}
});

</script>