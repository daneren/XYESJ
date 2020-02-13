<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="row">
	<div class="col-sm-12">
		<div class="row" id="photo">
			<div class="col-xs-4 col-md-2">
				<label class="label-icon">照片</label>
			</div>
			<div id="divimg" class="col-xs-8 col-md-10">
				<img  id="img0" src="imgs/none_img.png"  class="img-thumbnail img-icon imgs" title="点击添加图片" alt="点击添加图片" />
			</div>
			<input name="inputimg0" type="file"  class="inputfile" id="inputimg0" style="height:0;width:0;z-index: -1;" />
		</div>
	</div>
</div>
<span class="span-remind-show" id="rimg"></span>
<script type="text/javascript">
	var imgid = "img0";
	var imgcount = $(".imgs").length;
	$(".imgs").live("click",function(){
	    imgid = this.id;
		$("#input"+imgid).click();
	});
	$(".inputfile").live("change",function() {
		PreviewImage(this);
		var co = imgcount -1;
		if(imgcount <4 && imgid.trim() == ("img"+co)){
			$("#divimg").append("<img id='img"+imgcount+"' src='imgs/none_img.png'  class='img-thumbnail img-icon imgs' title='点击添加图片' alt='点击添加图片'/>");		
			$("#photo").append("<input name='inputimg"+imgcount+"' class='inputfile' id='inputimg"+imgcount+"' type='file' style='height:0;width:0;z-index: -1;' />");
			imgcount ++;
		}	
		if(imgcount>1){
			error8 = 0;
			$("#rimg").hide();
		}
	});

/**预览图片*/

function PreviewImage(imgFile) {
	var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;
	if (!pattern.test(imgFile.value) && imgFile.value != "") {
		alert("系统仅支持jpg/jpeg/png/gif/bmp格式的照片！");
		imgFile.focus();
	} else {
		var path;
		if (document.all)//IE
		{
			imgFile.select();
			path = document.selection.createRange().text;
			document.getElementById(imgid).style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src=\""
					+ path + "\")";//使用滤镜效果
					
		} else//FF
		{
			path = URL.createObjectURL(imgFile.files[0]);
			document.getElementById(imgid).src = path;
		}
	}
}

</script>