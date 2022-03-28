/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 *
 */
package tw.teddysoft.gof.Adapter.exercise;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AgentModelAdapterTest {
    private AgentModelContext adapter;

    @Before
    public void setup() {
        adapter = new AgentModelAdapter(new ConfigContext());
    }

    @Test
    public void can_add_multiple_acceptors() {
        adapter.addAcceptor(new Acceptor());
        adapter.addAcceptor(new Acceptor());
        adapter.addAcceptor(new Acceptor());
        assertEquals(3, adapter.getAcceptors().size());
    }

    @Test
    public void can_set_an_agent() {
        Agent agent = new Agent();
        adapter.setAgent(agent);
        assertEquals(agent, adapter.getAgent());
    }

    @Test
    public void invoke_getAgent_will_throw_an_exception_if_not_call_setAgent_first() {
        Agent agent = new Agent();
        try {
            assertEquals(agent, adapter.getAgent());
        } catch (RuntimeException e) {
            assertEquals("No Agent found.", e.getMessage());
        }
    }
}
