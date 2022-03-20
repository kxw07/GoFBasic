/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Adapter.ans;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgentModelAdapterTest {
	private AgentModelContext adapter;

	@Before
	public void setup(){
		adapter = new AgentModelAdapter(new ConfigContext());
	}
	@Test
	public void can_add_multiple_acaptors(){
		adapter.addAcceport(new Acceptor());
		adapter.addAcceport(new Acceptor());
		adapter.addAcceport(new Acceptor());
		assertEquals(3,adapter.getAcceptors().size());
	}
	@Test
	public void can_set_an_agent(){
		Agent agent = new Agent();
		adapter.setAgent(agent);
		assertEquals(agent, adapter.getAgent());
	}
	@Test
	public void will_throw_an_exception_if_no_agent_was_set(){
		Agent agent = new Agent();
		try{
			assertEquals(agent, adapter.getAgent());
		}
		catch (RuntimeException e) {
			assertEquals("No Agent found.", e.getMessage());
		}
	}
}
