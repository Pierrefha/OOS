package oos_genercis_stack;

public class Stack<Data> {
	
	public static void main(String[] args) {
		Stack<Integer> intStack = new Stack<Integer>(5);
		intStack.push(0);
		intStack.push(1);
		intStack.push(2);
		intStack.push(3);
		intStack.push(4);
		intStack.push(5);
		System.out.println("Stack toString method: "+intStack.toString());
		System.out.println("top: "+intStack.top);
		
		intStack.pop();
		System.out.println("Stack toString method: "+intStack.toString());

	}
	@SuppressWarnings("unchecked")
	Data[] arr;
	int top=0;
	
	public Stack(int length){ 
		this.arr = (Data[])new Object [length];
	}
	//push value onto stack
	void push(Data value) {
		if(top >= arr.length) {
			System.out.println("Stack overflow!");
		}
		else {
			arr[top]=value;
			if(top+1 <=arr.length) {
				++top;
			}
		}
	}
	
	//return top value
	Data pop() {
		if(top==arr.length) {
			--top;
		}
		return this.arr[top];
	}
	
	//return stack in string represenation
	public String toString() {
		String output="";
		for (Data value: arr) {
			//if we hit the top, return value and stop
			if(value.toString().equals(arr[top-1].toString())) {
				output+=value.toString();
				break;
			}
			else {
				output+=value.toString();
			}
		}
		return output;
	}
	
}
