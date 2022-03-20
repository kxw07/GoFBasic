/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Command.ans;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DoorCommandTest {
	
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

	@Test
	public void testCommand_DoorOpen() {
		Door door = new MockRemoteDoor("192.168.0.1", "open");
		Command doorCmd = new DoorCommand(door);
		Result result = doorCmd.execute();
		assertEquals(Status.CRITICAL, result.getStatus());
		assertTrue(result.getMessage().startsWith("門被開啟"));
	}
	
	@Test
	public void testCommand_DoorClosed() {
		Door door = new MockRemoteDoor("192.168.0.1", "not open");
		Command doorCmd = new DoorCommand(door);
		Result result = doorCmd.execute();
		assertEquals(Status.OK, result.getStatus());
		assertTrue(result.getMessage().isEmpty());
	}

	@Test
	public void testLambdaCommand_DoorClosed() {
		Command doorCmd = () -> {
			Result result = new Result(Status.OK);
			result.setStatus(Status.OK);
			return result;
		};
		Result result = doorCmd.execute();
		assertEquals(Status.OK, result.getStatus());
		assertTrue(result.getMessage().isEmpty());
	}

	
	@Test
	public void testServer() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		
		Server server = new Server();
		Door door = new MockRemoteDoor("192.168.0.1", "open");
		Client client = new Client(new DoorCommand(door));
		server.addClient(client);
		server.monitor();
		
		assertEquals("發現問題並通知保全人員: 門被開啟\n", stream.toString());
	}
}



