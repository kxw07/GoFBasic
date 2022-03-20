/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.SimpleFactory.ans;

	public class DriveManager {
		private SimpleDriveFactory factory;
		public DriveManager(SimpleDriveFactory factory) {
			this.factory = factory;
		}
		public Drive getDrive(String type, int index){
			Drive drive = factory.createDrive(type, index);
			drive.updateFreeSpace();
			drive.doQuickSMARTCheck();
			return drive;
		}
	}
