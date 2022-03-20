/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.SimpleFactory.ans;

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
	public <T extends Drive> Drive createDrive(Class<T> type, int index)  {
		try {
			return type.getConstructor(int.class).newInstance(index);
		} catch (Exception e) {
			throw new RuntimeException("Cannot create drive.", e);
		}
	}	
}

