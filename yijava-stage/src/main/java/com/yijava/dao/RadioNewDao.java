package com.yijava.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.yijava.entity.RadioNew;
import com.yijava.orm.core.hibernate.support.HibernateSupportDao;

@Repository
public class RadioNewDao extends HibernateSupportDao<RadioNew, Long>{

	@SuppressWarnings("unchecked")
	public List<RadioNew> searchRadioTop5() {
		
		Query query = getSession().createQuery("from RadioNew order by id asc");
		query.setFirstResult(0);  
		query.setMaxResults(5);
		
		return query.list();
	}
}
