package com.yijava.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity
@Table(name = "tb_category")
@JsonAutoDetect
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}) 
public class Category {

	protected Long id;
	
	private String category;
	
	private Date create_at;
	
	private Date update_at;

	
	
	public Category() {
		
	}

	public Category(Long id, String category, Date create_at, Date update_at) {
		super();
		this.id = id;
		this.category = category;
		this.create_at = create_at;
		this.update_at = update_at;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@Column(name = "category_id",length = 10, nullable = false, unique = true)	
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SQ_CATEGORY_ID_SEQ")})
	@GeneratedValue(generator = "idGenerator")
	public Long getId() {
		return id;
	}

	@Column(name = "category_name",unique = true,nullable = false, length = 50)
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}
	
	public Date getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}
	
	
	

}
