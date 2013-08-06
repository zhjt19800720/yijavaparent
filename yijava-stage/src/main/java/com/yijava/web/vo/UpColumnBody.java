package com.yijava.web.vo;

public class UpColumnBody {

	private String column_id;
	private String pageno;
	private String pagesize;
	
	
	
	public UpColumnBody() {
		super();
	}
	
	public UpColumnBody(String column_id, String pageno, String pagesize) {
		super();
		this.column_id = column_id;
		this.pageno = pageno;
		this.pagesize = pagesize;
	}
	public String getColumn_id() {
		return column_id;
	}
	public void setColumn_id(String column_id) {
		this.column_id = column_id;
	}
	public String getPageno() {
		return pageno;
	}
	public void setPageno(String pageno) {
		this.pageno = pageno;
	}
	public String getPagesize() {
		return pagesize;
	}
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
	
	
	
}
