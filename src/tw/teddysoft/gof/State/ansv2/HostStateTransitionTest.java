/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.State.ansv2;

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
		assertEquals(Host.UP_HARD, host.getState());
		host.check();
		assertEquals(Host.DOWN_SOFT, host.getState());
		host.check();
		assertEquals(Host.DOWN_SOFT, host.getState());		
		host.check();
		assertEquals(Host.DOWN_HARD, host.getState());
		host.check();
		assertEquals(Host.DOWN_HARD, host.getState());
		host.check();
		assertEquals(Host.DOWN_HARD, host.getState());
		assertEquals(3, host.getAttempt());
		
		host.changeState(Host.UP_SOFT);
		assertEquals(Host.UP_SOFT, host.getState());
		host.check();
		assertEquals(Host.DOWN_HARD, host.getState());
	}
	@Test
	public void test_up_transition() {
		Host host = new Host(new UpCommand());
		host.changeState(Host.DOWN_HARD);
		assertEquals(Host.DOWN_HARD, host.getState());
		host.check();
		assertEquals(Host.UP_SOFT, host.getState());
		host.check();
		assertEquals(Host.UP_SOFT, host.getState());		
		host.check();
		assertEquals(Host.UP_HARD, host.getState());
		host.check();
		assertEquals(Host.UP_HARD, host.getState());
		host.check();
		assertEquals(Host.UP_HARD, host.getState());
		assertEquals(3, host.getAttempt());

		host.changeState(Host.DOWN_SOFT);
		assertEquals(Host.DOWN_SOFT, host.getState());
		host.check();
		assertEquals(Host.UP_HARD, host.getState());
	}
}
