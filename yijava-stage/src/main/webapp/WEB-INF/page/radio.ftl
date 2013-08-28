<#include "header.ftl">	
<div class="player-box" id="jp_container_N">
    <div id="jquery_jplayer_N" class="jp-jplayer"></div>
    <div id="jp_container" class="jp-audio">
      <div class="player-title" id="player-title"><span class="red">CNC</span> 新华网络电视-电台</div>
      <div class="jp-volume-button"></div>
      <a href="javascript:;" class="jp-mute" tabindex="1" title="静音">静音</a>
      <a href="javascript:;" class="jp-unmute" tabindex="1" title="取消静音">取消静音</a>
      	<div class="jp-volume-bar">
        	<div class="jp-volume-bar-value"><div class="jp-volume-icon"></div></div>
      	</div>
      <div class="player-button"><a href="javascript:;" class="jp-play" tabindex="1">播放</a>
      	<a href="javascript:;" class="jp-pause" tabindex="1">暂停</a></div>
      		<div class="cnc-title" ><span id="cnc-title"></span> <span class="gray" id="pubtime"></span></div>
      		
        
          <div class="jp-progress">
            <div class="jp-seek-bar">
              <div class="jp-play-bar"><div class="jp-play-icon"></div></div>
            </div>
          </div>
        
        <div class="jp-type-single">
      	
      	<a href="javascript:;" class="jp-stop" tabindex="1">停止</a>
      	<a href="javascript:;" class="jp-mute" tabindex="1" title="静音">静音</a>
        <a href="javascript:;" class="jp-unmute" tabindex="1" title="取消静音">取消静音</a>
        <a href="javascript:;" class="jp-volume-max" tabindex="1" title="最大音量">最大音量</a>
        <div class="jp-current-time"></div>
        <div class="jp-duration"></div>
        <a href="javascript:;" class="jp-repeat" tabindex="1" title="循环">循环</a><a href="javascript:;" class="jp-repeat-off" tabindex="1" title="关闭循环">关闭循环</a>
        
         <div class="jp-playlist" style="display:none">
					<ul>
						<!-- The method Playlist.displayPlaylist() uses this unordered list -->
						<li></li>
					</ul>
				</div>
       
        <div class="jp-no-solution"> <span>Update Required</span> To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>. </div>
      </div>
    </div>
    <a href="javascript:void(0);"class="shareBtn" id="share">分享</a>
    <a href="javascript:void(0);" class="keepBtn"  onclick="javascript:addfavorite();">收藏</a>
</div>

