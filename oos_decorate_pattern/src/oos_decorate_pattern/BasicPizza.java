package oos_decorate_pattern;

/*
 * Concrete Component that will be the base of every order we sell for SURE.
 */
public class BasicPizza implements Pizza{

	BasicPizza(){
		System.out.println("create basic dough for pizza margarita");
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "basic pizza";
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 5.00;
	}

}
