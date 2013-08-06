package com.yijava.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yijava.entity.User;
import com.yijava.service.UserService;
import com.yijava.web.vo.ErrorCode;
import com.yijava.web.vo.Result;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("no_visible_elements", "show");
		return "login";
	}

	@RequestMapping("/checklogin")
	@ResponseBody
	public Result<User> checkLogin(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");		
		User user=userService.getUserByUsername(username);
		Result<User> result = new Result<User>();
		if(null==user)
		{
			result.setError(new ErrorCode("用户名错误"));
		}else
		{
			
			Md5PasswordEncoder md5=new Md5PasswordEncoder();
			password=md5.encodePassword("cnc", password);
			if(StringUtils.equals(user.getPassword(), password))
			{
				request.getSession().setAttribute("currentUser", user);
				user.setPassword(null);
				result.setState(1);
				result.setData(user);
			}else
			{
				//密码不正确
				result.setState(0);
				result.setError(new ErrorCode("密码错误"));
			}
		}		
		return result;
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		request.getSession().setAttribute("currentUser",null);
		request.getSession().invalidate();
		return "redirect:/login";
	}
	
}
