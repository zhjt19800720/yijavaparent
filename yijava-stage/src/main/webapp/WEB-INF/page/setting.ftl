<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>新华社首页</title>
<link href="resource/css/index_zh.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resource/js/index.js"></script>
<script src="resource/js/jquery.min.js"></script>
<script src="resource/js/common.js"></script>

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
<a id="loginname" href="javascript:void(0);" onclick="javascript:login();">登陆</a>
<a id="logout" href="javascript:void(0);" onclick="javascript:reg();">注册</a> 

<a href="javascript:;"  id="settingBtn">个性定制</a>
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
      <div class="focus_title"><a class="more" href="#">更多&gt;&gt;</a>
        <h2>我的关注</h2>
        <a href="#" class="focus_title_tage">美国</a></div>
      <div class="focus_img"><a href="#"><img src="resource/images/img03.jpg"></a></div>
      <ul class="focus_list">
        <li><span>13:05</span><a href="#">尼罗河畔的政治龙虎斗将演变成三国</a></li>
        <li><span>11:45</span><a href="#">法国前总理：任何政府都应尊重起码的</a></li>
        <li><span>10:18</span><a href="#">波波卡特佩特火山预警级别升至</a></li>
        <li><span>09:22</span><a href="#">网店出售“回心转意符”　一月卖70</a></li>
        <li><span>09:10</span><a href="#">婴幼儿奶粉　反式脂肪酸含量符合国</a></li>
      </ul>
    </div>
    
    <div class="region_news clearfix mb">
      <div class="overflow">
       <div class="region_news_item">
          <div class="weather clearfix" id="weatherinfo"><img id="weatherimg" src="resource/weather/" width="48" height="48">今天<br>
            </div>
          <div class="region" id="regionname"> -  </div>
        </div>
        <div class="region_news_item" id="region_new1">
          <dl>
            <dt><a href="#">善后工作组抵达旧金山</a></dt>
            <dd>外交部：韩亚航空坠机事故135名中国公民确认安全</dd>
          </dl>
        </div>
        <div class="region_news_item" id="region_new2">
          <dl>
            <dt><a href="#">善后工作组抵达旧金山</a></dt>
            <dd>外交部：韩亚航空坠机事故135名中国公民确认安全</dd>
          </dl>
        </div>
        <div class="region_news_item" id="region_new3">
          <dl>
            <dt><a href="#">善后工作组抵达旧金山</a></dt>
            <dd>外交部：韩亚航空坠机事故135名中国公民确认安全</dd>
          </dl>
        </div>
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


<p><img src="resource/img/cnn_016.jpg" width="300" height="220" /></p>



<div class="right_cnn">
<table width="300" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="35" colspan="2" background="resource/img/cnn_017.jpg"><b>CNC</b></td>
    </tr>
  <tr>
    <td width="60" height="31" align="center" bgcolor="#f7f7f7">电台</td>
    <td width="240" height="31"><a href="#">全球通金石财金</a><span>09:00-10:30</span></td>
  </tr>
  <tr>
      <td width="60" height="31" align="center" bgcolor="#f7f7f7">中文台</td>
    <td width="240" height="31"><a href="#">全球通金石财金</a><span>09:00-10:30</span></td>
  </tr>
  <tr>
     <td width="60" height="31" align="center" bgcolor="#f7f7f7"> 英文台</td>
    <td width="240" height="31"><a href="#">凤凰大视野:民国司法十案</a><span>09:00-10:30</span></td>
  </tr>
</table>
</div>


<div class="right_cnn">
<table width="300" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="35" colspan="2" bgcolor="#f6f6f6"><h3>24小时新闻</h3><span><a href="#">更多>></a></span></td>
    </tr>
  <tr>
    <td width="40" height="55" align="center"><strong>16:53</strong></td>
    <td width="260" height="58" align="left" valign="middle"><p><a href="#">对于网络曝光的相关问题，张少龙介绍通过网络曝光</a></p></td>
  </tr>
  <tr>
      <td width="40" height="55" align="center"><strong>15:50</strong></td>
    <td width="260" height="58" valign="middle"><p><a href="#">对于网络曝光的相关问题，张少龙介绍通过网络曝光</a></p></td>
  </tr>
  <tr>
     <td width="40" height="55" align="center"><strong>15:35</strong></td>
    <td width="260" height="58" valign="middle"><p><a href="#">对于网络曝光的相关问题，张少</a></p></td>
  </tr>
