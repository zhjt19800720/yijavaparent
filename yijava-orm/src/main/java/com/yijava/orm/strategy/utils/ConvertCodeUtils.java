package com.yijava.orm.strategy.utils;

import java.util.Iterator;
import java.util.List;

import com.yijava.common.utils.ReflectionUtils;
import com.yijava.orm.enumeration.ExecuteMehtod;
import com.yijava.orm.strategy.CodeStrategy;
import com.yijava.orm.strategy.annotation.ConvertCode;
import com.yijava.orm.strategy.annotation.ConvertProperty;

public class ConvertCodeUtils {
	
	/**
	 * 
	 * 将对象集合执行转码操作
	 * 
	 * @param source 要转码的对象集合
	 * @param executeMehtods 在什么方法进行转码
	 */
	public static void convertObjects(List<Object> source,ExecuteMehtod... executeMehtods) {
		for (Iterator<Object> it = source.iterator(); it.hasNext();) {
			convertObject(it.next(), executeMehtods);
		}
	}
	
	/**
	 * 
	 * 将对象执行转码操作
	 * 
	 * @param source 要转码的对象
	 * @param executeMethods 在什么方法进行转码
	 */
	public static void convertObject(Object source,ExecuteMehtod...executeMethods) {
		if (executeMethods == null) {
			return ;
		}
		
		Class<?> entityClass = ReflectionUtils.getTargetClass(source);
		ConvertCode convertCode = ReflectionUtils.getAnnotation(entityClass,ConvertCode.class);
		
		if (convertCode == null) {
			return ;
		}
		
		for (ExecuteMehtod em:executeMethods) {
			if (convertCode.executeMehtod().equals(em)) {
				for (ConvertProperty convertProperty : convertCode.convertPropertys()) {
					
					CodeStrategy strategy = ReflectionUtils.newInstance(convertProperty.strategyClass());
					
					for (String property :convertProperty.propertyNames()) {
						
						Object fromValue = ReflectionUtils.invokeGetterMethod(source, convertCode.fromProperty());
						Object convertValue = strategy.convertCode(fromValue,property);
						ReflectionUtils.invokeSetterMethod(source, property, convertValue);
						
					}
				}
			}
		}
		
	}
}
