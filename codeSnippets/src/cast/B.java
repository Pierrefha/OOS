package cast;


public class B extends A{

	public String toString() {
		return "B";
	}
	
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		System.out.print(a.toString());
		System.out.print(b.toString());
		//casting will change the type of an object but it will still be the same object..
		//-> it's from type A but will print it's toString method.
		System.out.print(((A) b).toString());		
		/* create anonymous class and overwrite the toString function.
		 * toString will then be called by System.out.print(anonymousclass)
		 * the anonymous class does extend B and with super we call the toString from B
		 * which returns "B".
		 */
		System.out.print(new B() {
			public String toString() {
				return super.toString();
			}
		});
	}
}

	

