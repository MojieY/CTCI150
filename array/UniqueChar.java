package array;
//Question: check whether the char in a String is unique
public class UniqueChar {

	public static boolean check(String str){
		if(str.length()>256){
			return false;
		}
		boolean[] checkArray = new boolean[256];
		
		for(int i = 0; i<str.length(); i++){
			if(checkArray[str.charAt(i)] == true){
				return false;
			}
			checkArray[str.charAt(i)] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str = "wqefs";
		System.out.println(check(str));

	}

}
