package array;
//检查string是否相同的两种方法

public class Permutation {
	
	public static String sort(String string){
		char[] str = string.toCharArray();
		java.util.Arrays.sort(str);
		return new String(str);
	}
	
	public static int[] check(String string){
		int[] array = new int[256];
		for(int i = 0; i<string.length(); i++){
			int value = string.charAt(i);
			array[value]++;
		}
		return array;
	}

	public static void main(String[] args) {
		String string = "ueiwuiurieu";
		int[] array1 = check(string);
		String string2 = "eiuwuiurieu";
		int[] array2 = check(string2);
		int k = 0;
		for(int i = 0; i < 256; i++){
			if(array1[i]!=array2[i]){
				k++;
			}
		}
		if(k == 0){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}
		
	}

}
