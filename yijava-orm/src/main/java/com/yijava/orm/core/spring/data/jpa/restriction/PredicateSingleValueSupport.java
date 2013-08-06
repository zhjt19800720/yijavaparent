package com.yijava.orm.core.spring.data.jpa.restriction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;


import com.yijava.orm.core.MatchValue;
import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.spring.data.jpa.PredicateBuilder;
import com.yijava.orm.core.spring.data.jpa.specification.SpecificationModel;
import com.yijava.orm.core.spring.data.jpa.specification.Specifications;


/**
 * 处理{@link PropertyFilter#getMatchValue()}的基类，本类对3种值做处理
 * <p>
 * 1.值等于正常值的，如："amdin"，会产生的squall为:property = 'admin'
 * </p>
 * <p>
 * 2.值等于或值的，如："admin_OR_vincent"，会产生的sql为:property = 'admin' or property = 'vincent'
 * </p>
 * <p>
 * 3.值等于与值的,如:"admin_AND_vincent"，会产生的sql为:property = 'admin' and property = 'vincent'
 * </p>
 * 
 * @author vincent
 *
 */
public abstract class PredicateSingleValueSupport implements PredicateBuilder{
	
	//or值分隔符
	private String orValueSeparator = "|";
	//and值分隔符
	private String andValueSeparator = ",";
	
	public PredicateSingleValueSupport() {
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.PredicateBuilder#build(org.exitsoft.orm.core.PropertyFilter, javax.persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery, javax.persistence.criteria.CriteriaBuilder)
	 */
	public Predicate build(PropertyFilter filter,SpecificationModel model) {

		String matchValue = filter.getMatchValue();
		Class<?> propertyType = filter.getPropertyType();
		
		MatchValue matchValueModel = getMatchValue(matchValue, propertyType);
		
		Predicate predicate = null;
		
		if (matchValueModel.hasOrOperate()) {
			predicate = model.getBuilder().disjunction();
		} else {
			predicate = model.getBuilder().conjunction();
		}
		
		for (Object value : matchValueModel.getValues()) {
			if (filter.hasMultiplePropertyNames()) {
				for (String propertyName:filter.getPropertyNames()) {
					predicate.getExpressions().add(build(propertyName, value, model));
				}
			} else {
				predicate.getExpressions().add(build(filter.getSinglePropertyName(), value, model));
			}
		}
		
		return predicate;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.PredicateBuilder#build(java.lang.String, java.lang.Object, org.exitsoft.orm.core.spring.data.jpa.JpaBuilderModel)
	 */
	public Predicate build(String propertyName, Object value,SpecificationModel model) {
		
		return build(Specifications.getPath(propertyName, model.getRoot()),value,model.getBuilder());
	}
	
	/**
	 * 
	 * 获取Jpa的约束标准
	 * 
	 * @param expression 属性路径表达式
	 * @param value 值
	 * @param builder CriteriaBuilder
	 * 
	 * @return {@link Predicate}
	 */
	public abstract Predicate build(Path<?> expression,Object value,CriteriaBuilder builder);
	
	/**
	 * 获取值对比模型
	 * 
	 * @param matchValue 值
	 * @param propertyType 值类型
	 * 
	 * @return {@link MatchValue}
	 */
	public MatchValue getMatchValue(String matchValue,Class<?> propertyType) {
		return MatchValue.createMatchValueModel(matchValue, propertyType,andValueSeparator,orValueSeparator);
	}

	/**
	 * 获取and值分隔符
	 * 
	 * @return String
	 */
	public String getAndValueSeparator() {
		return andValueSeparator;
	}

	/**
	 * 设置and值分隔符
	 * @param andValueSeparator and值分隔符
	 */
	public void setAndValueSeparator(String andValueSeparator) {
		this.andValueSeparator = andValueSeparator;
	}
}
