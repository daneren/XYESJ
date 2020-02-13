<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML>
<html>
<head>
  <meta charset="utf-8">
  <meta name="renderer" content="webkit|ie-comp|ie-stand">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <!--[if lt IE 9]>
  <script type="text/javascript" src="lib/html5.js"></script>
  <script type="text/javascript" src="lib/respond.min.js"></script>
  <script type="text/javascript" src="lib/PIE_IE678.js"></script>
  <![endif]-->
  <link href="../css/H-ui.min.css" rel="stylesheet" type="text/css" />
  <link href="../css/H-ui.admin.css" rel="stylesheet" type="text/css" />
  <link href="../lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
  <!--[if IE 6]>
  <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
  <script>DD_belatedPNG.fix('*');</script>
  <![endif]-->
  <title>标签列表</title>
</head>
<body>
  <div class="cl pd-20" style=" background-color:#5bacb6">
    <img class="avatar size-XL l" src="images/user.png">
    <dl style="margin-left:80px; color:#fff">
      <dt>
        <span class="f-18">名称</span>
        <span class="pl-10 f-12">时间</span>
      </dt>
      <dd class="pt-10 f-12" style="margin-left:0">描述</dd>
    </dl>
  </div>
  <div class="pd-20">
    <table class="table">
      <thead>

        <tr class="text-c">
          <th width="100">标签编号</th>
          <th width="100">标签名称</th>
        </tr>
      </thead>

      <tbody>
        <tr class="text-c">
          <td>1</td>
          <td>
            标签名称
          </td>
         
        </tr>
      </tbody>
    </table>
  </div>
  <script type="text/javascript" src="../js/jquery.min.js"></script>
  <script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
  <script type="text/javascript" src="../lib/layer/1.9.3/layer.js"></script>
  <script type="text/javascript" src="../lib/My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
  <script type="text/javascript" src="../js/H-ui.js"></script>
  <script type="text/javascript" src="../js/H-ui.admin.js"></script>
  <script type="text/javascript">
$('.table-sort').dataTable({
  "aaSorting": [[ 1, "desc" ]],//默认第几个排序
  "bStateSave": true,//状态保存
  "aoColumnDefs": [
    //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
    {"orderable":false,"aTargets":[0,2,3,4,5,6,9,10,11]}// 制定列不参与排序
  ]
});

/*
  参数解释：
  title 标题
  url   请求的url
  id    需要操作的数据id
  w   弹出层宽度（缺省调默认值）
  h   弹出层高度（缺省调默认值）
*/
/*标签跳转*/
function userDemand_tag_show(title,url,w,h){

  layer_show(title,url,w,h);

}





</script>
</body>
</html>