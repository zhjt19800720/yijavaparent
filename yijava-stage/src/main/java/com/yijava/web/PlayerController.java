package com.yijava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yijava.common.HttpConstants;
import com.yijava.entity.RadioNew;
import com.yijava.service.RadioNewService;
import com.yijava.web.vo.PlayVo;

@Controller
public class PlayerController {

	@Autowired
	private RadioNewService radioNewService;
	
	
	@RequestMapping("/player")
	public String view(Model model,@RequestParam(value = "id", required = false)String id)
	{
		RadioNew news=radioNewService.getRadioNew(new Long(id));
		
		if(news!=null)
		{
			PlayVo playvo=new PlayVo();
			playvo.setId(news.getId().toString());
			playvo.setMp3(HttpConstants.SERVER_BASE_URL+news.getRadio_file());
			playvo.setTitle(news.getTitle());
			playvo.setPubdate(news.getLast_date());
			
			model.addAttribute("news", playvo);
		}
		
		return "player";
	}
}
