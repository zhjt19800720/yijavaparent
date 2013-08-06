package com.yijava.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USER_CUSTOM")
public class UserCustom {

	private Integer id;
	private Integer user_id;
	private String channel_ids;
	
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "custom_id",unique = true,nullable = false, length = 10)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getChannel_ids() {
		return channel_ids;
	}
	public void setChannel_ids(String channel_ids) {
		this.channel_ids = channel_ids;
	}
	
	
	
	
}
