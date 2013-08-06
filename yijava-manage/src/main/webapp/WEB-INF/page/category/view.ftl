<#assign no_visible_elements=false />
<#include "../header.ftl">
<div>
				<ul class="breadcrumb">
					<li>
						<a href="#">首页</a> <span class="divider">/</span>
					</li>
					<li>
						<a href="#">新闻分类管理</a>
					</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-user"></i> 新闻分类</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
								  <th>分类名称</th>
								  <th>创建时间</th>
								  <th>最后修改时间</th>								  
								  <th>Actions</th>
							  </tr>
						  </thead>   
						  <tbody>
						  <#list categorys as e>
							<tr>
								<td>${e.category}</td>
								<td class="center">${e.create_at}</td>
								<td class="center">${e.update_at}</td>
								
								<td class="center">
									<a class="btn btn-success" href="#">
										<i class="icon-zoom-in icon-white"></i>  
										View                                            
									</a>
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										Edit                                            
									</a>
									<a class="btn btn-danger" href="#">
										<i class="icon-trash icon-white"></i> 
										Delete
									</a>
								</td>
							</tr>
							</#list>
							
						  </tbody>
					  </table>       
						       
					</div>
				</div><!--/span-->
			
			</div><!--/row-->

			
<#include "../footer.ftl">
