package com.yijava.web.vo;

import java.util.Date;
import java.util.List;

public class AudioNew {

	
	private Long id;

	private String title;

	private String radio_file;
	
	private String image_file;

	private String duration;

	private Date create_date;

	private Date last_date;
	
	private String seq_num;
	
	
	private List<AudioNewCategory> categorys;


	
	
	public AudioNew() {
		super();
	}


	public AudioNew(Long id, String title, String radio_file,
			String image_file, String duration, Date create_date,
			Date last_date, String seq_num, List<AudioNewCategory> categorys) {
		super();
		this.id = id;
		this.title = title;
		this.radio_file = radio_file;
		this.image_file = image_file;
		this.duration = duration;
		this.create_date = create_date;
		this.last_date = last_date;
		this.seq_num = seq_num;
		this.categorys = categorys;
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


	public String getImage_file() {
		return image_file;
	}


	public void setImage_file(String image_file) {
		this.image_file = image_file;
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


	public String getSeq_num() {
		return seq_num;
	}


	public void setSeq_num(String seq_num) {
		this.seq_num = seq_num;
	}


	public List<AudioNewCategory> getCategorys() {
		return categorys;
	}


	public void setCategorys(List<AudioNewCategory> categorys) {
		this.categorys = categorys;
	}
	
	
	
}
