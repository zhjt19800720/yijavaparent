package com.yijava.web.vo;

public class UpScribeNewBody {

	private String user_id;
	private String type;
	private String pageno;
	
	private String pagesize;

	
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public UpScribeNewBody(String user_id, String type, String pageno,
			String pagesize) {
		super();
		this.user_id = user_id;
		this.type = type;
		this.pageno = pageno;
		this.pagesize = pagesize;
	}

	public UpScribeNewBody() {
		super();
	}
	
	
	
}
