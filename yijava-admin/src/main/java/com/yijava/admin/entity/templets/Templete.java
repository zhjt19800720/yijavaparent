package com.yijava.admin.entity.templets;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yijava.admin.entity.UniversallyUniqueIdentifier;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_TEMPLETS")
public class Templete extends UniversallyUniqueIdentifier {

	// 文件名
	private String filename;
	// 文件名
	private String filepath;
	// 文件名
	private Date create_date=new Date();
	// 文件名
	private Date last_update=new Date();
	// 备注
	private String remark;
	
	
	
	public Templete() {
		
	}
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false,nullable=false,length=20)
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false,nullable=false,length=20)
	public Date getLast_update() {
		return last_update;
	}
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
