package oos_template_method_pattern;

/*
 * really awesome cause im vegan sandwich 
 */
public class VeganBangerSandwichConcreteClass extends SubwaySandwichAbstractClass {
	
	String meatUsed[] = {"sweetLittleYellowChickensTurnRed"};
	String cheeseUsed[] = {"cheddar","gouda","emmentaler"};
	String veggiesUsed[] = {"jalapenos","green pepper","ruccola","olives","falafel","apple"};
	/*
	 * override our hooks because vegan won't get meat and cheese
	 */
	@Override
	boolean customerWantsCheese() {
		return false;
	}
	
	@Override
	boolean customerWantsMeat() {
		return false;
	}
	
	/*
	 * override our forced abstract methods with the ingredients of our 
	 * tasty sandwich
	 */
	
	@Override
	void addMeat() {
	}

	@Override
	void addCheese() {
	}

	@Override
	void addVegetables() {
		String out="";
		for(String item : veggiesUsed) {
			out+=item+" ";
		}
		System.out.println("Added: "+out.substring(0,out.length()-1));
	}
}
