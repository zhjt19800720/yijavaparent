package com.yijava.admin.service.account;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.stereotype.Component;

import com.yijava.admin.service.account.CaptchaAuthenticationFilter.UsernamePasswordTokeExtend;

/**
 * 自定义RememberMeManager,根据页面提交的cookie有效时间来设置cookie的maxAge值
 * 
 * @author vincent
 *
 */
@Component
public class CustomRememberMeManager extends CookieRememberMeManager{
	
	/**
	 * 构造方法，不在这里对Cookie的maxAge设置值
	 */
	public CustomRememberMeManager() {
		Cookie cookie = new SimpleCookie(DEFAULT_REMEMBER_ME_COOKIE_NAME);
        cookie.setHttpOnly(true);
        setCookie(cookie);
	}
	
	/**
	 * 重写父类方法，写入Cookie时，先把传过来的有效时间设置到cookie里面在序列化Identity
	 */
	@Override
	public void rememberIdentity(Subject subject, AuthenticationToken token,AuthenticationInfo authcInfo) {
		UsernamePasswordTokeExtend tokeExtend = (UsernamePasswordTokeExtend) token;
		
		getCookie().setMaxAge(tokeExtend.getRememberMeCookieValue());
		
		super.rememberIdentity(subject, token, authcInfo);
	}
}
