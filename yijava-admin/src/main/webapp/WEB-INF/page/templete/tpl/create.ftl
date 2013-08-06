<div id="create_form" class="form_widget">
	<form id="templete_form" action="templete/tpl/insert" method="post">
	    <div class="column">
	        <label for="filename">
				文件名:
	        </label>
	        <div class="field">
	            <input type="text" id="filename" name="filename" placeholder="模板文件名称" class="text_input_big required"  size="25" />
	        </div>
	        <label for="filepath">
				文件路径:
	        </label>
	        <div class="field">
	            <input type="text" id="filepath" name="filepath" class="text_input_big" size="25" />
	        </div>
	    </div>
	   <div class="column">
	    	<label for="remark">
	    		备注:
	    	</label>
	    	<div class="field">
	    		 <input type="text" id="icon" name="remark" class="text_input_big" size="66"  />
	    	</div>
	    </div>
	</form>
	<div class="clear">
		<a href="javascript:$.form.resetForm('#templete_form')" title="清空表单"><span class="button right">重 置</span></a>
		<a href="javascript:$.form.submitMaskForm('#templete_form',{maskEl:'#create_user',target:'#main_content',resetForm:true});" title="保存信息"><span class="button right">保 存</span></a>
	</div>
</div>