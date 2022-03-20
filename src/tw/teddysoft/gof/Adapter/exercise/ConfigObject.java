/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Adapter.exercise;

public class ConfigObject {
	String getKey(){
		return this.getClass().toString() + "." + this.toString();
	}
}
