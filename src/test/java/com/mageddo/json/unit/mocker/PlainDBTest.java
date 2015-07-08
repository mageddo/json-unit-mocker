package com.mageddo.json.unit.mocker;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

public class PlainDBTest {
	
	private static final String FAMILY_MOCK = "theAttachedFamilies/happyFamily.json";
	private static final String PLAIN_LIST_ITEMS_MOCK = "general/listItems.plain";
	private static final String DEFAULT_LISTS_ITEMS = "Grape\nOrange\nMango";

	@Test
	public void readAsStringTest() throws IOException {
		final String family = PlainDB.readAsString(FAMILY_MOCK);
		Assert.assertTrue(family.indexOf("Bob") > 0);
	}
	
	@Test
	public void readAsFileTest(){
		PlainDB.readAsFile(FAMILY_MOCK);
	}
	
	@Test
	public void readAsInputStreamTest() throws FileNotFoundException {
		PlainDB.readAsInputStream(FAMILY_MOCK);
	}
	
	@Test
	public void readAsOuputStreamAppendTest() throws IOException {
		
		// creating the file
		writeFileTest();
		
		OutputStream out = PlainDB.readAsOuputStream(PLAIN_LIST_ITEMS_MOCK, true);
		out.close();
		
		Assert.assertEquals(
			DEFAULT_LISTS_ITEMS,
			PlainDB.readAsString(PLAIN_LIST_ITEMS_MOCK)
		);
	}
	
	@Test
	public void readAsOuputStreamTest() throws IOException {
		
		// creating the file
		writeFileTest();
		
		OutputStream out = PlainDB.readAsOuputStream(PLAIN_LIST_ITEMS_MOCK);
		out.close();
		
		Assert.assertEquals(
			"",
			PlainDB.readAsString(PLAIN_LIST_ITEMS_MOCK)
		);
	}
	
	@Test
	public void writeFileTest() throws IOException {
		PlainDB.write(PLAIN_LIST_ITEMS_MOCK, DEFAULT_LISTS_ITEMS);
		Assert.assertEquals(
			DEFAULT_LISTS_ITEMS,
			PlainDB.readAsString(PLAIN_LIST_ITEMS_MOCK)
		);
	}
	
	@Test
	public void writeOutputStreamTest() throws IOException {
			InputStream	inListItems =	IOUtils.toInputStream(DEFAULT_LISTS_ITEMS);
			PlainDB.write(PLAIN_LIST_ITEMS_MOCK, inListItems);
			Assert.assertEquals(
				DEFAULT_LISTS_ITEMS,
				PlainDB.readAsString(PLAIN_LIST_ITEMS_MOCK)
			);
	}
	
}
