package com.yijava.admin.entity.channel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.yijava.admin.entity.UniversallyUniqueIdentifier;
import com.yijava.admin.entity.account.Resource;

@Entity
@Table(name = "TB_CHANNEL")
@SuppressWarnings("serial")
public class Channel extends UniversallyUniqueIdentifier {

	private String title;
	private String meta_keyword;
	private String metadesc;
	private String status;
	private String parent_channel;
	private String name;
	private String type;
	
	
	
	private List<Channel> children = new ArrayList<Channel>();
	
	private Date create_date;

	
	public Channel() {
		
		
	}
	
	
	public Channel(String title) {
		
		this.title = title;
	}

	/**
	 * 获取当前实体是否是为根节点,如果是返回ture，否则返回false
	 * 
	 * @return boolean
	 */
	@Transient
	public Boolean getLeaf() {
		return this.children != null && this.getChildren().size() > 0;
	}
	
	
	
	@OrderBy("id ASC")
	@OneToMany(mappedBy = "parent_channel",fetch = FetchType.LAZY,cascade={CascadeType.ALL})
	public List<Channel> getChildren() {
		return children;
	}

	/**
	 * 设置子类资源
	 * 
	 * @param children 子类资源
	 */
	public void setChildren(List<Channel> children) {
		this.children = children;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMeta_keyword() {
		return meta_keyword;
	}

	public void setMeta_keyword(String meta_keyword) {
		this.meta_keyword = meta_keyword;
	}

	public String getMetadesc() {
		return metadesc;
	}

	public void setMetadesc(String metadesc) {
		this.metadesc = metadesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getParent_channel() {
		return parent_channel;
	}

	public void setParent_channel(String parent_channel) {
		this.parent_channel = parent_channel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	/*public List<Channel> getChildren() {
		return children;
	}

	public void setChildren(List<Channel> children) {
		this.children = children;
	}*/
	
	
	
	
}
