package com.yijava.web;





import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yijava.entity.Category;
import com.yijava.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/category-view")
	public String view(Model model) {
		model.addAttribute("categorys", categoryService.getAllCategory());
		return "categoryview";
	}
	
	@RequestMapping(value="/category-save", method = RequestMethod.POST)
	public String saveCategory(Category entity,HttpServletRequest request) {
		
		if(entity.getCreate_at()==null)
		{
			entity.setCreate_at(new Date());
		}
		if(entity.getUpdate_at()==null)
		{
			entity.setUpdate_at(new Date());
		}
		categoryService.insertCategory(entity);
		return "redirect:/category-view";
	}

	@RequestMapping("/category-add")
	public String add() {
		return "categoryadd";
	}
	
	@RequestMapping("/category-update")
	public String update(Category entity,HttpServletRequest request) {
		if(entity.getUpdate_at()==null)
		{
			entity.setUpdate_at(new Date());
		}
		Category category = categoryService.getCategory(entity.getId());
		entity.setCreate_at(category.getCreate_at());
		//BeanUtils.copyProperties(category,entity, new String[]{"id,category,update_at"});
		categoryService.updateCategory(category,entity);
		return "redirect:/category-view";
	}
	
	@RequestMapping("/category-read")
	public String read(@RequestParam(value = "id", required = false)Long id,Model model) {
		if (null!=id) {
			return "categoryread";
		} else {
			return "categoryadd";
		}
	}
	
	
	@RequestMapping("/category-del")
	public String delete(@RequestParam(value = "id", required = false)Long id,Model model) {
		
		List<Long> ids=new ArrayList<Long>();
		ids.add(id);
		
		categoryService.deleteCategorys(ids);
		return "redirect:/category-view";
	}
	
	
	@ModelAttribute("entity")
	public Category bindingModel(@RequestParam(value = "id", required = false)Long id) {		
		Category category = new Category();		
		if (null!=id) {			
			try {
				category = categoryService.getCategory(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return category;
	}
}
