package com.yijava.web.vo;

/**
 * 上行报文体
 * @author zhjt
 *
 */
public class UpBody {

	private String province;
	private String pagesize;
	private String pageno;
	
	
	public UpBody() {
		super();
	}
	public UpBody(String province, String pagesize, String pageno) {
		super();
		this.province = province;
		this.pagesize = pagesize;
		this.pageno = pageno;
	}
	public String getProvince() {
		return province;
	}
	public String getPagesize() {
		return pagesize;
	}
	public String getPageno() {
		return pageno;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
	public void setPageno(String pageno) {
		this.pageno = pageno;
	}
	
	
}
