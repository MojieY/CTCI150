package bit;
//CTCI150 5.1
public class Insertion {
	
	public static void main(String[] args) {
		int m = 32;
		int n = 7;
		int i = 1;
		int j = 3;
		int left = (m>>(j+1))<<(j+1);
		int right = m & ((1<<(i))-1);
		System.out.println(left);
		System.out.println(right);
		
		m = left+right;
		
		int p = n<<i;
        int q = m+p;
        System.out.print(q);
	}

}
