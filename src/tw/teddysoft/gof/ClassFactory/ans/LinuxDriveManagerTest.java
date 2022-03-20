/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.ClassFactory.ans;

import static org.junit.Assert.*;
import org.junit.Test;

public class LinuxDriveManagerTest {
	@Test
	public void createLinuxUSBDrive(){
		DriveManager dm = new LinuxDriveManager();
		Drive drive = dm.getDrive("USB", 0);
		assertEquals(LinuxUSBDrive.class, drive.getClass());
		assertNotEquals(WinSATADrive.class, drive.getClass());
		assertNotEquals(WinUSBDrive.class, drive.getClass());
		assertNotEquals(LinuxSATADrive.class, drive.getClass());
	}
	@Test
	public void createLinuxSATADrive(){
		DriveManager dm = new LinuxDriveManager();
		Drive drive = dm.getDrive("SATA", 0);
		assertEquals(LinuxSATADrive.class, drive.getClass());
		assertNotEquals(WinUSBDrive.class, drive.getClass());
		assertNotEquals(LinuxUSBDrive.class, drive.getClass());
		assertNotEquals(WinSATADrive.class, drive.getClass());
	}
	@Test
	public void createUnsupportedWinSASDrive(){
		DriveManager dm = new LinuxDriveManager();
		try{
			Drive drive = dm.getDrive("SAS", 0);
			fail("Infessible path.");
		}
		catch(RuntimeException e){
			assertTrue("Unsupported drive type 'SAS' "
					+ "throws a RuntimeException", true);
		}
	}
}
