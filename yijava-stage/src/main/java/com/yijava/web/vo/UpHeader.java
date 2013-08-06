package com.yijava.web.vo;

/**
 * 上行报文头
 * @author zhjt
 *
 */
public class UpHeader {

	private String uid;
	private String sid;
	private String st;
	
	
	
	public UpHeader() {
		super();
	}
	public UpHeader(String uid, String sid, String st) {
		super();
		this.uid = uid;
		this.sid = sid;
		this.st = st;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}
	
	
	
}
