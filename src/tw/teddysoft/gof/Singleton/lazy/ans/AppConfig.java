/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Singleton.lazy.ans;

public class AppConfig {
	private static class Lazy {
        static final AppConfig instance = new AppConfig();
    }
	private AppConfig(){}
	public static AppConfig getInstance(){
		return Lazy.instance;
	}

	
	private int timeout = 0;
	private int port = 0;
	private String workingDir = "";
	
	
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
