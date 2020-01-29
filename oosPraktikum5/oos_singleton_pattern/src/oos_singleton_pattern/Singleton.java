package oos_singleton_pattern;

import java.util.ArrayList;

/*
 * singleton pattern is used when you want to have only ONE object of a class
 * you can do this by making the constructor private 
 * -> error when trying to create obj from outside :)
 */
public class Singleton {
	
	//create list of stuff we want to print
	private ArrayList<String> printList = new ArrayList<String>();
	/*
	 * static reference to our only instance
	 */
	public static Singleton onlyInstance = null;
	
	/*
	 * make constructor private to avoid creation of objs
	 */
	private Singleton() {
		
	}
	
	/*
	 * return reference to our only obj. or create it if its not up.
	 */
	public static Singleton getInstance() {
		
		if(onlyInstance == null) {
			onlyInstance = new Singleton();
		}
		return onlyInstance;
	}
	
	/*
	 * those methods are created to test the pattern 
	 */
	/*
	 * display items that are going to be printed
	 */
	public String returnPrintQuery() {
		String out="";
		for (String listItem : this.printList) {
			out+=listItem.toString()+ " ";
		}
		return out.substring(0,out.length()-1);
	}
	/*
	 * add item to printList
	 */
	public void addToQueue(String item) {
		this.printList.add(item);
	}
	
	/*
	 * print first item / remove first item
	 */
	public String printNext() {
		String out = this.printList.get(0);
		this.printList.remove(0);
		return out;
	}
}
