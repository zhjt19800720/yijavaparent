package com.yijava.orm.core.spring.data.jpa.restriction.support;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import com.yijava.orm.core.RestrictionNames;


/**
 * 不等于约束 ( from object o where o.value <> ?) RestrictionName:NE
 * <p>
 * 表达式:NE属性类型_属性名称[_OR_属性名称...]
 * </p>
 * 
 * @author vincent
 *
 */
public class NeRestriction extends EqRestriction{

	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.restriction.support.EqRestriction#getRestrictionName()
	 */
	public String getRestrictionName() {
		
		return RestrictionNames.NE;
	}

	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.restriction.support.EqRestriction#build(javax.persistence.criteria.Path, java.lang.Object, javax.persistence.criteria.CriteriaBuilder)
	 */
	@SuppressWarnings("rawtypes")
	public Predicate build(Path expression, Object value,CriteriaBuilder builder) {
		
		return value == null ? builder.isNotNull(expression) : builder.notEqual(expression, value);
	}
	
}
