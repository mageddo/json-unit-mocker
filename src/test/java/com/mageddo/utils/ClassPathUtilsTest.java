package com.mageddo.utils;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class ClassPathUtilsTest {
	
	/**
	 * How many concurrent threads to create
	 */
	private static final int HOW_MUCH_TIMES_TEST_SINGLETON = 30;
	/**
	 * This is a time to all the threads of {@link #singletonTest()} run, if it time is not sufficient please
	 * try to set a bigger time 
	 */
	private static final long MILLIS_TO_WAIT_THREADS_CREATE_SINGLETON_INSTANCE = 3000;

	/**
	 * Test if all asynchronous tries to instance {@link ClasshPathUtil}
	 * return a unique instance
	 * @throws Exception
	 */
	@Test
	public void singletonTest() throws Exception {
		final Map<Long, Object> mapInstances = new HashMap<Long, Object>();
		for(int i=0; i < HOW_MUCH_TIMES_TEST_SINGLETON; i++){
			new Thread("test " + i + " - singleton " + this.getClass().getName()){
				public void run() {
					mapInstances.put(getId(), ClasshPathUtil.getInstance());
				};
			}.start();
		}		
		
		Thread.sleep(MILLIS_TO_WAIT_THREADS_CREATE_SINGLETON_INSTANCE);
		
		Object last = null;
		for(Long tId: mapInstances.keySet()){
			final Object current = mapInstances.get(tId);
			if(last == null){
				last = current;
			}else{
				Assert.assertEquals(last, current);
			}
		}		
	}
	
	@Test
	public void classPathGenerationTest(){
		ClasshPathUtil.getInstance();
	}
	

}
