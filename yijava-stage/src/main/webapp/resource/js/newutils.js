

function saveUserCustom(channels)
{
	var d = new Date();
	var n = d.getTime();
	
	var region=$('#selRegion').val();
	//alert(region);
	
	if(userId)
	{
		var params = "ids="+channels+"&region="+region+"&uid="+userId;
		$.ajax({
			  type: 'POST',
			  url: "me/custom/add",
			  data: params,		
			  success: Response,
		  	  error: function () {//ajax请求错误的情况返回超时重试。
		  		  alert(error);
		  	  }
		});	
	}else
	{
		alert("请先登陆再定制");
	}
	
	
}

function Response(msg){
	 // alert(msg.state)
	//
	location.reload() ;
}

function initpage()
{
	getCustom();
	getScribe();
}
//得到订阅
function getScribe()
{
	var params = "userid="+userId;
	$.ajax({
		  type: 'POST',
		  url: "api/getnewbys",
		  data: params,		
		  success: initScribe,
	  	  error: function () {//ajax请求错误的情况返回超时重试。
	  		  alert(error);
	  	  }
	});	
}

function initScribe(data)
{
	var content="";
	
	if(data.length>=1)
	{
		content+="<div class=\"focus_img\"><a href=\""+data[0].url+"\"><img src=\""+data[0].picurl+"\"></a></div>";
	}
	
	if(data.length>1)
	{
		content+="<ul class=\"focus_list\">";
		for(x in data)
		{
			content+="<li><span>"+data[x+1].date+"</span><a href=\""+data[x+1].url+"\">"+data[x+1].desc+"</a></li>";
		}
		content+="</ul>";
	}	
	$('#scribenew').html(content);	
}
//得到定制
function getCustom()
{
	var params = "uid="+userId;
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
	//alert("initregionnews");
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
	//alert("initcloumnnews");
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
		var stylename=getcolumnstyle(key);
		var funname="fillnewby"+stylename;
		
		var func = eval(funname);
		func(key,values);
		
		//eval(funname+"();");
		//funname(key,values);
		//fillnewbyStyle8(key,values);
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
//根据栏目id得到栏目名称
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
	
	
	
	if(news.length>=2)
	{
		content+="<h3><a href=\""+news[0].url+"\"><img src=\""+news[0].image_set.image_url+"\" width=\"150\" height=\"90\" /></a><span>" +
		"<a href=\""+news[0].url+"\">"+news[0].title+"</a></span></h3>";
		content+="<h3 class=\"mi_zp\"><a href=\""+news[1].url+"\"><img src=\""+news[1].image_set.image_url+"\" width=\"150\" height=\"90\" /></a><span>" +
		"<a href=\""+news[1].url+"\">"+news[1].title+"</a></span></h3>";
	}else
	{
		content+="<h3><a href=\""+news[0].url+"\"><img src=\""+news[0].image_set.image_url+"\" width=\"150\" height=\"90\" /></a><span>" +
		"<a href=\""+news[0].url+"\">"+news[0].title+"</a></span></h3>";
	}
	
	content+="</div>";
	
	if(news.length>=3)
	{
		content+="<div class=\"gj_mj_right\">";
		
		
		content+="<p><b><a href=\""+news[2].url+"\">"+news[2].title+"</a></b><span>";
		
		if(news.length>=4)
	    {
			for(var j=0;j<3;j++)
			{
				if(news[j+3])
				{
					content+="<a href=\""+news[j+3].url+"\">"+news[j+3].title+"</a><br />";	
				}
			}
	    }		
		content+="</div>";
	}	
	content+="</div>";
	$('#newscolumn').append(content);
}

function fillnewbyStyle2(columnid,news)//样式二适用：财经频道（宏观经济）；文娱频道（文化时尚），新闻频道（文化时尚）
{
	var content="";
	var columnurl=getColumnUrlById(columnid);
	var columnname=getColumnNameById(columnid);
	
	
	content+="<div class=\"cjing_left_gj\">";
	content+="<p><b>"+columnname+"</b><span><a href=\""+columnurl+"\">更多>></a></span></p>";
	content+="</div>";
	
	content+="<div class=\"left_gj_mj\">";
	content+="<div class=\"gj_mj_left\">";
	
	content+="<h2><a href=\""+news[0].url+"\"><img src=\""+news[0].image_set.image_url+"\" width=\"320\" height=\"185\" /></a></h2>";	
	content+="</div>";
	
	if(news.length>=2)
	{
		content+="<div class=\"mj_right_hj\">";
		content+="<p><b><a href=\""+news[1].url+"\">"+news[1].title+"</a><br /><strong>"+news[1].abstract+"</strong></b><span>";
		
		if(news.length>=3)
		{
			for(var j=0;j<3;j++)
			{
				if(news[j+2])
				{
					content+="<a href=\""+news[j+2].url+"\">"+news[j+2].title+"</a><br />";
				}
			}
		}		

		content+="</span>";
		content+="</p>";
		content+="</div>";
	}
	
	content+="</div>";
	
	$('#newscolumn').append(content);
}

