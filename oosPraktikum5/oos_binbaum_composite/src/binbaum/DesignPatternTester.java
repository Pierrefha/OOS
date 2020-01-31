package binbaum;

/*
 * this class has nothing to do with the implementation
 * it's just here for testing
 */
public class DesignPatternTester {

	public static void main(String args[]) {
		/*
		 * create binary tree (left is bot right is root)
		-4 
	-5 * 1
		 *   2   
		 * 3
		 *      6
		 * 8  
		 *   7
		 * 9
		 * 
		 */
		/*
		 * create leafs
		 */
		Leaf<Integer> leaf1=new Leaf<Integer>(1);
		Leaf<Integer> leaf2=new Leaf<Integer>(3);
		Leaf<Integer> leaf3=new Leaf<Integer>(8);
		Leaf<Integer> leaf4=new Leaf<Integer>(9);
		/*
		 * create binBaums with leafs
		 */
		BinBaum<Integer> b1 = new BinBaum<Integer>(2,leaf1,leaf2);
		BinBaum<Integer> b2 = new BinBaum<Integer>(7,leaf3,leaf4);
		BinBaum<Integer> b3 = new BinBaum<Integer>(6,null,null);
		/*
		 * append trees
		 */
		b3.addLeft(b1);
		b3.addRight(b2);
		/*
		 * append -4 to left child of b3
		 */
		//b3.addLeft(new Leaf<Integer>(-4));
		/*
		 * print tree and get node count
		 */
		System.out.println("Baumstruktur: "+b3.toString());
		System.out.println("Anzahl knoten: "+b3.anzahl());
		
	}
}
