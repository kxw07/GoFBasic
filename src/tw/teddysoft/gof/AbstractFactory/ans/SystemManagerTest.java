/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.AbstractFactory.ans;

import static org.junit.Assert.*;
import org.junit.Test;

public class SystemManagerTest {
	@Test
	public void usingWindowsFactory(){
		SystemManager sm = new SystemManager(new WindowsFactory());
		assertEquals(WinUSBDrive.class, sm.getDrive("USB", 0).getClass());
		assertEquals(WinIOPort.class, sm.getIOPort(0x00ff).getClass());
		assertEquals(WinProcess.class, sm.getProcess(3388).getClass());
		assertEquals(WinMonitor.class, sm.getMonitor(1).getClass());
	}
	@Test
	public void usingLinuxFactory(){
		SystemManager sm = new SystemManager(new LinuxFactory());
		assertEquals(LinuxUSBDrive.class, sm.getDrive("USB", 0).getClass());
		assertEquals(LinuxIOPort.class, sm.getIOPort(0x00ff).getClass());
		assertEquals(LinuxProcess.class, sm.getProcess(3388).getClass());
		assertEquals(LinuxMonitor.class, sm.getMonitor(1).getClass());
	}
}
