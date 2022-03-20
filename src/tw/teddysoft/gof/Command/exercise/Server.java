package tw.teddysoft.gof.Command.exercise;

import java.util.ArrayList;
import java.util.List;

public class Server {
	private final List<Client<Command>> clients = new ArrayList<>();

	public void monitor(){
		clients.forEach(client -> {
			Result result = client.getCheckCommand().execute();
			if (!Status.OK.equals(result.getStatus())) {
				sendAlert(result.getMessage());
			}
		});
	}

	public void sendAlert(String msg){
		System.out.println("發現問題並通知保全人員: " + msg);
	}

	public void addClient(Client<Command> client) {
		clients.add(client);
	}

	public void removeClient(Client<Command> client) {
		clients.remove(client);
	}
}



