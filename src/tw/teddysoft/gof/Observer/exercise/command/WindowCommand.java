/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Observer.exercise.command;

import tw.teddysoft.gof.Observer.exercise.Result;
import tw.teddysoft.gof.Observer.exercise.Status;
import tw.teddysoft.gof.Observer.exercise.sensor.Window;

public class WindowCommand implements Command {
	private Window window = null;
	
	public WindowCommand(String ipAddress){
		window = new Window(ipAddress);
	}
	@Override
	public Result execute() {
		Result result = new Result(Status.OK);
		String msg = null;
		if (window.isBroken()){
			result.setStatus(Status.CRITICAL);
			msg = "窗戶被打破 ";
		}
		if (window.isOpen()){
			result.setStatus(Status.CRITICAL);
			msg = "窗戶被打破 " + toString();
		}
		if (null != msg)
			result.setMessage(msg + " :" + toString());
		return result;
	}
}
