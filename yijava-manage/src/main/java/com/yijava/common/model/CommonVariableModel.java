package com.yijava.common.model;

import com.yijava.entity.User;

public class CommonVariableModel {
	// 当前用户
	private User user;

	/**
	 * 获取当前用户
	 * 
	 * @return {@link User}
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 设置当前用户
	 * 
	 * @param user
	 *            当前用户
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
