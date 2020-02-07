package oos_decorate_pattern;

/*
 * class where we simulate ordering and creating the ordered pizza
 */
public class PizzaShop {
	
	public static void main(String args[]) {
		//order a basic pizza with cheese and mushrooms 
		//and print price aswell as description for it
		
		//Pizza basicPizza = new BasicPizza();
		//Pizza basicWithCheese = new CheeseConcreteDecorator(basicPizza);
		//Pizza basicWithCheeseAndMushrooms = new MushroomConcreteDecorator(basicWithCheese);
		
		//we can also write it like this
		Pizza orderedPizza = new CheeseConcreteDecorator(new MushroomConcreteDecorator(new BasicPizza()));
		
		System.out.println("Description of our pizza: "+orderedPizza.getDescription());
		System.out.println("Cost of our created pizza: "+orderedPizza.getCost());
		
		
	}
}
