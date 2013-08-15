package com.yijava.web.vo;

public class NewImage {

	private String image_height;
	private String image_type;
	private String video_url;
	private String image_width;
	private String image_url;
	
	
	
	public NewImage() {
		super();
	}
	
	
	public NewImage(String image_height, String image_type, String video_url,
			String image_width, String image_url) {
		super();
		this.image_height = image_height;
		this.image_type = image_type;
		this.video_url = video_url;
		this.image_width = image_width;
		this.image_url = image_url;
	}
	public String getImage_height() {
		return image_height;
	}
	public void setImage_height(String image_height) {
		this.image_height = image_height;
	}
	public String getImage_type() {
		return image_type;
	}
	public void setImage_type(String image_type) {
		this.image_type = image_type;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
	public String getImage_width() {
		return image_width;
	}
	public void setImage_width(String image_width) {
		this.image_width = image_width;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	
	
	
}
