package com.yijava.web.vo;

import java.util.List;

public class Channel {

	private String channel_id;
	private String channel_name;	
	private List<Column> columns;
	
	
	
	public Channel() {
		super();
	}
	public Channel(String channel_id, String channel_name, List<Column> columns) {
		super();
		this.channel_id = channel_id;
		this.channel_name = channel_name;
		this.columns = columns;
	}
	public String getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}
	public String getChannel_name() {
		return channel_name;
	}
	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}
	public List<Column> getColumns() {
		return columns;
	}
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	
	
	
	
}
