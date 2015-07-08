package com.mageddo.json.unit.mocker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;
import com.mageddo.modelTest.Child;
import com.mageddo.modelTest.Parent;

/**
 *
 * @author Elvis
 */
public class JsonDbTest {
	
	
	private static final String FAMILY_MOCK_FILE_NAME ="theFamilies/happyFamily";
	private static final String FAMILY_ATTACHED_FILE_NAME ="theAttachedFamilies/happyFamily";
	private Child childBob;
	private Parent mother;
	private Parent father;
	private ArrayList<Parent> familly;

	@Before
	public void creatingMockToSave() throws Exception{

		// creating the kid
		childBob = new Child();
		childBob.name = "Bob";
		childBob.birthYear = 2010;
		
		// creating the mother and set up the child
		mother = new Parent();
		mother.name = "Jane";
		mother.birthYear = 1970;
		mother.childs.add(childBob);
		
		// creating the father and set up the child
		father = new Parent();
		father.birthYear = 1967;
		father.name = "Michael";
		father.childs.add(childBob);
		
		// creating the familly
		familly = new ArrayList<Parent>();
		familly.add(father);
		familly.add(mother);
		
		writeParentMockTest();
	}
	
	@Test
	public void writeParentMockTest() throws Exception {
		// writing it to the disk as json file
		JsonDB.writeMock(familly, FAMILY_MOCK_FILE_NAME);
	}	
	
	@Test
	public void readMockTest() throws IOException{
		
		List<Parent> readedfamily = JsonDB.readMock(FAMILY_MOCK_FILE_NAME, new TypeToken<List<Parent>>(){}.getType());
		assertNotNull(readedfamily);
		Parent readFather = readedfamily.get(0);
		assertEquals(father.name, readFather.name);
		assertEquals(father.birthYear, readFather.birthYear);
		
		Parent readMother = readedfamily.get(1);
		assertEquals(mother.name, readMother.name);
		assertEquals(mother.birthYear, readMother.birthYear);
		
		Child readChild = readFather.childs.get(0);
		assertEquals(childBob.name, readChild.name);
		assertEquals(childBob.birthYear, readChild.birthYear);
	}
	
	/**
	 * The classpath need to exists to some funcions on the api works 
	 * like {@link JsonDB#writeMock(Object)} and {@link JsonDB#readMock(String, Class)}
	 * if this test not pass, consider set a folder classpath or use read and mock methods of {@link JsonDB} that have {@link File}
	 * assignature
	 */
	@Test
	public void classhPathTest(){
		String classpath = System.getProperty("java.class.path");
		Assert.assertNotNull(classpath);
		Assert.assertFalse(classpath.trim().isEmpty());
	}
	
	@Test
	public void readAttachedMockTest() throws IOException{
		List<Parent> readedfamily = JsonDB.readMock(FAMILY_ATTACHED_FILE_NAME, new TypeToken<List<Parent>>(){}.getType());
		assertNotNull(readedfamily);
		Parent readFather = readedfamily.get(0);
		assertEquals(father.name, readFather.name);
		assertEquals(father.birthYear, readFather.birthYear);
		
		Parent readMother = readedfamily.get(1);
		assertEquals(mother.name, readMother.name);
		assertEquals(mother.birthYear, readMother.birthYear);
		
		Child readChild = readFather.childs.get(0);
		assertEquals(childBob.name, readChild.name);
		assertEquals(childBob.birthYear, readChild.birthYear);
		
	}
	
}
