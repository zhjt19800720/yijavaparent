package com.yijava.web.vo;

public class DownLogin {

	private String msg;
	private Long userid;
	private String username;
	
	
	
	public DownLogin() {
		super();
	}
	public DownLogin(String msg, Long userid, String username) {
		super();
		this.msg = msg;
		this.userid = userid;
		this.username = username;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
