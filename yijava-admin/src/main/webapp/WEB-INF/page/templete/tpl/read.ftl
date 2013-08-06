<div id="update_tpl" class="form_widget">
	<form id="tpl_form" action="templete/tpl/update" method="post">
		<input type="hidden" name="id" value="${entity.id!""}" />
	    <div class="column">
	        <label for="filename">
				文件名:
	        </label>
	        <div class="field">
	            <input type="text" readonly="filename" id="filename" name="filename" class="text_input_big" size="25" value="${entity.filename!""}"/>
	        </div>
	        <label for="filepath">
				文件路径:
	        </label>
	        <div class="field">
	            <input type="text" id="filepath" name="filepath" class="text_input_big" size="25" value="${entity.filepath!""}"/>
	        </div>
	    </div>
	    <div class="column">
	        <label for="remark">
				备注:
	        </label>
	        <div class="field">
	          <input type="text" id="remark" name="remark" class="text_input_big" size="25" value="${entity.remark!""}" />
	        </div>
	       
	    </div>	   
	</form>
	<div class="clear">
		<a href="javascript:$.form.resetForm('#tpl_form')" title="清空表单"><span class="button right">重 置</span></a>
		<a href="javascript:$.form.submitMaskForm('#tpl_form',{maskEl:'#update_user',target:'#main_content'});" title="保存信息"><span class="button right">保 存</span></a>
	</div>
</div>