package com.yijava.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorityAnnotationInterceptor extends HandlerInterceptorAdapter{

	final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
		if(request.getRequestURI().contains("js") || request.getRequestURI().contains("css") || request.getRequestURI().contains("img"))
		{
			return true;
		}
		
		
		if(request.getRequestURI().contains("login"))
		{
			return true;
		}
		
		if(null==request.getSession().getAttribute("currentUser"))
		{
			//response.sendRedirect("/yijava-manage/login");
			return true;
		}else
		{
			return true;
		}
		
		/*User user = (User)httpServletRequest.getSession().getAttribute("currentUser");  
		if()
		{
			return true;
		}else
		{
			response.sendRedirect("/login");
			return false;
		}*/
		

		
	}

	
}
