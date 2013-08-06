package com.yijava.common.test.mapper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.yijava.common.mapper.JacksonMapper;
import com.yijava.common.test.entity.Group;
import com.yijava.common.test.entity.User;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestJacksonMapper {
	
	private User user;
	
	@Before
	public void reloadUser() {
		user = new User();
	}
	
	@Test
	public void testToJson() {
		String json = null;
		
		//测试不管任何属性的值是否为空，只要存在就序列化成json
		json = JacksonMapper.alwaysMapper().toJson(user);
		assertTrue(StringUtils.contains(json,"\"groupsList\""));
		
		//测试紧存在属性的值不为空的json
		user.setGroupsList(new ArrayList<Group>());
		json = JacksonMapper.nonEmptyMapper().toJson(user);
		assertFalse(StringUtils.contains(json,"\"groupsList\""));
		assertFalse(StringUtils.contains(json,"\"email\""));
		
		//测试紧存在属性的值不为null的json
		json = JacksonMapper.nonNullMapper().toJson(user);
		assertTrue(StringUtils.contains(json,"\"groupsList\""));
		assertTrue(StringUtils.contains(json,"\"groupNames\""));
		
		//测试初始值被改变的json user.setGroupsList(new ArrayList<Group>());
		user = new User();
		json = JacksonMapper.nonDefaultMapper().toJson(user);
		assertTrue(StringUtils.contains(json,"{}"));
		
		user.setEmail("vincent@es.com");
		user.setUsername("vincent");
		user.setGroupsList(new ArrayList<Group>());
		json = JacksonMapper.nonDefaultMapper().toJson(user);
		
		assertTrue(StringUtils.contains(json,"\"email\""));
		assertTrue(StringUtils.contains(json,"\"groupsList\""));
		assertTrue(StringUtils.contains(json,"\"groupNames\""));
	}
}
