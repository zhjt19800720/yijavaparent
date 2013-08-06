package com.yijava.admin.test.manager.account;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.yijava.admin.common.enumeration.entity.GroupType;
import com.yijava.admin.entity.account.Group;
import com.yijava.admin.service.account.AccountManager;
import com.yijava.admin.test.manager.ManagerTestCaseSupport;
import com.yijava.orm.core.Page;
import com.yijava.orm.core.PageRequest;
import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.PropertyFilters;

/**
 * 测试组管理所有方法
 * 
 * @author vincent
 *
 */
public class TestGroupManager extends ManagerTestCaseSupport{

	@Autowired
	private AccountManager accountManager;
	
	@Test
	@Transactional(readOnly=true)
	public void testGetGroup() {
		Group group = accountManager.getGroup("SJDK3849CKMS3849DJCK2039ZMSK0003");
		assertEquals(group.getName(), "用户角色");
		assertEquals(group.getChildren().size(),3);
	}

	@Test
	public void testGetGroupsListOfString() {
		List<String> ids = Lists.newArrayList("SJDK3849CKMS3849DJCK2039ZMSK0004",
						   					  "SJDK3849CKMS3849DJCK2039ZMSK0005",
						   					  "SJDK3849CKMS3849DJCK2039ZMSK0006");
		
		List<Group> result = accountManager.getGroups(ids);
		
		assertEquals(result.size(), 3);
	}

	@Test
	public void testSaveGroup() {
		Group entity = new Group();
		entity.setName("test");
		entity.setRemark("...");
		entity.setRole("role[test]");
		entity.setType(GroupType.RoleGorup.getValue());
		entity.setValue("/**");
		
		int before = countRowsInTable("tb_group");
		accountManager.saveGroup(entity);
		int after = countRowsInTable("tb_group");
		
		assertEquals(before + 1, after);
	}

	@Test
	public void testDeleteGroups() {
		int before = countRowsInTable("tb_group");
		accountManager.deleteGroups(Lists.newArrayList("SJDK3849CKMS3849DJCK2039ZMSK0003"));
		int after = countRowsInTable("tb_group");
		
		assertEquals(before - 4, after);
	}

	@Test
	public void testSearchGroupPage() {
		PageRequest request = new PageRequest();
		
		List<PropertyFilter> filters = Lists.newArrayList(
				PropertyFilters.build("LIKES_name", "角色"),
				PropertyFilters.build("EQS_type", "03")
		);
		
		Page<Group> page = accountManager.searchGroupPage(request, filters);
		
		assertEquals(page.getTotalItems(), 4);
		assertEquals(page.getTotalPages(), 1);
	}

	@Test
	public void testGetAllGroupGroupType() {
		List<Group> result = accountManager.getAllGroup(GroupType.RoleGorup);
		assertEquals(result.size(), 4);
		
		result = accountManager.getAllGroup(GroupType.RoleGorup,"SJDK3849CKMS3849DJCK2039ZMSK0004","SJDK3849CKMS3849DJCK2039ZMSK0004");
		assertEquals(result.size(), 3);
	}

	@Test
	public void testGetUserGroups() {
		List<Group> result = accountManager.getUserGroups("SJDK3849CKMS3849DJCK2039ZMSK0001");
		assertEquals(result.size(), 4);
	}
	
}
