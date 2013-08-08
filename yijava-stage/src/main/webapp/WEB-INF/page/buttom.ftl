<script type="text/javascript" src="resource/js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="resource/css/jquery-ui.css">
<script>
initpage();
var islogin = false;
var userId = 0;
document.domain="cncnews.cn"


function getCookie(name){
 var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
 if(arr=document.cookie.match(reg))
  return unescape(arr[2]);
 else
  return null;
} 
function delCookie(objName) {
   var date = new Date();
   date.setTime(date.getTime() - 10000);
   document.cookie = objName + "=a;path=/;domain=cncnews.cn; expires=" + date.toGMTString();
}

 $(function() {
    $( "#dialog" ).dialog({
      autoOpen: false,
      height: 400,
      width: 500,
      modal: true
    });
    var shortname ="";
    var username = getCookie("uid");
    alert(username);
    if(username !='' && username != null ){
	 	   islogin(username);
    }
    
  });

 function islogin(username){
	var url = "http://login.cncnews.cn/user/islogin.cc?login_name="+username+"&callback=showData";
	$.getScript(url);
  }
  
  function showData(data){
  	alert(data);	
  	/*if(data.msg =="success"){
	  if(data.username.length >5){
		shortname = data.username.substring(0,5);
		$("#loginname").html(shortname);
	  }else{
		$("#loginname").html(data.username);
	  }
	  $("#loginname").attr("onclick","").attr("title",shortname);
	  $("#logout").html("退出");
	  $("#logout").attr("onclick","logout()");
	  var validateinfo = getCookie("validateinfo");
	  if(validateinfo == data.username){
		delCookie("validateinfo");
		filldata(validateinfo);      
	  }
	}*/
  	
 }
  
function logout(){
		delCookie("uname");
		delCookie("uid");
		window.location.reload();
  }

function filldata(username){
	var url = "http://login.cncnews.cn/user/tofilldata.cc?userName="+username ; 
	$("#cframe").attr("src",url);
	if($( "#dialog" ).css("display")=='none'||$( "#overlay" ).css("display")=='none'){
		$( "#dialog" ).css("display","block");
		$( "#overlay" ).css("display","block")
	}  
	$( "#dialog" ).dialog( "open" );
	return false;
 }

  
 function login(){ 	
  $("#cframe").attr("src","http://login.cncnews.cn/user/weblogin.cc");
  if($( "#dialog" ).css("display")=='none'||$( "#overlay" ).css("display")=='none'){
    $( "#dialog" ).css("display","block");
    $( "#overlay" ).css("display","block")
  }    
  $( "#dialog" ).dialog( "open" );  
  	return false;
 }
 
 function reg(){
  $("#cframe").attr("src","http://login.cncnews.cn/user/reg.cc");
  if($( "#dialog" ).css("display")=='none'||$( "#overlay" ).css("display")=='none'){
    $( "#dialog" ).css("display","block");
    $( "#overlay" ).css("display","block")
   }  
  $( "#dialog" ).dialog( "open" );
  return false;
 }
 </script>
<div id="dialog" title="">
<iframe id="cframe" src="" width="100%" height="100%" frameborder="0"  scrolling="no" frameborder="no" border="0" marginwidth="0" marginheight="0"></iframe>
</div>
<div class="pn_foot mb">
  <div class="wrap foot_list"><span>关联媒体</span><a href="#">新华网</a> <a href="#">新华08</a> <a href="#">参考消息</a> <a href="#">经济参考报</a> <a href="#">现代快报</a> <a href="#">中国证劵报</a> <a href="#">半月谈</a> <a href="#">瞭望</a> <a href="#">瞭望东方周刊</a> <a href="#">金融世界</a> <a href="#">中国记者</a> </div>
</div>
<div class="wrap">
  <div class="pn_foot_a">
    <p><a href="http://www.xhstv.com" target="_blank"><img src="resource/images/logo.png" width="188" height="35"></a></p>
    <ul>
      <li><a href="#">关于我们</a></li>
      <li><a href="#">新华通讯社</a></li>
      <li><a href="#">CNC公司网站</a></li>
      <li><a href="#">联系我们</a></li>
      <li><a href="#">法律条款</a></li>
      <li><a href="#">隐私政策</a></li>
    </ul>
  </div>
  <p class="pn_copy">本网站所刊登的各种视频，均为新华社版权所有，未经协议授权，禁止下载使用。Copyright @ 2009-2015 XHTV WEB ,All Rights Reserved.&nbsp;&nbsp;<a href="#">京备案ICP 09086651</a></p>
</div>
</div>
</div>
</body>
</html>