/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Adapter.ans;

public class Host extends ConfigObject {
	private String ip;

	public Host() {
	}

	public void  setIPAddress(String ip){
		this.ip = ip;
	}

	public String getIPAddress(){
		return ip;
	}
}
