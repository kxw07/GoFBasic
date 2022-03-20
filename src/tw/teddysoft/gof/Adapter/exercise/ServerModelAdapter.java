/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Adapter.exercise;

import java.util.LinkedList;
import java.util.List;

public class ServerModelAdapter {
	private ConfigContext mContext = null;

	public ServerModelAdapter(ConfigContext aContext) {
		mContext = aContext;
	}
	public void addHost(Host aObj) {
		mContext.add(aObj);
	}

	public Host getHost(String key) {
		return (Host) mContext.get(key);
	}

	public List<Host> getHosts() {
		List<Host> result = new LinkedList<>();
		for (ConfigObject obj : mContext.getAllObjects()){
			if (obj instanceof Host)
				result.add((Host)obj);
		}
		return result;
	}
	
	public void addContact(Contact aObj) {
		mContext.add(aObj);
	}

	public Contact getContact(String key) {
		return (Contact) mContext.get(key);
	}

	public List<Contact> getContacts() {
		List<Contact> result = new LinkedList<>();
		for (ConfigObject obj : mContext.getAllObjects()){
			if (obj instanceof Contact)
				result.add((Contact)obj);
		}
		return result;
	}
	
	//... other methods
}
