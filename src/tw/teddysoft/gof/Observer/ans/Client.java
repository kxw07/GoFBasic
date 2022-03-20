package tw.teddysoft.gof.Observer.ans;

import java.util.ArrayList;
import java.util.List;

public class Client implements Subject {
	private Command checkCommand;
	private Result result = new Result(Status.PENDING);
	private List<Observer> observers = new ArrayList<>();
	
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	@Override
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}
	@Override
	public void notifyObserver() {
		for(Observer observer : observers){
			if (null != observer)
				observer.update(this);
		}
	}
	public void setResult(Result result) {
		this.result = result;
		notifyObserver();
	}

	
	public Result getResult() {
		return result;
	}
	public Client(Command command) {
		this.checkCommand = command;
	}

	public void setCheckCommand(Command command) {
		this.checkCommand = command;
	}
	public Command getCheckCommand() {
		return checkCommand;
	}
}
