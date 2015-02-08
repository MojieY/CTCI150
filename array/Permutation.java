package array;
//Question：check whether a string is the permutation of another string

public class Permutation {
//方法1， sort
	public static String sort(String string){
		char[] str = string.toCharArray();
		java.util.Arrays.sort(str);
		return new String(str);
	}
//方法2，比较ascii码	
	public static boolean check(String string1, String string2){
		if(string1.length()!=string2.length()){
			return false;
		}
		int[] array = new int[256];
		for(int i = 0; i<string1.length(); i++){
			int value = string1.charAt(i);
			array[value]++;
		}
		
		for(int i = 0; i<string2.length(); i++){
			int value = string2.charAt(i);
			if(--array[value]<0){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String string = "ueiwuiurieu";
		
		String string2 = "eiwuiurieu";
		
		System.out.print(check(string, string2));
	}

}
