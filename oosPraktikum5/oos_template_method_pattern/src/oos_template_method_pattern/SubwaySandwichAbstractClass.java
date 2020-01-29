package oos_template_method_pattern;

/*
 * use template method to create all different kinds of subway sandwiches
 */
public abstract class SubwaySandwichAbstractClass {
	
	final void makeSandwhich() {
		
		cutBun();
		
		if(customerWantsMeat()) {
			addMeat();
		}
		
		if(customerWantsCheese()) {
			addCheese();
		}
		
		if(customerWantsVegetables()) {
			addVegetables();
		}
		
		heatAndServe();
	}
	
	//abstract when you want to force the concrete class to implement stuff
	abstract void addMeat();
	abstract void addCheese();
	abstract void addVegetables();

	public void cutBun() {
		System.out.println("Cut bread into two slices");
	}
	
	public void heatAndServe() {
		System.out.println("heat and serve sandwich");
	}

	
	//create method as a hook because most disgusting creatures want to eat meat
	//hook means that we set default settings but the user might implement his own, if he wishes to
	//also good example with default hotkeys and custom hotkeys!
	boolean customerWantsMeat() {return true;}
	boolean customerWantsCheese() {return true;}
	boolean customerWantsVegetables() {return true;}


}
