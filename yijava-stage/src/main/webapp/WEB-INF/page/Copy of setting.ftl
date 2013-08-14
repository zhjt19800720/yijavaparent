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

<!--国际新闻-->
<div class="cjing_left_gj">
<p><b>内容名称</b><span><a href="#">更多>></a></span></p>
</div>
<div class="left_gj_mj">
<div class="gj_mj_left">
<h3><a href="#"><img src="resource/img/cnn_040.jpg" width="150" height="90" /></a><span><a href="#">菲总:统府记者会拒绝回应枪杀台湾渔民事件</a></span></h3>
<h3 class="mi_zp"><a href="#"><img src="resource/img/cnn_040.jpg" width="150" height="90" /></a><span><a href="#">菲总:统府记者会拒绝回应枪杀台湾渔渔渔渔民事件</a></span></h3>
</div>
<div class="gj_mj_right">
<p><b><a href="#">台湾“中央社”报道，台“总统府”发言人15日说马英九对菲律宾政府授权不够、诚意不够</a></b><span><a href="#">刻采取冻结菲劳申等项</a><br /><a href="#">采取冻结菲劳申请等项撒的刻录机的制裁措施</a><br /><a href="#">即刻采取冻结菲劳申请等3项制裁措施</a><br /><a href="#">菲劳申请等3项制裁措施制裁措施。</a></span></p>
</div>
</div>


<!--亚洲-->
<div class="cjing_left_gj">
<p><b>亚洲</b><span><a href="#">更多>></a></span></p>
</div>
<div class="left_gj_mj">
<div class="gj_mj_left">
<h2><a href="#"><img src="resource/img/cnn_041.jpg" width="320" height="185" /></a></h2>
</div>
<div class="mj_right_hj">
<p><b><a href="#">取冻结菲劳申请等项撒的刻录机</a><br /><strong>发言人15日说马英九对菲律宾政府授权不够、诚意不够</strong></b><span><a href="#">刻采取冻结菲劳申等项</a><br /><a href="#">采取冻结菲劳申请等项撒的刻录机的制裁措施</a><br /><a href="#">即刻采取冻结菲劳申请等3项制裁措施</a></span></p>
</div>
</div>


<!--金融市场-->
<div class="cjing_left_gj">
<p><b>金融市场</b><span><a href="#">更多>></a></span></p>
</div>
<div class="cjing_left_jr">
<ul>
<li><a href="#"><img src="resource/img/cnn_042.jpg" width="150" height="90" /></a><span><a href="#">台湾渔民事件菲律宾总统就射道歉</a><strong>菲律宾总统发言人陈显达15日下午声称菲总统阿基诺已向遇难台湾渔民的家属以及台湾人民就这起不幸的</strong></span></li>
<li class="left_jrpl"><a href="#"><img src="resource/img/cnn_042.jpg" width="150" height="90" /></a><span><a href="#">台湾渔民事件菲律宾总统就射道歉</a><strong>菲律宾总统发言人陈显达15日下午声称菲总统阿基诺已向遇难台湾渔民的家属以及台湾人民就这起不幸的</strong></span></li>
<li class="left_jrpl"><a href="#"><img src="resource/img/cnn_042.jpg" width="150" height="90" /></a><span><a href="#">台湾渔民事件菲律宾总统就射道歉</a><strong>菲律宾总统发言人陈显达15日下午声称菲总统阿基诺已向遇难台湾渔民的家属以及台湾人民就这起不幸的</strong></span></li>
<li class="left_jrpl"><a href="#"><img src="resource/img/cnn_042.jpg" width="150" height="90" /></a><span><a href="#">台湾渔民事件菲律宾总统就射道歉</a><strong>菲律宾总统发言人陈显达15日下午声称菲总统阿基诺已向遇难台湾渔民的家属以及台湾人民就这起不幸的</strong></span></li>
</ul>
</div>

<!--基金/理财-->
<div class="cjing_left_gj">
<p><b>基金/理财</b><span><a href="#">更多>></a></span></p>
</div>

