package com.mageddo.json.unit.mocker.util;

import org.junit.Test;

public class ClassPathTest {
	
	@Test
	public void classhPathTest(){
		String classpath = System.getProperty("java.class.path");
		System.out.println(">>>>>>>>>> CHECK IT!!!!!");
		System.out.println(classpath);
		System.out.println(">>>>>>>>>>>>");
	}

}
