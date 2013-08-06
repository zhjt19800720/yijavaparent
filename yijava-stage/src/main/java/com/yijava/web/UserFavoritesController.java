package com.yijava.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yijava.entity.UserFavorites;
import com.yijava.orm.core.Page;
import com.yijava.orm.core.PageRequest;
import com.yijava.orm.core.PageRequest.Sort;
import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.PropertyFilters;
import com.yijava.service.UserFavoritesService;
import com.yijava.web.vo.News;
import com.yijava.web.vo.Result;

@Controller
@RequestMapping("/api")
public class UserFavoritesController {

	@Autowired
	private UserFavoritesService userFavoritesService;
	
	
	@RequestMapping("/favorites/me")
	@ResponseBody
	public Result<Page<News>> view(PageRequest pageRequest,HttpServletRequest request,Model model)
	{
		List<PropertyFilter> filters = PropertyFilters.build(request);
		if (!pageRequest.isOrderBySetted()) {
			pageRequest.setOrderBy("create_at");
			pageRequest.setOrderDir(Sort.DESC);
		}
		Result<Page<News>> result= new Result<Page<News>> ();
		Page<UserFavorites> data=userFavoritesService.searchRadioNewPage(pageRequest, filters);			
		List<UserFavorites> favs=data.getResult();		
		List<News> newList=new ArrayList<News>();
		News news;
		for(UserFavorites fav:favs)
		{
			news=new News();
			if(StringUtils.isNotBlank(fav.getRadioNew().getTitle()))
				news.setTitle(fav.getRadioNew().getTitle());
			if(StringUtils.isNotBlank(fav.getRadioNew().getDuration()))
				news.setDuration((fav.getRadioNew().getDuration()));
			if(StringUtils.isNotBlank(fav.getRadioNew().getImage_file()))
				news.setImage_file((fav.getRadioNew().getImage_file()));
			if(StringUtils.isNotBlank(fav.getRadioNew().getRadio_file()))
				news.setRadio_file((fav.getRadioNew().getRadio_file()));
			if(null!=fav.getRadioNew().getId())
				news.setId(fav.getRadioNew().getId());
			
			newList.add(news);
		}
		
		Page<News> page=new Page<News>(pageRequest);	
		BeanUtils.copyProperties(data, page,new String[]{"result"});
		
		page.setResult(newList);
		result.setData(page);
		result.setState(1);
		return result;		
	}
	@RequestMapping("/favorites/add")
	@ResponseBody
	public Result<Integer> view(HttpServletRequest request,UserFavorites entity )
	{
		Result<Integer> result= new Result<Integer> ();
		if(entity.getState()==null)
			entity.setState(1);
		if(entity.getCreate_at()==null)
			entity.setCreate_at(new Date());
		userFavoritesService.insertRadioNew(entity);
		result.setState(1);
		result.setData(1);
		return result;
	}
}
