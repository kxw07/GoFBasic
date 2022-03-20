/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.FactoryMethod.ans;

	public class WinDriveManager extends DriveManager {
		@Override
		protected Drive createDrive(String type, int index){
			Drive drive = null;
			switch(type){
				case "SATA":
					drive = new WinSATADrive(index);
					break;
				case "USB":
					drive = new WinUSBDrive(index);
					break;
				default:
					throw new RuntimeException
					("Unsupported drive type: " + type);
			}
			return drive;
		}
	}
