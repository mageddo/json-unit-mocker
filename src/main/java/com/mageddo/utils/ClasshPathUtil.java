package com.mageddo.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClasshPathUtil {
	
	private static ClasshPathUtil instance;
	private String[] classPaths;
	
	private ClasshPathUtil() {
		classPaths = System.getProperty("java.class.path").split(File.pathSeparator);
	}
	
	/**
	 * Create the singleton instance
	 * @return
	 */
	public static synchronized ClasshPathUtil getInstance(){
		if(instance == null)
			instance = new ClasshPathUtil();
			return instance;
	}

	/**
	 * Load all files and directories in the classpath as a {@link File} array
	 * @return File[]
	 */
	public File[] loadClassPaths(){
		File[] files = new File[classPaths.length];
		for(int i=0; i < classPaths.length; i++){
			files[i] = new File(classPaths[i]);
		}
		return files;
	}
	
	/**
	 * Load all only files on the classpath list
	 * @return
	 */
	public File[] loadClassPathFiles(){
		List<File> files = new ArrayList<File>();
		for(File f: loadClassPaths()){
			if(f.isFile())
				files.add(f);
		}
		return files.toArray(new File[files.size()]);
	}
	
	/**
	 * Load all only folders on the classpath list
	 * @return
	 */
	public File[] loadClassPathFolders(){
		List<File> folders = new ArrayList<File>();
		for(File f: loadClassPaths()){
			if(f.isDirectory())
				folders.add(f);
		}
		return folders.toArray(new File[folders.size()]);
	}
	
	/**
	 * get the path in the specified index as {@link File }
	 * @param index of the path in the classpath from 0
	 * @return
	 */
	public File getPath(int index){
		return new File(classPaths[index]);
	}
	
	public String[] getClassPaths() {
		return classPaths;
	}
}
