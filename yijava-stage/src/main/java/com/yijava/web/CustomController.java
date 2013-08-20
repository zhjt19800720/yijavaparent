package com.yijava.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yijava.dao.http.BaseHttpUtil;
import com.yijava.entity.UserCustom;
import com.yijava.entity.WeatherInfo;
import com.yijava.service.UserCustomService;
import com.yijava.service.WeatherService;
import com.yijava.web.vo.CNew;
import com.yijava.web.vo.Channel;
import com.yijava.web.vo.CncNew;
import com.yijava.web.vo.Column;
import com.yijava.web.vo.DownLogin;
import com.yijava.web.vo.LogedUser;
import com.yijava.web.vo.Result;
import com.yijava.web.vo.ScribeNew;
import com.yijava.web.vo.UpBody;
import com.yijava.web.vo.UpCloumnMessage;
import com.yijava.web.vo.UpColumnBody;
import com.yijava.web.vo.UpColumnHeader;
import com.yijava.web.vo.UpHeader;
import com.yijava.web.vo.UpMessage;
import com.yijava.web.vo.UpScribe;
import com.yijava.web.vo.UpScribeBody;
import com.yijava.web.vo.UpScribeNew;
import com.yijava.web.vo.UpScribeNewBody;

@Controller
public class CustomController {

	private static final Logger logger = LoggerFactory.getLogger(CustomController.class);
	
	@Autowired
	private UserCustomService userCustomService;
	
	@Autowired
	private WeatherService weatherService;
	
	@Autowired
	private BaseHttpUtil httpService;
	
	@RequestMapping("/seting")
	public String seting()
	{
		return "setting";
	}
	
	@RequestMapping("/me")
	public String index(Model model,HttpServletRequest request) {		
		
		LogedUser user=getUserIdFromCookie(request);
		logger.debug("cookieuser"+user.toString());
		user.setUid("b42752e55a1397348588d015a60eb8ee");
		//所有栏目
		List<Channel>  channels = httpService.getAllChannel();					
		List<Column> nosetAllcolumns=new ArrayList<Column>();	
		for(Channel channel:channels)
		{				
			List<Column> tmpcolumns1=channel.getColumns();			
			for(Column c:tmpcolumns1)
			{
				nosetAllcolumns.add(c);
			}
		}
		//所有地区
		List<String> provinces  = httpService.getAllProvince();		
		
		logger.debug(user.toString());
		if(user.getUid()!=null)
		{
			//换取uid
			DownLogin loged=httpService.isLogin(user.getUid());
			if(loged!=null)
			{
				user.setUid(loged.getUserid().toString());
				logger.debug("cookieuser"+user.toString());
				if(loged.getUserid()!=null)
				{
					//throw new RuntimeException("访问此页面需要先登陆");		
					//用户已经收藏的栏目
					
					UserCustom userCustom=userCustomService.getUserCustomByUid(user.getUid());
					List<Column> columns=null; 
					List<Column> allcolumns=null;
					
					
					LinkedList<Column> newcolumns=new LinkedList<Column>();
					if(userCustom!=null && userCustom.getChannel_ids()!=null && userCustom.getChannel_ids()!="")
					{
						//用户已经收藏的栏目
						
						String[] ids=userCustom.getChannel_ids().split("-");
						for(String id:ids)
						{
							for(Column colunm:nosetAllcolumns)
							{
								if(colunm.getColumn_id().equals(id))
								{
									newcolumns.add(colunm);
									break;
								}
							}
						}
					}
					
					
					//根据用户已经收藏的id得到栏目
					if(userCustom!=null && userCustom.getChannel_ids()!=null && userCustom.getChannel_ids()!="")
					{
						columns=new ArrayList<Column>();	
						allcolumns=new ArrayList<Column>();	
						for(Channel channel:channels)
						{				
							List<Column> tmpcolumns=channel.getColumns();			
							for(Column colunm:tmpcolumns)
							{
								if(userCustom.getChannel_ids().indexOf(colunm.getColumn_id())>-1)
								{						
									columns.add(colunm);
									colunm.setCustomed(true);
								}
								allcolumns.add(colunm);
								
							}
						}
					}
					//得到用户收藏的关键字
					String scribename = getUserScribeName(user.getUid());
					
					if(scribename!=null && !scribename.equals(""))
					{
						model.addAttribute("scribename", scribename);
					}
					
					if(userCustom!=null)
					{
						model.addAttribute("newcolumns", newcolumns);
						model.addAttribute("customs", columns);
						model.addAttribute("userCustom", userCustom);
					}
						
					if(allcolumns!=null)			
						model.addAttribute("allcolumns", allcolumns);
				}
			}		
		}
		//String uid="11";
		//订阅		
		if(nosetAllcolumns!=null)
			model.addAttribute("allnosetcolumns", nosetAllcolumns);	
		if(provinces!=null)
			model.addAttribute("provinces", provinces);
		if(channels!=null)
			model.addAttribute("channels", channels);
		
		return "setting";
	}
	@RequestMapping("/me/custom/add")
	@ResponseBody
	public Result<Integer> addUserCustom(HttpServletRequest request)
	{
		//String uid="11";
		String userId=request.getParameter("uid");
		
		UserCustom userCustom=userCustomService.getUserCustomByUid(userId);
		
		String channelids = request.getParameter("ids");
		String region = request.getParameter("region");		
		
		
		if(userCustom==null)
		{
			userCustom=new UserCustom();
			userCustom.setUser_id(userId);
			userCustom.setChannel_ids(channelids);
			userCustom.setRegion_name(region);
			userCustomService.insertUserCustom(userCustom);
		}else
		{
			//if(channelids.equals(userCustom.getChannel_ids()) && !region.equals(userCustom.getRegion_name()))
			//{
				//UserCustom entity=new UserCustom();
				userCustom.setUser_id(userId);
				userCustom.setChannel_ids(channelids);
				userCustom.setId(userCustom.getId());
				userCustom.setRegion_name(region);
				userCustomService.updateUserCustom(userCustom);
			//}
			
		}	
		
		
		Result<Integer> result=new Result<Integer>();
		result.setState(1);
		result.setData(1);
		return result;
	}
	
