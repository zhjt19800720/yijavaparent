Date.prototype.pattern=function(fmt) {       
	var o = {       
	   "M+" : this.getMonth()+1, //月份       
	   "d+" : this.getDate(), //日       
	   "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时       
	   "H+" : this.getHours(), //小时       
	   "m+" : this.getMinutes(), //分       
	   "s+" : this.getSeconds(), //秒       
	   "q+" : Math.floor((this.getMonth()+3)/3), //季度       
	   "S" : this.getMilliseconds() //毫秒       
	};       
	var week = {       
	   "0" : "\u65e5",       
	   "1" : "\u4e00",       
	   "2" : "\u4e8c",       
	   "3" : "\u4e09",       
	   "4" : "\u56db",       
	   "5" : "\u4e94",       
	   "6" : "\u516d"      
	};       
	if(/(y+)/.test(fmt)){       
	   fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));       
	}       
	if(/(E+)/.test(fmt)){       
	   fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);       
	}       
	for(var k in o){       
	   if(new RegExp("("+ k +")").test(fmt)){       
		fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));       
	   }       
	}       
	return fmt;       
}
//tab切换函数
function tabs(e1, e2, className, e3){
	var e1 = $('li', e1);
	var e2 = $(e2);
	e1.click(function(){
		if(!$(this).hasClass(className)){
			e1.removeClass(className);
			$(this).addClass(className);
			var idx = e1.index(this);
			e2.hide();
			$(e2[idx]).show();
		}
		if(e3){
			$(e3).attr('href',$(this).attr('data-rel'));
		}
	});
}
function SetHome(obj,vrl){
		try{
				obj.style.behavior='url(#default#homepage)';obj.setHomePage(vrl);
		}
		catch(e){
				if(window.netscape){
						try{
								netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");  
						}catch (e){
								alert("抱歉！您的浏览器不支持直接设为首页。请在浏览器地址栏输入“about:config”并回车然后将[signed.applets.codebase_principal_support]设置为“true”，点击“加入收藏”后忽略安全提示，即可设置成功。");
						}
						var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
						prefs.setCharPref('browser.startup.homepage',vrl);
				 }else{  
				alert('抱歉，您的浏览器不支持自动设置首页, 请使用浏览器菜单手动设置!');
			}
		}
}
function addBookmark(title,url) {
	if (window.sidebar) {
		window.sidebar.addPanel(title, url,"");
	} else if( document.all ) {
		window.external.AddFavorite( url, title);
	} else if( window.opera && window.print ) {
		return true;
	}
}

