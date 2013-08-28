<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resource/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="resource/themes/icon.css">
<link rel="stylesheet" type="text/css" href="resource/css/main.css">
<script type="text/javascript" src="resource/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="resource/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="resource/js/common.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="height: 60px; background: #ddd; padding: 10px">
		
		<div id="menu">
			<jsp:include page="menu.jsp"></jsp:include>
		</div>
	
	</div>
	<div data-options="region:'west',split:true,title:'公司信息'"
		style="width: 150px; padding: 10px;">west content
	</div>
	<div
		data-options="region:'east',split:true,collapsed:false,title:'待处理事项'"
		style="width: 100px; padding: 10px;">east region
		</div>
	<div data-options="region:'south',border:false"
		style="height: 20px; background: #ddd; padding: 10px;"></div>
	<div id="mainPanle" data-options="region:'center',title:''">
		<div id="tabs" class="easyui-tabs"  fit="true" border="false" >
		<div title="首页" data-options="iconCls:'icon-help',closable:false" style="padding:20px;overflow:hidden;" id="home">
				
			<h1>Welcome to jQuery UI!</h1>

			</div>
		</div>
	</div>
<script type="text/javascript">
$(document).ready(function(){
	$('#mm1').menu();  
});
</script>
</body>
</html>