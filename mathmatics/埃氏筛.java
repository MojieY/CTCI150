package mathmatics;

public class 埃氏筛 {
	
	public static void set(boolean[] array){
		for(int i = 0; i<array.length; i++){
			array[i] = true;
		}
	}
	
	public static boolean[] check(int max){
		boolean[] flag = new boolean[max+1];
		set(flag);
		int prime = 2;
		while(prime<max){
			crossoff(flag, prime);
			
			prime = next(flag,prime);
			//if(prime >= flag.length)
				//break;
		}
		return flag;
	}
	
	public static void crossoff(boolean[] flag, int prime){
		for(int i = prime*prime; i<flag.length; i += prime){
			flag[i] = false;
		}
	}
	
	public static int next(boolean[] flag, int prime){
		int next = prime+1;
		while(next<flag.length && flag[next] == false){
			next++;
		}
		return next;
	}
	
	public static void print(boolean[] flag){
		for(int i = 0; i<flag.length; i++){
			if(flag[i] == true){
				System.out.print(i+" ");
			}
		}
	}

	public static void main(String[] args) {
		
		int max = 100;
		boolean[] flag = check(max);
		print(flag);
        
	}

}
