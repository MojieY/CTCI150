package array;

public class StringRotate {

	public static String rotate(String str, int left, int right){
		char[] string = str.toCharArray();
		while(left<right){
			char temp = string[left];
			string[left++] = string[right];
			string[right--] = temp;
		}
		return str = String.valueOf(string);
		
	}
	public static void main(String[] args) {
		String string = "abcdefg";
		String str = rotate(string,0,2);
		//System.out.println(string);
		str = rotate(str,3,string.length()-1);
		str = rotate(str,0, string.length()-1);
		System.out.println(str);
	}

}
