package com.yijava.dao;

import org.springframework.stereotype.Repository;

import com.yijava.entity.Category;
import com.yijava.orm.core.hibernate.support.HibernateSupportDao;

@Repository
public class CategoryDao extends HibernateSupportDao<Category, Long>{

	
	
	public void evictCategory(Category entity )
	{
		this.getSession().evict(entity);
	}
}