<div class="main">
  <ul id="tabTitle" class="tabs-title">
    <li class="first current"><span class="tab-left"></span><span class="tab-middle">最新播报</span><span class="tab-right"></span></li>
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
	
	function initcurrplaycontent(pageNo)
	{
		var d = new Date();
		var n = d.getTime();
		if(pageNo==0)
			var params = "pageSize=30&category_id=1&time="+n;
		else
			var params = "pageSize=30&category_id=1&pageNo="+pageNo+"&time="+n;
			
		//alert(params);
		
		
		$.ajax({
		  type: 'POST',
		  url: "api/currentplaycontent",
		  data: params,
		  beforeSend:RequestPlayContent,
		  success: ResponseContent,
	  	  error: function () {//ajax请求错误的情况返回超时重试。
            alert(error);
          }
		});
	}
	
	function RequestPlayContent(){
   		
	}
	function ResponseContent(msg){
		
		if(msg.state==1)
		{
			var news=msg.data;
			
			var pubtime,title,audiof,id;
			for(var x=0;x<news.length;x++)
			{
				pubtime=getdate(news[x].pubdate);
				title=news[x].title;
				audiof=news[x].mp3;
				id=news[x].id;
				
				
				//添加进播放列表
				myPlaylist.add({
				id:id,
				title:title,
				pubdate:pubtime,				
				mp3:audiof
				}, false);
				
				
			}
			$("#jquery_jplayer_N").jPlayer("play");
			
		}
	}
	
	
	
	function initcurrdate(pageNo)
	{
		var d = new Date();
		var n = d.getTime();
		if(pageNo==0)
			var params = "pageSize=12&category_id=1&time="+n;
		else
			var params = "pageSize=12&category_id=1&pageNo="+pageNo+"&time="+n;
			
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
			var pubtime,title,audiof,id;
			for(var x=0;x<news.length;x++)
			{
				pubtime=getdate(news[x].last_date);
				title=news[x].title;
				audiof=news[x].radio_file;
				id=news[x].id;
				content+="<li><a href=\"javaScript:void(0)\" onclick=\"doplayer('"+id+"','"+audiof+"','"+title+"','"+pubtime+"')\">";
				
				content+="<img src=\""+news[x].image_file+"\" width=144 height=144>";
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
			alert("error");
			//$("#alertinfo").html(msg.error.msg);					
		}			
	}	
	
	function ___redirectpage(page)
	{
		//alert(page);
		initcurrdate(page);
	}
	
	
	
	function share()
	{
		alert("share");
	}
	function addfavorite(radioid)
	{		
		if(islogined && userId!=0)
		{
			//alert("logined");
			var playingid=getPlayingId();
			var d = new Date();
			var n = d.getTime();
			var params = "user_id="+userId+"&radio_id="+playingid+"&time="+n;
			
			$.ajax({
			  type: 'POST',
			  url: "api/favorites/add",
			  data: params,
			  //beforeSend:requestcommand,
			  success: responseresult,
		  	  error: function () {//ajax请求错误的情况返回超时重试。
	           alert("error");
	          }
			});	
		}
		else
		{
			alert("请先登录");
			login();
		}		
	}
	
	
	
	function responseresult(result){
		//alert(msg);
		if(result.data!=1)
		{
			alert(result.error.msg);
		}else
		{
			alert("收藏完成");
			initme(0);
		}
	}
	
	function initrecommend(pageNo)
	{
		var d = new Date();
		var n = d.getTime();
		if(pageNo==0)
			var params = "pageSize=12&category_id=2&time="+n;
		else
			var params = "pageSize=12&category_id=2&pageNo="+pageNo+"&time="+n;
			
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
			var pubtime,title,audiof,id;
			for(var x=0;x<news.length;x++)
			{
				pubtime=getdate(news[x].last_date);
				title=news[x].title;
				audiof=news[x].radio_file;
				id=news[x].id;
				content+="<li><a href=\"javaScript:void(0)\" onclick=\"doplayer('"+id+"','"+audiof+"','"+title+"','"+pubtime+"')\">";
				content+="<img src=\""+news[x].image_file+"\" width=144 height=144>";
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
			alert("error");
			//$("#alertinfo").html(msg.error.msg);					
		}			
	}		
	function ___redirectpagec(page)
	{
		//alert(page);
		initrecommend(page);
	}
	
	function initmedefault()
	{
		
		$('#menew').html('<center>请先登录后再操作！</center>');
		//login();
	}
	
	function initme(pageNo)
	{
		var d = new Date();
		var n = d.getTime();
		if(pageNo==0)
			var params = "pageSize=12&filter_EQL_user_id="+userId+"&time="+n;
		else
			var params = "pageSize=12&filter_EQL_user_id="+userId+"&pageNo="+pageNo+"&time="+n;
			
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
			var pubtime,title,audiof,id;
			for(var x=0;x<news.length;x++)
			{
				pubtime=getdate(news[x].last_date);
				title=news[x].title;
				audiof=news[x].radio_file;
				id=news[x].id;
				content+="<li><a href=\"javaScript:void(0)\" onclick=\"doplayer('"+id+"','"+audiof+"','"+title+"','"+pubtime+"')\">";
				content+="<img src=\""+news[x].image_file+"\" width=144 height=144>";
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
			alert("error");
			//$("#alertinfo").html(msg.error.msg);					
		}			
	}		
	function ___redirectpageme(page)
	{
		//alert(page);
		initme(page);
	}
	
	
</script>

