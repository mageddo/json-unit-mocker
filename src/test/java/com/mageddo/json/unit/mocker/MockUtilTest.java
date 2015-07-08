package com.mageddo.json.unit.mocker;

import junit.framework.Assert;

import org.junit.Test;

import com.mageddo.utils.MockerUtil;

public class MockUtilTest {
	
	@Test 
	public void atLeastOneFolderOnClassPathTest(){
		Assert.assertTrue(MockerUtil.getDefaultFolder().isDirectory());
	}
}
