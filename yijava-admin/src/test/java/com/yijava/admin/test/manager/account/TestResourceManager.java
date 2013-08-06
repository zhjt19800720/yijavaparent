package com.yijava.admin.test.manager.account;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.yijava.admin.common.enumeration.entity.ResourceType;
import com.yijava.admin.entity.account.Resource;
import com.yijava.admin.service.account.AccountManager;
import com.yijava.admin.test.manager.ManagerTestCaseSupport;
import com.yijava.orm.core.Page;
import com.yijava.orm.core.PageRequest;
import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.PropertyFilters;

/**
 * 测试资源管理所有方法
 * 
 * @author vincent
 *
 */
public class TestResourceManager extends ManagerTestCaseSupport{
	
	@Autowired
	private AccountManager accountManager;
	
	@Test
	@Transactional(readOnly=true)
	public void testGetResource() {
		Resource resource = accountManager.getResource("SJDK3849CKMS3849DJCK2039ZMSK0007");
		assertEquals(resource.getName(), "系统管理");
		assertEquals(resource.getChildren().size(), 3);
	}

	@Test
	public void testGetResources() {
		List<String> ids = Lists.newArrayList(
				"SJDK3849CKMS3849DJCK2039ZMSK0007",
				"SJDK3849CKMS3849DJCK2039ZMSK0008",
				"SJDK3849CKMS3849DJCK2039ZMSK0009",
				"SJDK3849CKMS3849DJCK2039ZMSK0010"
		);
		
		List<Resource> result = accountManager.getResources(ids);
		
		assertEquals(result.size(), 4);
	}

	@Test
	public void testSearchResourcePage() {
		PageRequest request = new PageRequest();
		List<PropertyFilter> filters = Lists.newArrayList(
				PropertyFilters.build("LIKES_name", "管理"),
				PropertyFilters.build("LIKES_type", "01")
				
		);
		Page<Resource> page = accountManager.searchResourcePage(request, filters);
		
		assertEquals(page.getTotalItems(), 5);
		assertEquals(page.getTotalPages(), 1);
	}

	@Test
	public void testSaveResource() {
		Resource entity = new Resource();
		entity.setName("test");
		entity.setPermission("prem[test:test]");
		entity.setRemark("...");
		entity.setType(ResourceType.Security.getValue());
		entity.setValue("/test/**");
		
		int before = countRowsInTable("tb_resource");
		accountManager.saveResource(entity);
		int after = countRowsInTable("tb_resource");
		
		assertEquals(before + 1, after);
	}

	@Test
	public void testDeleteResources() {
		
		int before = countRowsInTable("tb_resource");
		accountManager.deleteResources(Lists.newArrayList("SJDK3849CKMS3849DJCK2039ZMSK0007"));
		int after = countRowsInTable("tb_resource");
		
		assertEquals(before - 4, after);
	}

	@Test
	public void testGetAllParentMenuResources() {
		List<Resource> result = accountManager.getAllParentMenuResources();
		assertEquals(result.size(), 2);
	}

	@Test
	public void testGetAllParentResources() {
		List<Resource> result = accountManager.getAllParentMenuResources();
		assertEquals(result.size(), 2);
	}

	@Test
	public void testGetAllResources() {
		List<Resource> result = accountManager.getAllResources();
		assertEquals(result.size(), 8);
		
		result = accountManager.getAllResources("SJDK3849CKMS3849DJCK2039ZMSK0007","SJDK3849CKMS3849DJCK2039ZMSK0008");
		assertEquals(result.size(), 6);
	}
	
	@Test
	public void testGetUserResources() {
		List<Resource> result = accountManager.getUserResources("SJDK3849CKMS3849DJCK2039ZMSK0001");
		assertEquals(result.size(), 8);
	}

	@Test
	@Transactional(readOnly=true)
	public void testMergeResourcesToParent() {
		List<Resource> result = accountManager.getUserResources("SJDK3849CKMS3849DJCK2039ZMSK0001");
		result = accountManager.mergeResourcesToParent(result, ResourceType.Security);
		assertEquals(result.size(), 2);
	}
}
