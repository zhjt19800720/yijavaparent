package com.yijava.admin.web.templete;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yijava.admin.entity.templets.Templete;
import com.yijava.admin.service.templete.TempleteManager;
import com.yijava.orm.core.Page;
import com.yijava.orm.core.PageRequest;
import com.yijava.orm.core.PageRequest.Sort;
import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.PropertyFilters;

/**
 * 模板管理Controller
 * 
 * @author zhjt
 * 
 */
@Controller
@RequestMapping("/templete/tpl")
public class TempleteController {

	@Autowired
	private TempleteManager templeteManager;
	
	
	/**
	 * 获取模板列表
	 * 
	 * @param pageRequest 分页实体信息
	 * @param request HttpServlet请求
	 * 
	 * @return {@link Page}
	 */
	@RequestMapping("view")
	public Page<Templete> view(PageRequest pageRequest,HttpServletRequest request) {
		
		List<PropertyFilter> filters = PropertyFilters.build(request);
		//request.setAttribute("states", SystemVariableUtils.getDataDictionariesByCategoryCode(SystemDictionaryCode.State,"3"));		
		if (!pageRequest.isOrderBySetted()) {
			pageRequest.setOrderBy("id");
			pageRequest.setOrderDir(Sort.DESC);
		}
		
		return templeteManager.searchTempletePage(pageRequest, filters);
	}
	
	/**
	 * 创建和更新使用的方法签名.如果链接没有?id=*会跳转到create.flt,如果存在跳转到read.ftl
	 * 
	 * @param id 主键id
	 * @param model Spring mvc的Model接口，主要是将model的属性返回到页面中
	 * 
	 * @return String
	 * 
	 */
	@RequestMapping("read")
	public String read(@RequestParam(value = "id", required = false)String id,Model model) {
		
		if (StringUtils.isEmpty(id)) {
			return "templete/tpl/create";
		} else {
			model.addAttribute("resourcesList", templeteManager.getAllTempletes(id));
			return "templete/tpl/read";
		}		
	}
	
	
	
	/**
	 * 创建用户,创建成功后重定向到:account/user/view
	 * 
	 * @param entity 实体信息
	 * @param groupIds 所在组id
	 * @param redirectAttributes spring mvc 重定向属性
	 * 
	 * @return String
	 * 
	 */
	@RequestMapping("update")
	public String update(Templete entity,RedirectAttributes redirectAttributes) {		
		
		templeteManager.saveTemplete(entity);
		redirectAttributes.addFlashAttribute("message", "新增成功");		
		return "redirect:/templete/tpl/view";
	}
	
	/**
	 * 创建用户,创建成功后重定向到:account/user/view
	 * 
	 * @param entity 实体信息
	 * @param groupIds 所在组id
	 * @param redirectAttributes spring mvc 重定向属性
	 * 
	 * @return String
	 * 
	 */
	@RequestMapping("insert")
	public String insert(Templete entity,RedirectAttributes redirectAttributes) {		
		
		templeteManager.insertTemplete(entity);
		redirectAttributes.addFlashAttribute("message", "新增成功");		
		return "redirect:/templete/tpl/view";
	}
	
	/**
	 * 通过主键id集合删除用户,删除成功后重定向到:account/user/view
	 * 
	 * @param ids 主键id集合
	 * @param redirectAttributes spring mvc 重定向属性
	 * 
	 * @return String
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam("ids")List<String> ids,RedirectAttributes redirectAttributes) {
		templeteManager.deleteTemplete(ids);
		redirectAttributes.addFlashAttribute("message", "删除" + ids.size() + "条信息成功");
		return "redirect:/templete/tpl/view";
	}
	
	/**
	 * 绑定实体数据，如果存在id时获取后从数据库获取记录，进入到相对的C后在将数据库获取的记录填充到相应的参数中
	 * 
	 * @param id 主键ID
	 * 
	 */
	@ModelAttribute("entity")
	public Templete bindingModel(@RequestParam(value = "id", required = false)String id) {		
		Templete templete = new Templete();		
		if (StringUtils.isNotEmpty(id)) {
			templete = templeteManager.getTemplete(id);
		}		
		return templete;
	}
}
