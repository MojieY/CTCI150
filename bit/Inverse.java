package bit;
//取反只要取反后加一即可
public class Inverse {
	
	public static int bitinverse(int num){
		return ~num+1;
	}

	public static void main(String[] args) {
		int i = 1;
		System.out.println(bitinverse(i));
	}

}
