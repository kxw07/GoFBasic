/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.AbstractFactory.ans;

public abstract class AbstractFactory {
	public abstract Drive createDrive(String type, int index);
	public abstract Process createProcess(int id);
	public abstract IOPort createIOPort(int address);
	public abstract Monitor createMonitor(int id);
	// more creational methods....
}
