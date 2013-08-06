package com.yijava.admin.web.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yijava.admin.common.SystemVariableUtils;
import com.yijava.admin.common.enumeration.SystemDictionaryCode;
import com.yijava.admin.common.enumeration.entity.GroupType;
import com.yijava.admin.entity.account.User;
import com.yijava.admin.service.account.AccountManager;
import com.yijava.orm.core.Page;
import com.yijava.orm.core.PageRequest;
import com.yijava.orm.core.PageRequest.Sort;
import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.PropertyFilters;

/**
 * 用户管理Controller
 * 
 * @author vincent
 *
 */
@Controller
@RequestMapping("/account/user")
public class UserController {
	
	@Autowired
	private AccountManager accountManager;
	
	/**
	 * 获取用户列表
	 * 
	 * @param pageRequest 分页实体信息
	 * @param request HttpServlet请求
	 * 
	 * @return {@link Page}
	 */
	@RequestMapping("view")
	public Page<User> view(PageRequest pageRequest,HttpServletRequest request) {
		
		List<PropertyFilter> filters = PropertyFilters.build(request);

		request.setAttribute("states", SystemVariableUtils.getDataDictionariesByCategoryCode(SystemDictionaryCode.State,"3"));
		
		if (!pageRequest.isOrderBySetted()) {
			pageRequest.setOrderBy("id");
			pageRequest.setOrderDir(Sort.DESC);
		}
		
		return accountManager.searchUserPage(pageRequest, filters);
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
	public String insert(User entity,@RequestParam(value = "groupIds",required=false)List<String> groupIds,RedirectAttributes redirectAttributes) {
		
		entity.setGroupsList(accountManager.getGroups(groupIds));
		
		accountManager.insertUser(entity);
		redirectAttributes.addFlashAttribute("message", "新增成功");
		
		return "redirect:/account/user/view";
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
		accountManager.deleteUsers(ids);
		redirectAttributes.addFlashAttribute("message", "删除" + ids.size() + "条信息成功");
		return "redirect:/account/user/view";
	}
	
	/**
	 * 更新用户，更新成功后重定向到:account/user/view
	 * 
	 * @param entity 实体信息
	 * @param groupIds 所在组id
	 * @param redirectAttributes spring mvc 重定向属性
	 * 
	 * @return String
	 */
	@RequestMapping(value="update")
	public String update(@ModelAttribute("entity")User entity, @RequestParam(value = "groupIds",required=false)List<String> groupIds,RedirectAttributes redirectAttributes) {

		entity.setGroupsList(accountManager.getGroups(groupIds));
		
		accountManager.updateUser(entity);
		redirectAttributes.addFlashAttribute("message", "修改成功");
		return "redirect:/account/user/view";
	}
	
	/**
	 * 判断用户帐号是否唯一,在新建时使用,如果存在用户返回"true",否则返回"false"
	 * 
	 * @param username 用户帐号
	 * 
	 * @return boolean 
	 */
	@ResponseBody
	@RequestMapping("isUsernameUnique")
	public String isUsernameUnique(String username) {
		
		return String.valueOf(accountManager.isUsernameUnique(username));
		
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
		
		model.addAttribute("states", SystemVariableUtils.getDataDictionariesByCategoryCode(SystemDictionaryCode.State,"3"));
		model.addAttribute("groupsList", accountManager.getAllGroup(GroupType.RoleGorup));
		
		if (StringUtils.isEmpty(id)) {
			return "account/user/create";
		} else {
			return "account/user/read";
		}
		
	}
	
	/**
	 * 绑定实体数据，如果存在id时获取后从数据库获取记录，进入到相对的C后在将数据库获取的记录填充到相应的参数中
	 * 
	 * @param id 主键ID
	 * 
	 */
	@ModelAttribute("entity")
	public User bindingModel(@RequestParam(value = "id", required = false)String id) {
		
		User user = new User();
		
		if (StringUtils.isNotEmpty(id)) {
			user = accountManager.getUser(id);
		}
		
		return user;
	}
	
}
