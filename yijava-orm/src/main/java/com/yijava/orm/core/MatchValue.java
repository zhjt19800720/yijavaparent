package com.yijava.orm.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.yijava.common.utils.ConvertUtils;

/**
 * 对比值实体,根据该类的信息进行对一个或多个属性值该如何是 or或者and进行条件关联
 * 
 * @author vincent
 *
 */
public class MatchValue {
	
	private boolean hasOrOperate;
	private List<Object> values;
	
	/**
	 * 对比值实体,根据该类的信息进行对一个或多个属性值该如何是 or或者and进行条件关联
	 * 
	 * @param hasOrOperate 是否存在or提哦间操作
	 * @param values 要对比的值
	 */
	public MatchValue(boolean hasOrOperate,List<Object> values) {
		this.hasOrOperate = hasOrOperate;
		this.values = values;
	}
	
	/**
	 * 获取是否存在or条件对比
	 * 
	 * @return boolean
	 */
	public boolean hasOrOperate() {
		return hasOrOperate;
	}
	
	/**
	 * 获取要对比的所有值
	 * 
	 * @return List
	 */
	public List<Object> getValues() {
		return values;
	}
	
	/**
	 * 创建对比值模型，如果是多值以andValueSeparator（并且值）或者orValueSeparator(或者值)分割
	 * 
	 * @param matchValue 值
	 * @param type 值类型
	 * @param andValueSeparator 并且分隔符
	 * @param orValueSeparator 或者分隔符
	 * 
	 * @return {@link MatchValue}
	 */
	public static MatchValue createMatchValueModel(String matchValue,Class<?> type,String andValueSeparator,String orValueSeparator) {
		
		List<Object> values = new ArrayList<Object>();
		
		if (StringUtils.contains(matchValue, andValueSeparator)) {
			String[] siplit = StringUtils.splitByWholeSeparator(matchValue, andValueSeparator);
			CollectionUtils.addAll(values, (Object[])ConvertUtils.convertToObject(siplit, type));
			return new MatchValue(false, values);
		} else if (StringUtils.contains(matchValue, orValueSeparator)){
			String[] siplit = StringUtils.splitByWholeSeparator(matchValue, orValueSeparator);
			CollectionUtils.addAll(values, (Object[])ConvertUtils.convertToObject(siplit, type));
			return new MatchValue(true, values);
		} else {
			values.add(ConvertUtils.convertToObject(matchValue, type));
			return new MatchValue(false, values);
		}
		
	}
}
