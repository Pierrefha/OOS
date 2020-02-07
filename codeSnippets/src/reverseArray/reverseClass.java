package reverseArray;

//reverse aus 14.07.2017
public class reverseClass {

	public static void main(String args[]) {
//erstelle Array mit 5 Eintraegen
		int zA[] = { 1, 2, 3, 4, 5 };

		print(zA);
		reverse(zA);
		print(zA);
		
	}

public static void print(int zA[]){
String output="";
for(int i=0;i<zA.length;++i){
	output+=zA[i];
}
System.out.println(output);
}

public static int[] reverse(int zA[]){
int tmp;
for(int i=0;i<zA.length/2;++i){
tmp=zA[i];
zA[i]=zA[zA.length-1-i];
zA[zA.length-1-i]=tmp;
}
return zA;
}
}
