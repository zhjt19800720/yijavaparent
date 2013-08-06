package com.yijava.orm.core.spring.data.jpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yijava.orm.core.PropertyFilter;

/**
 * 针对spring data jpa所提供的接口{@link JpaRepository}再次扩展，支持{@link PropertyFilter}查询和其他方式查询
 * @author vincent
 *
 * @param <T> ORM对象
 * @param <ID> 主键Id类型
 */
public interface BasicJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T>{
	
	/**
	 * 通过属性过滤器查询全部对象
	 * 
	 * @param filters 属性过滤器集合
	 * 
	 * @return List
	 */
	public List<T> findAll(List<PropertyFilter> filters);
	
	/**
	 * 通过属性名查询全部对象
	 * 
	 * @param propertyName 属性名
	 * @param value 值
	 * 
	 * @return List
	 */
	public List<T> findAll(String propertyName,Object value);
	
	/**
	 * 通过属性名查询全部对象
	 * 
	 * @param propertyName 属性名
	 * @param value 值
	 * @param sort 排序方法
	 * 
	 * @return List
	 */
	public List<T> findAll(String propertyName,Object value,Sort sort);
	
	/**
	 * 通过属性名查询全部对象
	 * 
	 * @param propertyName 属性名
	 * @param value 值
	 * @param restrictionName 约束条件名称
	 * 
	 * @return List
	 */
	public List<T> findAll(String propertyName,Object value,String restrictionName);
	
	/**
	 * 通过属性名查询全部对象
	 * 
	 * @param propertyName 属性名
	 * @param value 值
	 * @param sort 排序方法
	 * @param restrictionName 约束条件名称
	 * 
	 * @return List
	 */
	public List<T> findAll(String propertyName,Object value,Sort sort,String restrictionName);
	
	/**
	 * 通过属性过滤器查询全部对象
	 * 
	 * @param filters 属性过滤器集合
	 * @param sort 排序形式
	 * 
	 * @return List
	 */
	public List<T> findAll(List<PropertyFilter> filters, Sort sort);
	
	/**
	 * 通过属性过滤器查询对象分页
	 * 
	 * @param pageable 分页参数
	 * @param filters 属性过滤器集合
	 * 
	 * @return {@link Page}
	 */
	public Page<T> findAll(Pageable pageable, List<PropertyFilter> filters);
	
	/**
	 * 通过属性过滤器查询单个对象
	 * 
	 * @param filters 属性过滤器
	 * 
	 * @return Object
	 */
	public T findOne(List<PropertyFilter> filters);
	
	/**
	 * 通过属性名查询单个对象
	 * 
	 * @param propertyName 属性名
	 * @param value 值
	 * 
	 * @return Object
	 */
	public T findOne(String propertyName,Object value);
	
	/**
	 * 通过属性名查询全部对象
	 * 
	 * @param propertyName 属性名
	 * @param value 值
	 * @param restrictionName 约束条件名称
	 * 
	 * @return Object
	 */
	public T findOne(String propertyName,Object value,String restrictionName);
}
