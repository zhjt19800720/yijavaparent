package com.yijava.admin.web.log;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yijava.admin.common.SystemVariableUtils;
import com.yijava.admin.common.enumeration.SystemDictionaryCode;
import com.yijava.admin.entity.log.SystemLog;
import com.yijava.admin.service.log.SystemLogManager;
import com.yijava.orm.core.Page;
import com.yijava.orm.core.PageRequest;
import com.yijava.orm.core.PageRequest.Sort;
import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.PropertyFilters;

@Controller
@RequestMapping("/systemlog")
public class SystemLogController {

	@Autowired
	private SystemLogManager systemLogManager;
	
	
	/**
	 * 获取用户列表
	 * 
	 * @param pageRequest 分页实体信息
	 * @param request HttpServlet请求
	 * 
	 * @return {@link Page}
	 */
	@RequestMapping("view")
	public Page<SystemLog> view(PageRequest pageRequest,HttpServletRequest request) {
		
		List<PropertyFilter> filters = PropertyFilters.build(request);

		request.setAttribute("states", SystemVariableUtils.getDataDictionariesByCategoryCode(SystemDictionaryCode.State,"3"));
		
		if (!pageRequest.isOrderBySetted()) {
			pageRequest.setOrderBy("id");
			pageRequest.setOrderDir(Sort.DESC);
		}
		
		return systemLogManager.searchSystemLogPage(pageRequest, filters);
	}
}
