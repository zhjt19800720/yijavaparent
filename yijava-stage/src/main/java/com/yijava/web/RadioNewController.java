package com.yijava.web;

import java.util.ArrayList;
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
import com.yijava.web.vo.News;
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
		String title=request.getParameter("title");
		String category_id=request.getParameter("category_id");
		PropertyFilter filter=null;
		PropertyFilter filter2=null;
		if(title!=null)
		{
			filter = PropertyFilters.build("RLIKES_title",title);
			
		}
		if(category_id!=null)
		{
			filter2 = PropertyFilters.build("EQS_category_id",category_id);			
		}	
		
		

		List<PropertyFilter> filters = PropertyFilters.build(request);
		if(filter!=null)
			filters.add(filter);
		if(filter2!=null)
			filters.add(filter2);
		
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
	public List<News> topnew(PageRequest pageRequest,HttpServletRequest request,Model model)
	{
		List<News> topnews=new ArrayList<News>();
		List<RadioNew> news=radioNewService.searchRadioTop5();
		for(RadioNew radioNew:news)
		{
			topnews.add(new News(radioNew.getTitle(),"http://manage.yijava.com/"+radioNew.getRadio_file()));
		}
		
		return topnews;
	}
	
	
	
	
}
