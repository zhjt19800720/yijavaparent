package com.yijava.dao;

import org.springframework.stereotype.Repository;

import com.yijava.entity.User;
import com.yijava.orm.core.hibernate.support.HibernateSupportDao;

@Repository
public class UserDao extends HibernateSupportDao<User, String>{

	
	/**
	 * 通过用户id更新用户密码
	 * 
	 * @param userId 用户id
	 * @param password 密码
	 */
	public void updatePassword(Integer userId, String password) {
		executeUpdate(User.UpdatePassword, password,userId);
	}
	
	
}