</table>
</div>
<div class="index_blank"></div>

<div class="main_right_cy">创意视频</div>
<div class="main_right_cu">
<ul>
<li><a href="#"><img src="resource/img/cnn_029.jpg" width="70" height="70" /></a><span><a href="#">做品牌文化宣传</a></span></li>
<li><a href="#"><img src="resource/img/cnn_029.jpg" width="70" height="70" /></a><span><a href="#">视台做品牌文化宣传</a></span></li>
<li><a href="#"><img src="resource/img/cnn_029.jpg" width="70" height="70" /></a><span><a href="#">电视台做文化宣传</a></span></li>
<li><a href="#"><img src="resource/img/cnn_029.jpg" width="70" height="70" /></a><span><a href="#">华社电视做文化宣传</a></span></li>
<li><a href="#"><img src="resource/img/cnn_029.jpg" width="70" height="70" /></a><span><a href="#">新华社电视牌文化宣传</a></span></li>
<li><a href="#"><img src="resource/img/cnn_029.jpg" width="70" height="70" /></a><span><a href="#">在电视台做文化宣传</a></span></li>
</ul>
</div>

<div class="main_right_wx"><img src="resource/img/cnn_030.jpg" width="300" height="438"></div>

<!--排行榜-->
<div class="main_right_hg">
<div id="Tab1">
<div class="Menubox">
<ul>
<li id="two1" onmouseover="setTab('two',1,2)"  class="hover">新闻1</li>
<li id="two2" onmouseover="setTab('two',2,2)" >新闻2</li>
</ul>
</div>
<div class="Contentbox">
<div id="con_two_1" >
<ul>
<li  class="con_two_red"><a href="#">件爱神的箭卡拉斯的就阿斯顿啊看来</a></li>
<li  class="con_two_red"><a href="#">神的箭卡拉斯的就阿斯顿啊看来</a></li>
<li  class="con_two_red"><a href="#">课件爱神的箭阿斯顿课件爱神的斯的就阿斯顿啊看来</a></li>
<li><a href="#">阿斯顿课件爱神的箭卡拉斯的就阿斯顿啊看来</a></li>
<li><a href="#">件爱神的箭卡拉斯的就阿斯顿啊看来</a></li>
<li><a href="#">斯顿课件爱神的箭卡拉斯的就阿斯顿啊看来</a></li>
<li><a href="#">爱神的箭卡拉斯的就阿斯顿啊看来</a></li>
<li><a href="#">箭卡拉斯的就阿斯顿啊看来</a></li>
<li><a href="#">件爱神的箭卡拉斯的就阿斯顿啊看来</a></li>
<li><a href="#">阿斯顿课件爱神的箭卡拉斯的就阿斯顿啊看来</a></li>
</ul>

</div>
<div id="con_two_2" style="display:none">

<ul>
<li  class="con_two_red"><a href="#">神的箭卡拉斯的就阿斯顿啊看来</a></li>
<li  class="con_two_red"><a href="#">神的箭卡拉斯的就阿斯顿啊看来</a></li>
<li  class="con_two_red"><a href="#">课件爱神的箭阿斯顿课件爱神的斯的就阿斯顿啊看来</a></li>
<li><a href="#">阿斯顿课件爱神的的就阿斯顿啊看来</a></li>
<li><a href="#">件爱神的箭卡拉斯的就阿斯顿啊看来</a></li>
<li><a href="#">斯顿课件爱神的箭卡拉斯的就阿斯顿啊看来</a></li>
<li><a href="#">爱神的箭卡拉斯的就阿斯顿啊看来</a></li>
<li><a href="#">箭卡拉斯的就阿斯顿啊看来</a></li>
<li><a href="#">件爱神的箭卡拉斯的就阿斯顿啊看来</a></li>
<li><a href="#">阿斯顿课件卡拉斯的就阿斯顿啊看来</a></li>
</ul>
</div>
</div>
</div>
</div>
<!--排行榜结束-->

<div class="main_right_cy">行情动态</div>
<div class="main_right_if"><iframe src="http://data.stock.hexun.com/quote2012/stock_1.htm" marginWidth=0 marginHeight=0 frameBorder=0 width=300 scrolling=no height=217 ></iframe></div>

