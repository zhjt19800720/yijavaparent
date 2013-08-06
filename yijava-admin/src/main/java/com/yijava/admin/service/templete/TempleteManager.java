package com.yijava.admin.service.templete;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yijava.admin.dao.templete.TempleteDao;
import com.yijava.admin.entity.templets.Templete;
import com.yijava.orm.core.Page;
import com.yijava.orm.core.PageRequest;
import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.RestrictionNames;

@Service
@Transactional
public class TempleteManager {

	@Autowired
	private TempleteDao templeteDao;

	
	/**
	 * 获取数据字典实体
	 * 
	 * @param id 数据字典id
	 */
	public Templete getTemplete(String id) {
		return templeteDao.load(id);
	}
	
	
	/**
	 * 通过属性过滤器查询用户分页
	 * 
	 * @param request
	 *            分页参数
	 * @param filters
	 *            属性过滤器集合
	 * 
	 * @return {@link Page}
	 */
	public Page<Templete> searchTempletePage(PageRequest request,
			List<PropertyFilter> filters) {

		return templeteDao.findPage(request, filters);

	}

	
	/**
	 * 保存模板
	 * 
	 * @param entity
	 *            模板实体
	 */
	public void saveTemplete(Templete templete) {
		templeteDao.save(templete);
	}
	
	/**
	 * 保存模板
	 * 
	 * @param entity
	 *            模板实体
	 */
	public void insertTemplete(Templete templete) {
		templeteDao.insert(templete);
	}

	/**
	 * 删除模板
	 * 
	 * @param ids
	 *            模板id
	 */
	public void deleteTemplete(List<String> ids) {
		templeteDao.deleteAll(ids);
	}
	
	
	/**
	 * 获取所有资源
	 * 
	 * @param ignoreIdValue 要忽略的id属性值
	 * 
	 * @return List
	 */
	public List<Templete> getAllTempletes(String... ignoreIdValue) {
		
		if(ArrayUtils.isNotEmpty(ignoreIdValue)) {
			return templeteDao.findByProperty("id", ignoreIdValue, RestrictionNames.NIN);
		}
		
		return templeteDao.getAll();
	}

	
}
