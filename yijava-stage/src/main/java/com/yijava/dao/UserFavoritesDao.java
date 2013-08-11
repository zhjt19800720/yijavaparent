package com.yijava.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yijava.entity.UserFavorites;
import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.PropertyFilters;
import com.yijava.orm.core.hibernate.support.HibernateSupportDao;

@Repository
public class UserFavoritesDao extends
		HibernateSupportDao<UserFavorites, Long> {

	
	public UserFavorites getUserFavoritesByUidARid(Long userId,Long radioId)
	{
	    Map o = new HashMap();
		o.put("EQL_user_id",userId);
		o.put("EQL_radio_id",radioId);
		List<PropertyFilter> filters = PropertyFilters.build(o,true);
		
		return findUniqueByPropertyFilter(filters);
		
	}
}
