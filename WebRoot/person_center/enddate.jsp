<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<div class="row">
	<div class="col-xs-12 col-md-2">
		<label class="label-form">结束日期</label>
	</div>
	<div class="col-xs-12 col-md-10">
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12 col-md-1">
					<label class="label-date">年</label>
				</div>
				<div class="col-xs-12 col-md-3">
					<select id="eDatey" name="eDatey" class="form-control select-form">
					    <c:forEach var="i" begin="2016" end="2020">
							<option id="y${i }">${i }</option>
						</c:forEach>
						
					</select>
				</div>
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
			</div>
		</div>
	</div>
</div>
<span class="span-remind-show" id="rdate"></span>
<script type="text/javascript">
/**结束日期*/

$("#eDatem").live("change",function(){
	var m = $("#eDatem").val();
	var y = $("#eDatey").val();
	$("#eDated option").remove();
	for(var i=1; i<=31;i++){
		$("#eDated").append("<option id="+i+">"+i+"</option>");

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
$("#eDatey").live("change",function(){
	var y = $("#eDatey").val();
	if(y=="请选择"){
		$("#rdate").html("请选择年份");
		$("#rdate").show();
		error8 = 1;
	}else{
		error8 = 0;
		$("#rdate").hide();
		$("#eDatem").change();
	}
});

</script>