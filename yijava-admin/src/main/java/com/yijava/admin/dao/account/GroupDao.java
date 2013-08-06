package com.yijava.admin.dao.account;

import org.springframework.stereotype.Repository;

import com.yijava.admin.entity.account.Group;
import com.yijava.orm.core.hibernate.support.HibernateSupportDao;

/**
 * 部门数据访问
 * 
 * @author vincent
 *
 */
@Repository
public class GroupDao extends HibernateSupportDao<Group, String>{

}
