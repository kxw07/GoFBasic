package tw.teddysoft.gof.Observer.exercise;

import tw.teddysoft.gof.Observer.exercise.command.Command;
import tw.teddysoft.gof.Observer.exercise.observer.Observer;
import tw.teddysoft.gof.Observer.exercise.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class Client implements Subject {
	private Command checkCommand;
	private Result result = new Result(Status.PENDING);
	private final List<Observer> observers = new ArrayList<>();

	public Client(Command command) {
		this.checkCommand = command;
	}

	public void setResult(Result result) {
		this.result = result;
		notifyObserver();
	}

	public Result getResult() {
		return result;
	}

	public void setCheckCommand(Command command) {
		this.checkCommand = command;
	}

	public Command getCheckCommand() {
		return checkCommand;
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObserver() {
		observers.forEach(observer -> observer.update(this));
	}
}
