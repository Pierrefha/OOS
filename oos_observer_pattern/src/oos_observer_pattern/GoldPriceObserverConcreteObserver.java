package oos_observer_pattern;

public class GoldPriceObserverConcreteObserver implements Observer {

	//keep count of total active observers
	  static int nächsteNummer = 1;
	  //number of current observer
	  int nummer;
	  GoldPriceObserverConcreteObserver() {
	  	this.nummer = nächsteNummer++;
	  	System.out.println("Observer number: "+this.nummer+" was created!");
	  }
	  //update observer, print it's number and the subjects current values
		public void update(Subject subject) {
			System.out.println("ObserverNr. " + this.nummer + 
					" Current gold price:  " + ((GoldPriceConcreteSubject) subject).getPrice()+
					" Current state description: " + ((GoldPriceConcreteSubject) subject).getDescription());
	}
}
