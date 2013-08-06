package com.yijava.web.vo;

public class Column {

	private String column_id;
	private String column_name;
	
	
	
	public Column() {
		super();
	}
	public Column(String column_id, String column_name) {
		super();
		this.column_id = column_id;
		this.column_name = column_name;
	}
	public String getColumn_id() {
		return column_id;
	}
	public void setColumn_id(String column_id) {
		this.column_id = column_id;
	}
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	
	
	
}
