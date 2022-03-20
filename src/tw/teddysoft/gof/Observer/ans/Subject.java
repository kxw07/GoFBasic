/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Observer.ans;

public interface Subject {
	void addObserver(Observer observer); 
	void deleteObserver(Observer observer);
	void notifyObserver();
}
