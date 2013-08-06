<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>VCS 用户登录</title>

<!-- 用于布局的css -->
<link href="resources/styles/layout.css" rel="stylesheet" type="text/css" />
<!-- 图标的css -->
<link href="resources/styles/icon.css" rel="stylesheet" type="text/css" />
<!-- 控件布局的css -->
<link href="resources/styles/component.css" rel="stylesheet" type="text/css" />

<!-- jquery 核心代码 -->
<script type="text/javascript" src="resources/scripts/jquery.core.js"></script>
<script type="text/javascript" src="resources/scripts/exit.jquery.extend.js"></script>
<script type="text/javascript" src="resources/scripts/exit.jquery.ui.js"></script>

<script type="text/javascript">
	function login(){
		$("#login_form").submit();
	}
	function reloadValidateCode() {
		$("#captchaImg").attr("src","getCaptcha?date = " + new Date() + Math.floor(Math.random()*24));
	}
</script>

</head>

<body>

	
</body>