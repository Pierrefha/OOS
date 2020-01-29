package oos_template_method_pattern;

public class TestDesignPattern {

	public static void main(String args[]) {
		/*
		 * make me a vegan and a chickenteriyaki sandwich please
		 */
		SubwaySandwichAbstractClass chickenSW = new ChickenTeriyakiSandwichConcreteClass();
		SubwaySandwichAbstractClass veganSW = new VeganBangerSandwichConcreteClass();
		
		/*
		 * please make chicken sandwich
		 */
		chickenSW.makeSandwhich();
		
		/*
		 * please make me a vegan sandwich
		 */
		veganSW.makeSandwhich();
	}
}
