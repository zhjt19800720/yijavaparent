package com.yijava.admin.web.channel;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yijava.orm.core.PageRequest;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@RequestMapping("view")
	public String view(PageRequest pageRequest,HttpServletRequest request) {
		
		return "article/view";
	}
}
