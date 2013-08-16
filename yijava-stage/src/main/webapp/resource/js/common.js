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
};

Array.prototype.in_array = function(e) {  
    for(i=0; i<this.length && this[i]!=e; i++);  
    return !(i==this.length);  
} ;

function empty(v){ 
	switch (typeof v){ 
	case 'undefined' : return true; 
	case 'string' : if(trim(v).length == 0) return true; break; 
	case 'boolean' : if(!v) return true; break; 
	case 'number' : if(0 === v) return true; break; 
	case 'object' : 
	if(null === v) return true; 
	if(undefined !== v.length && v.length==0) return true; 
	for(var k in v){return false;} return true; 
	break; 
	} 
	return false; 
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

function showcustom()
{	
	$("#settingBtn").css('display','block'); 	
}