package recursionDynamic;

public class Stairs {
	
	public static int count(int n){
		if(n<0){
			return 0;
		}
		else if(n == 0 || n==1){
			return 1;
		}
		else if(n == 2){
			return count(n-1)+count(n-2);
		}
		else{
		return count(n-1)+count(n-2)+count(n-3);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		
		System.out.println(count(4));
	}

}
