package bit;

public class abs {

	public static void main(String[] args) {
		int i =-10;
		int j = i >> 31;
		System.out.println( j == 0? i:(~i+1)); 
		System.out.println( (i ^ j) - j); 
	}

}
