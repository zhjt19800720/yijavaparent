package com.yijava.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.yijava.entity.RadioNew;
import com.yijava.orm.core.Page;
import com.yijava.orm.core.PageRequest;
import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.hibernate.support.HibernateSupportDao;

@Repository
public class RadioNewDao extends HibernateSupportDao<RadioNew, Long>{

	@SuppressWarnings("unchecked")
	public List<RadioNew> searchRadioTop5() {
		
		Query query = getSession().createQuery("from RadioNew order by id desc");
		query.setFirstResult(0);  
		query.setMaxResults(5);
		
		return query.list();
	}
	
	/*public Page<RadioNew> searchRadioNewPage(PageRequest request,
			List<PropertyFilter> filters,Long category_id) {
		
		Query query = getSession().createQuery("select u from RadioNew u left join u.categorys gl  where gl.id=?1");
		query.setParameter("", category_id);
		
		
		
		
		return radioNewDao.findPage(request, filters);
	} */
	
}
