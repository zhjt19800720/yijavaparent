package com.yijava.web.vo;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class CNew {

	private String title;
	private String date;
	private String media;
	private String url;
	private String desciber;
	private List<NewImage> image_set;
	
	
	
	
	public CNew() {
		super();
	}
	
	
	public CNew(String title, String date, String media, String url,
			String desciber, List<NewImage> image_set) {
		super();
		this.title = title;
		this.date = date;
		this.media = media;
		this.url = url;
		this.desciber = desciber;
		this.image_set = image_set;
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
	public List<NewImage> getImage_set() {
		return image_set;
	}
	public void setImage_set(List<NewImage> image_set) {
		this.image_set = image_set;
	}
	
	
	
	
}
