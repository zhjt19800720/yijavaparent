<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="resource/css/reset.css">
<link rel="stylesheet" type="text/css" href="resource/css/miniplay.css">
<script src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/jquery.jplayer.js"></script>
<script type="text/javascript" src="resource/js/jplayer.playlist.js"></script>
<script>
$(function(){
	$('#shareBox').hide();
	$('#share').click(function(){
		$('#shareBox').css({left:$(this).offset().left, top:$(this).offset().top + $(this).outerHeight()}).show();
		return false;
	});
	$('#shareBox .popClose').click(function(){
		$('#shareBox').hide();
	});
});
</script>
</head>

<body>
<div class="nobg">
<div  id="jp_container_N">
    <div id="jquery_jplayer_N" class="jp-jplayer" style="height:0; line-height:0;font-size:0;overflow:hidden;"></div>
    <div id="jp_container" class="cnc-audio">
      <div class="player-title" id="player-title"><span class="red">CNC</span> 新华网络电视-电台</div>
      <div class="jp-volume-button"></div>
      <a href="javascript:void(0);" class="jp-mute" tabindex="1" title="静音">静音</a>
      <a href="javascript:void(0);" class="jp-unmute" tabindex="1" title="取消静音">取消静音</a>
      	<div class="jp-volume-bar">
        	<div class="jp-volume-bar-value"><div class="jp-volume-icon"></div></div>
      	</div>
      <div class="player-button"><a href="javascript:void(0);" class="jp-play" tabindex="1">播放</a>
      	<a href="javascript:void(0);" class="jp-pause" tabindex="1">暂停</a></div>
      		<div class="cnc-title" ><span id="cnc-title"></span> <span class="gray" id="pubtime"></span></div>
      		
        
          <div class="jp-progress">
            <div class="jp-seek-bar">
              <div class="jp-play-bar"><div class="jp-play-icon"></div></div>
            </div>
          </div>
        
        <div class="jp-type-single">
      	
      	<a href="javascript:void(0);" class="jp-stop" tabindex="1">停止</a>
      	<a href="javascript:void(0);" class="jp-mute" tabindex="1" title="静音">静音</a>
        <a href="javascript:void(0);" class="jp-unmute" tabindex="1" title="取消静音">取消静音</a>
        <a href="javascript:void(0);" class="jp-volume-max" tabindex="1" title="最大音量">最大音量</a>
        <div class="jp-current-time"></div>
        <div class="jp-duration"></div>
        <a href="javascript:void(0);" class="jp-repeat" tabindex="1" title="循环">循环</a><a href="javascript:void(0);" class="jp-repeat-off" tabindex="1" title="关闭循环">关闭循环</a>
        
         <div class="jp-playlist" style="display:none">
					<ul>
						<!-- The method Playlist.displayPlaylist() uses this unordered list -->
						<li></li>
					</ul>
				</div>
       
        <div class="jp-no-solution"> <span>Update Required</span> To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>. </div>
      </div>
    </div>
   </div>
<!--a href="javascript:void(0);" class="shareBtn" id="share">分享</a>
<a href="#" class="keepBtn">收藏</a-->

<script type="text/javascript">
$(document).ready(function(){
	
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
		//swfPath: "http://localhost:8080/stage/resource/js/Jplayer.swf",
		supplied: "webmv, ogv, m4v, oga, mp3",
		smoothPlayBar: true,
		keyEnabled: true,
		audioFullScreen: true
	});

	// Click handlers for jPlayerPlaylist method demo

	// Audio mix playlist

	
		
	 //监听事件开始
	 //暂停
	 $("#jquery_jplayer_N").bind($.jPlayer.event.pause, function(event) { 
    	
    	var logoinfo="<span class=\"red\">CNC</span> 新华网络电视-电台";
    	$("#player-title").html(logoinfo); 
  	});
	 //暂停
	 $("#jquery_jplayer_N").bind($.jPlayer.event.play, function(event) { 
	 		$("#player-title").html(""); 
    	
  		var current = myPlaylist.current;
  		var title=myPlaylist.playlist[current].title;
  		var pubdate=myPlaylist.playlist[current].pubdate;
  		$("#cnc-title").html(title); 
  		$("#pubtime").html(pubdate); 
    
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
  		 //alert("Error Event: type = " + event.jPlayer.error.type);
  		 switch(event.jPlayer.error.type) {
  		 	 case $.jPlayer.error.URL:
  		 		  //getNextMedia(); // A function you might create to move on to the next media item when an error occurs.
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
  		
    	//alert("loadeddata"); 
  	});	
  	
  	 //监听事件结束
  	//得到下一首
  	function getNextMedia()
		{
			//alert(myPlaylist.current);
			//alert(myPlaylist.playlist[0].mp3);
			
			myPlaylist.next();
			//myPlaylist.option("autoPlay", true);
		}
		
	function doplayer(id,audiof,title,pubtime)
	{
		myPlaylist.add({
				id:id,
				title:title,
				pubdate:pubtime,				
				mp3:audiof
			}, true);		
	}	
	
	
	if(id)
	{
		myPlaylist.add({
				id:id,
				title:title,
				pubdate:pubtime,				
				mp3:audiof
			}, true);		
	
	}
	
});


<#if news??>
	var id="${news.id!""}";
	var title="${news.title!""}";
	var audiof="${news.mp3!""}";
	var pubdate="${news.pubdate!""}";
</#if>



</script>
<div class="shareBox" id="shareBox">
	<span class="popClose"></span>
    <div class="shareTitle">分享给站外好友</div>
    <div class="shareLine clearfix"><label>flash地址:</label><input name="" type="text"><button name="" type="button">复制</button></div>
    <div class="shareLine clearfix"><label>html代码:</label><input name="" type="text"><button name="" type="button">复制</button></div>
    <div class="shareLine clearfix"><label>通用代码:</label><input name="" type="text"><button name="" type="button">复制</button></div>
</div>
</div>
</body>
</html>
