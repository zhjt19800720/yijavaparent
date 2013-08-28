package com.yijava.web.vo;

public class AudioNewCategory {

	private Long id;
	private String category;
	
	
	
	public AudioNewCategory() {
		super();
	}
	
	
	public AudioNewCategory(Long id, String category) {
		super();
		this.id = id;
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
}
