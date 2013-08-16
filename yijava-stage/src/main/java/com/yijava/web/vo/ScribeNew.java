package com.yijava.web.vo;

public class ScribeNew {

	private String desc;
	private String picurl;
	private String url;
	private String date;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ScribeNew() {
		super();
	}
	public ScribeNew(String desc, String picurl, String url) {
		super();
		this.desc = desc;
		this.picurl = picurl;
		this.url = url;
	}
	
	
}
