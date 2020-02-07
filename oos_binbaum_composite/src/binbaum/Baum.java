package binbaum;

/*
 * declare generics to make sure we can only use objects of same type
 */
public abstract class Baum<Data> {
	Data entry;
	
	/*
	 * every tree has node
	 */
	public Baum(Data entry) {
		this.entry=entry;
	}
	
	/*
	 * abstract methods that have to be implemented in concrete classes
	 */
	public abstract String toString();
	public abstract int anzahl();
	
}
