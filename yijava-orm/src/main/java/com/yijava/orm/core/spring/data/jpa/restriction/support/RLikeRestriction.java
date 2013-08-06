package com.yijava.orm.core.spring.data.jpa.restriction.support;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;


import com.yijava.orm.core.RestrictionNames;
import com.yijava.orm.core.spring.data.jpa.restriction.PredicateSingleValueSupport;

/**
 * 右模糊约束 ( from object o where o.value like '?%') RestrictionName:RLIKE
 * <p>
 * 表达式:RLIKE属性类型_属性名称[_OR_属性名称...]
 * </p>
 * 
 * @author vincent
 *
 */
public class RLikeRestriction extends PredicateSingleValueSupport{
	
	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.PredicateBuilder#getRestrictionName()
	 */
	public String getRestrictionName() {
		return RestrictionNames.RLIKE;
	}

	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.PredicateBuilder#build(javax.persistence.criteria.Path, java.lang.Object, javax.persistence.criteria.CriteriaBuilder)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Predicate build(Path expression, Object value,CriteriaBuilder builder) {
		
		return builder.like(expression, value + "%");
	}

	
}

