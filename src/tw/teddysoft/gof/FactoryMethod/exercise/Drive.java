/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.FactoryMethod.exercise;

abstract class Drive {

	private final int index;

	Drive(int index) {
		this.index = index;
	}

	protected void updateFreeSpace() {
		System.out.println("updateFreeSpace");
	}

	protected void doQuickSMARTCheck() {
		System.out.println("doQuickSMARTCheck");
	}
}
