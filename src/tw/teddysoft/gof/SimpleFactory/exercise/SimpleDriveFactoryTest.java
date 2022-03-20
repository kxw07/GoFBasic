/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.SimpleFactory.exercise;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleDriveFactoryTest {

	@Test
	public void create_SATADrive_via_SimpleDriveFactory() {
		assertEquals(SATADrive.class, new SimpleDriveFactory().createDrive("SATA", 0).getClass());
	}

	@Test
	public void create_USBDrive_via_SimpleDriveFactory() {
		assertEquals(USBDrive.class, new SimpleDriveFactory().createDrive("USB", 0).getClass());
	}
	
	@Test
	public void create_unsported_drive_SASDrive_via_SimpleDriveFactory_will_thorw_a_runtime_exception() {
		
		try{
			new SimpleDriveFactory().createDrive("SAS", 0);
			fail();
		}
		catch(RuntimeException e){
			assertEquals("Unsupported drive type: SAS", e.getMessage());
		}
	}
}
