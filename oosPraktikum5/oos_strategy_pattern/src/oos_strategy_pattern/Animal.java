package oos_strategy_pattern;

public class Animal {
	String sound;
	double speed;
	public FlysAbstractStrategy flyingType;
	
	public void setSound(String sound) {
		this.sound=sound;
	}
	public String getSound() {
		return this.sound;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getSpeed() {
		return this.speed;
	}
	/*
	 * use compositioned class to execute abstract strategy
	 */
	public String tryToFly() {
		return flyingType.fly();
	}
	/*
	 * set behaviour of abstractStrategy by specifying concreteStrategy
	 */
	public void setFlyingAbility(FlysAbstractStrategy flyingType) {
		this.flyingType=flyingType;
	}
}
