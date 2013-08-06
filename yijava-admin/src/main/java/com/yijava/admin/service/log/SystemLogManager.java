package com.yijava.admin.service.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yijava.admin.dao.log.SystemLogDao;
import com.yijava.admin.entity.log.SystemLog;
import com.yijava.orm.core.Page;
import com.yijava.orm.core.PageRequest;
import com.yijava.orm.core.PropertyFilter;

@Service
@Transactional
public class SystemLogManager {

	// 数据字典数据访问
	@Autowired
	private SystemLogDao systemLogDao;

	/**
	 * 保存系统日志
	 * 
	 * @param entity 数据字典实体
	 */
	//@CacheEvict(value=DataDictionary.FindByCateGoryCode,allEntries=true)
	public void saveSystemLog(SystemLog systemLog) {
		systemLogDao.save(systemLog);
	}
	
	/**
	 * 获取系统日志分页对象
	 * 
	 * @param request 分页参数请求
	 * @param filters 属性过滤器集合
	 * 
	 * @return Page
	 */
	public Page<SystemLog> searchSystemLogPage(PageRequest request,List<PropertyFilter> filters) {
		return systemLogDao.findPage(request, filters);
	}
}
