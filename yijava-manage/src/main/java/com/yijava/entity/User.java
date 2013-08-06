package com.yijava.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.NamedQuery;

import com.yijava.common.enumeration.entity.State;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
@Entity
@Table(name = "TB_USER")
@NamedQuery(name = User.UpdatePassword, query = "update User u set u.password = ?1 where u.id = ?2")
public class User {

	/**
	 * 更新用户密码NamedQuery
	 */
	public static final String UpdatePassword = "updatePassword";

	private Integer id;
	// 登录名称
	private String username;
	// 登录密码
	private String password;
	// 真实名称
	private String realname;
	// 状态
	private Integer state;
	// 邮件
	private String email;

	/**
	 * 构造方法
	 */
	public User() {
	}
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "user_id",unique = true,nullable = false, length = 10)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * 获取登录名称
	 * 
	 * @return String
	 */
	@Column(length = 64, unique = true, nullable = false, updatable = false)
	public String getUsername() {
		return username;
	}

	/**
	 * 设置登录名称
	 * 
	 * @param username
	 *            登录名称
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取登录密码
	 * 
	 * @return String
	 */
	@Column(nullable = false, length = 32, updatable = false)
	public String getPassword() {
		return password;
	}

	/**
	 * 设置登录密码
	 * 
	 * @param password
	 *            登录密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取真实姓名
	 * 
	 * @return String
	 */
	@Column(length = 128, nullable = false)
	public String getRealname() {
		return realname;
	}

	/**
	 * 设置真实名称
	 * 
	 * @param realname
	 *            真实姓名
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}

	/**
	 * 获取用户状态
	 * 
	 * @return {@link State}
	 */
	@Column(nullable = false)
	public Integer getState() {
		return state;
	}

	/**
	 * 设置用户状态
	 * 
	 * @param state
	 *            用户状态
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * 获取邮件
	 * 
	 * @return String
	 */
	@Column(length = 256)
	public String getEmail() {
		return email;
	}

	/**
	 * 设置邮件
	 * 
	 * @param email
	 *            邮件地址
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
