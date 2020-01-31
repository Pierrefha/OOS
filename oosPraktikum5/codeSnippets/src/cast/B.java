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
		
		//when we have sayHello only implemented in A, we will print A
		b.sayHello();
		
		//when we have sayHello also implemented in B, we will print B!
		//why isn't this printing B?
		new B() { public void sayHello() {
			System.out.println("Hello from B!");
		}
		};
		b.sayHello();
		
		
		//what is this code?
		System.out.print(new B() {
			public String toString() {
				return super.toString();
			}
		});
	}
}

	

