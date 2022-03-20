/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.State.exercise;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HostFunctionTest {

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
	public void test_up_hard_state() {
		Host host = new Host(null);
		host.powerOn();
		assertEquals("Cannot power on under up hard state.", stream.toString().trim());
		stream.reset();
		
		host.powerOff();
		assertEquals("Power off gracefully.", stream.toString().trim());
		stream.reset();
		
		assertEquals("Diagnostic via the remote agent.", host.diagnostic());
	}
	
	@Test
	public void test_down_soft_state() {
		Host host = new Host(null);
		host.changeState(HostState.DOWN_SOFT);
		
		host.powerOn();
		assertEquals("Cannot power on under down soft state.", stream.toString().trim());
		stream.reset();
		
		host.powerOff();
		assertEquals("Cannot power off under down soft state.", stream.toString().trim());
		stream.reset();
		
		assertEquals("Diagnostic via IPMI.", host.diagnostic());
	}
	
	@Test
	public void test_down_hard_state() {
		Host host = new Host(null);
		host.changeState(HostState.DOWN_HARD);
		
		host.powerOn();
		assertEquals("Power On.", stream.toString().trim());
		stream.reset();
		
		host.powerOff();
		assertEquals("Cannot power off under down hard state.", stream.toString().trim());
		stream.reset();
		
		assertEquals("Diagnostic via IPMI.", host.diagnostic());
	}
	
	@Test
	public void test_up_soft_state() {
		Host host = new Host(null);
		host.changeState(HostState.UP_SOFT);
		
		host.powerOn();
		assertEquals("Cannot power on under up soft state.", stream.toString().trim());
		stream.reset();
		
		host.powerOff();
		assertEquals("Power off after 60 second(s).", stream.toString().trim());
		stream.reset();
		
		assertEquals("Diagnostic via the remote agent.", host.diagnostic());
	}
	
}
