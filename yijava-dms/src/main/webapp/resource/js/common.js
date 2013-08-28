$(function(){
	InitLeftMenu();
	//tabClose();
	//tabCloseEven();
});

function addTab(subtitle,url){
	if(!$('#tabs').tabs('exists',subtitle)){
		$('#tabs').tabs('add',{
			title:subtitle,
			content:createFrame(url),
			closable:true,
			width:$('#mainPanle').width()-10,
			height:$('#mainPanle').height()-26
		});
	}else{
		$('#tabs').tabs('select',subtitle);
	}
	tabClose();
}


function createFrame(url)
{
	var s = '<iframe name="mainFrame" scrolling="no" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}


function InitLeftMenu()
{
	
	$('.menu-text a').click(function(){
		
		var tabTitle = $(this).text();
		var url = $(this).attr("url");
		addTab(tabTitle,url);
	});
}



function tabClose()
{
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children("span").text();
		$('#tabs').tabs('close',subtitle);
	})

	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY,
		});
		
		var subtitle =$(this).children("span").text();
		$('#mm').data("currtab",subtitle);
		
		return false;
	});
}
function openwind(obj)
{
	
	//var tabTitle = obj.text();
	//var url = obj.attr("url");
	//addTab(tabTitle,url);
}

