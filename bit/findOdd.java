package bit;

public class findOdd {
//只需检查最后一位
	public static void main(String[] args) {
		for(int i = 0 ;i<100; i++){
			if ((i & 1) == 1 ){
				System.out.println(i);
			}
		}

	}

}
