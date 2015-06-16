package com.mageddo.utils;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

public class FileStructureTest {
	
	@Test
	public void navigatePathTest(){
		boolean b = new File(ClasshPathUtil.getInstance().getPath(0), "com").exists();
		Assert.assertTrue(b);
	}
}