<script type="text/javascript">

	var myPlaylist = new jPlayerPlaylist({
		jPlayer: "#jquery_jplayer_N",
		cssSelectorAncestor: "#jp_container_N"
	}, [], {
		playlistOptions: {
			enableRemoveControls: true
		},
		ready:function(){
			//alert("ready!");
		},
		
	
		swfPath: "http://audio.cncnews.cn/resource/js/Jplayer.swf",
		supplied: "webmv, ogv, m4v, oga, mp3",
		smoothPlayBar: true,
		keyEnabled: true,
		audioFullScreen: true
	});
	
	/*默认播放*/
	myPlaylist.setPlaylist([
			
			
	]);
	
	 //监听事件开始
	 //暂停
	 $("#jquery_jplayer_N").bind($.jPlayer.event.pause, function(event) { 
    	
    	var logoinfo="<span class=\"red\">CNC</span> 新华网络电视-电台";
    	$("#player-title").html(logoinfo); 
  	});
	 //暂停
	 $("#jquery_jplayer_N").bind($.jPlayer.event.play, function(event) { 
	 		$("#player-title").html(""); 
    	//alert("play"); 
    
  	});	
  	//搜索
  	$("#jquery_jplayer_N").bind($.jPlayer.event.seeking, function(event) { 
  		var logoinfo="<span class=\"red\">CNC</span> 新华网络电视-电台";
  		logoinfo+="  loading...";
	 		$("#player-title").html(logoinfo); 
    	//alert("play"); 
  	});	
  	//搜索完毕
  	$("#jquery_jplayer_N").bind($.jPlayer.event.seeked , function(event) { 
  		
  		
	 		$("#player-title").html(""); 
    	//alert("play"); 
  	});	
  	//错误
  	$("#jquery_jplayer_N").bind($.jPlayer.event.error , function(event) { 
  		 alert("Error Event: type = " + event.jPlayer.error.type);
  		 switch(event.jPlayer.error.type) {
  		 	 case $.jPlayer.error.URL:
  		 		  getNextMedia(); // A function you might create to move on to the next media item when an error occurs.
      			break;
      	 case $.jPlayer.error.NO_SOLUTION:
      	  	break;
      	 case $.jPlayer.error.NO_SOLUTION:
      	  	break;
  		 	}
  	});
  	//播放完毕
  	$("#jquery_jplayer_N").bind($.jPlayer.event.ended , function(event) { 
  		var logoinfo="<span class=\"red\">CNC</span> 新华网络电视-电台";
  		logoinfo+="  播放完毕...";
	 		$("#player-title").html(logoinfo); 
    	//alert("play"); 
  	});
  	
  	//加载完毕	
  	$("#jquery_jplayer_N").bind($.jPlayer.event.loadeddata , function(event) { 
  		var current = myPlaylist.current;
  		var title=myPlaylist.playlist[current].title;
  		var pubdate=myPlaylist.playlist[current].pubdate;
  		$("#cnc-title").html(title); 
  		$("#pubtime").html(pubdate); 
    	//alert("loadeddata"); 
  	});	
  	
  	 //监听事件结束
  	//得到下一首
  	function getNextMedia()
	{
		alert(myPlaylist.current);
		//alert(myPlaylist.playlist[0].mp3);
		
		myPlaylist.next();
		//myPlaylist.option("autoPlay", true);
	}
	
	//播放
	function doplayer(id,audiof,title,pubtime)
	{
		myPlaylist.add({
				id:id,
				title:title,
				pubdate:pubtime,				
				mp3:audiof
			}, true);		
	}
	
	function addplaylist(id,audiof,title,pubtime)
	{
		myPlaylist.add({
				id:id,
				title:title,
				pubdate:pubtime,				
				mp3:audiof
			}, false);
	}
	
	function getPlayingId()
	{
		var current = myPlaylist.current;
  		return myPlaylist.playlist[current].id;
	}

	
</script>
<div class="shareBox" id="shareBox">
	<span class="popClose"></span>
    <div class="shareTitle">分享给站外好友</div>
    
    <div class="shareLine clearfix"><label>html代码:</label><input name="" type="text" id="htmlurl"><button name="" type="button" id="btnhtmlurl">复制</button></div>
    <div class="shareLine clearfix"><label>通用代码:</label><input name="" type="text"  id="normalurl"><button name="" type="button" id="btnnormalurl">复制</button></div>
</div>
<#include "footer.ftl">	