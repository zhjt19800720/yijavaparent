package com.yijava.orm.core.spring.data.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.criteria.Predicate;


import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.spring.data.jpa.restriction.support.EqRestriction;
import com.yijava.orm.core.spring.data.jpa.restriction.support.GeRestriction;
import com.yijava.orm.core.spring.data.jpa.restriction.support.GtRestriction;
import com.yijava.orm.core.spring.data.jpa.restriction.support.InRestriction;
import com.yijava.orm.core.spring.data.jpa.restriction.support.LLikeRestriction;
import com.yijava.orm.core.spring.data.jpa.restriction.support.LeRestriction;
import com.yijava.orm.core.spring.data.jpa.restriction.support.LikeRestriction;
import com.yijava.orm.core.spring.data.jpa.restriction.support.LtRestriction;
import com.yijava.orm.core.spring.data.jpa.restriction.support.NeRestriction;
import com.yijava.orm.core.spring.data.jpa.restriction.support.NinRestriction;
import com.yijava.orm.core.spring.data.jpa.restriction.support.RLikeRestriction;
import com.yijava.orm.core.spring.data.jpa.specification.SpecificationModel;

/**
 * jpa约束捆绑者，将所有的{@link PredicateBuilder}实现类添加到{@link PropertyFilters#getRestrictionsMap()}中，
 * 辅佐PropertyFilterSpecification和RestrictionNameSpecification做创建Predicate操作。
 * 
 * @author vincent
 *
 */
public class JpaRestrictionBuilder{
	
	private static Map<String, PredicateBuilder> predicateBuilders = new HashMap<String, PredicateBuilder>();
	
	static {
		PredicateBuilder eqRestriction = new EqRestriction();
		PredicateBuilder neRestriction = new NeRestriction();
		PredicateBuilder geRestriction = new GeRestriction();
		PredicateBuilder gtRestriction = new GtRestriction();
		PredicateBuilder inRestriction = new InRestriction();
		PredicateBuilder lLikeRestriction = new LLikeRestriction();
		PredicateBuilder leRestriction = new LeRestriction();
		PredicateBuilder likeRestriction = new LikeRestriction();
		PredicateBuilder ltRestriction = new LtRestriction();
		PredicateBuilder notInRestriction = new NinRestriction();
		PredicateBuilder rLikeRestriction = new RLikeRestriction();
		
		predicateBuilders.put(eqRestriction.getRestrictionName(), eqRestriction);
		predicateBuilders.put(neRestriction.getRestrictionName(), neRestriction);
		predicateBuilders.put(geRestriction.getRestrictionName(), geRestriction);
		predicateBuilders.put(inRestriction.getRestrictionName(), inRestriction);
		predicateBuilders.put(gtRestriction.getRestrictionName(), gtRestriction);
		predicateBuilders.put(lLikeRestriction.getRestrictionName(), lLikeRestriction);
		predicateBuilders.put(leRestriction.getRestrictionName(), leRestriction);
		predicateBuilders.put(likeRestriction.getRestrictionName(), likeRestriction);
		predicateBuilders.put(ltRestriction.getRestrictionName(), ltRestriction);
		predicateBuilders.put(rLikeRestriction.getRestrictionName(), rLikeRestriction);
		predicateBuilders.put(notInRestriction.getRestrictionName(), notInRestriction);
	}
	
	/**
	 * 通过属性过滤器创建Predicate
	 * 
	 * @param filter 属性过滤器
	 * @param restrictionModel jpa查询绑定载体
	 * 
	 * @return {@link Predicate}
	 */
	public static Predicate getRestriction(PropertyFilter filter,SpecificationModel model) {
		if (!predicateBuilders.containsKey(filter.getRestrictionName())) {
			throw new IllegalArgumentException("找不到约束名:" + filter.getRestrictionName());
		}
		PredicateBuilder predicateBuilder  = predicateBuilders.get(filter.getRestrictionName());
		return predicateBuilder.build(filter,model);
	}

	/**
	 * 通过属性名称，值，约束条件创建Predicate
	 * 
	 * @param propertyName 属性名称
	 * @param value 值
	 * @param restrictionName 约束条件
	 * @param model jpa查询绑定载体
	 * 
	 * @return {@link Predicate}
	 */
	public static Predicate getRestriction(String propertyName, Object value,String restrictionName,SpecificationModel model) {
		if (!predicateBuilders.containsKey(restrictionName)) {
			throw new IllegalArgumentException("找不到约束名:" + restrictionName);
		}
		PredicateBuilder predicateBuilder  = predicateBuilders.get(restrictionName);
		return predicateBuilder.build(propertyName, value, model);
	}

	/**
	 * 获取所有的条件约束
	 * 
	 * @return Map
	 */
	public static Map<String, PredicateBuilder> getPredicateBuilders() {
		return predicateBuilders;
	}

	/**
	 * 设置所有的条件约束
	 * 
	 * @param 条件约束
	 */
	public static void setPredicateBuilders(Map<String, PredicateBuilder> predicateBuilders) {
		JpaRestrictionBuilder.predicateBuilders = predicateBuilders;
	}
	
	
}
