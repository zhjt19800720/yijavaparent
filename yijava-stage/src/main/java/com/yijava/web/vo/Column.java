package com.yijava.web.vo;

public class Column {

	private String column_id;
	private String column_name;
	private boolean customed;
	
	
	
	public Column() {
		super();
	}
	
	public Column(String column_id, String column_name) {
		super();
		this.column_id = column_id;
		this.column_name = column_name;
	}
	
	
	
	public Column(String column_id, String column_name, boolean customed) {
		super();
		this.column_id = column_id;
		this.column_name = column_name;
		this.customed = customed;
	}

	public boolean isCustomed() {
		return customed;
	}
	public void setCustomed(boolean customed) {
		this.customed = customed;
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
