package com.mageddo.utils;

import java.io.File;

public class MockerUtil {

	private static final int DEFAULT_INDEX = 0;

	/**
	 * Return the default path to save the json file<br>
	 * This folder is the first folder in the classpath
	 * @return
	 */
	public static File getDefaultFolder() {
		return ClasshPathUtil.getInstance()
				.getPath(DEFAULT_INDEX);
	}
}
