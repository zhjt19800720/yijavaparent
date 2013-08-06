
	<script language="javascript">
			function initTrees() {
				$("#black").treeview({
					url: "http://localhost:8080/yijava-admin/channel/test"
				})
				
				
			}
			$(document).ready(function(){
				initTrees();
				
			});
				
		</script>

</head>

<body>

<div class="panel_title">
	 	<span class="user24_icon">栏目管理</span>
	</div>
	
	<div class="panel_content">
	  <#if message?has_content>
	  	  <div class="notification information">
	  	  	<a href="#" class="close"><img src="resources/images/icons/16/close.png" title="关闭信息" alt="关闭"></a>
	  	  	${message}
	  	  </div>
  	  </#if>
  	  
  	 
	<ul id="black">
	</ul>
	
	
	<div class="panel_footer">
		</div>