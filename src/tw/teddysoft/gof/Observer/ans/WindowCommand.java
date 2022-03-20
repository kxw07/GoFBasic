/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Observer.ans;

public class WindowCommand implements Command {
	private Window window = null;
	
	public WindowCommand(String ipAddress){
		window = new Window(ipAddress);
	}
	@Override
	public Result execute() {
		Result result =new Result(Status.OK);
		StringBuilder sb = new StringBuilder();
		if (window.isBroken()){
			result.setStatus(Status.CRITICAL);
			sb.append("窗戶被打破");
		}
		if (window.isOpen()){
			result.setStatus(Status.CRITICAL);
			if (sb.length() > 0)
				sb.append(", ");
			sb.append("窗戶被打開");
		}
		result.setMessage(sb.toString());
		return result;
	}
}


