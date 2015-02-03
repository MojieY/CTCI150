package mathmatics;

public class Operator {
	
	public static int negate(int a){
		int negate = 0;
		int b = (a>0)?-1:1;
		while(a!=0){
			a = a+b;
			negate = negate +b;
		}
		return negate;
	}

	public static int sub(int a, int b){
		int n = negate(b);
		return a+n;
	}
	
	public static int divide(int a, int b){
		int count = 0;
		while(a!=0){
			a = a - b;
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		int a = 6;
		int b = 3;
		System.out.println(sub(a,b));
		System.out.println(divide(a,b));

	}

}
