package com.yijava.admin.web.html;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yijava.admin.service.html.CreateHtmlManager;

@Controller
@RequestMapping("/html/create")
public class CreateHtmlController {
	
	@Autowired
	private CreateHtmlManager createHtmlManager;

	@RequestMapping("home")
	public String createHomeHtml(RedirectAttributes redirectAttributes,HttpServletRequest request) {
		
		createHtmlManager.processTemplate("tpl/default/ftl/index.ftl", null,"index.html");
		return "/html/success";
	}
}
