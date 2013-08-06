package com.yijava.web.vo;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class News {

	private Long id;
	private String title;
	private String radio_file;
	private String duration;
	private Integer category_id;
	private Date create_date;
	private Date last_date;
	private CommonsMultipartFile[] file;
	private String image_file;
	
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRadio_file() {
		return radio_file;
	}
	public void setRadio_file(String radio_file) {
		this.radio_file = radio_file;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getLast_date() {
		return last_date;
	}
	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}
	@JsonIgnore
	public CommonsMultipartFile[] getFile() {
		return file;
	}
	public void setFile(CommonsMultipartFile[] file) {
		this.file = file;
	}
	public String getImage_file() {
		return image_file;
	}
	public void setImage_file(String image_file) {
		this.image_file = image_file;
	}

	
}
