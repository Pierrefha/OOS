package oos_decorate_pattern;

public abstract class PizzaToppingsDecorator implements Pizza{
	
	Pizza aktuellePizza;
	
	//Im Konstruktor wird Referenz auf Pizza übergeben
	public PizzaToppingsDecorator(Pizza aktuellePizza) {
		this.aktuellePizza = aktuellePizza;
	}
	
	//Übergebe immer Methoden des ConcreteComponents
	@Override
	public String getDescription() {
		return aktuellePizza.getDescription();
	}

	//übergebe immer Methoden des ConcreteComponents
	@Override
	public double getCost() {
		return aktuellePizza.getCost();
	}
	
}
