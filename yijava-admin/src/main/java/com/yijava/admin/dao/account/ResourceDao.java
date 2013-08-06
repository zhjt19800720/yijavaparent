package com.yijava.admin.dao.account;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yijava.admin.entity.account.Resource;
import com.yijava.orm.core.hibernate.support.HibernateSupportDao;

/**
 * 资源数据访问
 * 
 * @author vincent
 *
 */
@Repository
public class ResourceDao extends HibernateSupportDao<Resource, String>{

	/**
	 * 通过用户id获取用户所有资源
	 * 
	 * @param userId 用户id
	 * 
	 * @return List
	 */
	public List<Resource> getUserResources(String userId) {
		return distinct(Resource.UserResources, userId);
	}

	
}
