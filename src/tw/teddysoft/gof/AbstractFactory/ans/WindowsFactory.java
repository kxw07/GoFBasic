/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.AbstractFactory.ans;

public class WindowsFactory extends AbstractFactory {
	@Override
	public Drive createDrive(String type, int index) {		
		SimpleDriveFactory driveFactory = new SimpleDriveFactory();
		return driveFactory.createWindowsDrive(type, index);
	}
	@Override
	public Process createProcess(int id) {
		return new WinProcess(id);
	}
	@Override
	public IOPort createIOPort(int address) {
		return new WinIOPort(address);
	}
	@Override
	public Monitor createMonitor(int id) {
		return new WinMonitor(id);
	}
}
