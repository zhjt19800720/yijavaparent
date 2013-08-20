package com.yijava.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yijava.dao.UserCustomDao;
import com.yijava.entity.UserCustom;


@Transactional
@Service
public class UserCustomService {

	private static final Logger logger = LoggerFactory.getLogger(UserCustomService.class);
	
	@Autowired
	private UserCustomDao userCustomDao;

	/**
	 * 单个增加用户定制栏目
	 * @param entity
	 */
	public void insertUserCustom(UserCustom entity) {
		userCustomDao.insert(entity);
	}
	
	/**
	 * 单个增加用户定制栏目
	 * @param entity
	 */
	public void updateUserCustom(UserCustom entity) {
		//userCustomDao.evict(oldentity);
		try
		{
			userCustomDao.updateUserCustom(entity);
		}catch(Exception e)
		{
			logger.error(e.toString());
		}
		
	}

	/**
	 * 批量增加用户定制栏目
	 * @param entitys
	 */
	public void insertUserCustom(List<UserCustom> entitys) {
		userCustomDao.insertAll(entitys);
	}
	/**
	 * 单个删除用户定制栏目
	 * @param entity
	 */
	public void deleteUserCustom(UserCustom entity)
	{
		userCustomDao.delete(entity);
	}
	
	public UserCustom getUserCustomByUid(String uid)
	{
		return userCustomDao.findUniqueByProperty("user_id", uid);
	}
	
}
