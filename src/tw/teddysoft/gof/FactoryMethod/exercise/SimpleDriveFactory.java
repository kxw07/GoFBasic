/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.FactoryMethod.exercise;

public class SimpleDriveFactory {
	public  Drive createDrive(String type, int index){
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
		return drive;
	}
}