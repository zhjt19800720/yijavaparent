package com.yijava.web;

import java.util.ArrayList;
import java.util.List;

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
import com.yijava.web.vo.Channel;
import com.yijava.web.vo.CncNew;
import com.yijava.web.vo.Column;
import com.yijava.web.vo.Result;
import com.yijava.web.vo.UpBody;
import com.yijava.web.vo.UpCloumnMessage;
import com.yijava.web.vo.UpColumnBody;
import com.yijava.web.vo.UpColumnHeader;
import com.yijava.web.vo.UpHeader;
import com.yijava.web.vo.UpMessage;

@Controller
public class CustomController {

	private static final Logger logger = LoggerFactory.getLogger(CustomController.class);
	
	@Autowired
	private UserCustomService userCustomService;
	
	@Autowired
	private WeatherService weatherService;
	
	@Autowired
	private BaseHttpUtil httpService;
	
	
	@RequestMapping("/me")
	public String index(Model model) {
		List<Channel>  channels = httpService.getAllChannel();	
		//用户已经收藏的栏目
		String uid="11";
		UserCustom userCustom=userCustomService.getUserCustomByUid(uid);
		List<Column> columns=null; 
		//根据用户已经收藏的id得到栏目
		if(userCustom!=null && userCustom.getChannel_ids()!=null && userCustom.getChannel_ids()!="")
		{
			columns=new ArrayList<Column>();			
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
				}
			}
		}
		
		
		
		
		List<String> provinces  = httpService.getAllProvince();		
		
		//检索地区新闻		
		if(provinces!=null)
			model.addAttribute("provinces", provinces);
		if(channels!=null)
			model.addAttribute("channels", channels);
		if(userCustom!=null)			
			model.addAttribute("customs", columns);
		return "index";
	}
	@RequestMapping("/me/custom/add")
	@ResponseBody
	public Result<Integer> addUserCustom(HttpServletRequest request)
	{
		String uid="11";
		UserCustom userCustom=userCustomService.getUserCustomByUid(uid);
		
		String channelids = request.getParameter("ids");
		String region = request.getParameter("region");		
		
		
		
		if(userCustom==null)
		{
			UserCustom entity=new UserCustom();
			entity.setUser_id(uid);
			entity.setChannel_ids(channelids);
			entity.setRegion_name(region);
			userCustomService.insertUserCustom(entity);
		}
		{
			//if(channelids.equals(userCustom.getChannel_ids()) && !region.equals(userCustom.getRegion_name()))
			//{
				UserCustom entity=new UserCustom();
				entity.setUser_id(uid);
				entity.setChannel_ids(channelids);
				entity.setId(userCustom.getId());
				entity.setRegion_name(region);
				userCustomService.updateUserCustom(userCustom,entity);
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
	public List<CncNew> getNewByChannel(@RequestParam(value = "columnid", required = false)String columnid)
	{		
		//根据栏目检索新闻
		UpCloumnMessage columnmessage=new UpCloumnMessage(new UpColumnHeader("","","","","","",""),new UpColumnBody(columnid,"10","1"));				
		return httpService.getAllNewsByChannel(columnmessage);
	}
	
	/**
	 * 根据区域获取新闻
	 * @param columnid
	 * @return
	 */
	@RequestMapping("/api/getnewbyr")
	@ResponseBody
	public List<CncNew> getNewByRegion(@RequestParam(value = "regionname", required = false)String regionname)
	{
		UpHeader header = new UpHeader("", "", "");
		UpBody body = new UpBody("北京", "10", "1");		
		UpMessage message = new UpMessage(header, body);		
		return httpService.getNewsByProvince(message);
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
	
	
	
}
