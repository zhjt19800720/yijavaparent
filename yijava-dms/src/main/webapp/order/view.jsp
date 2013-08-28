<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="../resource/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../resource/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../resource/css/main.css">
<script type="text/javascript" src="../resource/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../resource/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../resource/js/common.js"></script>
</head>
<body LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>

	

		<div id="p" class="easyui-panel" title="">
			<div style="margin: 10px 0;"></div>
			<div style="padding-left: 10px; padding-right: 10px">

				<div class="easyui-panel" title="查询条件">
					<div style="padding: 10px 0 10px 60px">
						<form id="ff" method="post">
							<table>
								<tr>
									<td>Name:</td>
									<td><input class="easyui-validatebox" type="text"
										name="name" data-options="required:true"></input></td>
								
									<td>Email:</td>
									<td><input class="easyui-validatebox" type="text"
										name="email" data-options="required:true,validType:'email'"></input></td>
								
									<td>Subject:</td>
									<td><input class="easyui-validatebox" type="text"
										name="subject" data-options="required:true"></input></td>
								</tr>
								<tr>
									<td>Message:</td>
									<td><textarea name="message" style="height: 60px;"></textarea></td>
								
									<td>Language:</td>
									<td><select class="easyui-combobox" name="language"><option
												value="ar">Arabic</option>
											<option value="bg">Bulgarian</option>
											<option value="ca">Catalan</option>
											<option value="zh-cht">Chinese Traditional</option>
											<option value="cs">Czech</option>
											<option value="da">Danish</option>
											<option value="nl">Dutch</option>
											<option value="en" selected="selected">English</option>
											<option value="et">Estonian</option>
											<option value="fi">Finnish</option>
											<option value="fr">French</option>
											<option value="de">German</option>
											<option value="el">Greek</option>
											<option value="ht">Haitian Creole</option>
											<option value="he">Hebrew</option>
											<option value="hi">Hindi</option>
											<option value="mww">Hmong Daw</option>
											<option value="hu">Hungarian</option>
											<option value="id">Indonesian</option>
											<option value="it">Italian</option>
											<option value="ja">Japanese</option>
											<option value="ko">Korean</option>
											<option value="lv">Latvian</option>
											<option value="lt">Lithuanian</option>
											<option value="no">Norwegian</option>
											<option value="fa">Persian</option>
											<option value="pl">Polish</option>
											<option value="pt">Portuguese</option>
											<option value="ro">Romanian</option>
											<option value="ru">Russian</option>
											<option value="sk">Slovak</option>
											<option value="sl">Slovenian</option>
											<option value="es">Spanish</option>
											<option value="sv">Swedish</option>
											<option value="th">Thai</option>
											<option value="tr">Turkish</option>
											<option value="uk">Ukrainian</option>
											<option value="vi">Vietnamese</option></select></td>
								</tr>
							</table>
						</form>
					</div>
					<div style="text-align: center; padding: 5px">
						<a href="javascript:void(0)" class="easyui-linkbutton"
							onclick="submitForm()">Submit</a> <a href="javascript:void(0)"
							class="easyui-linkbutton" onclick="clearForm()">Clear</a>
					</div>
				</div>

			</div>


			<div style="margin: 10px 0;"></div>

			<div style="padding-left: 10px; padding-right: 10px">


				<table id="dg" title="查询结果" style="height: 250px"
					data-options="rownumbers:true,singleSelect:true,pagination:true,url:'http://localhost:8080/yijava-dms/api/user/test',method:'get'">
					<thead>
						<tr>
							<th data-options="field:'id',width:80">Item ID</th>
							<th data-options="field:'username',width:100">Product</th>
							<th data-options="field:'password',width:80,align:'right'">List
								Price</th>
							<th data-options="field:'realname',width:80,align:'right'">Unit
								Cost</th>
							<th data-options="field:'state',width:240">Attribute</th>
							<th data-options="field:'email',width:60,align:'center'">Status</th>
						</tr>
					</thead>
				</table>

			</div>
			<div style="margin: 10px 0;"></div>
		</div>

	<script type="text/javascript">
		$(function() {
			var pager = $('#dg').datagrid().datagrid('getPager'); // get the pager of datagrid
			pager.pagination({
				buttons : [ {
					iconCls : 'icon-search',
					handler : function() {
						alert('search');
					}
				}, {
					iconCls : 'icon-add',
					handler : function() {
						alert('add');
					}
				}, {
					iconCls : 'icon-edit',
					handler : function() {
						alert('edit');
					}
				} ]
			});
		})
	</script>

	<script type="text/javascript"> 
		$(function(){ 
		$("#tabs").tabs({ 
		width:$("#tabs").parent().width(), 
		height:$("#tabs").parent().height() 
		}); 
		}); 
</script>
</body>
</html>