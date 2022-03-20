/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.ClassFactory.ans;

	public abstract class DriveManager {
		
		public static DriveManager newInstance() {
			if(Platform.isWindows())
				return new WinDriveManager();
			else if(Platform.isLinux())
				return new LinuxDriveManager();
			else 
				throw new RuntimeException("Unsupported platform.");
		}
		
		public Drive getDrive(String type, int index){
			Drive drive = createDrive(type, index);
			drive.updateFreeSpace();
			drive.doQuickSMARTCheck();
			return drive;
		}
		abstract protected Drive createDrive(String type, int index);
	}
