package com.mageddo.json.unit.mocker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.mageddo.utils.MockerUtil;

/**
 * Utility to read/write files from the classpath, suffix extensions does not exists 
 * @author Elvis
 *
 */
public class PlainDB {

	
	/**
	 * Get entity name and load it from from the first classpath folder to a String
	 * @param mockEntityName
	 * @return
	 * @throws IOException
	 */
	public static String readAsString(String mockPath) throws IOException{
		return FileUtils.readFileToString(readAsFile(mockPath));
	}
	
	/**
	 * load the entity as a file 
	 * @param mockEntityName
	 * @return
	 */
	public static File readAsFile(String mockPath){
		return new File(MockerUtil.getDefaultFolder(), mockPath);
	}
	
	public static FileInputStream readAsInputStream(String mockPath) throws FileNotFoundException {
		return new FileInputStream(readAsFile(mockPath));
	}
	
	public static FileOutputStream readAsOuputStream(String mockPath) throws FileNotFoundException {
		return readAsOuputStream(mockPath, false);
	}
	
	public static FileOutputStream readAsOuputStream(String mockPath, boolean append) throws FileNotFoundException {
		return new FileOutputStream(readAsFile(mockPath), append);
	}
	
	public static void write(String mockPath, String data) throws IOException {
		FileUtils.write(readAsFile(mockPath), data);
	}
	
	public static void write(String mockPath, InputStream data) throws IOException {
		OutputStream out = readAsOuputStream(mockPath);
		IOUtils.copy(data, out);
		data.close();
		out.close();
	}
	
}