var C1 = {};
(function($){
	var C1 = function(){};
	$.extend(C1,{
			 
	});
	$.extend(C1.prototype,{
		defaults :{
			banner_img:null,//广告图片控制class	
			ban_show:null,//展示时的图片class
			c_bged:null,//展示时的切换标签效果class
			c_bg:null	//小图标切换标签class
		},
		/*弹出层代码开始*/
		is_exist : function(elem){//判断传输的数据是否存在
			if(typeof elem !== 'undefined' && typeof elem !== null) {
				return true;
			}else{
				return false;	
			}
		},
		add_overlay : function(cl, op){
			var ie6 = $.browser.msie && parseInt($.browser.version)<=6 ;
			this.remove_overlay();
			var	overlayCss = {
					position       : 'fixed',
					zIndex         : '900',
					top            : '0px',
					left           : '0px',
					height         : '100%',
					width          : '100%',
					backgroundColor: '#000',
					filter         : 'alpha(opacity=50)',
					opacity        : 0
			},
			overlayCss2 = { //for ie 6
					position : 'absolute',
					height   : $(document).height()
			};
			var overlay = $('<div id="Overlay" class="OverlayBG"><frame width="100%" height="100%"></frame></div>');		
			if(this.is_exist(cl)){
				overlayCss.backgroundColor = cl;
			};
			$('body').append(overlay.css(overlayCss));		
			if(ie6){overlay.css(overlayCss2)};
			if(this.is_exist(op)){$('#Overlay').animate({opacity: op},0)};	
		},
		remove_overlay : function(){
			if(this.is_exist($('#Overlay'))){$('#Overlay').remove()};
		},
		hide_mask : function(target){
			if(!target.length){
				target = this.create_target(target,target_htm);
			}
			target.fadeOut(200);
			this.remove_overlay();
			return false;
		},
		init_jump : function(target,target_htm){
			if(!target.length){
				target = this.create_target(target,target_htm,arguments[2]);
			}
			var _this= $(this);
			var first_htm=target.html();
			var ie6 = $.browser.msie && parseInt($.browser.version)<=6 ;
			this.add_overlay('#000', 0.6);
			var windowTop=($(window).height()-target.height())/2 + $(window).scrollTop();
			if(windowTop<0){windowTop = 20};
			if(ie6){
			  target.css("position","absolute")
					   .css("top",windowTop)
					   .css("left",($(window).width()-target.width())/2+$(window).scrollLeft())
					   .css("z-index","9999")
					   .fadeIn(200);
			  /*$(window).scroll( function() { 
					target.css("top",($(window).height()-target.height())/2 + $(window).scrollTop())
							  .css("left",($(window).width()-target.width())/2+$(window).scrollLeft())
			   });*/
			}else {
			  target.css("position","absolute")
					   .css("top",windowTop)
					   .css("left",($(window).width()-target.width())/2+$(window).scrollLeft())
					   .css("z-index","9999")
					   .fadeIn(200);
			}	
			$(".pop_close").add(".pop_box .btn").click(function(){
				var sun_mids = new C1();
				//target.html(first_htm);
				sun_mids.hide_mask(target);
			});
			//$("#Overlay").click(function(){	
			// 	var sun_mids = new C1();
				//target.html(first_htm);
			//	sun_mids.hide_mask(target);
			//});
		},
		create_target : function(target,target_htm){//创建弹出层的内容层
				var containerBox='body';
				if(arguments[2]){
					containerBox=arguments[2];
				}
				if(target_htm!=''){
					target = $(target_htm);
				}
				target.appendTo($(containerBox));
				return target;
		},
		/*弹出层代码结束*/ 
		IeVesion : function() { //判断浏览器类型和版本
			var Sys = {}; 
			var ua = navigator.userAgent.toLowerCase(); 
			var s; 
			(s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] : 
			(s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] : 
			(s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] : 
			(s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] : 
			(s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0; 
			var ieversion; 
			if (Sys.ie){ 
				Sys.ieversion = parseInt(Sys.ie); 
			}
			return Sys; 
		},
		errorMessage:function(container_box,returnmessage){//错误弹出框
			container_box.css({'borderColor':'#DF4541'});
			container_box.find('input').css({'color':'#DF4541'}).val(returnmessage);
			container_box.find('input').unbind('focus').focus(function(){
				$(this).val('');
				container_box.css({'borderColor':'#dbdbdb'});
				$(this).css({'color':'#333333'});
			});
			container_box.find('textarea').css({'color':'#DF4541'}).val(returnmessage);
			container_box.find('textarea').unbind('focus').focus(function(){
				$(this).val('');
				container_box.css({'borderColor':'#dbdbdb'});
				$(this).css({'color':'#333333'});
			});
		},
		scriptAttacks:function(str){//script标签转义(对于字符串)
			if(/\<|\>/g.test(str)){
				str = str.replace(/\</g,'&lt;').replace(/\>/g,'&gt;');
			};
			return str;
		},
		backscriptAttacks:function(str){//反转译
			if(/\&lt\;|\&gt\;/g.test(str)){
				str = str.replace(/\&lt\;/g,'<').replace(/\&gt\;/g,'>');
			};
			return str;
		}
	});
	C1_sun = C1;
})(jQuery);
var popup = new C1_sun();

$(function(){
	tabs($('#hotTop .tab_title'), $('#hotTop .tab_content'), 'current');
	if($('#date').length > 0){
		$('#date').html(new Date().pattern('yyyy-MM-dd'));
	}
	$('#settingBtn').click(function(){
		popup.init_jump($('#setting'),'');
	});
	$('#addButton .tageList a').live('click',function(){
		if($(this).hasClass('have')) return false;
		var columnId = $(this).attr('data-column');
		var columnName = $(this).text();
		$('#myTageList').append('<span class="myTage"><a href="javascript:;" class="remove" data-column="'+columnId+'"></a>'+columnName+'</span>');
		$(this).addClass('have');
	});
	$('#myTageList .remove').live('click',function(e){
		var columnId = $(this).attr('data-column');
		$(this).closest('.myTage').remove();
		$('#addButton [data-column='+columnId+']').removeClass('have');
		cancelBubble(e);
		return false;
	});
	$('#myTageList .remove').live('mousedown',function(e){
		if (e.stopPropagation) e.stopPropagation();
		else e.cancelBubble = true;
	})
	$('#myTageList .myTage').live('mousedown',function(e){
		var cX = e.clientX;
		var cY = e.clientY;
		var $_this = $(this);
		var len = $('#myTageList .myTage').length;
		var line = Math.ceil(len / 6);
		//var l = $_this.offset().left - $('#myTageList').offset().left;
		//var t = $_this.offset().top - $('#myTageList').offset().top;
		
		var l = (cX + $(window).scrollLeft()) - $('#myTageList').offset().left - $_this.outerWidth()/2 - 2;
		var t = (cY + $(window).scrollTop()) - $('#myTageList').offset().top - $_this.outerHeight()/2 - 2;

		var sl = $_this.outerWidth()+8;
		var st = $_this.outerHeight()+8;
		
		var ql = parseInt($('#myTageList').css("padding-left"));
		var qt = parseInt($('#myTageList').css("padding-top"));
		
		$_this.after('<span class="myTage" id="placeholder">&nbsp;</span>');
		$_this.css({"position":"absolute","z-index":99999,"left":l,"top":t});
		$('#myTageList').append($_this);
		
		$(document).bind('mousemove',function(e){
			var moveLeft = l-(cX-e.clientX);
			var moveTop = t-(cY-e.clientY);
			
			$_this.css({"left":moveLeft,"top":moveTop});
			var ln = Math.round((moveLeft+sl)/sl) >= 0 ? Math.round((moveLeft+sl)/sl): 0;
			ln = ln > 6 ? 6 : ln;
			
			var tn = Math.round((moveTop-qt)/st) >= 0 ? Math.round((moveTop-qt)/st): 0;
			tn = tn >= line ? line :tn;
			
			var n = ln + tn*6;
			n = n > len ? len : n;

			if($('#myTageList .myTage:eq('+n+')').attr('id') == 'placeholder') --n;
			$('#myTageList .myTage:eq('+n+')').before($('#placeholder'));
		});
		$_this.bind('mouseup',function(){
			$('#placeholder').after($(this)).remove();
			$_this.removeAttr('style');
			$_this.unbind("mousemove mouseup");
			$(document).unbind("mousemove mouseup");
		});
	});
	
	$('#setting .close').click(function(){
		var colume= getColumn();
		var channels = colume.join("-");
		saveUserCustom(channels);
		
		
	});
	
});

function getColumn(){
	var $_domList = $('#myTageList .remove');
	var columnList = [];
	$_domList.each(function(index, element) {
		columnList.push(parseInt($(element).attr('data-column')));
	});
	return columnList;
}

function saveUserCustom(channels)
{
	var d = new Date();
	var n = d.getTime();
	
	var region=$('#selRegion').val();
	//alert(region);
	
	var params = "ids="+channels+"&region="+region;
	$.ajax({
		  type: 'POST',
		  url: "me/custom/add",
		  data: params,		
		  success: Response,
	  	  error: function () {//ajax请求错误的情况返回超时重试。
	  		  alert(error);
	  	  }
	});	
}

function Response(msg){
	 // alert(msg.state)
	//
	location.reload() ;
}

function initpage()
{
	getCustom();
}
//得到定制
function getCustom()
{
	var params = "uid=11";
	$.ajax({
		  type: 'POST',
		  url: "api/getcustom",
		  data: params,		
		  success: initcustom,
	  	  error: function () {//ajax请求错误的情况返回超时重试。
	  		  alert(error);
	  	  }
	});	
}
function initcustom(date)
{
	
	var region=date.region_name;
	var columnid=date.channel_ids;
	//alert(region);
	initweather(region);
	initregionnews(region);
	initcloumnnews(columnid);
	
	getColumnUrlById("124020581");
	//alert(date.region_name);/api/getnewbyc
}

function initweather(region)
{
	//alert("initweather");
	var params = "regionname="+region;
	$.ajax({
		  type: 'POST',
		  url: "api/getweather",
		  data: params,		
		  success: fillweather,
	  	  error: function () {//ajax请求错误的情况返回超时重试。
	  		  alert(error);
	  	  }
	});	
}
function fillweather(data)
{
	//alert("fillweather");
	$('#regionname').html(data.region +"-"+ data.city);
	var imagesrc="<img id=\"weatherimg\" src=\"resource/weather/"+data.img2+"\" width=\"48\" height=\"48\">";
	imagesrc+="今天<br>";
	imagesrc+=data.temp;
	$('#weatherinfo').html(imagesrc);
}
function initregionnews(region)
{
	alert("initregionnews");
	var params = "regionname="+region;
	$.ajax({
		  type: 'POST',
		  url: "api/getnewbyr",
		  data: params,		
		  success: fillregionnews,
	  	  error: function () {//ajax请求错误的情况返回超时重试。
	  		  alert(error);
	  	  }
	});	
}

function fillregionnews(news)
{
	var sum=0;
	for (x in news)
	{
		var newinfo="<dl>";
		newinfo+="<dt><a href=\""+news[x].url+"\">";
		newinfo+=news[x].title;
		newinfo+="</a></dt>";
		newinfo+="<dd>"+news[x].abstract+"</dd></dl>";
		
		$('#region_new'+(sum+1)).html(newinfo);		
		
		sum++;		
		if(sum>=3)
			return;
	}	
}
function initcloumnnews(cloumn)
{
	alert("initcloumnnews");
	var params = "columnid="+cloumn;
	$.ajax({
		  type: 'POST',
		  url: "api/getnewbyc",
		  data: params,		
		  success: fillcolumnnews,
	  	  error: function () {//ajax请求错误的情况返回超时重试。
	  		  alert(error);
	  	  }
	});	
}
function fillcolumnnews(news)
{
	$.each(news,function(key,values){ 
		//fillnew(key,values);
		fillnewbyStyle4(key,values);
	}); 
	
}

function fillnew(columnid,news)
{
	try
	{
		var content="";
		var columnurl=getColumnUrlById(columnid);
		var columnname=getColumnNameById(columnid);
		content+="<div class=\"cjing_left_gj\">";
		content+="<p><b>"+columnname+"</b><span><a href=\""+columnurl+"\">更多>></a></span></p>";
		content+="</div>";
		
		//for (x in news)
		//{
			
			//content+="<div class=\"left_gj_mj\">";
			//content+="<div class=\"gj_mj_left\">";
			//content+="<h3><a href=\"#\"><img src=\"resource/img/cnn_040.jpg\" width=\"150\" height=\"90\" /></a><span><a href=\"#\">菲总:统府记者会拒绝回应枪杀台湾渔民事件</a></span></h3>";
			//content+="<h3 class=\"mi_zp\"><a href=\"#\"><img src=\"resource/img/cnn_040.jpg\" width=\"150\" height=\"90\" /></a><span><a href=\"#\">菲总:统府记者会拒绝回应枪杀台湾渔渔渔渔民事件</a></span></h3>";
			//content+="</div>";
			content+="<div class=\"gj_mj_right\">";
			content+="<p><b><a href=\"#\">发言人15日说马英九对菲律宾政府授权不够、诚意不够</a></b><span>" +
					"<a href=\"#\">刻采取冻结菲劳申等项</a><br />" +
					"<a href=\"#\">采取冻结菲劳申请等项撒的刻录机的制裁措施</a><br /><a href=\"#\">即刻采取冻结菲劳申请等3项制裁措施</a><br />" +
					"<a href=\"#\">菲劳申请等3项制裁措施制裁措施。</a></span></p>";
			content+="</div>";
			content+="</div>";
			//alert(news[x].title);
		//}
		//alert(content);
		$('#newscolumn').append(content);
	}catch(e)
	{
		alert(e);
	}
	
		
}


function getdate(datestr)
{
	var filter=datestr;
	if(datestr.indexOf(".")>-1)
	{
		filter=datestr.substr(0,datestr.indexOf("."));
	}	
	var strArray=filter.split("T");   
	var strDate=strArray[0].split("-");   
	var strTime=strArray[1].split(":");   
	var a=new   Date(strDate[0],(strDate[1]-parseInt(1)),strDate[2],strTime[0],strTime[1],strTime[2])   
	return a.pattern("yyyy年M月d日  h:m:s");  
}

//根据栏目id得到栏目url
function getColumnUrlById(id)
{
	var columnUrl="";
	for (x in allcolumns)//数组中的每一个变量
	{
		if(allcolumns[x][0]==id)
		{
			columnUrl=allcolumns[x][1];
			break;
		}
			
	}
	return columnUrl;	
}
//根据栏目id得到栏目url
function getColumnNameById(id)
{
	var columnName="";
	for (x in allcolumns)//数组中的每一个变量
	{
		if(allcolumns[x][0]==id)
		{
			columnName=allcolumns[x][2];
			break;
		}
			
	}
	return columnName;	
}

function fillnewbyStyle1(columnid,news)
{
	var content="";
	var columnurl=getColumnUrlById(columnid);
	var columnname=getColumnNameById(columnid);
	content+="<div class=\"cjing_left_gj\">";
	content+="<p><b>"+columnname+"</b><span><a href=\""+columnurl+"\">更多>></a></span></p>";
	content+="</div>";
	content+="<div class=\"left_gj_mj\">";
	content+="<div class=\"gj_mj_left\">";
	
	for(var i=0; i<news.length; i++) 
	{
		//先得到有图片的循环
		content+="<h3>";
		content+="<a href=\"#\"><img src=\"img/cnn_040.jpg\" width=\"150\" height=\"90\" /></a>";
		content+="<span><a href=\"#\">菲总:统府记者会拒绝回应枪杀台湾渔民事件</a></span>";
		content+="</h3>";	
	}
	
	
	content+="</div>";
	
	content+="<div class=\"gj_mj_right\">";
	//标题内容只有一个
	content+="<p><b><a href=\"#\">台湾发言人15日说马英九对菲律宾政府授权不够、诚意不够</a></b>";
	
	content+="<span>";
	//循环剩余的
	content+="<a href=\"#\">刻采取冻结菲劳申等项</a><br />";
	//循环剩余的
	
	
	content+="</span>";
	content+="</p></div></div>";	
}

function fillnewbyStyle1(columnid,news)//样式一适用：财经频道（国际经济），体育频道（缤纷体育）
{
	var content="";
	var columnurl=getColumnUrlById(columnid);
	var columnname=getColumnNameById(columnid);
	
	
	content+="<div class=\"cjing_left_gj\">";
	content+="<p><b>"+columnname+"</b><span><a href=\""+columnurl+"\">更多>></a></span></p>";
	content+="</div>";
	
	
	content+="<div class=\"left_gj_mj\">";
	content+="<div class=\"gj_mj_left\">";
	content+="<h3><a href=\"#\"><img src=\"img/cnn_040.jpg\" width=\"150\" height=\"90\" /></a><span><a href=\"#\">菲总:统府记者会拒绝回应枪杀台湾渔民事件</a></span></h3>";
	content+="<h3 class=\"mi_zp\"><a href=\"#\"><img src=\"img/cnn_040.jpg\" width=\"150\" height=\"90\" /></a><span><a href=\"#\">菲总:统府记者会拒绝回应枪杀台湾渔民事件</a></span></h3>";
	
	content+="</div>";
	
	content+="<div class=\"gj_mj_right\">";
	content+="<p><b><a href=\"#\">台湾“中央社”报道，台“总统府”发言人15日说马英九对菲律宾政府授权不够、诚意不够</a></b><span>";
	content+="<a href=\"#\">刻采取冻结菲劳申等项</a><br />";
	
	
	content+="</div>";
	content+="</div>";
	
}

function fillnewbyStyle2(columnid,news)//样式二适用：财经频道（宏观经济）；文娱频道（文化时尚），新闻频道（文化时尚）
{
	var content="";
	var columnurl=getColumnUrlById(columnid);
	var columnname=getColumnNameById(columnid);
	
	
	content+="<div class=\"cjing_left_gj\">";
	content+="<p><b>"+columnname+"</b><span><a href=\""+columnurl+"\">更多>></a></span></p>";
	content+="</div>";
	
	<div class="left_gj_mj">
	<div class="gj_mj_left">
	<h2><a href="#"><img src="img/cnn_041.jpg" width="320" height="185" /></a></h2>
	</div>
	<div class="mj_right_hj">
	<p><b><a href="#">取冻结菲劳申请等项撒的刻录机</a><br /><strong>发言人15日说马英九对菲律宾政府授权不够、诚意不够</strong></b><span><a href="#">刻采取冻结菲劳申等项</a><br /><a href="#">采取冻结菲劳申请等项撒的刻录机的制裁措施</a><br /><a href="#">即刻采取冻结菲劳申请等3项制裁措施</a></span></p>
	</div>
	</div>
	
	
}

function fillnewbyStyle3(columnid,news)//样式三适用：财经频道（金融市场），体育频道（火爆篮球）
{
	<div class="cjing_left_gj">
	<p><b>金融市场</b><span><a href="#">更多>></a></span></p>
	</div>
	<div class="cjing_left_jr">
	<ul>
	<li><a href="#"><img src="img/cnn_042.jpg" width="150" height="90" /></a><span><a href="#">台湾渔民事件菲律宾总统就射道歉</a><strong>菲律宾总统发言人陈显达15日下午声称菲总统阿基诺已向遇难台湾渔民的家属以及台湾人民就这起不幸的</strong></span></li>
	<li class="left_jrpl"><a href="#"><img src="img/cnn_042.jpg" width="150" height="90" /></a><span><a href="#">台湾渔民事件菲律宾总统就射道歉</a><strong>菲律宾总统发言人陈显达15日下午声称菲总统阿基诺已向遇难台湾渔民的家属以及台湾人民就这起不幸的</strong></span></li>
	<li class="left_jrpl"><a href="#"><img src="img/cnn_042.jpg" width="150" height="90" /></a><span><a href="#">台湾渔民事件菲律宾总统就射道歉</a><strong>菲律宾总统发言人陈显达15日下午声称菲总统阿基诺已向遇难台湾渔民的家属以及台湾人民就这起不幸的</strong></span></li>
	<li class="left_jrpl"><a href="#"><img src="img/cnn_042.jpg" width="150" height="90" /></a><span><a href="#">台湾渔民事件菲律宾总统就射道歉</a><strong>菲律宾总统发言人陈显达15日下午声称菲总统阿基诺已向遇难台湾渔民的家属以及台湾人民就这起不幸的</strong></span></li>
	</ul>
	</div>
}

function fillnewbyStyle4(columnid,news)//样式四适用：财经频道（基金/理财），文娱频道（文娱播报），新闻频道（国际新闻）
{
	var content="";
	var columnurl=getColumnUrlById(columnid);
	var columnname=getColumnNameById(columnid);
	
	
	content+="<div class=\"cjing_left_gj\">";
	content+="<p><b>"+columnname+"</b><span><a href=\""+columnurl+"\">更多>></a></span></p>";
	content+="</div>";
		
	var needloop=1;	
	if(news.length>=4)
	{
		needloop=2;
	}	
	
	for(var i=0; i<needloop; i++) 		
	{
		var descindex=0;
		var startminloop=1;
		if(needloop==2)
		{
			if(i==0)
			{
				descindex=0;
				startminloop=1;
			}else
			{
				descindex=3;
				startminloop=4;
			}
		}		
		content+="<div class=\"cjing_left_lc\">";		
		//标题
		content+="<h1><a href=\""+news[descindex].url+"\">"+news[descindex].title+"</a></h1>";	
		//图片
		content+="<div class=\"left_lc_left\"><a href=\""+news[descindex].url+"\">" +
				"<img src=\""+news[descindex].image_set.image_url+"\" width=\"150\" height=\"90\"/></a></div>";	
		
		content+="<div class=\"left_lc_right\">";
		//内容
		content+="<p>"+news[descindex].abstract+"</p>";		
		//再循环两个
		content+="<ul>";
		
		for(var j=0;j<2;j++)
		{
			if(news[startminloop+j])
			{
				content+="<li><a href=\""+news[startminloop+j].url+"\">"+news[startminloop+j].title+"</a></li>";
			}			
		}		
		content+="</ul>";
		content+="</div>";
		content+="</div>";		
	}
	$('#newscolumn').append(content);
}


function fillnewbyStyle5(columnid,news)//样式五适用：财经频道（公司行业），新闻频道（国内新闻），体育频道（综合赛事），纪录片频道（历史人文）
{
	var content="";
	var columnurl=getColumnUrlById(columnid);
	var columnname=getColumnNameById(columnid);
	
	
	content+="<div class=\"cjing_left_gj\">";
	content+="<p><b>"+columnname+"</b><span><a href=\""+columnurl+"\">更多>></a></span></p>";
	content+="</div>";
	
	content+="<div class=\"cjing_left_jr\">";	
	for (x in news)
	{
		if(x==0)
		{
			content+="<div class=\"cjing_left_jr_a \">";
		}else
		{
			content+="<div class=\"cjing_left_jr_a left_jrpl\">";
		}
		
		content+="<p><a href=\""+news[x].url+"\"><img src=\""+news[x].image_set.image_url+"\" width=\"150\" height=\"90\" /></a>" +
				"<i></i><b><a href=\""+news[x].url+"\">"+news[x].title+"</a></b><span><strong>"+news[x].abstract+"</strong></span></li></p>";
		content+="</div>";		
	}
	content+="</div>";
	$('#newscolumn').append(content);
}

function fillnewbyStyle6(columnid,news)//样式六适用：文娱频道（名人明星），体育频道（超级足球），纪录片频道（领进着说）
{
	<div class="cjing_left_gj">
	<p><b>名人明星</b><span><a href="#">更多>></a></span></p>
	</div>
	<div class="guonei_jqu">
	<div class="guonei_jqu_z">
	<p><a href="#"><img src="img/cnn_041.jpg" width="320" height="170" /></a><i>提高扩容的背后，最大的无奈在于门票收入分成部分</i><b><a href="#">景区“涨价潮”折射式中国“门票经济”</a></b></p>
	</div>
	<div class="guonei_jqu_z guonei_jqu_y">
	<p><a href="#"><img src="img/cnn_041.jpg" width="320" height="170" /></a><i>提高扩容的背后，最大的无奈在于门票收入分成部分</i><b><a href="#">景区“涨价潮”折射式中国“门票经济”</a></b></p>
	</div>
	<div class="clear"></div>
	</div>
}
function fillnewbyStyle7(columnid,news)//样式七适用：文娱频道（影视天地），纪录片频道（环球纵横）
{
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
	<div class="pic"><a href="#" target="_blank"><img alt="" src="img/wenyu_015.jpg" width="150" height="90"></a><span><strong><a href="#" target="_blank">飞一咕咕是一只咕咕是一只般爱情小说</a></strong></span></div>
	<div class="line"></div>
	</div></div>

	<div class="left wdC">
	<div class="tBG"></div>
	<div class="bord">
	<div class="pic"><a href="#" target="_blank"><img src="img/wenyu_014.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">咕咕是一只咕咕是一只咕咕是一只猫</a></strong></span></div>
	<div class="line"></div>
	</div></div>

	<div class="left wdE">
	<div class="tBG"></div>
	<div class="bord">
	<div class="pic"><a href="#" target="_blank"><img alt="爱有来生" src="img/wenyu_015.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">爱有来生</a></strong></span></div>
	<div class="line"></div>
	</div></div>

	<div class="left wdH">
	<div class="tBG"></div>
	<div class="bord">
	<div class="pic"><a href="#" target="_blank"><img alt="救命" src="img/wenyu_014.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">救命</a></strong></span></div>
	<div class="line"></div>
	</div></div>

	<div class="left wdG">
	<div class="tBG"></div>
	<div class="bord">
	<div class="pic"><a href="#" target="_blank"><img alt="罗马，不设防的城市" src="img/wenyu_015.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">罗马，不设防的城市</a></strong></span></div>
	<div class="line"></div>
	</div></div>

	<div class="left wdD">
	<div class="tBG"></div>
	<div class="bord">
	<div class="pic"><a href="#" target="_blank"><img alt="可可西里" src="img/wenyu_015.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">可可西里</a></strong></span></div>
	<div class="line"></div>
	</div></div>

	<div class="left wdD">
	<div class="tBG"></div>
	<div class="bord">
	<div class="pic"><a href="#" target="_blank"><img alt="可可西里" src="img/wenyu_014.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">可可西里</a></strong></span></div>
	<div class="line"></div>
	</div></div>

	<div class="left wdB">
	<div class="tBG"></div>
	<div class="bord">
	<div class="pic"><a href="#" target="_blank"><img alt="神经侠侣" src="img/wenyu_015.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">神经侠侣</a></strong></span></div>
	<div class="line"></div>
	</div></div>

	<div class="left wdD">
	<div class="tBG"></div>
	<div class="bord">
	<div class="pic"><a href="#" target="_blank"><img alt="可可西里" src="img/wenyu_014.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">可可西里</a></strong></span></div>
	<div class="line"></div>
	</div></div>

	<div class="left wdD">
	<div class="tBG"></div>
	<div class="bord">
	<div class="pic"><a href="#" target="_blank"><img alt="可可西里" src="img/wenyu_015.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">可可西里</a></strong></span></div>
	<div class="line"></div>
	</div></div>

	<div class="left wdF">
	<div class="tBG"></div>
	<div class="bord">
	<div class="pic"><a href="#" target="_blank"><img alt="刀剑笑" src="img/wenyu_014.jpg" width="150" height="85"></a><span><strong><a href="#" target="_blank">刀剑笑</a></strong></span></div>
	<div class="line"></div>
	</div></div>
	</div>
	</div>
	<div class="btns"><a href="javascript:void(0)" class="up"></a><a href="javascript:void(0)" class="down"></a></div>
	</div>

	</div>
}

function fillnewbyStyle8(columnid,news)//样式八适用：新闻频道（精品栏目），纪录片频道（香港香港）
{
	<div class="cjing_left_gj">
	<p><b>精品栏目</b><span><a href="#">更多>></a></span></p>
	</div>

	<div class="jilu_xgang">
	<ul>
	<li><a href="#"><img src="img/jilu_006.jpg" width="140" height="80" /></a><span><a href="#">已向遇难台湾渔民向遇难台湾渔民的的家属幸</a><strong>渔民的家属以及台湾人民就这起</strong></span></li>
	<li class="jilu_pli"><a href="#"><img src="img/jilu_006.jpg" width="140" height="80" /></a><span><a href="#">已向遇难湾人民就这起不幸</a><strong>渔民的家属以及台湾人民就这起</strong></span></li>
	<li><a href="#"><img src="img/jilu_006.jpg" width="140" height="80" /></a><span><a href="#">已向遇难台湾渔民的不幸</a><strong>渔民的家属以及台湾人民就这起</strong></span></li>
	<li class="jilu_pli"><a href="#"><img src="img/jilu_006.jpg" width="140" height="80" /></a><span><a href="#">已向遇难台湾渔民的家属以及台湾人民就这起不幸</a><strong>渔民的家属以</strong></span></li>
	</ul>
	</div>
}
