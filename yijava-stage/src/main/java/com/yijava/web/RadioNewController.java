package com.yijava.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yijava.entity.RadioNew;
import com.yijava.orm.core.Page;
import com.yijava.orm.core.PageRequest;
import com.yijava.orm.core.PageRequest.Sort;
import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.PropertyFilters;
import com.yijava.service.RadioNewService;
import com.yijava.web.vo.Result;

@Controller
@RequestMapping("/api")
public class RadioNewController {

	
	
	@Autowired
	private RadioNewService radioNewService;
	
	
	@RequestMapping("/rnews")
	@ResponseBody
	public Result<Page<RadioNew>> view(PageRequest pageRequest,HttpServletRequest request,Model model)
	{
		List<PropertyFilter> filters = PropertyFilters.build(request);
		if (!pageRequest.isOrderBySetted()) {
			pageRequest.setOrderBy("id");
			pageRequest.setOrderDir(Sort.DESC);
		}
		Result<Page<RadioNew>> result= new Result<Page<RadioNew>> ();
		Page<RadioNew> data=radioNewService.searchRadioNewPage(pageRequest, filters);		
		result.setData(data);
		result.setState(1);
		return result;		
	}
	
	@RequestMapping("/rnew-top")
	@ResponseBody
	public List<RadioNew> topnew(PageRequest pageRequest,HttpServletRequest request,Model model)
	{
		return radioNewService.searchRadioTop5();
	}
	
	
	
	
}
