package bit;

public class swap {

	public static void main(String[] args) {
		int num = 13;
		int output = ((num & 0xaaaa)>>1) | ((num & 0x5555)<<1);
		System.out.println(output);

	}

}
