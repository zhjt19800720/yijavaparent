package com.yijava.web.vo;

import java.util.Date;

public class PlayVo {

	private String id;
	private String title;
	private Date pubdate;
	private String mp3;
	
	
	
	public PlayVo() {
		super();
	}
	public PlayVo(String id, String title, Date pubdate, String mp3) {
		super();
		this.id = id;
		this.title = title;
		this.pubdate = pubdate;
		this.mp3 = mp3;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public String getMp3() {
		return mp3;
	}
	public void setMp3(String mp3) {
		this.mp3 = mp3;
	}
	
	
	
}
