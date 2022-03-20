/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.State.exercise;

import static org.junit.Assert.*;
import org.junit.Test;

public class HostStateTransitionTest {
	class DownCommand implements Command{
		@Override
		public CheckResult execute() {
			return CheckResult.DOWN;
		}
	}
	class UpCommand implements Command{
		@Override
		public CheckResult execute() {
			return CheckResult.UP;
		}
	}
	@Test
	public void test_down_transition() {
		Host host = new Host(new DownCommand());
		assertEquals(HostState.UP_HARD, host.getState());
		host.check();
		assertEquals(HostState.DOWN_SOFT, host.getState());
		host.check();
		assertEquals(HostState.DOWN_SOFT, host.getState());		
		host.check();
		assertEquals(HostState.DOWN_HARD, host.getState());
		host.check();
		assertEquals(HostState.DOWN_HARD, host.getState());
		host.check();
		assertEquals(HostState.DOWN_HARD, host.getState());
		assertEquals(3, host.getAttempt());
		
		host.changeState(HostState.UP_SOFT);
		assertEquals(HostState.UP_SOFT, host.getState());
		host.check();
		assertEquals(HostState.DOWN_HARD, host.getState());
	}
	
	@Test
	public void test_up_transition() {
		Host host = new Host(new UpCommand());
		host.changeState(HostState.DOWN_HARD);
		assertEquals(HostState.DOWN_HARD, host.getState());
		host.check();
		assertEquals(HostState.UP_SOFT, host.getState());
		host.check();
		assertEquals(HostState.UP_SOFT, host.getState());		
		host.check();
		assertEquals(HostState.UP_HARD, host.getState());
		host.check();
		assertEquals(HostState.UP_HARD, host.getState());
		host.check();
		assertEquals(HostState.UP_HARD, host.getState());
		assertEquals(3, host.getAttempt());

		host.changeState(HostState.DOWN_SOFT);
		assertEquals(HostState.DOWN_SOFT, host.getState());
		host.check();
		assertEquals(HostState.UP_HARD, host.getState());
	}
}
