package com.yijava.web.vo;

import org.codehaus.jackson.annotate.JsonProperty;

public class CncNew {

	private String title;
	private String date;
	private String media;
	private String url;
	private String desciber;
	private NewImage image_set;
	
	
	
	
	public CncNew() {
		super();
	}
	
	public CncNew(String desciber,String title, String date, String media, String url) {
		super();
		this.title = title;
		this.date = date;
		this.media = media;
		this.url = url;
		this.desciber=desciber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@JsonProperty("abstract")
	public String getDesciber() {
		return desciber;
	}
	public void setDesciber(String desciber) {
		this.desciber = desciber;
	}

	public NewImage getImage_set() {
		return image_set;
	}

	public void setImage_set(NewImage image_set) {
		this.image_set = image_set;
	}
	
	
}
