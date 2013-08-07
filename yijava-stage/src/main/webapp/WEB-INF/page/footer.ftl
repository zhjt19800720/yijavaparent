<script type="text/javascript" src="resource/js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="resource/css/jquery-ui.css">
<script>
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
<iframe id="cframe" src="" width="100%" height="100%" scrolling="no" FRAMEBORDER=0 SCROLLING=NO frameborder="no" border="0" marginwidth="0" marginheight="0"></iframe>
</div>
<div class="footer">
  <p>本网站所刊登的各种视频，均为新华社版权所有，未经协议授权，禁止下载使用。Copyright @ 2009-2015 XHTV WEB ,All Rights Reserved。</p>
  <p>京备案ICP 09086651</p>
</div>
</body>
</html>