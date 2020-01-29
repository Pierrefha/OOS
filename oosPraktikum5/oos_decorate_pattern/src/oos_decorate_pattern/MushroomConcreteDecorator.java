package oos_decorate_pattern;

public class MushroomConcreteDecorator extends PizzaToppingsDecorator {

	public MushroomConcreteDecorator(Pizza aktuellePizza) {
		super(aktuellePizza);
		System.out.println("add some juicy mushrooms");
	}
	
	//rufe aktuelle Pizzabeschreibung auf und fuege CheeseConcreteDecoratorBeschreibung hinzu
	public String getDescription() {
		return aktuellePizza.getDescription()+ "and some mushrooms";
	}
	
	//rufe aktuellen Pizzapreis auf und fuege CheeseConcreteDecoratorPreis hinzu
	public double getCost() {
		return aktuellePizza.getCost()+0.90;
	}
}
