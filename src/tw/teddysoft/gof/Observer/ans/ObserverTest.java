/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Observer.ans;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

public class ObserverTest {
	class MockRemoteDoor extends Door {
		private String status = null;
		public MockRemoteDoor(String ipAddress) {
			super(ipAddress);
		}
		public MockRemoteDoor(String ipAddress, String status) {
			super(ipAddress);
			this.status = status;
		}
		@Override
		public String getDoorStatus(){
			return status;
		}
	}
	public class MockChangeLogger implements Observer {
		public int notifiedCount = 0;
		@Override
		public void update(Subject subject) {
				notifiedCount++;
		}
	}

	@Test
	public void subject_status_change_will_notify_observers() {
		Client client = new Client(new DoorCommand(""));
		MockChangeLogger logger1 = new MockChangeLogger();
		MockChangeLogger logger2 = new MockChangeLogger();
		MockChangeLogger logger3 = new MockChangeLogger();
		client.addObserver(logger1);
		client.addObserver(logger2);
		client.addObserver(logger3);
		
		client.setResult(new Result(Status.CRITICAL));
		assertEquals(1, logger1.notifiedCount);
		assertEquals(1, logger2.notifiedCount);
		assertEquals(1, logger3.notifiedCount);
		
		client.setResult(new Result(Status.WARRING));
		assertEquals(2, logger1.notifiedCount);
		assertEquals(2, logger2.notifiedCount);
		assertEquals(2, logger3.notifiedCount);
	}
	
	@Test
	public void integration_test_door_open_will_notify_real_observers() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		Door door = new MockRemoteDoor("192.168.0.1", "open");
		Client client = new Client(new DoorCommand(door));
		SendingAlertObserver alert = new SendingAlertObserver();
		WritingLogObserver log = new WritingLogObserver();
		client.addObserver(alert);
		client.addObserver(log);
		Server server = new Server();
		server.addClient(client);
		server.monitor();
		String expected = "發現問題並通知保全人員: 門被開啟\n"
										+ "寫資料到資料庫: 門被開啟";
		assertTrue(stream.toString().startsWith(expected));
	}
	
	@Test
	public void integration_test_door_not_open_will_not_notify_observers() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		Door door = new MockRemoteDoor("192.168.0.1", "not open");
		Client client = new Client(new DoorCommand(door));
		SendingAlertObserver alert = new SendingAlertObserver();
		WritingLogObserver log = new WritingLogObserver();
		client.addObserver(alert);
		client.addObserver(log);
		Server server = new Server();
		server.addClient(client);
		server.monitor();
		assertEquals("",stream.toString());
	}
}



