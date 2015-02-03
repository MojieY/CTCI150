package bit;

public class TheNumberOfBitToConvert {
	public static int convert(int a, int b){
		int count = 0;
		for(int c = a^b; c!=0; c >>= 1){
			if((c&1) == 1){
				count++;
			}
		}
		return count;
	}
	
	public static int convert2(int a, int b){
		int count = 0;
		for(int c = a^b; c!=0; c = c&(c-1)){
			
				count++;
			
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(convert2(31,14));

	}

}
