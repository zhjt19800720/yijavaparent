package com.yijava.orm.core.spring.data.jpa.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * jpa查询绑定载体，辅助属性过滤器查询时需要的jpa属性
 * 
 * @author vincent
 *
 */
public class SpecificationModel {

	private Root<?> root;
	private CriteriaQuery<?> query;
	private CriteriaBuilder builder;
	
	public SpecificationModel() {
		
	}

	public SpecificationModel(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		super();
		this.root = root;
		this.query = query;
		this.builder = builder;
	}

	public Root<?> getRoot() {
		return root;
	}

	public void setRoot(Root<?> root) {
		this.root = root;
	}

	public CriteriaQuery<?> getQuery() {
		return query;
	}

	public void setQuery(CriteriaQuery<?> query) {
		this.query = query;
	}

	public CriteriaBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(CriteriaBuilder builder) {
		this.builder = builder;
	}
	
	
	
}
