package com.yijava.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "TB_RADIO_NEWS")
public class RadioNew {

	protected Long id;

	private String title;

	private String radio_file;

	private String image_file;

	private String duration;

	private Date create_date;

	private Date last_date;

	private Long category_id;
	
	private String seq_num;

	
	private Set<Category> categorys= new HashSet<Category>(0);

	public RadioNew() {

	}

	public RadioNew(Long id, String title, String radio_file,
			String image_file, String duration, Date create_date,
			Date last_date, Long category_id) {
		super();
		this.id = id;
		this.title = title;
		this.radio_file = radio_file;
		this.image_file = image_file;
		this.duration = duration;
		this.create_date = create_date;
		this.last_date = last_date;
		this.category_id = category_id;
	}

	@Id
	@Column(name = "entity_id", length = 10, nullable = false, unique = true)
	@GenericGenerator(name = "idGenerator", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "SQ_RADIO_NEW_SEQ") })
	@GeneratedValue(generator = "idGenerator")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRadio_file() {
		return radio_file;
	}

	public void setRadio_file(String radio_file) {
		this.radio_file = radio_file;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getLast_date() {
		return last_date;
	}

	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public String getImage_file() {
		return image_file;
	}

	public void setImage_file(String image_file) {
		this.image_file = image_file;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "tb_new_category",  joinColumns = { 
			@JoinColumn(name = "new_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "category_id") })
	/*@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_new_category", joinColumns = { @JoinColumn(name = "new_id") }, inverseJoinColumns = { @JoinColumn(name = "category_id") })*/
	public Set<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(Set<Category> categorys) {
		this.categorys = categorys;
	}
	
	
	
	public String getSeq_num() {
		return seq_num;
	}

	public void setSeq_num(String seq_num) {
		this.seq_num = seq_num;
	}

		//重写该方法，以辨别是否是同一条数据	
		@Override
		public boolean equals(Object obj) {
			boolean flag = false;
			if(!(obj instanceof RadioNew)){
				flag = false;
			}else {
				RadioNew org = (RadioNew)obj;
				if(org.getId().equals(this.getId())){
					flag = true;
				}
			}
			return flag;
		}
		@Override
		public int hashCode() {
			int result = id.hashCode(); 
			result = result+(int)'f';
			return result;
		}

		
}
