/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Observer.exercise; 

public class DoorCommand implements Command {
	private Door _door = null;
	
	public DoorCommand(String ipAddress){
		_door = new Door(ipAddress);
	}
	public DoorCommand(Door door){
		_door = door;
	}
	@Override
	public Result execute() {
		Result result = new Result(Status.OK);
		if ("open".equals(_door.getDoorStatus())){
			result.setStatus(Status.CRITICAL);
			result.setMessage("門被開啟:" + toString());
		}
		return result;
	}
}
