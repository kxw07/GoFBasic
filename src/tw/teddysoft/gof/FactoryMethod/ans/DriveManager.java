/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.FactoryMethod.ans;

public abstract class DriveManager {
	public Drive getDrive(String type, int index){
		Drive drive = createDrive(type, index);
		drive.updateFreeSpace();
		drive.doQuickSMARTCheck();
		return drive;
	}
	abstract protected Drive createDrive(String type, int index);
}
