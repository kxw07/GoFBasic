/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.FactoryMethod.exercise;

import static org.junit.Assert.*;
import org.junit.Test;

public class WinDriveManagerTest {
	@Test
	public void createWinUSBDrive(){
		DriveManager dm = new WinDriveManager();
		Drive drive = dm.getDrive("USB", 0);
		assertEquals(WinUSBDrive.class, drive.getClass());
	}
	@Test
	public void createWinSATADrive(){
		DriveManager dm = new WinDriveManager();
		Drive drive = dm.getDrive("SATA", 0);
		assertEquals(WinSATADrive.class, drive.getClass());
	}
	@Test
	public void createUnsupportedWinSASDrive(){
		DriveManager dm = new WinDriveManager();
		try{
			Drive drive = dm.getDrive("SAS", 0);
			fail("Infeasible path.");
		}
		catch(RuntimeException e){
			assertTrue("Unsupported drive type 'SAS'"
					+ " throws a RuntimeException", true);
		}
	}
}
