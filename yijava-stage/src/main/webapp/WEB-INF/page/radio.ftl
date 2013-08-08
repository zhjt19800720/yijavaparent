<#include "header.ftl">	
<div class="player-box">
    <div id="cnc_player" class="cnc-jplayer"></div>
    <div id="cnc_container" class="cnc-audio">
      <div class="player-title"><span class="red">CNC</span> 新华网络电视-电台</div>
      <div class="cnc-volume-button"></div>
      	<div class="cnc-volume-bar">
        	<div class="cnc-volume-bar-value"><div class="cnc-volume-icon"></div></div>
      	</div>
      <div class="player-button"><a href="javascript:;" class="cnc-play" tabindex="1">播放</a>
      	<a href="javascript:;" class="cnc-pause" tabindex="1">暂停</a></div>
        <div class="cnc-title">上海现代制药股份有限公司关于重大对外投资事   <span class="gray">6月30日23:56</span></div>
          <div class="cnc-progress">
            <div class="cnc-seek-bar">
              <div class="cnc-play-bar"><div class="cnc-play-icon"></div></div>
            </div>
          </div>
        
        <div class="cnc-type-single">
      	
      	<a href="javascript:;" class="cnc-stop" tabindex="1">停止</a>
      	<a href="javascript:;" class="cnc-mute" tabindex="1" title="静音">静音</a>
        <a href="javascript:;" class="cnc-unmute" tabindex="1" title="取消静音">取消静音</a>
        <a href="javascript:;" class="cnc-volume-max" tabindex="1" title="最大音量">最大音量</a>
        <div class="cnc-current-time"></div>
        <div class="cnc-duration"></div>
        <a href="javascript:;" class="cnc-repeat" tabindex="1" title="循环">循环</a><a href="javascript:;" class="cnc-repeat-off" tabindex="1" title="关闭循环">关闭循环</a>
        
        
        <div class="cnc-no-solution"> <span>Update Required</span> To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>. </div>
      </div>
    </div>
    <a href="javascript:void(0);"class="shareBtn" id="share">分享</a>
    <a href="javascript:void(0);" class="keepBtn"  onclick="javascript:addfavorite();">收藏</a>
</div>
<script type="text/javascript">
//<![CDATA[
$(function(){
	$("#cnc_player").jPlayer({
		ready: function (event) {
			$(this).jPlayer("setMedia", {
				//mp3:"nbszzdkl.mp3"
				m4a:"TSP-01-Cro_magnon_man.m4a",
				oga:"TSP-01-Cro_magnon_man.ogg"
			});
		},
		swfPath: "js",
		//supplied: "mp3",
		supplied: "m4a,oga",
		wmode: "window",
		smoothPlayBar: true,
		keyEnabled: true
	});
});
//]]>
</script>
<div class="main">
  <ul id="tabTitle" class="tabs-title">
    <li class="first current"><span class="tab-left"></span><span class="tab-middle">今日电台</span><span class="tab-right"></span></li>
    <li><span class="tab-left"></span><span class="tab-middle">精彩推荐</span><span class="tab-right"></span></li>
    <li class="last"><span class="tab-left"></span><span class="tab-middle">我的收藏</span><span class="tab-right"></span></li>
  </ul>
  <div class="inner-box">
    <div class="inner-bg clearfix">
      <div id="tabContent">
        <div class="tab-content">
          <div class="media-left">
            <ul class="media-list clearfix" id="currentnew">
              
            </ul>
            <div class="pages" id="currentpage"><a href="#" class="prev"></a><a href="#" class="current"></a><a href="#" class="page"></a><a href="#" class="page"></a><a href="#" class="page"></a><a href="#" class="next"></a></div>
          </div>
          <div class="right-ad">
            <div class="adimg"><img src="resource/images/img01.jpg" width="310" height="301"></div>
            <div class="dimensional-code"><img src="resource/images/dimensional-code.png" width="82" height="82"></div>
            <ul class="downloads">
              <li><a href="#"><img src="resource/images/play-iphone.png" width="76" height="41"></a></li>
              <li><a href="#"><img src="resource/images/play-ipad.png" width="76" height="41"></a></li>
              <li><a href="#"><img src="resource/images/play-weixin.png" width="76" height="41"></a></li>
            </ul>
          </div>
        </div>
        <div class="tab-content" style="display:none;">
          <div class="media-full">
            <ul class="media-list clearfix" id="recommendnew">
              
            </ul>
            <div class="pages" id="recommendpage"></div>
          </div>
        </div>
        <div class="tab-content" style="display:none;">
          <div class="media-full">
            <ul class="media-list clearfix" id="menew">
              
            </ul>
            <div class="pages" id="mepage"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="inner-bottom" id="menewpage"></div>
