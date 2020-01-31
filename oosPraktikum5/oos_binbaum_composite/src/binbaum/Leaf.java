package binbaum;

/*
 * leaf class that has no children
 */
public class Leaf<Data> extends Baum<Data> {

	/*
	 * assign entry
	 */
	public Leaf(Data entry) {
		super(entry);
		}

	@Override
	public String toString() {
		return this.entry.toString();
	}

	@Override
	public int anzahl() {
		return 1;
	}

}
