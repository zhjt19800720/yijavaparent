package com.yijava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yijava.dao.UserFavoritesDao;
import com.yijava.entity.UserFavorites;
import com.yijava.orm.core.Page;
import com.yijava.orm.core.PageRequest;
import com.yijava.orm.core.PropertyFilter;

@Service
@Transactional
public class UserFavoritesService {

	@Autowired
	private UserFavoritesDao userFavoritesDao;
	
	public Page<UserFavorites> searchRadioNewPage(PageRequest request,
			List<PropertyFilter> filters) {
		return userFavoritesDao.findPage(request, filters);
	}
	
	public void insertRadioNew(UserFavorites entity) {
		this.userFavoritesDao.insert(entity);
	}
	
	public void deleteRadioNew(List<Long> ids) {
		userFavoritesDao.deleteAll(ids);
	}
	
	
	
	public boolean isFavoritesUnique(Long userId,Long radioId)
	{
		return userFavoritesDao.getUserFavoritesByUidARid( userId,radioId)!=null;
	}
}
