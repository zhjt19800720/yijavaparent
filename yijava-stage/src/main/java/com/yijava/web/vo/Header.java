package com.yijava.web.vo;

public class Header {

	private String resp_msg;
	private String resp_code;
	
	
	
	
	public Header() {
		super();
	}
	public Header(String resp_msg, String resp_code) {
		super();
		this.resp_msg = resp_msg;
		this.resp_code = resp_code;
	}
	public String getResp_msg() {
		return resp_msg;
	}
	public void setResp_msg(String resp_msg) {
		this.resp_msg = resp_msg;
	}
	public String getResp_code() {
		return resp_code;
	}
	public void setResp_code(String resp_code) {
		this.resp_code = resp_code;
	}
	
	
}
