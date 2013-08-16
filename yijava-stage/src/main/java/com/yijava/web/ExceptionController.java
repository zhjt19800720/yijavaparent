package com.yijava.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 错误处理
 * @author zhjt
 *
 */
@Controller

public class ExceptionController {

	@RequestMapping("/exception/default")
	public String defaultException(Model model,HttpServletRequest request) {
		return "error/500";
	}
}
