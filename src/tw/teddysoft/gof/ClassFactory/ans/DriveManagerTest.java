/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.ClassFactory.ans;

import static org.junit.Assert.*;
import org.junit.Test;

public class DriveManagerTest {
	@Test
	public void createLinuxUSBDrive(){
		DriveManager dm = DriveManager.newInstance();
		Drive drive = dm.getDrive("USB", 0);
		assertEquals(LinuxUSBDrive.class, drive.getClass());
	}
	@Test
	public void createLinuxSATADrive(){
		DriveManager dm =  DriveManager.newInstance();
		Drive drive = dm.getDrive("SATA", 0);
		assertEquals(LinuxSATADrive.class, drive.getClass());
	}
	@Test
	public void createUnsupportedWinSASDrive(){
		DriveManager dm =  DriveManager.newInstance();
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
