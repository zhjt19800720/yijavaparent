package com.yijava.orm.core.hibernate.restriction.support;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.yijava.orm.core.MatchValue;
import com.yijava.orm.core.RestrictionNames;
import com.yijava.orm.core.hibernate.restriction.CriterionSingleValueSupport;

/**
 * 等于约束 (from object o where o.value = ?) RestrictionName:EQ
 * <p>
 * 表达式:EQ属性类型_属性名称[_OR_属性名称...]
 * </p>
 * 
 * @author vincent
 *
 */
public class EqRestriction extends CriterionSingleValueSupport {
	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.hibernate.CriterionBuilder#getRestrictionName()
	 */
	public String getRestrictionName() {
		return RestrictionNames.EQ;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.hibernate.restriction.CriterionSingleValueSupport#getMatchValue(java.lang.String, java.lang.Class)
	 */
	public MatchValue getMatchValue(String matchValue, Class<?> propertyType) {
		
		MatchValue matchValueModel = super.getMatchValue(matchValue, propertyType);
		for (int i = 0; i < matchValueModel.getValues().size(); i++) {
			Object value = matchValueModel.getValues().get(i);
			if (value instanceof String && StringUtils.equals(value.toString(),"null")) {
				matchValueModel.getValues().remove(i);
				matchValueModel.getValues().add(i, null);
			}
		}
		return matchValueModel;
	}
	
	public Criterion build(String propertyName, Object value) {
		
		return value == null ? Restrictions.isNull(propertyName) : Restrictions.eq(propertyName, value);
		
	}
	
}
