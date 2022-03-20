/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.AbstractFactory.ans;

public abstract class IOPort {
	private int _address;

	public IOPort(int address){
		_address = address;
	}
}
