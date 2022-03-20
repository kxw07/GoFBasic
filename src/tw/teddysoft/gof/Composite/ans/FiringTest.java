/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Composite.ans;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FiringTest {
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
		childClip.add(new TraceBullet());
		childClip.add(new LineBullet());
		childClip.add(new TraceBullet());
		rootClip.add(childClip);
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
		Weapon rootClip = new Clip();
		Weapon childClip = new Clip();
		childClip.add(new TraceBullet());
		childClip.add(new TraceBullet());
		childClip.add(new TraceBullet());
		rootClip.add(new LineBullet());
		rootClip.add(childClip);
		rootClip.add(new LineBullet());
		rootClip.fire();
		String expected = "發射直線子彈.\n"
				+ "發射追蹤子彈.\n"
				+ "發射追蹤子彈.\n"
				+ "發射追蹤子彈.\n"
				+ "發射直線子彈.\n";
		assertEquals(expected, 
				stream.toString());
	}
	
	@Test
	public void testShotgunBullet() {
		Weapon rootClip = new Clip();
		Weapon childClip = new Clip();
		childClip.add(new TraceBullet());
		childClip.add(new TraceBullet());
		childClip.add(new TraceBullet());
		rootClip.add(new LineBullet());
		rootClip.add(childClip);
		rootClip.add(new LineBullet());
		rootClip.add(new ShotgunBullet());
		rootClip.add(new ShotgunBullet());
		
		rootClip.fire();
		String expected = "發射直線子彈.\n"
				+ "發射追蹤子彈.\n"
				+ "發射追蹤子彈.\n"
				+ "發射追蹤子彈.\n"
				+ "發射直線子彈.\n"
				+ "發射散彈.\n"
				+ "發射散彈.\n";
		assertEquals(expected, 
				stream.toString());
	}
	
}