<div class="cjing_left_lc">
<h1><a href="#">台湾军演启动 军舰越过对菲“暂定执法线”</a></h1>
<div class="left_lc_left"><a href="#"><img src="resource/img/cnn_043.jpg" width="150" height="90" /></a></div>
<div class="left_lc_right">
<p>据台湾TVBS报道，台湾防务部门与海巡部门在台湾岛南方海域举行联合演习已经启动，16日凌晨3点50分左右，台湾海军纪德舰已经越过对菲“暂定执法线</p>
<ul>
<li><a href="#">纪德舰会继续往南行到大约165海里的地方，也就是约北纬19度左右，</a></li>
<li><a href="#">纪德舰会继续往南行到大约165海里的地方，也就是约北纬19度左右，而在这附近有许</a></li>
</ul>
</div>
</div>


<div class="cjing_left_lc">
<h1><a href="#">台湾军演启动 军舰越过对菲“暂定执法线”</a></h1>
<div class="left_lc_left"><a href="#"><img src="resource/img/cnn_043.jpg" width="150" height="90" /></a></div>
<div class="left_lc_right">
<p>据台湾TVBS报道，台湾防务部门与海巡部门在台湾岛南方海域举行联合演习已经启动，16日凌晨3点50分左右，台湾海军纪德舰已经越过对菲“暂定执法线</p>
<ul>
<li><a href="#">纪德舰会继续往南行到大约165海里的地方，也就是约北纬19度左右，</a></li>
<li><a href="#">纪德舰会继续往南行到大约165海里的地方，也就是约北纬19度左右，而在这附近有许</a></li>
</ul>
</div>
</div>





<!--公司行业-->
<div class="cjing_left_gj">
<p><b>公司行业</b><span><a href="#">更多>></a></span></p>
</div>
<div class="cjing_left_jr">
<div class="cjing_left_jr_a">
<p><a href="#"><img src="resource/img/cnn_042.jpg" width="150" height="90" /></a><i></i><b><a href="#">四大皆空速度快</a></b><span><strong>菲律宾总统发言人陈显达15日下午声称菲总统阿基诺已向遇难台湾就这起不幸的</strong></span></li></p></div>

<div class="cjing_left_jr_a left_jrpl">
<p><a href="#"><img src="resource/img/cnn_042.jpg" width="150" height="90" /></a><i></i><b><a href="#">度快四大皆空速度快</a></b><span><strong>菲律宾总统发言人陈显达15日下午声称菲总统阿基诺已向遇难台湾渔民的家属以的</strong></span></li></p></div>

<div class="cjing_left_jr_a left_jrpl">
<p><a href="#"><img src="resource/img/cnn_042.jpg" width="150" height="90" /></a><i></i><b><a href="#">速度快四大皆空速度快</a></b><span><strong>菲律宾总统发言人陈显达15日下午声称菲总统阿基诺已向遇难台湾渔民的家属</strong></span></li></p></div>

<div class="cjing_left_jr_a left_jrpl">
<p><a href="#"><img src="resource/img/cnn_042.jpg" width="150" height="90" /></a><i></i><b><a href="#">大皆空速度快</a></b><span><strong>菲律宾总统发言人陈显达15日下午声称菲总统阿基诺已向遇难台湾渔台</strong></span></li></p></div>
</div>





<!--名人明星-->
<div class="cjing_left_gj">
<p><b>名人明星</b><span><a href="#">更多>></a></span></p>
</div>
<div class="guonei_jqu">
<div class="guonei_jqu_z">
<p><a href="#"><img src="resource/img/cnn_041.jpg" width="320" height="170" /></a><i>提高扩容的背后，最大的无奈在于门票收入分成部分</i><b><a href="#">景区“涨价潮”折射式中国“门票经济”</a></b></p>
</div>
<div class="guonei_jqu_z guonei_jqu_y">
<p><a href="#"><img src="resource/img/cnn_041.jpg" width="320" height="170" /></a><i>提高扩容的背后，最大的无奈在于门票收入分成部分</i><b><a href="#">景区“涨价潮”折射式中国“门票经济”</a></b></p>
</div>
<div class="clear"></div>
</div>



