package com.yijava.dao;

import org.springframework.stereotype.Repository;

import com.yijava.entity.UserFavorites;
import com.yijava.orm.core.hibernate.support.HibernateSupportDao;

@Repository
public class UserFavoritesDao extends
		HibernateSupportDao<UserFavorites, Integer> {

}
