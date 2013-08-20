<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>新华社首页</title>
<link href="resource/css/index_zh.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resource/js/index.js"></script>
<script src="resource/js/jquery.min.js"></script>
<script src="resource/js/common.js"></script>
<script src="resource/js/newutils.js"></script>
<style type="text/css">
#gotopbtn{width:26px;height:89px;background:url(resource/img/topback.gif);position:fixed;bottom:50px;right:90px;display:none;cursor:pointer;}
*html,*html body /* 修正IE6振动bug */{background-image:url(about:blank);background-attachment:fixed;}
*html #gotopbtn /* IE6 头部固定 */{position:absolute;margin:435px 0 0 0;top:expression(eval(document.documentElement.scrollTop));}
</style>

<script type="text/javascript">
function initArray(){
  for(i=0;i<initArray.arguments.length;i++)
  this[i]=initArray.arguments[i];
}

var isnMonths=new initArray("1","2","3","4","5","6","7","8","9","10","11","12");
var isnDays=new initArray("星期日","星期一","星期二","星期三","星期四","星期五","星期六","星期日");
today=new Date();
hrs=today.getHours();
min=today.getMinutes();
sec=today.getSeconds();
clckh=""+((hrs>12)?hrs-12:hrs);
clckm=((min<10)?"0":"")+min;clcks=((sec<10)?"0":"")+sec;
clck=(hrs>=12)?"下午":"上午";
var stnr="";
var ns="0123456789";
var a="";

function getFullYear(d){
  yr=d.getYear();
  if(yr<1000)
  yr+=1900;
  return yr;
}

</script>

</head>

<body>

<!--顶部开始-->
<div class="index_top">
<div class="top_lay">
<p>新华社电视 CNC网络互动媒体</p>
<h2>
<script type="text/javascript">
document.write("<div class='time'>"+(getFullYear(today)+"").substring(0,4)+"-"+(today.getMonth()+01)+"-"+today.getDate()+"</div>");
</script></h2>
<div class="login">
<a href="#">设为首页</a>
<a href="#">收藏</a>
<a href="javascript:;" class="setting" id="settingBtn" style="display:block">个性定制</a>
<a id="loginname" href="javascript:void(0);" onclick="javascript:login();">登陆</a>
<a id="logout" href="javascript:void(0);" onclick="javascript:reg();">注册</a> 
</div>
</div>
</div>
<!--顶部结束-->

<!--logo-->
<div class="index_logo">
<div class="logo_av">
<p><a href="#"><img src="resource/img/cnn_011.jpg" width="191" height="36"alt="新华社电视 CNC网络互动媒体" title="新华社电视 CNC网络互动媒体" /></a></p>
        <ul>
        <li><a href="#">CNCWORLD</a></li>
        <li><a href="#">直播</a></li>
        <li><a href="#">电台</a></li>
        <li><a href="#">纪录片</a></li>
        <li><a href="#">图片</a></li>
        <li><a href="#">体育</a></li>
        <li><a href="#">文娱</a></li>
        <li><a href="#">财经 </a></li>
        <li><a href="#">新闻</a></li>
        <li><a href="#">首页</a></li>
        </ul>
</div>
<div class="clear"></div>
</div>
<!--logo结束-->


<div class="index_banner"><img src="resource/img/cnn_012.jpg" width="966" height="85" alt="banner" title="新华社电视 CNC网络互动媒体" /></div>



<!--主题内容-->
<div class="index_main">
<div class="zuhe_zong">
<div class="cjing_main_left">


 	<div class="focus_news clearfix mb">
 		<div id="scribenew">
 			<div class="focus_title" id="focus_title" style="display:none">
 				<h2>我的关注</h2>
 				<a href="http://search.cncnews.cn/search?" class="focus_title_tage">${scribename!""}</a>
 			</div>
     	</div>
    </div>
    
    <div class="region_news clearfix mb">
    	
      <div class="overflow" >
       
       		<div id="weathinfo"></div>
       		<div id="regioninfo"></div>
      </div>
    </div>

<div id="newscolumn">
	
</div>








</div>
</div>





<!--右-->
<div class="main_right">     

<div class="cjing_search">
<h5><input type="text" name="movieAlias"  value="新闻搜索"  class="inpsty2"  /><span><input name="" type="button" class="button2" value="搜索" /></span></h5>
</div>

<!--广告1 start-->
<p><img src="resource/img/cnn_016.jpg" width="300" height="220" /></p>
<!--广告1 end-->
<!--24小时新闻 start-->
<#include "inc/24hour.inc">	
<!--24小时新闻 end-->
<!--广告2 start-->
<!--div class="main_right_wx"><img src="resource/img/cnn_030.jpg" width="300" height="438"></div-->
<!--广告2 end-->
<!--排行-->
<#include "inc/toplist.inc">
<!--行情动态-->
<#include "inc/trends.inc">
</div>
<!--主题内容结束-->

<!--login-->
<script type="text/javascript" src="resource/js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="resource/css/jquery-ui.css">
<script>

