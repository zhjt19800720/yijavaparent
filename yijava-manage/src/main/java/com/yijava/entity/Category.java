package com.yijava.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_category")
public class Category extends UniversallyUniqueIdentifier{

	//private Integer id;
	//private Long id;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3799610205620831987L;

	private String category;
	
	private Date create_at;
	
	private Date update_at;
	
	private Set<RadioNew> news = new HashSet<RadioNew>(0);

	
	
	public Category() {
		
	}
	
	
	

	public Category(Long id,String category, Date create_at, Date update_at) {
		super();		
		this.id=id;
		this.category = category;
		this.create_at = create_at;
		this.update_at = update_at;
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



	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categorys")
	/*@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "TB_RADIO_NEWS", joinColumns = { @JoinColumn(name = "category_id") }, inverseJoinColumns = { @JoinColumn(name = "new_id") })*/
	public Set<RadioNew> getNews() {
		return news;
	}




	public void setNews(Set<RadioNew> news) {
		this.news = news;
	}
	
	
	

}
