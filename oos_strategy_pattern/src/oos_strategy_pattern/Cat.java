package oos_strategy_pattern;

public class Cat extends Animal{
	
	public Cat() {
		super();
		setSound("meow");
		flyingType = new CantFlyConcreteStrategy();
	}
}
