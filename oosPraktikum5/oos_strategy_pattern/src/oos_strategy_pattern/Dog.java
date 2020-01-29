package oos_strategy_pattern;

public class Dog extends Animal{
	
	public Dog() {
		super();
		setSound("Bark");
		flyingType = new CantFlyConcreteStrategy();
	}
}
