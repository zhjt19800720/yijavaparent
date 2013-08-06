package com.yijava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yijava.dao.CategoryDao;
import com.yijava.entity.Category;
import com.yijava.orm.core.Page;
import com.yijava.orm.core.PageRequest;
import com.yijava.orm.core.PropertyFilter;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public void insertCategory(Category entity) {
		this.categoryDao.insert(entity);
	}

	public void updateCategory(Category oldentity,Category entity) {
		this.categoryDao.evict(oldentity);
		this.categoryDao.update(entity);
	}
	
	

	public Category getCategory(Long id) {
		return categoryDao.load(id);
	}

	public Page<Category> searchCategoryPage(PageRequest request,
			List<PropertyFilter> filters) {
		return categoryDao.findPage(request, filters);
	}

	public List<Category> getAllCategory() {
		return categoryDao.getAll();
	}

	public void deleteCategorys(List<Long> ids) {
		categoryDao.deleteAll(ids);
	}

}
