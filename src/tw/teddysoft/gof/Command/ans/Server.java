/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Command.ans;

import java.util.ArrayList;
import java.util.List;

public class Server {
	private List<Client> clients = new ArrayList<>();	
	public void monitor(){
		for(Client client : clients){
			client.setResult(client.getCheckCommand().execute());
			if (Status.OK != client.getResult().getStatus()) {
				sendAlert(client.getResult().getMessage());
			}
		}
	}
	public void sendAlert(String msg){
		System.out.println("發現問題並通知保全人員: " + msg);
	}
	public void addClient(Client client){
		clients.add(client);
	}
	public void removeClient(Client client){
		clients.remove(client);
	}
}




