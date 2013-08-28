package com.yijava.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yijava.common.HttpConstants;
import com.yijava.entity.Category;
import com.yijava.entity.RadioNew;
import com.yijava.orm.core.Page;
import com.yijava.orm.core.PageRequest;
import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.PropertyFilters;
import com.yijava.service.RadioNewService;
import com.yijava.web.vo.AudioNew;
import com.yijava.web.vo.AudioNewCategory;
import com.yijava.web.vo.News;
import com.yijava.web.vo.OutHeader;
import com.yijava.web.vo.OutResult;
import com.yijava.web.vo.PlayVo;
import com.yijava.web.vo.Result;

@Controller
@RequestMapping("/api")
public class RadioNewController {

	
	
	@Autowired
	private RadioNewService radioNewService;
	
	
	@RequestMapping("/rnews")
	@ResponseBody
	public Result<Page<AudioNew>> view(PageRequest pageRequest,HttpServletRequest request,Model model)
	{
		String callback = request.getParameter("callback");

		String title=request.getParameter("title");
		String category_id=request.getParameter("category_id");
		PropertyFilter filter=null;
		PropertyFilter filter2=null;
		if(title!=null && title!="")
		{
			filter = PropertyFilters.build("RLIKES_title",title);
			
		}
		if(category_id!=null && category_id!="")
		{
			filter2 = PropertyFilters.build("EQS_category_id",category_id);			
		}	
		
		

		List<PropertyFilter> filters = PropertyFilters.build(request);
		if(filter!=null)
			filters.add(filter);
		if(filter2!=null)
			filters.add(filter2);
		
		/*if (!pageRequest.isOrderBySetted()) {
			pageRequest.setOrderBy("id");
			pageRequest.setOrderDir(Sort.DESC);
		}*/
		Result<Page<AudioNew>> result= new Result<Page<AudioNew>> ();
		
		Page<RadioNew> data=radioNewService.searchRadioNewPage(pageRequest, filters,category_id,title);		
		
		
		
		//data.get
		List<RadioNew> newlist=data.getResult();
		
		List<AudioNew> audionews= new ArrayList<AudioNew>();
		
		AudioNew audionew;
		List<AudioNewCategory> audiocategorys;
		for(RadioNew news:newlist)
		{
			audiocategorys=new ArrayList<AudioNewCategory>();
			news.setImage_file(HttpConstants.SERVER_BASE_URL+news.getImage_file());
			news.setRadio_file(HttpConstants.SERVER_BASE_URL+news.getRadio_file());
			
			audionew=new AudioNew();
			audionew.setId(news.getId());
			audionew.setTitle(news.getTitle());
			audionew.setCreate_date(news.getCreate_date());
			audionew.setDuration(news.getDuration());
			audionew.setImage_file(news.getImage_file());
			audionew.setRadio_file(news.getRadio_file());
			audionew.setSeq_num(news.getSeq_num());
			audionew.setLast_date(news.getLast_date());
			
			List<Category> categorys=news.getCategorys();
		
			for(Category category:categorys)
			{
				audiocategorys.add(new AudioNewCategory(category.getId(),category.getCategory()));
				System.out.println(category.getCategory());
			}
			audionew.setCategorys(audiocategorys);
			audionews.add(audionew);
			
		}
		
		//赋值新的类型
		
		
		Page<AudioNew> newdata=new Page<AudioNew>();
		newdata.setTotalItems(data.getTotalItems());
		newdata.setPageNo(data.getPageNo());
		newdata.setPageSize(data.getPageSize());
		newdata.setResult(audionews);
		
		result.setData(newdata);
		result.setState(1);
		
		
		 /*ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		
		 try {
			mapper.writeValueAsString(result);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}*/
		 
		
		return result;		
	}
	
	@RequestMapping("/currentplaycontent")
	@ResponseBody
	public Result<List<PlayVo>> currentplaycontent(PageRequest pageRequest,HttpServletRequest request,Model model)
	{
		Result<List<PlayVo>> result= new Result<List<PlayVo>> ();
		
		//List<RadioNew> topnews=new ArrayList<RadioNew>();
		List<RadioNew> news=radioNewService.searchCurrentPlayContent();
		
		List<PlayVo> playVos=new ArrayList<PlayVo>();
		for(RadioNew radioNew:news)
		{
			radioNew.setImage_file(HttpConstants.SERVER_BASE_URL+radioNew.getImage_file());
			radioNew.setRadio_file(HttpConstants.SERVER_BASE_URL+radioNew.getRadio_file());
			//radioNew.setRadio_file(radio_file);
			//topnews.add(new News(radioNew.getTitle(),HttpConstants.SERVER_BASE_URL+radioNew.getRadio_file()));
			playVos.add(new PlayVo(radioNew.getId().toString(),radioNew.getTitle(),radioNew.getCreate_date(),radioNew.getRadio_file()));
		}
		result.setData(playVos);
		result.setState(1);
		return result;
	}
	
	
	@RequestMapping("/rnew-top")
	@ResponseBody
	public OutResult<Map<String,List<News>>> topnew(PageRequest pageRequest,HttpServletRequest request,Model model)
	{
		OutResult<Map<String,List<News>>> inResult=new OutResult<Map<String,List<News>>>();
		
		List<News> topnews=new ArrayList<News>();
		List<RadioNew> news=radioNewService.searchRadioTop5();
		for(RadioNew radioNew:news)
		{
			topnews.add(new News(radioNew.getTitle(),HttpConstants.SERVER_BASE_URL+radioNew.getRadio_file()));
		}
		
		inResult.setHead(new OutHeader("查询新闻","000",""));
		
		Map<String ,List<News>> body=new HashMap<String ,List<News>>();
		body.put("audio_set", topnews);
		inResult.setBody(body);
		return inResult;
	}
	
	
	
	
	
	
}
