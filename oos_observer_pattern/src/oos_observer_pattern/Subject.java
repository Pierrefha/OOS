package oos_observer_pattern;

	import java.util.ArrayList;

	public class Subject {
		//contain list of all observers
	  ArrayList<Observer> observers = new ArrayList<Observer>();
	  
	  //add observer to list of observers
	  void attach(Observer observer) {
	  	this.observers.add(observer);
	  }
	  //remove observer from list of observers
	  void detach(Observer observer) {
	  	this.observers.remove(observer);
	  }
	  //update every observer on specific subject
	  void notify(Subject subject) {
	  	for (Observer elem : this.observers) {
				elem.update(subject);
			}
	  }
	}
