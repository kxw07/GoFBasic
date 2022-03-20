package tw.teddysoft.gof.Observer.exercise.observer;

import tw.teddysoft.gof.Observer.exercise.Client;
import tw.teddysoft.gof.Observer.exercise.Status;

public class SendingAlertObserver implements Observer {

    @Override
    public void update(Subject subject) {
        Client client = (Client) subject;

        if (Status.OK != client.getResult().getStatus()) {
            System.out.println("發現問題並通知保全人員: " + client.getResult().getMessage().toString());
        }
    }
}
