package com.yijava.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yijava.entity.UserCustom;
import com.yijava.orm.core.hibernate.support.HibernateSupportDao;

@Repository
public class UserCustomDao extends HibernateSupportDao<UserCustom, Long>{

	private static final Logger logger = LoggerFactory.getLogger(UserCustomDao.class);
	
	
	public void updateUserCustom(UserCustom entity) {
		try {
			String hql = "UPDATE UserCustom set user_id = :user_id, channel_ids=:channel_ids,region_name=:region_name"
					+ " WHERE id = :id";
			//Transaction tran=getSession().beginTransaction();
			Query query = getSession().createQuery(hql);
			
			query.setParameter("user_id", entity.getUser_id());
			query.setParameter("channel_ids", entity.getChannel_ids());
			query.setParameter("region_name", entity.getRegion_name());
			query.setParameter("id", entity.getId());
			int result = query.executeUpdate();
			//tran.commit();
			logger.debug("updateUserCustom:" + result);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			logger.debug("updateUserCustom:" + e);
		}
	}
}
