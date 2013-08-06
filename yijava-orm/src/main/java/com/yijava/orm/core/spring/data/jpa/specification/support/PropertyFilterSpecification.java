package com.yijava.orm.core.spring.data.jpa.specification.support;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.spring.data.jpa.JpaRestrictionBuilder;
import com.yijava.orm.core.spring.data.jpa.specification.SpecificationModel;

/**
 * 实现spring data jpa的{@link Specification}接口，通过该类支持{@link PropertyFilter}以及表达式查询方法
 * 
 * @author vincent
 *
 * @param <T> orm对象
 */
public class PropertyFilterSpecification<T> implements Specification<T> {
	
	private List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
	
	public PropertyFilterSpecification() {
		
	}
	
	/**
	 * 通过属性过滤器构建
	 * 
	 * @param filter 属性过滤器
	 */
	public PropertyFilterSpecification(PropertyFilter filter) {
		this.filters.add(filter);
	}
	
	/**
	 * 通过属性过滤器集合构建
	 * 
	 * @param filters 集合
	 */
	public PropertyFilterSpecification(List<PropertyFilter> filters) {
		this.filters.addAll(filters);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.jpa.domain.Specification#toPredicate(javax.persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery, javax.persistence.criteria.CriteriaBuilder)
	 */
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,CriteriaBuilder builder) {
		
		
		List<Predicate> list = new ArrayList<Predicate>();
		
		for (PropertyFilter filter : filters) {
			list.add(JpaRestrictionBuilder.getRestriction(filter,new SpecificationModel(root, query, builder)));
		}
		
		return list.size() > 0 ? builder.and(list.toArray(new Predicate[list.size()])) : null;
		
	}

	/**
	 * 获取所有属性过滤器
	 * 
	 * @return List
	 */
	public List<PropertyFilter> getFilters() {
		return filters;
	}

	/**
	 * 设置所有属性过滤器
	 * 
	 * @param filters 属性过滤器
	 */
	public void setFilters(List<PropertyFilter> filters) {
		this.filters = filters;
	}
	
}
