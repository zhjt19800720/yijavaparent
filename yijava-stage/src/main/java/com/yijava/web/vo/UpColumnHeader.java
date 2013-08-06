package com.yijava.web.vo;

public class UpColumnHeader {

	/**
	 * {"head":{ "uid" : "" , "sid" : "" , "plat" : "" , "st" : "", "ver" : "" , "imei" : "" , "oc" : "" },
 "body":{
	"column_id"："xxx"，"pageno"："xxx"，"pagesize"："xxx"
}
}
	 */
	
	private String uid;
	private String sid;
	private String plat;
	private String st;
	private String ver;
	private String imei;
	private String oc;
	
	
	
	public UpColumnHeader() {
		super();
	}
	public UpColumnHeader(String uid, String sid, String plat, String st,
			String ver, String imei, String oc) {
		super();
		this.uid = uid;
		this.sid = sid;
		this.plat = plat;
		this.st = st;
		this.ver = ver;
		this.imei = imei;
		this.oc = oc;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getPlat() {
		return plat;
	}
	public void setPlat(String plat) {
		this.plat = plat;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getOc() {
		return oc;
	}
	public void setOc(String oc) {
		this.oc = oc;
	}
	
	
	
}
