package com.yijava.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yijava.entity.Category;
import com.yijava.service.CategoryService;

@Controller
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/category")
	@ResponseBody
	public List<Category> view(Model model) {
		return categoryService.getAllCategory();		
	}
	

}
