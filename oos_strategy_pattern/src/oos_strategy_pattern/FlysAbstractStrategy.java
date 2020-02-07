package oos_strategy_pattern;

/*
 * create interface for action
 */
public interface FlysAbstractStrategy {
	String fly();
}

/*
 * create one variant of solving the action
 */
class ItFlysConcreteStrategy implements FlysAbstractStrategy {

	@Override
	public String fly() {
		return "flying high";
	}
	
}

/*
 * create another variant of solving the action
 */
class CantFlyConcreteStrategy implements FlysAbstractStrategy {

	@Override
	public String fly() {
		return "I can't fly";
	}
	
	/*
	 * create tons of other possible variants of solving the action
	 */
	
}