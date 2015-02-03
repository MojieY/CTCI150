package mathmatics;

import java.util.ArrayList;
import java.util.List;

public class BitPrime {
	
	static  int num = 1000000000;
	
	static int[] array = new int[num/3+1];
	static int[] prime = new int[num/32+1];
	static int flag = 0;

	public static void getPrime(){
		for(int i = 2; i<num; i++){
			if((prime[i/32] >> (i%32) & 1)==0){
				array[flag++] = i;
				for(int j = i; j<num; j+=i){
					prime[j/32] |= (1<<(j%32));
				}
			}
		}
	}
	public static void printing(){
		for(int i = 0; i<flag; i++){
			System.out.print(array[i]+" ");
		}
	}
	public static void main(String[] args) {
		
		getPrime();
		printing();
		
	}

}