function fillnewbyStyle3(columnid,news)//样式三适用：财经频道（金融市场），体育频道（火爆篮球）
{
	var content="";
	var columnurl=getColumnUrlById(columnid);
	var columnname=getColumnNameById(columnid);
	
	
	content+="<div class=\"cjing_left_gj\">";
	content+="<p><b>"+columnname+"</b><span><a href=\""+columnurl+"\">更多>></a></span></p>";
	content+="</div>";
	
	content+="<div class=\"cjing_left_jr\">";
	content+="<ul>";
	content+="<li><a href=\""+news[0].url+"\"><img src=\""+news[0].image_set.image_url+"\" width=\"150\" height=\"90\" /></a>" +
			"<span><a href=\""+news[0].url+"\">"+news[0].title+"</a><strong>"+news[0].abstract+"</strong></span></li>";
	
	
	if(news.length>=2)
	{
		for(var j=0;j<3;j++)
		{
			if(news[j+1])
			{
				content+="<li class=\"left_jrpl\"><a href=\""+news[j+1].url+"\"><img src=\""+news[j+1].image_set.image_url+"\" width=\"150\" height=\"90\" /></a>" +
				"<span><a href=\""+news[j+1].url+"\">"+news[j+1].title+"</a><strong>"+news[j+1].abstract+"</strong></span></li>";
			}
		}
	}
	
	
	
	
	content+="</ul>";
	content+="</div>";
	

	$('#newscolumn').append(content);
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
		
		if(x>=3)
		{
			break;
		}
	}
	content+="</div>";
	$('#newscolumn').append(content);
}

function fillnewbyStyle6(columnid,news)//样式六适用：文娱频道（名人明星），体育频道（超级足球），纪录片频道（领进着说）
{
	var content="";
	var columnurl=getColumnUrlById(columnid);
	var columnname=getColumnNameById(columnid);
	
	
	content+="<div class=\"cjing_left_gj\">";
	content+="<p><b>"+columnname+"</b><span><a href=\""+columnurl+"\">更多>></a></span></p>";
	content+="</div>";
	
	content+="<div class=\"guonei_jqu\">";
	
	content+="<div class=\"guonei_jqu_z\">";
	
	content+="<p><a href=\""+news[0].url+"\"><img src=\""+news[0].image_set.image_url+"\" width=\"320\" height=\"170\" /></a>" +
			"<i>"+news[0].title+"</i><b><a href=\"#\">"+news[0].title+"</a></b></p>";
	
	content+="</div>";
	
	if(news.length>=2)
	{
	
		content+="<div class=\"guonei_jqu_z guonei_jqu_y\">";

	
		content+="<p><a href=\""+news[1].url+"\"><img src=\""+news[1].image_set.image_url+"\" width=\"320\" height=\"170\" /></a>" +
			"<i>"+news[1].title+"</i><b><a href=\""+news[1].url+"\">"+news[1].title+"</a></b></p>";
	
		content+="</div>";
	
	}
	content+="<div class=\"clear\"></div>";

	content+="</div>";
	
	$('#newscolumn').append(content);
	
}
function fillnewbyStyle7(columnid,news)//样式七适用：文娱频道（影视天地），纪录片频道（环球纵横）
{
	//为了设置滚动事件变量
	
	
	var content="";
	var columnurl=getColumnUrlById(columnid);
	var columnname=getColumnNameById(columnid);
	
	
	content+="<div class=\"cjing_left_gj\">";
	content+="<p><b>"+columnname+"</b><span><a href=\""+columnurl+"\">更多>></a></span></p>";
	content+="</div>";
	
	content+="<div class=\"wenyu_luh\">";
	/*if(style7sum==0)
	{
		content+="<div id=\"contentE\" class=\"area\">";
	}else
	{*/
		
		content+="<div id=\"contentE"+style7sum+"\" class=\"area\">";
	//}
	
	content+="<div class=\"cons\">";

	content+="<div class=\"con\" style=\"left: 0px;\">";

	for(var x=0;x<news.length;x++)
	//for(x in news)
	{
		content+="<div class=\"left wdA\">";
		content+="<div class=\"tBG\"></div>";
		content+="<div class=\"bord\">";
		content+="<div class=\"pic\"><a href=\""+news[x].url+"\" target=\"_blank\">" +
				"<img alt=\""+news[x].title+"\" src=\""+news[x].image_set.image_url+"\" width=\"150\" height=\"90\"></a>" +
				"<span><strong><a href=\""+news[x].url+"\" target=\"_blank\">"+news[x].title+"</a></strong></span></div>";
		
		content+="<div class=\"line\"></div>";
		content+="</div>";
		content+="</div>";
		
		//if(x>=9)
			//break;
	}
	content+="</div>";
	content+="</div>";
	content+="<div class=\"btns\"><a href=\"javascript:void(0)\" class=\"up\"></a><a href=\"javascript:void(0)\" class=\"down\"></a></div>";
	content+="</div>";
	content+="</div>";
	
	$('#newscolumn').append(content);
	
	//配置事件
	initscrool(style7sum);
	
	style7sum++;
}

