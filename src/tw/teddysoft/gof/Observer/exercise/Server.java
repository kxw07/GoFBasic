/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Observer.exercise;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Server {
	private List<Client> clients = new ArrayList<>();
	
	public void monitor(){
		for(Client client : clients){
			client.setResult(client.getCheckCommand().execute());
			if (Status.OK != client.getResult().getStatus()) {
				sendAlert(client.getResult().getMessage());
				writeLog(client.getResult().getMessage(), new Date());
			}
		}
	}
	public void sendAlert(String msg){
		System.out.println("發現問題並通知保全人員: " + msg);
	}
	public void writeLog(String msg, Date date){
		System.out.println("寫資料到資料庫: " + 
						msg + " 在: " + date.toString());
	}
	public void addClient(Client client){
		clients.add(client);
	}
	public void removeClient(Client client){
		clients.remove(client);
	}
}