//var islogin = false;
var userId = 0;
//document.domain="cncnews.cn"


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
   
    if(username !='' && username != null ){
	 	   islogin(username);
    }else
    {
    	//login();
    }
    
  });

 function islogin(username){
	var url = "http://login.cncnews.cn/user/islogin.cc?login_name="+username+"&callback=showData";
	$.getScript(url);
  }
  
  function showData(data){
  
  	if(data.msg =="success"){
	  if(data.username.length >5){
		shortname = data.username.substring(0,5);
		$("#loginname").html(shortname);
	  }else{
		$("#loginname").html(data.username);
	  }
	  userId=data.userid;
	  $("#loginname").attr("onclick","").attr("title",shortname);
	  $("#logout").html("退出");
	  $("#logout").attr("onclick","logout()");
	  
	  //初始化页面信息start
	  initpage();
	  //显示定制
	  showcustom();
	  //初始化页面信息end
	  
	  var validateinfo = getCookie("validateinfo");
	  if(validateinfo == data.username){
		delCookie("validateinfo");
		filldata(validateinfo);      
	  }
	}
  	
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

<div class="index_mtg">
<div class="mtg_mt">
<p><b>关联媒体</b><a href="#">新华网</a><a href="#">新华网08</a><a href="#">经济参考报</a><a href="#">参考消息</a><a href="#">中国证劵报</a><a href="#">中国记者</a><a href="#">金融世界</a><a href="#">瞭望</a><a href="#">参考消息</a><a href="#">中国证劵报</a><a href="#">中国记者</a></p>
</div>
</div>

<!--尾-->
<div class="index_foot">
<div class="foot_zh">
<p><a href="#"><img src="resource/img/cnn_011.jpg" width="191" height="36" /></a><span><a href="#">隐私政策</a><a href="#">法律条款</a><a href="#">联系我们</a><a href="#">CNC公司网站</a><a href="#">新华通讯社</a><a href="#">关于我们</a></span></p>
</div>
<div class="foot_bq"><p>本站所刊登的新华社及新华网各种新闻﹑未经协议授权禁止下载使用 Copyright ? 2000-2013 XINHUANET.com All Rights Reserved.</p></div>
</div>


<div id="gotopbtn">&nbsp;</div>
<script type="text/javascript">
backTop=function (btnId){
	var btn=document.getElementById(btnId);
	var d=document.documentElement;
	window.onscroll=set;
	btn.onclick=function (){
		btn.style.display="none";
		window.onscroll=null;
		this.timer=setInterval(function(){
			d.scrollTop-=Math.ceil(d.scrollTop*1);
			if(d.scrollTop==0) clearInterval(btn.timer,window.onscroll=set);
		},10);
	};
	function set(){btn.style.display=d.scrollTop?'block':"none"}
};
backTop('gotopbtn');
</script>



<!--setting start-->
<div id="setting" class="popbox">
  <div class="followTage poptitle"><span class="r"><a href="#" class="pop_close close"></a><a href="#">修改注册信息</a></span><h4>我的CNC</h4></div>
  <div class="followTage" id="scribename"><strong>我的关注：</strong>
  <#if scribename??>
  	<span class="tage" >${scribename!""}</span>
  	<#else>&nbsp;您目前还没有标签，添加播放器上方的“彩色”标签，完成您的关注。
  </#if>
  </div>
  <div class="followTage"><strong>区域新闻：</strong>
    <select id="selRegion" name="selRegion">
    	 
       <#list provinces as e>
			<option value="${e!""}" <#if userCustom??><#if (userCustom.region_name==e)> checked</#if></#if>
			>${e!""}</option>
		</#list>	
      </select>
    &nbsp;设置您的区域，获得身边新闻。</div>
  <div class="followTage"> <strong>栏目定制：</strong></div>
  <div class="myTageList" id="myTageList"><#if customs??><#list customs as c><span class="myTage"><a href="javascript:;" class="remove" data-column="${(c.column_id)!""}"></a>${(c.column_name)!""}</span></#list></#if></div>
	<div id="addButton">
    <table>
     <#list channels as e>
      <tr>
        <th>${(e.channel_name)!""}：</th>
        <td>
        <ul class="tageList">
        	<#list e.columns as c>
            <li><a href="javascript:;" data-column="${(c.column_id)!""}" <#if c.customed > class="have" </#if>>${(c.column_name)!""}</a></li>             
            </#list>	            
          </ul>
         </td>
      </tr>
     </#list>      
    </table>
</div>
</div>
<!--setting end-->
<script>
	 <#if allnosetcolumns??>
	 var allcolumns=new Array(${allnosetcolumns?size});	
	 <#list allnosetcolumns as c>
	 		allcolumns[${c_index}]=new Array(3);
	 		allcolumns[${c_index}][0]="${(c.column_id)!""}";
	 		allcolumns[${c_index}][1]="${(c.column_url)!""}";
	 		allcolumns[${c_index}][2]="${(c.column_name)!""}";	 	 	
	 </#list>
	 </#if>
	 
	var colstyle=new Array(8); 
	colstyle[0] = new Array();
	colstyle[0][0] = new Array('124020580','124020650','124020731');
	colstyle[0][1] = "Style1";
	colstyle[1] = new Array();
	colstyle[1][0] = new Array('124020581','124020810');
	colstyle[1][1] = "Style2";
	colstyle[2] = new Array();
	colstyle[2][0] = new Array('124020582','124020730');
	colstyle[2][1] = "Style3";
	colstyle[3] = new Array();
	colstyle[3][0] = new Array('124020583','124020621','124020734');
	colstyle[3][1] = "Style4";
	colstyle[4] = new Array();
	colstyle[4][0] = new Array('124020584','124020733','124020732','124020825');
	colstyle[4][1] = "Style5";
	colstyle[5] = new Array();
	colstyle[5][0] = new Array('124020651','124020729','124020826');
	colstyle[5][1] = "Style6";
	colstyle[6] = new Array();
	colstyle[6][0] = new Array('124020652','124020824');
	colstyle[6][1] = "Style7";
	colstyle[7] = new Array();
	colstyle[7][0] = new Array('124020773','124020827');
	colstyle[7][1] = "Style8";
	
	var style7sum=0;
	var varscribename="";
	var usersetcolumns="";
	
</script>
</body>
</html>