<!--影视天地-->
<div class="cjing_left_gj">
<p><b>影视天地</b><span><a href="#">更多>></a></span></p>
</div>
<div class="wenyu_luh">
<div id="contentE" class="area">
<div class="cons">
<div class="con" style="left: 0px;"><!--调整第一个显示位置请修改"left:0px;的值"，技术教程网修改整理，转载请注明谢谢合作！-->
<div class="left wdA">

<div class="tBG"></div>
<div class="bord">
<div class="pic"><a href="#" target="_blank"><img alt="" src="resource/img/wenyu_015.jpg" width="150" height="90"></a><span><strong><a href="#" target="_blank">飞一咕咕是一只咕咕是一只般爱情小说</a></strong></span></div>
<div class="line"></div>
</div></div>

<div class="left wdC">
<div class="tBG"></div>
<div class="bord">
<div class="pic"><a href="#" target="_blank"><img src="resource/img/wenyu_014.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">咕咕是一只咕咕是一只咕咕是一只猫</a></strong></span></div>
<div class="line"></div>
</div></div>

<div class="left wdE">
<div class="tBG"></div>
<div class="bord">
<div class="pic"><a href="#" target="_blank"><img alt="爱有来生" src="resource/img/wenyu_015.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">爱有来生</a></strong></span></div>
<div class="line"></div>
</div></div>

<div class="left wdH">
<div class="tBG"></div>
<div class="bord">
<div class="pic"><a href="#" target="_blank"><img alt="救命" src="resource/img/wenyu_014.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">救命</a></strong></span></div>
<div class="line"></div>
</div></div>

<div class="left wdG">
<div class="tBG"></div>
<div class="bord">
<div class="pic"><a href="#" target="_blank"><img alt="罗马，不设防的城市" src="resource/img/wenyu_015.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">罗马，不设防的城市</a></strong></span></div>
<div class="line"></div>
</div></div>

<div class="left wdD">
<div class="tBG"></div>
<div class="bord">
<div class="pic"><a href="#" target="_blank"><img alt="可可西里" src="resource/img/wenyu_015.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">可可西里</a></strong></span></div>
<div class="line"></div>
</div></div>

<div class="left wdD">
<div class="tBG"></div>
<div class="bord">
<div class="pic"><a href="#" target="_blank"><img alt="可可西里" src="resource/img/wenyu_014.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">可可西里</a></strong></span></div>
<div class="line"></div>
</div></div>

<div class="left wdB">
<div class="tBG"></div>
<div class="bord">
<div class="pic"><a href="#" target="_blank"><img alt="神经侠侣" src="resource/img/wenyu_015.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">神经侠侣</a></strong></span></div>
<div class="line"></div>
</div></div>

<div class="left wdD">
<div class="tBG"></div>
<div class="bord">
<div class="pic"><a href="#" target="_blank"><img alt="可可西里" src="resource/img/wenyu_014.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">可可西里</a></strong></span></div>
<div class="line"></div>
</div></div>

<div class="left wdD">
<div class="tBG"></div>
<div class="bord">
<div class="pic"><a href="#" target="_blank"><img alt="可可西里" src="resource/img/wenyu_015.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">可可西里</a></strong></span></div>
<div class="line"></div>
</div></div>

<div class="left wdF">
<div class="tBG"></div>
<div class="bord">
<div class="pic"><a href="#" target="_blank"><img alt="刀剑笑" src="resource/img/wenyu_014.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">刀剑笑</a></strong></span></div>
<div class="line"></div>
</div></div>
</div>
</div>
<div class="btns"><a href="javascript:void(0)" class="up"></a><a href="javascript:void(0)" class="down"></a></div>
</div>

</div>



<!--精品栏目-->

<div class="cjing_left_gj">
<p><b>精品栏目</b><span><a href="#">更多>></a></span></p>
</div>

