package com.yijava.web.vo;

import java.util.List;

public class DownBody {

	private String date;
	private List<Channel> channels;
	
	
	
	public DownBody() {
		super();
	}


	public DownBody(String date, List<Channel> channels) {
		super();
		this.date = date;
		this.channels = channels;
	}
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Channel> getChannels() {
		return channels;
	}
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	
	
	
}
