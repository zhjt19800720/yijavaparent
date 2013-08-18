<#assign no_visible_elements=false />
<#include "header.ftl">	
<div>
				<ul class="breadcrumb">
					<li>
						<a href="#">首页</a> <span class="divider">/</span>
					</li>
					<li>
						<a href="#">添加新闻</a>
					</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-edit"></i> 新闻</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form class="form-horizontal" action="rnew-save"  method="POST" enctype="multipart/form-data">
						
						  <fieldset>
							
							<div class="control-group">
							  <label class="control-label" for="typeahead">新闻标题</label>
							  <div class="controls">
								<input type="text" class="span6 typeahead" id="title" name="title">								
							  </div>
							</div>
							
							<div class="control-group">
							  <label class="control-label" for="typeahead">标签</label>
							  <div class="controls">
							  
							<#list catelist as e>
									<label class="checkbox inline">
									
									<input type="checkbox" id="categorys" name="categorys" value="${e.id!""}">${e.category!""}
								  </label>
								</#list>
							 </div>
							</div>
													
							
							
							
							<div class="control-group">
							  <label class="control-label" for="file">上传新闻图片文件</label>
							  <div class="controls">
								<input class="input-file uniform_on" id="file" name="file" type="file">
								或者直接填写文件名称：
								<input class="input-file uniform_on" id="imgfilename" name="imgfilename" type="text">
							  </div>
							</div>    
							  
							  <div class="control-group">
							  <label class="control-label" for="file">上传音频文件</label>
							  <div class="controls">
								<input class="input-file uniform_on" id="file" name="file" type="file">
								或者直接填写文件名称：
								<input class="input-file uniform_on" id="audiofilename" name="audiofilename" type="text">
							  </div>
							</div>    
							
							
							
							<div class="control-group">
							  <label class="control-label" for="duration">播放时长</label>
							  <div class="controls">
								<input type="text" class="span6 typeahead" id="duration" name="duration">								
							  </div>
							</div>
							
							<div class="control-group">
							  <label class="control-label" for="duration">排序号</label>
							  <div class="controls">
								<input type="text" class="span6 typeahead" id="seq_num" name="seq_num" maxlength="3">								
							  </div>
							</div>
							
							<div class="form-actions">
							  <button type="submit" class="btn btn-primary">Save changes</button>
							  <button type="reset" class="btn">Cancel</button>
							</div>
						  </fieldset>
						</form>   

					</div>
				</div><!--/span-->

			</div><!--/row-->
<#include "footer.ftl">