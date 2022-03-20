/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.AbstractFactory.ans;

public class LinuxFactory extends AbstractFactory {
	@Override
	public Drive createDrive(String type, int index) {
		SimpleDriveFactory driveFactory = new SimpleDriveFactory();
		return driveFactory.createLinuxDrive(type, index);
	}
	@Override
	public Process createProcess(int id) {
		return new LinuxProcess(id);
	}
	@Override
	public IOPort createIOPort(int address) {
		return new LinuxIOPort(address);
	}
	@Override
	public Monitor createMonitor(int id) {
		return new LinuxMonitor(id);
	}
}
