package com.yijava.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yijava.entity.RadioNew;
import com.yijava.orm.core.hibernate.support.HibernateSupportDao;

@Repository
public class RadioNewDao extends HibernateSupportDao<RadioNew, Long>{

	public List<RadioNew> searchRadioTop5() {
		return null;
	}
}
