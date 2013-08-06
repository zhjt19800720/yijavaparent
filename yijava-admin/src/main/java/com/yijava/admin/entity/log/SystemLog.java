package com.yijava.admin.entity.log;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.yijava.admin.entity.UniversallyUniqueIdentifier;
import com.yijava.admin.entity.account.User;

@Entity
@Table(name = "TB_SYSTEM_LOG")
@SuppressWarnings("serial")
public class SystemLog  extends UniversallyUniqueIdentifier {

	private String action_name;

	private String action_url;
	
	private Date action_date_time;
	
	private User user;

	
	public String getAction_name() {
		return action_name;
	}

	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	public String getAction_url() {
		return action_url;
	}

	public void setAction_url(String action_url) {
		this.action_url = action_url;
	}

	public Date getAction_date_time() {
		return action_date_time;
	}

	public void setAction_date_time(Date action_date_time) {
		this.action_date_time = action_date_time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
