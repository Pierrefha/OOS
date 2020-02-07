package oos_decorate_pattern;

public class CheeseConcreteDecorator extends PizzaToppingsDecorator {

	public CheeseConcreteDecorator(Pizza aktuellePizza) {
		super(aktuellePizza);
		System.out.println("add cheeese :]");
	}
	
	//rufe aktuelle Pizzabeschreibung auf und fuege CheeseConcreteDecoratorBeschreibung hinzu
	public String getDescription() {
		return aktuellePizza.getDescription()+ "and some cheese";
	}
	
	//rufe aktuellen Pizzapreis auf und fuege CheeseConcreteDecoratorPreis hinzu
	public double getCost() {
		return aktuellePizza.getCost()+3.30;
	}
	
}
