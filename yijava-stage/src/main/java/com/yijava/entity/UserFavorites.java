package com.yijava.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity
@Table(name = "TB_USER_FAVORITES")
public class UserFavorites {

	private Long id;
	private Long user_id;
	private Long radio_id;
	private Date create_at;
	private Integer state;
	private RadioNew radioNew;
	
	
	
	public UserFavorites() {
		
	}
	public UserFavorites(Long id, Long user_id, Long radio_id,
			Date create_at, Integer state, RadioNew radioNew) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.radio_id = radio_id;
		this.create_at = create_at;
		this.state = state;
		this.radioNew = radioNew;
	}
	@Id
	@Column(name = "favorite_id",length = 10, nullable = false, unique = true)	
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SQ_RADIO_USER_FAVORITE_SEQ")})
	@GeneratedValue(generator = "idGenerator")	
	@JsonIgnore
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@JsonIgnore
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	@JsonIgnore
	public Long getRadio_id() {
		return radio_id;
	}
	public void setRadio_id(Long radio_id) {
		this.radio_id = radio_id;
	}
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "radio_id", insertable = false, updatable = false)
	public RadioNew getRadioNew() {
		return radioNew;
	}
	public void setRadioNew(RadioNew radioNew) {
		this.radioNew = radioNew;
	}
	public Date getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	
	
	
	
	
	
	
}