	@RequestMapping("/me/custom/delete")
	@ResponseBody
	public Result<Integer> deleteUserCustom()
	{
		Result<Integer> result=new Result<Integer>();
		result.setState(1);
		result.setData(1);
		return result;
	}
	
	//以下方法供ajax调用
	@RequestMapping("/api/getcustom")
	@ResponseBody
	public UserCustom getUserCustom(HttpServletRequest request)
	{
		String userId=request.getParameter("uid");
		return  userCustomService.getUserCustomByUid(userId);
	}
	/**
	 * 得到所有栏目
	 * @return
	 */
	@RequestMapping("/api/getchannels")
	@ResponseBody
	public List<Channel> getAllChannels()
	{
		//检索所有栏目
		return httpService.getAllChannel();
	}
	
	/**
	 * 根据栏目检索新闻
	 * @param columnid
	 * @return
	 */
	@RequestMapping("/api/getnewbyc")
	@ResponseBody
	public Map<String,List<CncNew>> getNewByChannel(@RequestParam(value = "columnid", required = false)String columnid)
	{	
		LinkedHashMap<String,List<CncNew>> newmap=new LinkedHashMap<String,List<CncNew>>();
		String[] columns=columnid.split("-");
		//根据栏目检索新闻
		List<CncNew> news;
		for(String column:columns)
		{
			UpCloumnMessage columnmessage=new UpCloumnMessage(new UpColumnHeader("","","","","","",""),new UpColumnBody(column,"1","10"));
			news=httpService.getAllNewsByChannel(columnmessage);
			if(news!=null)
			{
				newmap.put(column, news);
			}
			//break;
		}
				
		return newmap;
	}
	
	/**
	 * 根据区域获取新闻
	 * @param columnid
	 * @return
	 */
	@RequestMapping("/api/getnewbyr")
	@ResponseBody
	public List<CNew> getNewByRegion(@RequestParam(value = "regionname", required = false)String regionname)
	{
		UpHeader header = new UpHeader("", "", "");
		UpBody body = new UpBody(regionname, "10", "1");		
		UpMessage message = new UpMessage(header, body);		
		return httpService.getNewsByProvince(message);
	}
	
	/**
	 * 根据订阅获取新闻
	 * @param columnid
	 * @return
	 */
	@RequestMapping("/api/getnewbys")
	@ResponseBody
	public List<ScribeNew> getNewByScribe(@RequestParam(value = "userid", required = false)String userid)
	{		
		
		UpScribeNew message=new UpScribeNew(new UpColumnHeader("","","","","","",""),new UpScribeNewBody(userid,"2","1","5"));
		
		return httpService.getAllScribeNews(message);
	}
	
	/**
	 * 根据区域获取天气预报
	 * @param regionname
	 * @return
	 */
	@RequestMapping("/api/getweather")
	@ResponseBody
	public WeatherInfo getWeatherInfo(@RequestParam(value = "regionname", required = false)String regionname)
	{
		//天气
		WeatherInfo weatherinfo=null;
		try{
			weatherinfo=weatherService.getWeatherInfoByCityName(regionname);
		}catch(Exception e)
		{
			logger.error("get weather error"+e.toString());;
		}
		return weatherinfo;
	}
	
	/**
	 * 用户已经收藏的关键字
	 * @param userId
	 * @return
	 */
	@RequestMapping("/api/getscribename")
	@ResponseBody
	public String getUserScribeNameToJs(@RequestParam(value = "uid", required = false)String userId)
	{
		
		return getUserScribeName(userId);
	}
	
	
	private LogedUser getUserIdFromCookie(HttpServletRequest request)
	{
		LogedUser user=new LogedUser(); 
		Cookie cookies[] = request.getCookies() ;
        Cookie c1 = null ;
        if(cookies != null){
            for(int i=0;i<cookies.length;i++){
               c1 = cookies[i] ;
               if(c1.getName().equals("uid") && c1.getValue()!=null)
               {
            	   user.setUid(c1.getValue());
               }else if(c1.getName().equals("uname") && c1.getValue()!=null)
               {
            	   user.setUname(c1.getValue());
               }
               
            }
        }
        return user;
	}
	
	
	public String getUserScribeName(String userId)
	{
		UpScribe upScribeMessage = new UpScribe(new UpColumnHeader("","","","","","",""),new UpScribeBody(userId,"2"));		
		//upScribeMessage.setBody(new UpColumnHeader("","","","","","",""),new UpScribeBody("10000052","1"));
		String scribename=httpService.getAllScribe(upScribeMessage);
		return scribename;
	}
}
