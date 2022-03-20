/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Adapter.ans;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ServerModelAdapterTest {
	private ServerModelContext adapter;

	@Before
	public void setup(){
		adapter = new ServerModelAdapter(new ConfigContext());
	}
	@Test
	public void can_add_multiple_hosts(){
		adapter.addHost(new Host());
		adapter.addHost(new Host());
		adapter.addHost(new Host());
		assertEquals(3, adapter.getHosts().size());
	}
	@Test
	public void can_add_multiple_contracts(){
		adapter.addContact(new Contact());
		adapter.addContact(new Contact());
		adapter.addContact(new Contact());
		assertEquals(3, adapter.getContacts().size());
	}
}
