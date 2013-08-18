package com.yijava.web.vo;

public class LogedUser {

	private String uid;
	
	private String uname;

	
	
	public LogedUser() {
		super();
	}

	public LogedUser(String uid, String uname) {
		super();
		this.uid = uid;
		this.uname = uname;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "uid="+uid+",uname="+uname;
	}
	
	
	
}
