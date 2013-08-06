package com.yijava.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yijava.dao.http.BaseHttpUtil;
import com.yijava.entity.UserCustom;
import com.yijava.entity.WeatherInfo;
import com.yijava.service.UserCustomService;
import com.yijava.service.WeatherService;
import com.yijava.web.vo.Channel;
import com.yijava.web.vo.CncNew;
import com.yijava.web.vo.Result;
import com.yijava.web.vo.UpBody;
import com.yijava.web.vo.UpCloumnMessage;
import com.yijava.web.vo.UpColumnBody;
import com.yijava.web.vo.UpColumnHeader;
import com.yijava.web.vo.UpHeader;
import com.yijava.web.vo.UpMessage;

@Controller
public class CustomController {

	@Autowired
	private UserCustomService userCustomService;
	
	@Autowired
	private WeatherService weatherService;
	
	@Autowired
	private BaseHttpUtil httpService;
	
	
	@RequestMapping("/me")
	public String index(Model model) {
		
		List<String> provinces = httpService.getAllProvince();
		
		WeatherInfo weatherinfo=weatherService.getWeatherInfoByCityName("北京");
		
		//检索地区新闻
		UpHeader header = new UpHeader("", "", "");
		UpBody body = new UpBody("天津", "10", "1");		
		UpMessage message = new UpMessage(header, body);		
		List<CncNew> cncNews=httpService.getNewsByProvince(message);
		
		//检索所有栏目
		List<Channel> channels=httpService.getAllChannel();
		//根据栏目检索新闻
		UpCloumnMessage columnmessage=new UpCloumnMessage(new UpColumnHeader("","","","","","",""),new UpColumnBody("201101644","",""));
		
		List<CncNew> news=httpService.getAllNewsByChannel(columnmessage);
		
		
		model.addAttribute("entity", weatherinfo);
		model.addAttribute("provinces", provinces);
		return "index";
	}
	@RequestMapping("/me/custom/add")
	@ResponseBody
	public Result<Integer> addUserCustom(HttpServletRequest request)
	{
		String channelids = request.getParameter("ids");
		
		UserCustom entity=new UserCustom();
		entity.setUser_id(1);
		entity.setChannel_ids(channelids);
		userCustomService.insertUserCustom(entity);
		
		
		
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
	
	
}
