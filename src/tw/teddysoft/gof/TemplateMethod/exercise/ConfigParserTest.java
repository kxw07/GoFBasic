/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.TemplateMethod.exercise;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConfigParserTest {
	private ByteArrayOutputStream stream = null;
	private PrintStream printStream = null;
	@Before
	public void setUp() {
		stream = new ByteArrayOutputStream();
		printStream = new PrintStream(stream);
		System.setOut(printStream);
	}
	@After
	public void tearDown() throws IOException {
		if (null != printStream)
			printStream.close();
		if (null != stream)
			stream.close();
	}
	@Test
	public void testFileConfigParser(){
		ConfigParser fileParser = new 
				FileConfigParser("C:\\config.ini");
		PersonData fpd = fileParser.doParse();
		assertEquals("Teddy", fpd.getName());
		assertEquals(100, fpd.getHP());
		String expected = "Read config data from file: C:\\config.ini parseToken... validate config data built from file...\n";
		assertEquals(expected, stream.toString());
	}

	@Test
	public void testDBConfigParser(){
		ConfigParser dbParser = new 
				DbConfigParser("http://127.0.0.1/hsql/mydb");
		PersonData dbpd = dbParser.doParse();
		assertEquals("Kay", dbpd.getName());
		assertEquals(100, dbpd.getHP());
		String expected = "Read config data from database: http://127.0.0.1/hsql/mydb parseToken... validate config data built from database...\n";
		assertEquals(expected, stream.toString());
	}
}
