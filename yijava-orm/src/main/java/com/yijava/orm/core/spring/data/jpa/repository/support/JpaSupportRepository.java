package com.yijava.orm.core.spring.data.jpa.repository.support;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.yijava.common.utils.ConvertUtils;
import com.yijava.common.utils.ReflectionUtils;
import com.yijava.orm.annotation.StateDelete;
import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.RestrictionNames;
import com.yijava.orm.core.spring.data.jpa.repository.BasicJpaRepository;
import com.yijava.orm.core.spring.data.jpa.specification.Specifications;
import com.yijava.orm.enumeration.ExecuteMehtod;
import com.yijava.orm.strategy.utils.ConvertCodeUtils;

/**
 * {@link BasicJpaRepository}接口实现类，并在{@link SimpleJpaRepository}基础上扩展,包含对{@link PropertyFilter}的支持。或其他查询的支持,
 * 重写了{@link SimpleJpaRepository#save(Object)}和{@link SimpleJpaRepository#delete(Object)}方法，支持@StateDelete注解和@ConvertProperty注解
 * 
 * @author vincent
 *
 * @param <T> ORM对象
 * @param <ID> 主键Id类型
 */
@SuppressWarnings("unchecked")
public class JpaSupportRepository<T, ID extends Serializable>  extends SimpleJpaRepository<T, ID> implements BasicJpaRepository<T, ID>{
	
	private EntityManager entityManager;
	private JpaEntityInformation<T, ?> entityInformation;
	
	public JpaSupportRepository(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}
	
	public JpaSupportRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager em) {
		super(entityInformation, em);
		this.entityInformation = entityInformation;
		this.entityManager = em;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.jpa.repository.support.SimpleJpaRepository#save(S)
	 */
	@Override
	@Transactional
	public <S extends T> S save(S entity) {
		
		if (entityInformation.isNew(entity)) {
			ConvertCodeUtils.convertObject(entity,ExecuteMehtod.Save,ExecuteMehtod.Insert);
			entityManager.persist(entity);
			return entity;
		} else {
			ConvertCodeUtils.convertObject(entity,ExecuteMehtod.Save,ExecuteMehtod.Update);
			return entityManager.merge(entity);
		}
	}
	
	 /*
	  * (non-Javadoc)
	  * @see org.springframework.data.jpa.repository.support.SimpleJpaRepository#delete(java.lang.Object)
	  */
	@Override
	@Transactional
	public void delete(T entity) {
		Class<?> entityClass = ReflectionUtils.getTargetClass(entity);
		StateDelete stateDelete = ReflectionUtils.getAnnotation(entityClass,StateDelete.class);
		if (stateDelete != null) {
			Object value = ConvertUtils.convertToObject(stateDelete.value(), stateDelete.type().getValue());
			ReflectionUtils.invokeSetterMethod(entity, stateDelete.propertyName(), value);
			save(entity);
		} else {
			super.delete(entity);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.repository.BasicJpaRepository#findAll(java.util.List)
	 */
	@Override
	public List<T> findAll(List<PropertyFilter> filters) {
		return findAll(filters,(Sort)null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.repository.BasicJpaRepository#findAll(java.util.List, org.springframework.data.domain.Sort)
	 */
	@Override
	public List<T> findAll(List<PropertyFilter> filters, Sort sort) {
		
		return findAll(Specifications.get(filters), sort);
	}

	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.repository.BasicJpaRepository#findAll(org.springframework.data.domain.Pageable, java.util.List)
	 */
	@Override
	public Page<T> findAll(Pageable pageable, List<PropertyFilter> filters) {
		
		return findAll(Specifications.get(filters),pageable);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.repository.BasicJpaRepository#findAll(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<T> findAll(String propertyName, Object value) {
		
		return findAll(propertyName, value, (Sort)null);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.repository.BasicJpaRepository#findAll(java.lang.String, java.lang.Object, org.springframework.data.domain.Sort)
	 */
	@Override
	public List<T> findAll(String propertyName, Object value, Sort sort) {
		return findAll(propertyName, value, sort, RestrictionNames.EQ);
	}

	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.repository.BasicJpaRepository#findAll(java.lang.String, java.lang.Object, java.lang.String)
	 */
	@Override
	public List<T> findAll(String propertyName, Object value,String restrictionName) {
		return findAll(propertyName, value, (Sort)null, restrictionName);
	}

	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.repository.BasicJpaRepository#findAll(java.lang.String, java.lang.Object, org.springframework.data.domain.Sort, java.lang.String)
	 */
	@Override
	public List<T> findAll(String propertyName, Object value, Sort sort,String restrictionName) {
		
		return findAll(Specifications.get(propertyName, value, restrictionName),sort);
	}

	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.repository.BasicJpaRepository#findOne(java.util.List)
	 */
	@Override
	public T findOne(List<PropertyFilter> filters) {
		return findOne(Specifications.get(filters));
	}

	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.repository.BasicJpaRepository#findOne(java.lang.String, java.lang.Object)
	 */
	@Override
	public T findOne(String propertyName, Object value) {
		return findOne(propertyName, value, RestrictionNames.EQ);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.repository.BasicJpaRepository#findOne(java.lang.String, java.lang.Object, java.lang.String)
	 */
	@Override
	public T findOne(String propertyName, Object value, String restrictionName) {
		return findOne(Specifications.get(propertyName, value, restrictionName));
	}
	
	
}
