/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Adapter.ans;

import java.util.LinkedList;
import java.util.List;

public class ServerModelAdapter implements ServerModelContext {
	private ConfigContext context = null;

	public ServerModelAdapter(ConfigContext context) {
		this.context = context;
	}
	@Override
	public void addHost(Host host) {
		context.add(host);
	}
	@Override
	public Host getHost(String key) {
		return (Host) context.get(key);
	}
	@Override
	public List<Host> getHosts() {
		List<Host> result = new LinkedList<>();
		for (ConfigObject obj : context.getAllObjects()){
			if (obj instanceof Host)
				result.add((Host)obj);
		}
		return result;
	}
	@Override
	public void addContact(Contact contact) {
		context.add(contact);
	}
	@Override
	public Contact getContact(String key) {
		return (Contact) context.get(key);
	}
	@Override
	public List<Contact> getContacts() {
		List<Contact> result = new LinkedList<>();
		for (ConfigObject obj : context.getAllObjects()){
			if (obj instanceof Contact)
				result.add((Contact)obj);
		}
		return result;
	}
}
