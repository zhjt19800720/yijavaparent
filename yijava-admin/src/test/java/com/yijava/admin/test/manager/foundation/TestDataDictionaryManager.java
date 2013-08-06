package com.yijava.admin.test.manager.foundation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yijava.admin.common.SystemVariableUtils;
import com.yijava.admin.common.enumeration.SystemDictionaryCode;
import com.yijava.admin.entity.foundation.DataDictionary;
import com.yijava.admin.entity.foundation.DictionaryCategory;
import com.yijava.admin.service.foundation.SystemDictionaryManager;
import com.yijava.admin.test.manager.ManagerTestCaseSupport;
import com.yijava.orm.core.PropertyType;

/**
 * 测试数据字典管理所有方法
 * 
 * @author vincent
 *
 */
public class TestDataDictionaryManager extends ManagerTestCaseSupport{
	
	@Autowired
	private SystemDictionaryManager systemDictionaryManager;
	
	@Test
	public void testGetDataDictionariesByCategoryCode() {
		
		assertEquals("启用", SystemVariableUtils.getDictionaryNameByValue(SystemDictionaryCode.State, "1"));
		assertEquals("启用", SystemVariableUtils.getDictionaryNameByValue(SystemDictionaryCode.State, "1"));
		assertEquals("启用", SystemVariableUtils.getDictionaryNameByValue(SystemDictionaryCode.State, "1"));
		
		testSaveDataDictionary();
		
		assertEquals("a1b2c3d4e5f6g7h8i9j0k中文输入法a1b2c3d4e5f6g7h8i9j0k", SystemVariableUtils.getDictionaryNameByValue(SystemDictionaryCode.State, "4"));
		assertEquals("a1b2c3d4e5f6g7h8i9j0k中文输入法a1b2c3d4e5f6g7h8i9j0k", SystemVariableUtils.getDictionaryNameByValue(SystemDictionaryCode.State, "4"));
		assertEquals("a1b2c3d4e5f6g7h8i9j0k中文输入法a1b2c3d4e5f6g7h8i9j0k", SystemVariableUtils.getDictionaryNameByValue(SystemDictionaryCode.State, "4"));
		
		testDeleteDataDictionary();
		
		assertEquals("删除", SystemVariableUtils.getDictionaryNameByValue(SystemDictionaryCode.State, "3"));
		assertEquals("删除", SystemVariableUtils.getDictionaryNameByValue(SystemDictionaryCode.State, "3"));
		assertEquals("删除", SystemVariableUtils.getDictionaryNameByValue(SystemDictionaryCode.State, "3"));
	}
	
	public void testDeleteDataDictionary() {
		
		List<String> ids = new ArrayList<String>();
		CollectionUtils.addAll(ids, new String[]{"SJDK3849CKMS3849DJCK2039ZMSK0018","SJDK3849CKMS3849DJCK2039ZMSK0019"});
		
		int beforeRow = countRowsInTable("TB_DATA_DICTIONARY");
		systemDictionaryManager.deleteDataDictionary(ids);
		int afterRow = countRowsInTable("TB_DATA_DICTIONARY");
		
		assertEquals(afterRow, beforeRow - 2);
	}
	
	public void testSaveDataDictionary() {
		
		DictionaryCategory category = systemDictionaryManager.getDictionaryCategory("SJDK3849CKMS3849DJCK2039ZMSK0015");
		
		DataDictionary dataDictionary = new DataDictionary();
		dataDictionary.setCategory(category);
		dataDictionary.setName("a1b2c3d4e5f6g7h8i9j0k中文输入法a1b2c3d4e5f6g7h8i9j0k");
		dataDictionary.setValue("4");
		dataDictionary.setType(PropertyType.I.toString());
		dataDictionary.setRemark("*");
		
		int beforeRow = countRowsInTable("TB_DATA_DICTIONARY");
		systemDictionaryManager.saveDataDictionary(dataDictionary);
		int afterRow = countRowsInTable("TB_DATA_DICTIONARY");
		
		assertEquals(afterRow, beforeRow + 1);
		
		assertEquals(dataDictionary.getWubiCode(), "A1B2C3D4E5F6G7H8I9J0KKYLTIA1B2C3D4E5F6G7H8I9J0K");
		assertEquals(dataDictionary.getPinYinCode(), "A1B2C3D4E5F6G7H8I9J0KZWSRFA1B2C3D4E5F6G7H8I9J0K");
		
	}
	
}
