package com.yijava.orm.core.hibernate;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.criterion.Criterion;

import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.hibernate.restriction.support.EqRestriction;
import com.yijava.orm.core.hibernate.restriction.support.GeRestriction;
import com.yijava.orm.core.hibernate.restriction.support.GtRestriction;
import com.yijava.orm.core.hibernate.restriction.support.InRestriction;
import com.yijava.orm.core.hibernate.restriction.support.LLikeRestriction;
import com.yijava.orm.core.hibernate.restriction.support.LeRestriction;
import com.yijava.orm.core.hibernate.restriction.support.LikeRestriction;
import com.yijava.orm.core.hibernate.restriction.support.LtRestriction;
import com.yijava.orm.core.hibernate.restriction.support.NeRestriction;
import com.yijava.orm.core.hibernate.restriction.support.NinRestriction;
import com.yijava.orm.core.hibernate.restriction.support.RLikeRestriction;

/**
 * Hibernate约束捆绑者，帮助HibernateDao对buildCriterion方法创建相对的Criterion对象给Hibernate查询
 * 
 * @author vincent
 *
 */
public class HibernateRestrictionBuilder {
	
	private static Map<String, CriterionBuilder> criterionBuilders = new HashMap<String, CriterionBuilder>();
	
	static {
		
		CriterionBuilder eqRestriction = new EqRestriction();
		CriterionBuilder neRestriction = new NeRestriction();
		CriterionBuilder geRestriction = new GeRestriction();
		CriterionBuilder gtRestriction = new GtRestriction();
		CriterionBuilder inRestriction = new InRestriction();
		CriterionBuilder lLikeRestriction = new LLikeRestriction();
		CriterionBuilder leRestriction = new LeRestriction();
		CriterionBuilder likeRestriction = new LikeRestriction();
		CriterionBuilder ltRestriction = new LtRestriction();
		CriterionBuilder notInRestriction = new NinRestriction();
		CriterionBuilder rLikeRestriction = new RLikeRestriction();
		
		criterionBuilders.put(eqRestriction.getRestrictionName(), eqRestriction);
		criterionBuilders.put(neRestriction.getRestrictionName(), neRestriction);
		criterionBuilders.put(geRestriction.getRestrictionName(), geRestriction);
		criterionBuilders.put(inRestriction.getRestrictionName(), inRestriction);
		criterionBuilders.put(gtRestriction.getRestrictionName(), gtRestriction);
		criterionBuilders.put(lLikeRestriction.getRestrictionName(), lLikeRestriction);
		criterionBuilders.put(leRestriction.getRestrictionName(), leRestriction);
		criterionBuilders.put(likeRestriction.getRestrictionName(), likeRestriction);
		criterionBuilders.put(ltRestriction.getRestrictionName(), ltRestriction);
		criterionBuilders.put(rLikeRestriction.getRestrictionName(), rLikeRestriction);
		criterionBuilders.put(notInRestriction.getRestrictionName(), notInRestriction);
	}
	
	/**
	 * 通过属性过滤器人获取Hibernate Criterion
	 * 
	 * @param filter 属性过滤器
	 * 
	 * @return {@link Criterion}
	 */
	public static Criterion getRestriction(PropertyFilter filter) {
		
		if (!criterionBuilders.containsKey(filter.getRestrictionName())) {
			throw new IllegalArgumentException("找不到约束名:" + filter.getRestrictionName());
		}
		
		CriterionBuilder criterionBuilder = criterionBuilders.get(filter.getRestrictionName());
		return criterionBuilder.build(filter);
	}

	/**
	 * 通过属性名称，值，约束条件。获取Hibernate Criterion
	 * 
	 * @param propertyName 属性名称
	 * @param value 值
	 * @param restrictionName 约束条件
	 * 
	 * @return {@link Criterion}
	 */
	public static Criterion getRestriction(String propertyName, Object value,String restrictionName) {
		
		if (!criterionBuilders.containsKey(restrictionName)) {
			throw new IllegalArgumentException("找不到约束名:" + restrictionName);
		}
		
		CriterionBuilder restriction = criterionBuilders.get(restrictionName);
		return restriction.build(propertyName, value);
	}

	/**
	 * 获取所有的条件约束
	 * 
	 * @return Map
	 */
	public static Map<String, CriterionBuilder> getCriterionBuilders() {
		return criterionBuilders;
	}

	/**
	 * 设置所有的条件约束
	 * 
	 * @param criterionBuilders 条件约束
	 */
	public static void setCriterionBuilders(Map<String, CriterionBuilder> criterionBuilders) {
		HibernateRestrictionBuilder.criterionBuilders = criterionBuilders;
	}
	
	
	
}
