<script type="text/javascript" src="resource/js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="resource/css/jquery-ui.css">
<script>

 $(function() {
    $( "#dialog" ).dialog({
      autoOpen: false,
      height: 400,
      width: 500,
      modal: true
    });
  });

  
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
<iframe id="cframe" src="" width="100%" height="100%" scrolling="no" frameborder="no" border="0" marginwidth="0" marginheight="0"></iframe>
</div>
<div class="footer">
  <p>本网站所刊登的各种视频，均为新华社版权所有，未经协议授权，禁止下载使用。Copyright @ 2009-2015 XHTV WEB ,All Rights Reserved。</p>
  <p>京备案ICP 09086651</p>
</div>
</body>
</html>