package com.mageddo.json.unit.mocker.util;

import org.junit.Test;

import com.mageddo.json.unit.mocker.JsonDB;

public class ClassPathTest {
	
	@Test
	public void classhPathTest(){
		JsonDB.gson.toJson(new Object());
		String classpath = System.getProperty("java.class.path");
		System.out.println(">>>>>>>>>> CHECK IT!!!!!");
		System.out.println(classpath);
		System.out.println(">>>>>>>>>>>>");
	}

}
