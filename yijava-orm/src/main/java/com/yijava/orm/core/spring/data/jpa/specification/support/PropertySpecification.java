package com.yijava.orm.core.spring.data.jpa.specification.support;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.yijava.orm.core.RestrictionNames;
import com.yijava.orm.core.spring.data.jpa.JpaRestrictionBuilder;
import com.yijava.orm.core.spring.data.jpa.specification.SpecificationModel;

/**
 * 实现spring data jpa的{@link Specification}接口，通过该类支持对象属性名查询方法
 * 
 * @author vincent
 *
 * @param <T> orm 对象
 */
public class PropertySpecification<T> implements Specification<T>{
	
	//属性名称
	private String propertyName;
	//值
	private Object value;
	//约束名称
	private String restrictionName;
	
	public PropertySpecification() {
		
	}

	/**
	 * 构造属性名查询Specification
	 * 
	 * @param propertyName 对象属性名
	 * @param value 值
	 */
	public PropertySpecification(String propertyName, Object value) {
		this.propertyName = propertyName;
		this.value = value;
		this.restrictionName = RestrictionNames.EQ;
	}
	
	/**
	 * 构造属性名查询Specification
	 * 
	 * @param propertyName 对象属性名
	 * @param value 值
	 * @param restrictionName 约束名称
	 */
	public PropertySpecification(String propertyName, Object value,String restrictionName) {
		this.propertyName = propertyName;
		this.value = value;
		this.restrictionName = restrictionName;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.jpa.domain.Specification#toPredicate(javax.persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery, javax.persistence.criteria.CriteriaBuilder)
	 */
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,CriteriaBuilder builder) {
		
		
		Predicate predicate = builder.and(JpaRestrictionBuilder.getRestriction(propertyName, value, restrictionName, new SpecificationModel(root, query, builder)));
		
		
		return predicate;
	}

}
