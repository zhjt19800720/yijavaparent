<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="padding: 5px; width: 600px;">
	<a href="javascript:void(0)" id="mb1" class="easyui-menubutton"
		data-options="menu:'#mm1',iconCls:'icon-filep'">系统管理</a> <a
		href="javascript:void(0)" id="mb2" class="easyui-menubutton"
		data-options="menu:'#mm2',iconCls:'icon-filep'">基础信息维护</a>
</div>
<div id="mm1" style="width: 150px;">
	<div data-options="iconCls:'icon-file'">
		<a href="javascript:void(0)" title="订单管理" url="user/view.jsp">用户管理</a>
	</div>
	<div data-options="iconCls:'icon-file'">
		<a href="javascript:void(0)" title="订单管理"
			url="foundation/data-dictionary/view.jsp">数据字典管理</a>
	</div>
	<div data-options="iconCls:'icon-file'">
		<a href="javascript:void(0)" title="订单管理"
			url="foundation/dictionary-category/view.jsp">字典类别管理</a>
	</div>

</div>
<div id="mm2" style="width: 100px;">
	<div data-options="iconCls:'icon-file'">
		<a href="javascript:void(0)" title="医院信息维护"
			url="base/hospital/view.jsp">医院信息维护</a>
	</div>
	<div data-options="iconCls:'icon-file'">
		<a href="javascript:void(0)" title="经销商基础信息维护"
			url="foundation/dictionary-category/view.jsp">经销商基础信息维护</a>
	</div>
	<div data-options="iconCls:'icon-file'">
		<a href="javascript:void(0)" title="经销商基础信息维护"
			url="foundation/dictionary-category/view.jsp">经销商授权信息维护</a>
	</div>
</div>
