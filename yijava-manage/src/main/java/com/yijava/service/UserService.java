package com.yijava.service;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yijava.common.SystemVariableUtils;
import com.yijava.dao.UserDao;
import com.yijava.entity.User;

@Service
@Transactional
public class UserService {

	// 用户数据访问
	@Autowired
	private UserDao userDao;
	
	/**
	 * 更新当前用户密码
	 * 
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * 
	 * @return boolean
	 */
	public boolean updateUserPassword(String oldPassword, String newPassword) {
		User user = SystemVariableUtils.getCommonVariableModel().getUser();
		
		oldPassword = new SimpleHash("MD5", oldPassword.toCharArray()).toString();
		if(user.getPassword().equals(oldPassword)) {
			String temp = new SimpleHash("MD5",newPassword).toHex();
			userDao.updatePassword(user.getId(),temp);
			user.setPassword(temp); 
			return true;
		}		
		return false;
	}
	
	/**
	 * 通过id获取用户实体
	 * @param id 用户id
	 */
	public User getUser(String id) {
		return userDao.load(id);
	}
	
	/**
	 * 新增用户
	 * 
	 * @param entity 用户实体
	 */
	public void insertUser(User entity) {
		if (!isUsernameUnique(entity.getUsername())) {
			throw new ServiceException("用户名已存在");
		}
		
		String password = new SimpleHash("MD5", entity.getPassword()).toHex();
		
		entity.setPassword(password);
		userDao.insert(entity);
	}
	
	/**
	 * 删除用户
	 * 
	 * @param ids 用户id集合
	 */
	public void deleteUsers(List<String> ids) {
		userDao.deleteAll(ids);
	}

	/**
	 * 通过用户名获取用户实体
	 * 
	 * @param username 用户实体
	 * 
	 * @return {@link User}
	 */
	public User getUserByUsername(String username) {
		return userDao.findUniqueByProperty("username", username);
	}
	
	/**
	 * 是否唯一的用户名 如果是返回true,否则返回false
	 * 
	 * @param username 用户名
	 * 
	 * @return boolean
	 */
	public boolean isUsernameUnique(String username) {
		return getUserByUsername(username) == null;
	}
	
	
}
