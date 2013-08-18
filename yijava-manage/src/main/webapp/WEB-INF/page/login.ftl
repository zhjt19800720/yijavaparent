<#assign no_visible_elements=true />
<#include "header.ftl">
			<div class="row-fluid">
				<div class="span12 center login-header">
					<h2>Welcome to Charisma</h2>
				</div><!--/span-->
			</div><!--/row-->
			
			<div class="row-fluid">
				<div class="well span5 center login-box">
					<div class="alert alert-info" id="alertinfo">
						Please login with your Username and Password.
					</div>
					<form class="form-horizontal" action="checklogin" method="post">
						
						<fieldset>
							<div class="input-prepend" title="Username" data-rel="tooltip">
								<span class="add-on"><i class="icon-user"></i></span><input autofocus class="input-large span10" name="username" id="username" type="text" value="admin" />
							</div>
							
							<div class="clearfix"></div>

							<div class="input-prepend" title="Password" data-rel="tooltip">
								<span class="add-on"><i class="icon-lock"></i></span><input class="input-large span10" name="password" id="password" type="password" value="111111" />
							</div>
							<div class="clearfix"></div>

							<div class="input-prepend">
							<label class="remember" for="remember"><input type="checkbox" id="remember" />Remember me</label>
							</div>
							<div class="clearfix"></div>

							<p class="center span5">
							<button type="button" id="btnLogin" class="btn btn-primary">Login</button>
							</p>
						</fieldset>
					</form>
				</div><!--/span-->
			</div><!--/row-->
<#include "footer.ftl">
<script language="javascript">
	$(document).ready(function(){ 
		
		
	}); 

	$(function() {
	    $('#btnLogin').click(function() {	
	    	
	        uname = $("#username").val(),	         
	        password = $("#password").val()
	        var params = "username="+uname+"&password="+password;
	        $.ajax({
			url:"checklogin",
			data: params,
			success:function(msg){	
									
				if(msg.state==1)
				{
					window.location.href='index'; // 跳转到B目录
				}else
				{
					
					$("#alertinfo").html(msg.error.msg);
					
				}			
						
			},
			error: function () {//ajax请求错误的情况返回超时重试。
                alert("error");
            }
		});	        
	    });
	});
	
	
</script>