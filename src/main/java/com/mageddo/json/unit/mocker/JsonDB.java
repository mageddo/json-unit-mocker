/**
 * Generate entites from json mocks files in the classpath
 */
package com.mageddo.json.unit.mocker;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Elvis
 */
public class JsonDB {
	
	public static final Gson gson = new Gson();
	
	private JsonDB(){};
	
	public static <T> T getObject(String mockEntityName, Type type){
		try {
			return gson.fromJson(FileUtils.readFileToString(new File("/" + mockEntityName)), type);
		} catch (IOException ex) {
			return null;
		}
	}
	
	public static<T> T getObject(String mockEntityName, Class<?> type){
		try {
			return (T) gson.fromJson(FileUtils.readFileToString(new File("/" + mockEntityName)), type);
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
	
	public static void setObject(Object o) throws IOException{
		FileUtils.write(new File("/" + o.getClass().getSimpleName()), gson.toJson(o));
	}
	public static void setObject(Object o, String mockName) throws IOException{
		FileUtils.write(new File("/" + mockName), gson.toJson(o));
	}
	public static void setObject(Object o, File mockFile) throws IOException{
		FileUtils.write(mockFile, gson.toJson(o));
	}
}
