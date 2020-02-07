package oos_observer_pattern;

/*
 * this class has nothing to do with the pattern itself. it's just for testing it out.
 */
public class TestDesignPattern {
	
	//test our code
	public static void main(String[] args) {
		//create our GoldPrice subject
		GoldPriceConcreteSubject gpS1 = new GoldPriceConcreteSubject();
		
		//create observers that want to monitor the current gold price
		GoldPriceObserverConcreteObserver gpObs1 = new GoldPriceObserverConcreteObserver();
		GoldPriceObserverConcreteObserver gpObs2 = new GoldPriceObserverConcreteObserver();
		GoldPriceObserverConcreteObserver gpObs3 = new GoldPriceObserverConcreteObserver();
		GoldPriceObserverConcreteObserver gpObs4 = new GoldPriceObserverConcreteObserver();
		
		//make all observers listen to gold price
		gpS1.attach(gpObs1);
		gpS1.attach(gpObs2);
		gpS1.attach(gpObs3);
		gpS1.attach(gpObs4);
		
		//set price and description value
		gpS1.setPrice(9.39);
		gpS1.setDescription("Goldpreis bleibt Konstant");
		
		//stop listening for observer 3 and 4
		gpS1.detach(gpObs3);
		gpS1.detach(gpObs4);
		
		//update price and description again
		gpS1.setPrice(5.49);
		gpS1.setDescription("disgusting value, don't sell now!");
		
		//notice how obs 3 and 3 have not changed :]
	}
	
}
