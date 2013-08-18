package com.yijava.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
			List<PropertyFilter> filters,String category_id,String title) {		
		
		
		if(!StringUtils.isEmpty(category_id) && !StringUtils.isEmpty(title))
		{						
			String hql="select u from RadioNew u left join u.categorys gl  where gl.id=?1 and u.title like:title";			
			return radioNewDao.findPage(request,hql,Long.parseLong(category_id),title + "%");			
		}else if(!StringUtils.isEmpty(category_id) && StringUtils.isEmpty(title))
		{
			String hql="select u from RadioNew u left join u.categorys gl  where gl.id=?1";			
			return radioNewDao.findPage(request,hql,Long.parseLong(category_id));	
		}else if(StringUtils.isEmpty(category_id) && !StringUtils.isEmpty(title))
		{
			String hql="select u from RadioNew u left join u.categorys gl  where u.title like:title";			
			return radioNewDao.findPage(request,hql,title + "%");	
		}else
		{
			return radioNewDao.findPage(request, filters);
		}
		
		
		/*if(!StringUtils.isEmpty(category_id) || !StringUtils.isEmpty(title))
		{
			String hql="select u from RadioNew u left join u.categorys gl  where gl.id=?1 and u.title like:title";			
			return radioNewDao.findPage(request,hql,Long.parseLong(category_id),title + "%");		
		}else
		{
			return radioNewDao.findPage(request, filters);
		}*/
			
				
		
	}
	
	public List<RadioNew> searchRadioTop5() {
		return radioNewDao.searchRadioTop5();
	}
	
	
}
