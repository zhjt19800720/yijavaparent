package com.yijava.common;

public class HttpConstants {

	//获取所有省份
	public static String GET_PROVINCE_URI="http://data.cncnews.cn/cnc/province.jsp";
	
	//获取区域新闻的接口
	public static String GET_NEW_BYPROVINCE_URI="http://data.cncnews.cn/cnc/localsearch.jsp";
	
	//获取所有栏目
	public static String GET_ALLCOLUMN="http://data.cncnews.cn/cnc/column_list.jsp";
	
	//根据栏目获取新闻
	public static String GET_NEW_BYCOLUMN_URI="http://data.cncnews.cn/cnc/column_news_list.jsp";

	
	//得到订阅
	public static String GET_SUBSCIBE_URI="http://login.cncnews.cn/subscibe/subjectlist.cc";
	//根据订阅查找新闻
	public static String GET_SUBSCIBE_NEW_URI="http://login.cncnews.cn/subscibe/newslist.cc";
	
	public static String GET_ISLOGIN_URI="http://login.cncnews.cn/user/islogin.cc";
	
	public static String SERVER_BASE_URL="http://audio.cncnews.cn/stream/";
}
