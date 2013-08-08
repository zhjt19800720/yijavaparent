package com.yijava.dao;

import org.springframework.stereotype.Repository;

import com.yijava.entity.UserCustom;
import com.yijava.orm.core.hibernate.support.HibernateSupportDao;

@Repository
public class UserCustomDao extends HibernateSupportDao<UserCustom, Long>{

	
}
