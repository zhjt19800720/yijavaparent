package com.yijava.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlayerController {

	@RequestMapping("/player")
	public String view()
	{
		return "player";
	}
}
