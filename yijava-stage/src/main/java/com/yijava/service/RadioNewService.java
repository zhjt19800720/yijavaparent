package com.yijava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yijava.dao.RadioNewDao;
import com.yijava.entity.RadioNew;
import com.yijava.orm.core.Page;
import com.yijava.orm.core.PageRequest;
import com.yijava.orm.core.PropertyFilter;

@Service
public class RadioNewService {

	@Autowired
	private RadioNewDao radioNewDao;
	
	public Page<RadioNew> searchRadioNewPage(PageRequest request,
			List<PropertyFilter> filters) {
		return radioNewDao.findPage(request, filters);
	}
	
	
	
	
}
