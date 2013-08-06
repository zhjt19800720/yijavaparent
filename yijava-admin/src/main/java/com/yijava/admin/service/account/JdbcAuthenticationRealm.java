package com.yijava.admin.service.account;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import com.yijava.admin.common.enumeration.entity.State;
import com.yijava.admin.common.model.CommonVariableModel;
import com.yijava.admin.entity.account.User;

/**
 * 
 * apache shiro 的身份验证类
 * 
 * @author vincent
 *
 */
public class JdbcAuthenticationRealm extends AuthorizationRealm{
	
	private final static Logger logger = LoggerFactory.getLogger(JdbcAuthenticationRealm.class);
	
	
	@Autowired
	private AccountManager accountManager;

	/**
	 * 用户登录的身份验证方法
	 * 
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		logger.debug("--------------------------"+usernamePasswordToken.getUsername());
        String username = usernamePasswordToken.getUsername();
        
        if (username == null) {
            throw new AccountException("用户名不能为空");
        }
        
        User user = accountManager.getUserByUsername(username);
        
        if (user == null) {
            throw new UnknownAccountException("用户不存在");
        }
        
        if (user.getState().equals(State.Disable.getValue())) {
        	 throw new DisabledAccountException("你的账户是禁用的账户");
        }
        
        CommonVariableModel model = new CommonVariableModel(user);
        
        return new SimpleAuthenticationInfo(model,user.getPassword(),getName());
	}
	

}
