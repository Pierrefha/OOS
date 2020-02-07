package usammen;

public class Stack<Data> {
	
	
	Data[] arr;
	int top = 0;
	
	public Stack(int l) {
		this.arr = (Data[])new Object[l];
	}
	
	public void push(Data t) throws stackleer{
		if(top >= arr.length) {System.out.println("Stack overflow");}
		else {
			this.arr[top] = t;
			
			if(top+1 <= arr.length) {
				top++;
			}			
		}
	}
	
	Data pop() throws stackleer{
		if(top == 0 && arr[0] == null) throw new stackleer("Stack leer");
		if(top == arr.length) {top--;}
		Data t = arr[top];
		arr[top] = null;
		
		if(top - 1 >= 0) {
			top--;
		}		
		return t;
	}
	
	public String toString() {
		String out = "";
		for(int i = 0; i < top; i++) {
			out += arr[i].toString();
		}
		return out;
	}
	
	public static void main(String[] args) throws stackleer {
		
		Stack<Integer> a = new Stack<Integer>(5);
		
		for(int i = 0; i < 6; i++) {
			a.push(i);
		}
		
		System.out.println(a.toString());

		
		for(int i = 0; i < 5; i++) {
			System.out.print(a.pop().toString());
		}
		
		for(int i = 0; i < 5; i++) {
			a.push(i * 2);
		}
		
		System.out.println(a.toString());
		
		for(int i = 0; i < 5; i++) {
			System.out.print(a.pop().toString());
		}

	}
	
}
