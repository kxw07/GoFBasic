/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Singleton.standard.ans;

public class AppConfig {
	private static AppConfig instance = null;
	private int timeout = 0;
	private int port = 0;
	private String workingDir = "";
	
	private AppConfig(){}
	
	public static synchronized AppConfig getInstance(){
		if (null == instance) {
			instance = new AppConfig();
		}
		return instance;
	}
	
	
	
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getWorkingDir() {
		return workingDir;
	}
	public void setWorkingDir(String workingDir) {
		this.workingDir = workingDir;
	}
}
