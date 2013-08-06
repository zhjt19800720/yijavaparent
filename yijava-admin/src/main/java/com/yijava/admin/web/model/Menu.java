package com.yijava.admin.web.model;

import java.util.List;

public class Menu {

	private String text;
	private boolean expanded;
	
	private List<Menu> children;

	
	public Menu() {
		
	}
	
	public Menu(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	
	
	
}
