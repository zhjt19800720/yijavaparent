package com.yijava.orm.core.hibernate.restriction;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.Assert;

import com.yijava.common.utils.ConvertUtils;
import com.yijava.orm.core.PropertyFilter;

/**
 * 对{@link PropertyFilter#getMatchValue()}的特殊情况值做处理，例如 in, not in, between的多值情况,
 * 该类值处理一种情况
 * 
 * <p>
 * 	例如:
 * </p>
 * 
 * INI_property = "1,2,3,4";
 * <p>
 * 会产生的sql为: property in (1,2,3,4)
 * 
 * @author vincent
 *
 */
public abstract class CriterionMultipleValueSupport extends CriterionSingleValueSupport{
	
	/**
	 * 将得到值与指定分割符号,分割,得到数组
	 *  
	 * @param value 值
	 * @param type 值类型
	 * 
	 * @return Object
	 */
	public Object convertMatchValue(String value, Class<?> type) {
		Assert.notNull(value,"值不能为空");
		String[] result = StringUtils.splitByWholeSeparator(value, getAndValueSeparator());
		
		return  ConvertUtils.convertToObject(result,type);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.hibernate.restriction.CriterionSingleValueSupport#build(org.exitsoft.orm.core.PropertyFilter)
	 */
	public Criterion build(PropertyFilter filter) {
		Object value = convertMatchValue(filter.getMatchValue(), filter.getPropertyType());
		Criterion criterion = null;
		if (filter.hasMultiplePropertyNames()) {
			Disjunction disjunction = Restrictions.disjunction();
			for (String propertyName:filter.getPropertyNames()) {
				disjunction.add(build(propertyName,value));
			}
			criterion = disjunction;
		} else {
			criterion = build(filter.getSinglePropertyName(),value);
		}
		return criterion;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.hibernate.CriterionBuilder#build(java.lang.String, java.lang.Object)
	 */
	public Criterion build(String propertyName, Object value) {
		
		return buildRestriction(propertyName, (Object[])value);
	}
	
	
	/**
	 * 
	 * 获取Hibernate的约束标准
	 * 
	 * @param propertyName 属性名
	 * @param values 值
	 * 
	 * @return {@link Criterion}
	 */
	public abstract Criterion buildRestriction(String propertyName,Object[] values);
}