<div class="jilu_xgang">
<ul>
<li><a href="#"><img src="resource/img/jilu_006.jpg" width="140" height="80" /></a><span><a href="#">已向遇难台湾渔民向遇难台湾渔民的的家属幸</a><strong>渔民的家属以及台湾人民就这起</strong></span></li>
<li class="jilu_pli"><a href="#"><img src="resource/img/jilu_006.jpg" width="140" height="80" /></a><span><a href="#">已向遇难湾人民就这起不幸</a><strong>渔民的家属以及台湾人民就这起</strong></span></li>
<li><a href="#"><img src="resource/img/jilu_006.jpg" width="140" height="80" /></a><span><a href="#">已向遇难台湾渔民的不幸</a><strong>渔民的家属以及台湾人民就这起</strong></span></li>
<li class="jilu_pli"><a href="#"><img src="resource/img/jilu_006.jpg" width="140" height="80" /></a><span><a href="#">已向遇难台湾渔民的家属以及台湾人民就这起不幸</a><strong>渔民的家属以</strong></span></li>
</ul>
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


<div class="index_tpxw">
<p><strong>国际新闻</strong><span><a href="#">更多</a></span></p>
</div>

<div class="tpxw_tp">
<div class="wrap"> <a href="#x"> <img src="resource/img/cnn_034.jpg" width="243" height="175" /> <i></i><p> <b>当被记者问及台湾渔民遭菲海岸警卫</b> <span>这是台湾渔民遭菲海岸警卫队枪杀事件发生4天以来，阿基诺首次打破沉默，公开谈及这一事件。有专家认为，由于菲律宾正值期</span> </p> </a> </div>
<div class="wrap"> <a href="#x"> <img src="resource/img/cnn_034.jpg" width="243" height="175" /> <i></i><p> <b>当被记者问及台湾渔民遭菲海岸警卫</b> <span>这是台湾渔民遭菲海岸警卫队枪杀事件发生4天以来，阿基诺首次打破沉默，公开谈及这一事件。有专家认为，由于菲律宾正值期</span> </p> </a> </div>
<div class="wrap"> <a href="#x"> <img src="resource/img/cnn_034.jpg" width="243" height="175" /> <i></i><p> <b>当被记者问及台湾渔民遭菲海岸警卫</b> <span>这是台湾渔民遭菲海岸警卫队枪杀事件发生4天以来，阿基诺首次打破沉默，公开谈及这一事件。有专家认为，由于菲律宾正值期</span> </p> </a> </div>
<div class="wrap"> <a href="#x"> <img src="resource/img/cnn_034.jpg" width="243" height="175" /> <i></i><p> </p> </a> </div>

<div class="wrap"> <a href="#x"> <img src="resource/img/cnn_034.jpg" width="243" height="175" /> <i></i><p> <b>当被记者问及台湾渔民遭菲海岸警卫</b> <span>这是台湾渔民遭菲海岸警卫队枪杀事件发生4天以来，阿基诺首次打破沉默，公开谈及这一事件。有专家认为，由于菲律宾正值期</span> </p> </a> </div>
<div class="wrap"> <a href="#x"> <img src="resource/img/cnn_034.jpg" width="243" height="175" /> <i></i><p> <b>当被记者问及台湾渔民遭菲海岸警卫</b> <span>这是台湾渔民遭菲海岸警卫队枪杀事件发生4天以来，阿基诺首次打破沉默，公开谈及这一事件。有专家认为，由于菲律宾正值期</span> </p> </a> </div>
<div class="wrap"> <a href="#x"> <img src="resource/img/cnn_034.jpg" width="243" height="175" /> <i></i><p> <b>当被记者问及台湾渔民遭菲海岸警卫</b> <span>这是台湾渔民遭菲海岸警卫队枪杀事件发生4天以来，阿基诺首次打破沉默，公开谈及这一事件。有专家认为，由于菲律宾正值期</span> </p> </a> </div>
<div class="wrap"> <a href="#x"> <img src="resource/img/cnn_034.jpg" width="243" height="175" /> <i></i><p> </p> </a> </div>
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
	 		allcolumns[${c_index}]=new Array(2);
	 		allcolumns[${c_index}][0]="${(c.column_id)!""}";
	 		allcolumns[${c_index}][1]="${(c.column_url)!""}";	 	 	
	 </#list>
	 </#if>
</script>
</body>
</html>