</div>
<script language="javascript">
	
	function initcurrdate(pageNo)
	{
		var d = new Date();
		var n = d.getTime();
		if(pageNo==0)
			var params = "pageSize=12&filter_EQI_category_id=1&time="+n;
		else
			var params = "pageSize=12&filter_EQI_category_id=1&pageNo="+pageNo+"&time="+n;
			
		//alert(params);
		
		
		$.ajax({
		  type: 'POST',
		  url: "api/rnews",
		  data: params,
		  beforeSend:Request,
		  success: Response,
	  	  error: function () {//ajax请求错误的情况返回超时重试。
            alert(error);
          }
		});
	}
	function Request(){
   		$('#currentnew').html('<center><img src="resource/images/ajax-loader.gif" width="16" height="16" /></center>');
	}
	function Response(msg){
	   $('#currentnew').html();
	   if(msg.state==1)
		{
			var news=msg.data.result;
			var content="";
			
			for (x in news)
			{
				content+="<li><a href=\"#\">";
				content+="<img src=\"resource/images/default.png\">";
				content+="<span class=\"info-box\">";
				content+="<span class=\"info-time\">";
				content+=news[x].duration;
				content+="</span> <span class=\"info-title\">";
				content+=news[x].title;
				content+="</span></span></a></li>";	
				content+="\n";					
			}
			//alert(content);			
			$("#currentnew").html(content);	
			
			
			var pagecontent="<a href=\"javaScript:void(0)\" onclick=\"___redirectpage("+msg.data.prePage+")\" class=\"prev\"></a>";
			//alert(msg.data.totalPages);
			for(var i=1;i<=msg.data.totalPages;i++)
			{
				if(i==msg.data.pageNo)
					pagecontent+="<a href=\"javaScript:void(0)\" onclick=\"___redirectpage("+i+")\" class=\"current\"></a>";
				else
					pagecontent+="<a href=\"javaScript:void(0)\" onclick=\"___redirectpage("+i+")\" class=\"page\"></a>";
			}						
						
			pagecontent+="<a href=\"javaScript:void(0)\" onclick=\"___redirectpage("+msg.data.nextPage+")\"  class=\"next\"></a>";
			//alert(pagecontent);
			$("#currentpage").html(pagecontent);	
		}else
		{
			alert(msg.error.msg);
			//$("#alertinfo").html(msg.error.msg);					
		}			
	}	
	
	function ___redirectpage(page)
	{
		//alert(page);
		initcurrdate(page);
	}
	
	$(document).ready(function(){ 		
		initcurrdate(0);
		initrecommend(0);
		initme(0);
	}); 
	
	function share()
	{
		alert("share");
	}
	function addfavorite()
	{
		alert("addfavorite");
		var d = new Date();
		var n = d.getTime();
		var params = "user_id=12&radio_id=2&time="+n;
		
		$.ajax({
		  type: 'POST',
		  url: "api/favorites/add",
		  data: params,
		  //beforeSend:requestcommand,
		  success: responseresult,
	  	  error: function () {//ajax请求错误的情况返回超时重试。
            alert(error);
          }
		});	
	}
	
	function responseresult(msg){
		//alert(msg);
		if(msg.data!=1)
		{
			alert("error");
		}
	}
	
	function initrecommend(pageNo)
	{
		var d = new Date();
		var n = d.getTime();
		if(pageNo==0)
			var params = "pageSize=12&filter_EQI_category_id=2&time="+n;
		else
			var params = "pageSize=12&filter_EQI_category_id=2&pageNo="+pageNo+"&time="+n;
			
		//alert(params);
		
		
		$.ajax({
		  type: 'POST',
		  url: "api/rnews",
		  data: params,
		  beforeSend:requestcommand,
		  success: responsecommand,
	  	  error: function () {//ajax请求错误的情况返回超时重试。
            alert(error);
          }
		});
	}
	
	function requestcommand(){
   		$('#recommendnew').html('<center><img src="resource/images/ajax-loader.gif" width="16" height="16" /></center>');
	}
	function responsecommand(msg){
	   $('#recommendnew').html();
	   if(msg.state==1)
		{
			var news=msg.data.result;
			var content="";
			
			for (x in news)
			{
				content+="<li><a href=\"#\">";
				content+="<img src=\"resource/images/default.png\">";
				content+="<span class=\"info-box\">";
				content+="<span class=\"info-time\">";
				content+=news[x].duration;
				content+="</span> <span class=\"info-title\">";
				content+=news[x].title;
				content+="</span></span></a></li>";	
				content+="\n";					
			}
			//alert(content);			
			$("#recommendnew").html(content);	
			
			
			var pagecontent="<a href=\"javaScript:void(0)\" onclick=\"___redirectpagec("+msg.data.prePage+")\" class=\"prev\"></a>";
			//alert(msg.data.totalPages);
			for(var i=1;i<=msg.data.totalPages;i++)
			{
				if(i==msg.data.pageNo)
					pagecontent+="<a href=\"javaScript:void(0)\" onclick=\"___redirectpagec("+i+")\" class=\"current\"></a>";
				else
					pagecontent+="<a href=\"javaScript:void(0)\" onclick=\"___redirectpagec("+i+")\" class=\"page\"></a>";
			}						
						
			pagecontent+="<a href=\"javaScript:void(0)\" onclick=\"___redirectpagec("+msg.data.nextPage+")\"  class=\"next\"></a>";
			//alert(pagecontent);
			$("#recommendpage").html(pagecontent);	
		}else
		{
			alert(msg.error.msg);
			//$("#alertinfo").html(msg.error.msg);					
		}			
	}		
	function ___redirectpagec(page)
	{
		//alert(page);
		initrecommend(page);
	}
	
	
	function initme(pageNo)
	{
		var d = new Date();
		var n = d.getTime();
		if(pageNo==0)
			var params = "pageSize=12&filter_EQI_user_id=1&time="+n;
		else
			var params = "pageSize=12&filter_EQI_user_id=1&pageNo="+pageNo+"&time="+n;
			
		//alert(params);
		
		
		$.ajax({
		  type: 'POST',
		  url: "api/favorites/me",
		  data: params,
		  beforeSend:requestme,
		  success: responseme,
	  	  error: function () {//ajax请求错误的情况返回超时重试。
            alert(error);
          }
		});
	}
	
	function requestme(){
   		$('#recommendnew').html('<center><img src="resource/images/ajax-loader.gif" width="16" height="16" /></center>');
	}
	function responseme(msg){
	   $('#recommendnew').html();
	   if(msg.state==1)
		{
			var news=msg.data.result;
			var content="";
			
			for (x in news)
			{
				content+="<li><a href=\"#\">";
				content+="<img src=\"resource/images/default.png\">";
				content+="<span class=\"info-box\">";
				content+="<span class=\"info-time\">";
				content+=news[x].duration;
				content+="</span> <span class=\"info-title\">";
				content+=news[x].title;
				content+="</span></span></a></li>";	
				content+="\n";					
			}
			//alert(content);			
			$("#menew").html(content);	
			
			
			var pagecontent="<a href=\"javaScript:void(0)\" onclick=\"___redirectpageme("+msg.data.prePage+")\" class=\"prev\"></a>";
			//alert(msg.data.totalPages);
			for(var i=1;i<=msg.data.totalPages;i++)
			{
				if(i==msg.data.pageNo)
					pagecontent+="<a href=\"javaScript:void(0)\" onclick=\"___redirectpageme("+i+")\" class=\"current\"></a>";
				else
					pagecontent+="<a href=\"javaScript:void(0)\" onclick=\"___redirectpageme("+i+")\" class=\"page\"></a>";
			}						
						
			pagecontent+="<a href=\"javaScript:void(0)\" onclick=\"___redirectpageme("+msg.data.nextPage+")\"  class=\"next\"></a>";
			//alert(pagecontent);
			$("#mepage").html(pagecontent);	
		}else
		{
			alert(msg.error.msg);
			//$("#alertinfo").html(msg.error.msg);					
		}			
	}		
	function ___redirectpageme(page)
	{
		//alert(page);
		initme(page);
	}
</script>
<div class="shareBox" id="shareBox">
	<span class="popClose"></span>
    <div class="shareTitle">分享给站外好友</div>
    <div class="shareLine clearfix"><label>flash地址:</label><input name="" type="text"><button name="" type="button">复制</button></div>
    <div class="shareLine clearfix"><label>html代码:</label><input name="" type="text"><button name="" type="button">复制</button></div>
    <div class="shareLine clearfix"><label>通用代码:</label><input name="" type="text"><button name="" type="button">复制</button></div>
</div>
<#include "footer.ftl">	