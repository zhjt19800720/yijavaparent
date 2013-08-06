package com.yijava.admin.dao.templete;

import org.springframework.stereotype.Repository;

import com.yijava.admin.entity.templets.Templete;
import com.yijava.orm.core.hibernate.support.HibernateSupportDao;

@Repository
public class TempleteDao extends HibernateSupportDao<Templete, String>{

}
