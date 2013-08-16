package com.yijava.web.vo;

public class UpScribeBody {

	private String user_id;
	private String type;
	
	
	
	public UpScribeBody() {
		super();
	}
	
	
	public UpScribeBody(String user_id, String type) {
		super();
		this.user_id = user_id;
		this.type = type;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
