package com.yijava.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "TB_USER_CUSTOM")
public class UserCustom {

	private Long id;
	private String user_id;
	private String channel_ids;
	private String region_name;
	private String attention;
	
	
	
	public UserCustom() {
		super();
	}


	public UserCustom(Long id, String user_id, String channel_ids) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.channel_ids = channel_ids;
	}
	
	
	@Id
	@Column(name = "custom_id",length = 10, nullable = false, unique = true)	
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SQ_RADIO_USER_CUSTOM_SEQ")})
	@GeneratedValue(generator = "idGenerator")	
	@JsonIgnore	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getChannel_ids() {
		return channel_ids;
	}
	public void setChannel_ids(String channel_ids) {
		this.channel_ids = channel_ids;
	}


	public String getRegion_name() {
		return region_name;
	}


	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}


	public String getAttention() {
		return attention;
	}


	public void setAttention(String attention) {
		this.attention = attention;
	}
	
	
	
	
}
