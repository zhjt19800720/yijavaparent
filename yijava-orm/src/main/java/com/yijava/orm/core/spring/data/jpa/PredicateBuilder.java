package com.yijava.orm.core.spring.data.jpa;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;


import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.spring.data.jpa.specification.SpecificationModel;

/**
 * 
 * 辅助{@link JpaRestrictionBuilder}类创建PropertyFilter后使用哪种约束条件向{@link CriteriaBuilder}添加{@link Predicate}进行条件过滤查询的接口
 * 
 * @author vincent
 *
 */
public interface PredicateBuilder {

	/**
	 * 获取Jpa的约束标准
	 * 
	 * @param filter 属性过滤器
	 * @param model jpa绑定模型
	 * 
	 * @return {@link Predicate}
	 * 
	 */
	public Predicate build(PropertyFilter filter,SpecificationModel model);
	
	/**
	 * 获取Predicate标准的约束名称
	 * 
	 * @return String
	 */
	public String getRestrictionName();
	
	/**
	 * 获取Jpa的约束标准
	 * 
	 * @param propertyName 属性名
	 * @param value 值
	 * @param builder CriteriaBuilder
	 * 
	 * @return {@link Predicate}
	 * 
	 */
	public Predicate build(String propertyName, Object value,SpecificationModel model);
}
