/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Observer.exercise;

import java.util.ArrayList;
import java.util.List;

public class Server {
	private List<Client> clients = new ArrayList<>();
	
	public void monitor(){
		for(Client client : clients){
			client.setResult(client.getCheckCommand().execute());
		}
	}

	public void addClient(Client client){
		clients.add(client);
	}
	public void removeClient(Client client){
		clients.remove(client);
	}
}




