/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.FactoryMethod.ans;

public class GenericDriveManager {
	public <T extends Drive> Drive getDrive(Class<T> type, int index){
		Drive drive;
		try {
			drive =  type.getConstructor(int.class).newInstance(index);
			drive.updateFreeSpace();
			drive.doQuickSMARTCheck();
		} catch (Exception e) {
			throw new RuntimeException("Cannot create drive.", e);
		}
		return drive;
	}
}