<div class="main_right_cy">记录片</div>

<div class="main_right_jl">
<p><a href="#"><img src="resource/img/cnn_032.jpg" width="260" height="120" /></a><b><a href="#">环球聚焦 中国之路</a></b><span><a href="#">华尔地出面开记者会，闹出人命还笑着回答记者笑着回答记问题</a></span></p>
<div class="main_right_gf">
<ul>
<li><a href="#"><img src="resource/img/cnn_033.jpg" width="120" height="70" /></a><span><a href="#">台做品牌文化宣传</a></span></li>
<li><a href="#"><img src="resource/img/cnn_033.jpg" width="120" height="70" /></a><span><a href="#">视台做品牌文化宣传</a></span></li>
<li><a href="#"><img src="resource/img/cnn_033.jpg" width="120" height="70" /></a><span><a href="#">电视台做品牌文化宣传</a></span></li>
<li><a href="#"><img src="resource/img/cnn_033.jpg" width="120" height="70" /></a><span><a href="#">做品牌文化宣传</a></span></li>
</ul>
</div>


<div class="main_right_sy">
<h2><a href="#">纪录片分类索引</a></h2>
<div class="main_right_bv">

<div class="right_bv_f">
<h5><a href="#" target="_blank">记录中国</a> | <a href="#" target="_blank">军事风云</a> | <a href="#" target="_blank">传奇人物</a> | <a href="#" target="_blank">环球纵横</a> | <a href="#" target="_blank">历史人文</a></h5>
</div>
<div class="index_blank4"></div>

<div class="right_bv_f right_bv_t">
<h5><a href="#" target="_blank">记录中国</a> | <a href="#" target="_blank">军事风云</a> | <a href="#" target="_blank">传奇人物</a> | <a href="#" target="_blank">环球纵横</a> | <a href="#" target="_blank">历史人文</a></h5>
</div>
</div>
</div>
<div class="clear"></div>
</div>
</div>



</div>
<!--主题内容结束-->

<!--login-->
<script type="text/javascript" src="resource/js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="resource/css/jquery-ui.css">
<script>
initpage();
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
	  $("#loginname").attr("onclick","").attr("title",shortname);
	  $("#logout").html("退出");
	  $("#logout").attr("onclick","logout()");
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



<script type="text/javascript">
jQuery(function(jq){
	var rr = jq('#contentE');
	var conr = rr.find('div.con'),
		conr0 = conr[0],
		btnWr = rr.find('> div.btns'),
		btnPr = btnWr.find('a.up'),
		btnNr = btnWr.find('a.down');
	
	var lisr = conr.find('.left');
	
	conr.find(".bord").hover(function(){
		jq(this).addClass("bgBord");
	},function(){
		jq(this).removeClass("bgBord");
	});
	
	var pnumr = 6, numr = lisr.length;
	if(numr <= pnumr)return;
	
	var owr = lisr[1].offsetLeft - lisr[0].offsetLeft, 
		idxArear = [0, numr - pnumr],
		idxr = 0;
	
	function updateNum(n){
		if (n > idxArear[1] || n < idxArear[0]) {return;}
		
		btnPr[((n == 0)?'add':'remove') + 'Class']('uN');
		btnNr[((n == idxArear[1])?'add':'remove') + 'Class']('dN');
		
		idxr = n;
		conr.stop().animate({left: -n * owr},300);
	}
	
	btnPr.click(function(){
		updateNum(idxr - 1);
		return false;
	});
	btnNr.click(function(){
		updateNum(idxr + 1);
		return false;
	});
});
</script>
<div id="setting" class="popbox">
  <div class="followTage poptitle"><span class="r"><a href="#" class="pop_close close"></a><a href="#">修改注册信息</a></span><h4>我的CNC</h4></div>
  <div class="followTage"><strong>我的关注：</strong><span class="tage">无标签</span>&nbsp;您目前还没有标签，添加播放器上方的“彩色”标签，完成您的关注。</div>
  <div class="followTage"><strong>区域新闻：</strong>
    <select id="selRegion" name="selRegion">
    	 
       <#list provinces as e>
			<option value="${e!""}">${e!""}</option>
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
<script>
	 var allcolumns=new Array(${allcolumns?size});
	 <#if allcolumns??>
	 <#list allcolumns as c>
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
</script>
</body>
</html>
