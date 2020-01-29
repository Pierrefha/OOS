package oos_singleton_pattern;

public class TestDesignPattern {
	
	public static void main(String args[]) {
		/*
		 * create a printspooler
		 */
		//this will throw error because construct private
		//Singleton ps = new Singleton();
		Singleton ps = Singleton.getInstance();
		ps.addToQueue("addMeToArrayPlease");
		ps.addToQueue("printMeBitch");
		ps.addToQueue("IHaveNoTime");
		
		//display queue
		System.out.println("printspooler queue: "+ps.returnPrintQuery());
		
		//print next item
		System.out.println("print the next item: "+ps.printNext());
		
		//display queue
		System.out.println("printspooler queue: "+ps.returnPrintQuery());
	}
}
