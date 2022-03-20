/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Composite.exercise;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BeforeApplyingCompositeTest {
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
	public void testFiringClip() {
		Clip rootClip = new Clip();
		Clip childClip = new Clip();
		childClip.addBullet(new TraceBullet());
		childClip.addBullet(new LineBullet());
		childClip.addBullet(new TraceBullet());
		rootClip.addClip(childClip);
		rootClip.fire();
		String expected = "發射追蹤子彈.\n"
					+ "發射直線子彈.\n"
					+ "發射追蹤子彈.\n";
		assertEquals(expected, 
				stream.toString());
	}
	@Test
	public void testFiringBullet() {
		new LineBullet().fire();
		new TraceBullet().fire();
		new LineBullet().fire();
		String expected = "發射直線子彈.\n"
				+ "發射追蹤子彈.\n"
				+ "發射直線子彈.\n";
		assertEquals(expected, 
		stream.toString());
	}
	
	@Test
	public void testFiringClipWithBullet() {
		Clip rootClip = new Clip();
		Clip childClip = new Clip();
		childClip.addBullet(new TraceBullet());
		childClip.addBullet(new TraceBullet());
		childClip.addBullet(new TraceBullet());
		rootClip.addBullet(new LineBullet());
		rootClip.addClip(childClip);
		rootClip.addBullet(new LineBullet());
		rootClip.fire();
		String expected = "發射直線子彈.\n"
				+ "發射直線子彈.\n"
				+ "發射追蹤子彈.\n"
				+ "發射追蹤子彈.\n"
				+ "發射追蹤子彈.\n";
		assertEquals(expected, 
				stream.toString());
	}
}
