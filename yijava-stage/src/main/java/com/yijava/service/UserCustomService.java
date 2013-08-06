package com.yijava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yijava.dao.UserCustomDao;
import com.yijava.entity.UserCustom;


@Transactional
@Service
public class UserCustomService {

	@Autowired
	private UserCustomDao userCustomDao;

	public void insertUserCustom(UserCustom entity) {
		userCustomDao.insert(entity);
	}

	public void insertUserCustom(List<UserCustom> entitys) {
		userCustomDao.insertAll(entitys);
	}
	
	public void deleteUserCustom(UserCustom entity)
	{
		userCustomDao.delete(entity);
	}
}
