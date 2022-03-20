/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.SimpleFactory.exercise;

public class ConsoleDriveManager {
	Drive getDrive(String type, int index){
		Drive drive = null;
		switch(type){
			case "SATA":
				drive = new SATADrive(index);
				break;
			case "USB":
				drive = new USBDrive(index);
				break;
			default:
				throw new RuntimeException
				("Unsupported drive type: " + type);
		}
		drive.updateFreeSpace();
		drive.doQuickSMARTCheck();
		return drive;
	}
}
