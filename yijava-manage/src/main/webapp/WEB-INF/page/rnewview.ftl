<#assign no_visible_elements=false />
<#include "header.ftl">
<div>
				<ul class="breadcrumb">
					<li>
						<a href="#">首页</a> <span class="divider">/</span>
					</li>
					<li>
						<a href="#">新闻管理</a>
					</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-user"></i> 新闻</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<p class="left">
							<button class="btn" onclick="javascript:window.location.href='rnew-add'">添加</button>
						</p>
						<table class="table table-bordered">
						  <thead>
							  <tr>
								  <th>新闻标题</th>
								  <th>所述标签</th>
								  <th>时长</th>
								  <th>图片文件名称</th>
								  <th>新闻文件名称</th>
								  <th>创建时间</th>
								  <th>最后修改时间</th>
								  <th>排序号11</th>								  
								  <th>Actions</th>
							  </tr>
						  </thead>   
						  <tbody>
						  <#list page.result as e>
						  
							<tr>
								<td>${e.title!""}</td>
								<td class="center">
								 <#list e.categorys as value>  
							        ${value.category}|  
							    </#list>  
									
								</td>
								<td class="center">${e.duration!""}</td>
								<td class="center">${e.image_file!""}</td>
								<td class="center">${e.radio_file!""}</td>
								<td class="center">${e.create_date!""}</td>
								<td class="center">${e.last_date!""}</td>
								<td class="center">${e.seq_num!""}</td>
								<td class="center">									
									<a class="btn btn-info" href="rnew-read?id=${e.id!""}">
										<i class="icon-edit icon-white"></i>  
										Edit                                            
									</a>
									<a class="btn btn-danger" href="rnew-del?id=${e.id!""}">
										<i class="icon-trash icon-white"></i> 
										Delete
									</a>
								</td>
							</tr>
							</#list>
							
						  </tbody>
					  </table>       
					  <#if page.totalItems gt 0>
					  <div class="pagination pagination-left">
		    				每页显示:<input type="text" size="2" style="width:20px;" id="pageSize" name="pageSize"  value="${page.pageSize}"/> 共有${page.totalPages}页/${page.totalItems}条记录
		    				</div>
					  <div class="pagination pagination-centered">
					  		
						  <ul>
							<li><a href="rnew-view?pageSize=${page.pageSize}&pageNo=${page.prePage}">Prev</a></li>
							<#list page.getSlider(page.pageSize) as index>
							<li class="<#if page.pageNo == index>active</#if>">
							  <a href="rnew-view?pageSize=${page.pageSize}&pageNo=${index}">${index}</a>
							</li>
							</#list>							
							<li><a href="rnew-view?pageSize=${page.pageSize}&pageNo=${page.nextPage}">Next</a></li>
						  </ul>
						</div>     
					</#if>	       
					</div>
				</div><!--/span-->
			
			</div><!--/row-->
<script>
	$(document).ready(function(){
		$(".close").click(
			function () {
				$(this).parent().fadeTo(400, 0, function () {
					$(this).slideUp(400);
				});
				return false;
			}
		);
		$("#selectAll").click(function(){
			var checks = $("#resource_list tbody").find("input[type='checkbox'][id!='selectAll']");
			checks.attr('checked', $(this).is(':checked'));
			checks.click();
		});
	});
	
	function search(pageNo){
		param["pageSize"] = $("#pageSize").val();
		param["pageNo"] = pageNo || 1;
	}
</script>
			
<#include "footer.ftl">
