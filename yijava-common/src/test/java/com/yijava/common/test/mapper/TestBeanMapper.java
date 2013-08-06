package com.yijava.common.test.mapper;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.yijava.common.mapper.BeanMapper;
import com.yijava.common.test.entity.User;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanMapper {

	@Test
	public void testToMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map = BeanMapper.toMap(new User(), false, true);
		assertEquals(map.size(), 4);
		map = BeanMapper.toMap(new User(), false, false);
		assertEquals(map.size(), 7);
		map = BeanMapper.toMap(new User(), true, false);
		assertEquals(map.size(), 6);
		map = BeanMapper.toMap(new User(), true, true);
		assertEquals(map.size(), 4);
		map = BeanMapper.toMap(new User(), true, true,"username","password");
		assertEquals(map.size(), 2);
		map = BeanMapper.toMap(new User(), false, true,"username","password");
		assertEquals(map.size(), 2);
		map = BeanMapper.toMap(new User(), false, false,"username","password");
	}
}
