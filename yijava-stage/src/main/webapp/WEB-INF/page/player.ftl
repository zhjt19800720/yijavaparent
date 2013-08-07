<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>新华网络电视-电台</title>
<link rel="stylesheet" type="text/css" href="resource/css/reset.css">
<link rel="stylesheet" type="text/css" href="resource/css/play.css">
<script src="resource/js/jquery-1.7.2.js"></script>
<script src="resource/js/common.js"></script>
<script type="text/javascript" src="resource/js/player.js"></script>
<body class="nobg">
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
<a href="#" class="shareBtn">分享</a>
<a href="#" class="keepBtn">收藏</a>
<script type="text/javascript">
//<![CDATA[
$(function(){
	$("#cnc_player").jPlayer({
		ready: function (event) {
			$(this).jPlayer("setMedia", [{
				mp3:"http://manage.yijava.com/radiofile/2013080714/20130807142243434.mp3"
				
			},
			{
				mp3:"http://manage.yijava.com/radiofile/2013080714/20130807142243434.mp3"
				
			}
			]
			
			);
		},
		swfPath: "js",
		supplied: "mp3",
		//supplied: "m4a,oga",
		wmode: "window",
		smoothPlayBar: true,
		keyEnabled: true
	});
});
//]]>
</script>
</body>
</html>