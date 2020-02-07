package binbaum;

/*
 * binbaum contains a value and two child nodes
 */
public class BinBaum<Data> extends Baum<Data> {
	
	/*
	 * contain left and right child
	 */
	Baum<Data> left,right;
	
	/*
	 * construct to set value and children
	 */
	public BinBaum(Data entry,Baum<Data> left,Baum<Data> right) {
		super(entry);
		this.left=left;
		this.right=right;
	}

	/*
	 * Baum ist entweder Blatt oder Binärbaum
	 * und Binärbaum hat immer zwei Blätter, nie einzelne Blätter.
	 * 
	 * daher kann man nur Bäume von unten nach oben aufbauen,
	 * indem man den Konstruktor aufruft.
	 */
	/*
	 * if left child empty, add it. otherwise work your way recursive to the last child
	 */
	public BinBaum<Data> addLeft(Baum<Data> baum) {
		if(this.left == null) {
			this.left=baum;
			return this;
		}
		
		else {
			if(this.left instanceof Leaf<?>) {
			Data tmp = this.left.entry;
			this.left = new BinBaum<Data>(tmp,baum,new Leaf(0));
			return this;
			}
			else {
				return((BinBaum<Data>)(Baum<Data>)this.getLeftChild()).addLeft(baum);
			}
			}
	}
	/*
	 * if right child empty, add it. otherwise work your way recursive to the last child
	 */
	public BinBaum<Data> addRight(Baum<Data> baum) {
		if(this.right==null) {
			this.right=baum;
			return this;
		}
		else {
			if(this.right instanceof Leaf<?>) {
			Data tmp = this.right.entry;
			this.right = new BinBaum<Data>(tmp,baum,null);
			return this;
			}
			else {
				return((BinBaum<Data>)(Baum<Data>)this.getRightChild()).addRight(baum);
			}
		}
	}
	
	public Baum<Data> getLeftChild(){
		return this.left;
	}
	
	public Baum<Data>getRightChild(){
		return this.right;
	}
	
	/*
	 * return entry, left child and right child recursive
	 */
	@Override
	public String toString() {
		return this.entry.toString()+this.left.toString()+this.right.toString();
	}

	/*
	 * return 1 plus count of left and right child recursive
	 */
	@Override
	public int anzahl() {
		return 1+this.left.anzahl()+this.right.anzahl();
	}
	
}
