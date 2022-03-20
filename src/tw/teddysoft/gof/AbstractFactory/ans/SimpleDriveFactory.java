/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.AbstractFactory.ans;

public class SimpleDriveFactory {
	public  Drive createWindowsDrive(String type, int index){
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
	public  Drive createLinuxDrive(String type, int index){
		Drive drive = null;
		switch(type){
			case "SATA":
				drive = new LinuxSATADrive(index);
				break;
			case "USB":
				drive = new LinuxUSBDrive(index);
				break;
			default:
				throw new RuntimeException
				("Unsupported drive type: " + type);
		}
		return drive;
	}
}

