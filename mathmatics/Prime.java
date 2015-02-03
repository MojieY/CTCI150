package mathmatics;

import java.util.ArrayList;
import java.util.List;

public class Prime {
	static int num = 1000000000;
	static List<Integer> prime = new ArrayList<Integer>();
	static List<Boolean> array = new ArrayList<Boolean>();
	
	static int flag;
	
	public static void getPrime(){
		flag = 0;
		for(int i = 0; i<num; i++){
			array.add(false);
		}
		for(int i = 2; i<array.size(); i++){
			if(array.get(i) == false){
				prime.add(i);
				flag++;
			}
			for(int j = 0; (j<=flag) && (i*prime.get(j)<num); j++){
					array.set(i*prime.get(j), true);
					if(i%prime.get(j) == 0){
						break;
					}
				}
		}
		
	}
/*
	public static void printing(){
		for(int i = 0; i<flag; i++){
			System.out.print(prime.get(i)+" ");
		}
	}
	*/
	public static void main(String[] args) {
		long beginTime = System.currentTimeMillis();
		getPrime();
		long endTime = System.currentTimeMillis();
		System.out.println((endTime-beginTime)+"ms"); 
		//printing();
		
	}

}
