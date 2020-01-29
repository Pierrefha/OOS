package oos_observer_pattern;

/*
 * GoldPrice is a example ConcreteSubject that is monitored by many observers
 */
public class GoldPriceConcreteSubject extends Subject {
	
	private double price;
	private String description;
	
	/*
	 * set price of the observed object
	 */
	public void setPrice(double price) {
		this.price = price;
		notify(this);
	}
	
	/*
	 * set description of the observed object
	 */
	public void setDescription(String description) {
		this.description = description;
		notify(this);
	}
	
	/*
	 * get price of the observed object
	 */
	public double getPrice() {
		return this.price;
	}
	
	/*
	 * get description of the observed object
	 */
	public String getDescription() {
		return this.description;
	}
}
