/**
 * Generate entites from json mocks files in the classpath
 */
package com.mageddo.json.unit.mocker;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mageddo.utils.ClasshPathUtil;

/**
 *
 * @author Elvis
 */
public class JsonDB {
	
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private static final int DEFAULT_INDEX = 0;
	private static final String DEFAULT_EXTENSION = ".json";
	
	private JsonDB(){};
	
	public static <T> T getObject(String mockEntityName, Type type){
		try {
			return gson.fromJson(FileUtils.readFileToString(getPathInClassPath(mockEntityName)), type);
		} catch (IOException ex) {
			return null;
		}
	}
	
	public static<T> T getObject(String mockEntityName, Class<?> type){
		try {
			return (T) gson.fromJson(FileUtils.readFileToString(getPathInClassPath(mockEntityName)), type);
		} catch (IOException ex) {
			return null;
		}
	}
	
	public static<T> T getObject(File mockEntityFile, Class<?> type){
		try {
			return (T) gson.fromJson(FileUtils.readFileToString(mockEntityFile), type);
		} catch (IOException ex) {
			return null;
		}
	}
	
	protected static File getPathInClassPath(String fileName) {
		return new File(
				ClasshPathUtil.getInstance()
				.getPath(DEFAULT_INDEX),
				File.separator + fileName);
	}

	protected static String getDefaultMockFileName(Object o) {
		return o.getClass().getSimpleName() + DEFAULT_EXTENSION;
	}

	public static void setObject(Object o) throws IOException{
		FileUtils.write(getPathInClassPath(getDefaultMockFileName(o)), gson.toJson(o));
		
	}
	
	public static void setObject(Object o, Class<?> objecToRead) throws IOException{
		FileUtils.write(getPathInClassPath(getDefaultMockFileName(objecToRead)), gson.toJson(o));
	}
	
	public static void setObject(Object o, String mockName) throws IOException{
		FileUtils.write(getPathInClassPath(mockName), gson.toJson(o));
	}
	
	public static void setObject(Object o, File mockFile) throws IOException{
		FileUtils.write(mockFile, gson.toJson(o));
	}

	public void setSerializer(Gson gson){
		JsonDB.gson = gson;
	}
}
