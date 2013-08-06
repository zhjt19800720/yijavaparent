package com.yijava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yijava.dao.RadioNewDao;
import com.yijava.entity.Category;
import com.yijava.entity.RadioNew;
import com.yijava.orm.core.Page;
import com.yijava.orm.core.PageRequest;
import com.yijava.orm.core.PropertyFilter;

@Service
@Transactional
public class RadioNewService {

	@Autowired
	private RadioNewDao radioNewDao;
	
	public Page<RadioNew> searchRadioNewPage(PageRequest request,
			List<PropertyFilter> filters) {
		return radioNewDao.findPage(request, filters);
	}
	
	public void insertRadioNew(RadioNew entity) {
		this.radioNewDao.insert(entity);
	}
	
	public void updateRadioNew(RadioNew oldentity,RadioNew entity) {
		
		this.radioNewDao.evict(oldentity);
		this.radioNewDao.update(entity);
		//this.radioNewDao.save(entity);
	}
	
	public RadioNew getRadioNew(Long id) {
		return radioNewDao.load(id);
	}
	
	public List<RadioNew> getAllRadioNew() {
		return radioNewDao.getAll();
	}
	
	public void deleteRadioNew(List<Long> ids) {
		radioNewDao.deleteAll(ids);
	}
	
	
}
