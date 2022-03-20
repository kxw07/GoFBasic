/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.FactoryMethod.ans;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GenericDriveManagerTest {
	private GenericDriveManager gdm;
	@Before
	public void setup() {
		gdm = new GenericDriveManager();
	}
	@Test
	public void createWinUSBDrive(){
		Drive drive = gdm.getDrive(WinUSBDrive.class, 0);
		assertEquals(WinUSBDrive.class, drive.getClass());
	}
	@Test
	public void createWinSATADrive(){
		Drive drive = gdm.getDrive(WinSATADrive.class, 0);
		assertEquals(WinSATADrive.class, drive.getClass());
	}
	@Test
	public void createLinuxUSBDrive(){
		Drive drive = gdm.getDrive(LinuxUSBDrive.class, 0);
		assertEquals(LinuxUSBDrive.class, drive.getClass());
	}
	@Test
	public void createLinuxSATADrive(){
		Drive drive = gdm.getDrive(LinuxSATADrive.class, 0);
		assertEquals(LinuxSATADrive.class, drive.getClass());
	}
}