function fillnewbyStyle8(columnid,news)//样式八适用：新闻频道（精品栏目），纪录片频道（香港香港）
{
	var content="";
	var columnurl=getColumnUrlById(columnid);
	var columnname=getColumnNameById(columnid);
	
	
	content+="<div class=\"cjing_left_gj\">";
	content+="<p><b>"+columnname+"</b><span><a href=\""+columnurl+"\">更多>></a></span></p>";
	content+="</div>";
	
	content+="<div class=\"jilu_xgang\">";
	content+="<ul>";
	
	for ( x in news)
	{
		if(x%2==0)
		{
			content+="<li><a href=\""+news[x].url+"\"><img src=\""+news[x].image_set.image_url+"\" width=\"140\" height=\"80\" /></a><span>" +
			"<a href=\""+news[x].url+"\">"+news[x].title+"</a><strong>"+news[x].title+"</strong></span></li>";
		}else
		{
			content+="<li class=\"jilu_pli\"><a href=\""+news[x].url+"\"><img src=\""+news[x].image_set.image_url+"\" width=\"140\" height=\"80\" /></a><span>" +
			"<a href=\""+news[x].url+"\">"+news[x].title+"</a><strong>"+news[x].title+"</strong></span></li>";
		}		
		
		
		if(x>=3)
		{
			break;
		}
	}	
	content+="</ul>";
	content+="</div>";
	$('#newscolumn').append(content);
}

function getcolumnstyle(columnid)
{
	var stylename="";
	for (x in colstyle)//数组中的每一个变量
	{
		if (colstyle[x][0].in_array(columnid))
		{
			stylename=colstyle[x][1];
			break;
		}
			
			
	}
	return stylename;	
}


function initscrool(num)
{
	/*if (num==0)
	{
		var rr = $('#contentE');
	}else
	{*/
		var rr = $('#contentE'+num);
	//}
	
	
	var conr = rr.find('div.con'),
		conr0 = conr[0],
		btnWr = rr.find('> div.btns'),
		btnPr = btnWr.find('a.up'),
		btnNr = btnWr.find('a.down');
	
	var lisr = conr.find('.left');
	
	conr.find(".bord").hover(function(){
		$(this).addClass("bgBord");
	},function(){
		$(this).removeClass("bgBord");
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
}

function initcolumnstyle()
{
	
	var colstyle=new Array(); 
	colstyle[0][0] = new Array('124020580','124020650','124020731');
	colstyle[0][1] = "style1";
	colstyle[1][0] = new Array('124020581','124020810');
	colstyle[1][1] = "style2";
	colstyle[2][0] = new Array('124020582','124020730');
	colstyle[2][1] = "style3";
	colstyle[3][0] = new Array('124020583','124020621','124020734');
	colstyle[3][1] = "style4";
	colstyle[4][0] = new Array('124020584','124020733','124020732','124020825');
	colstyle[4][1] = "style5";
	colstyle[5][0] = new Array('124020651','124020729','124020826');
	colstyle[5][1] = "style6";
	colstyle[6][0] = new Array('124020652','124020824');
	colstyle[6][1] = "style7";
	colstyle[7][0] = new Array('124020773','124020827');
	colstyle[7][1] = "style8";
	
	/* {
                        "column_id": 124020651,
                        "column_name": "名人明星",
                        "column_url": "http://wenyu.cncnews.cn/shehui/index.html"
                    },
	 * {
                        "column_id": 124020653,
                        "column_name": "服务",
                        "column_url": "http://wenyu.cncnews.cn/fuwu/index.html"
                    }
	 *  {
                        "column_id": 124021172,
                        "column_name": "名记专栏",
                        "column_url": "http://news.cncnews.cn/reporter/index.html"
                    }
	 * columns": [
                    {
                        "column_id": 124021209,
                        "column_name": "科技",
                        "column_url": "http://photo.cncnews.cn/technology/index.html"
                    },
                    {
                        "column_id": 124021210,
                        "column_name": "军事",
                        "column_url": "http://photo.cncnews.cn/military/index.html"
                    },
                    {
                        "column_id": 124021204,
                        "column_name": "视觉中国",
                        "column_url": "http://photo.cncnews.cn/china/index.html"
                    }
	 * */
}
