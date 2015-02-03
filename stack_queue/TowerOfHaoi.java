package stack_queue;

public class TowerOfHaoi {
	
	public static int count = 0;

	public static void haoi(int n, String from, String buffer, String to){
		
		if(n == 1){
			System.out.println("moving "+n +"th plate: from " +from+" to " + to);
			
		}
		else{
			haoi(n-1, from, to, buffer);
			System.out.println("moving "+n +"th plate: from " +from+" to " + to);
			haoi(n-1, buffer,from, to);
			
		}
		count++;
	}
	public static void main(String[] args) {
		
		int n = 15;
		
		haoi(n, "A","B","C");

		System.out.println("Total number is: "+count);
	}

}
