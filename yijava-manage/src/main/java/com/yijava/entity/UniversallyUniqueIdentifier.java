package com.yijava.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@MappedSuperclass
public class UniversallyUniqueIdentifier implements Serializable {

	protected Long id;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1609312098348008171L;

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

}
