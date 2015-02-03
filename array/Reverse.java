package array;

public class Reverse {

	public static String reverse(String string){
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i<string.length(); i++){
			buffer.insert(0, string.charAt(i));
		}
		return buffer.toString();
	}
	
	public static void reverse2(String string){
		//System.out.println(string.length());
		if(string.length()==1){
			System.out.println(string);
		}
		else{
			String sub1 = string.substring(0, string.length()-1);
			String sub2 = string.substring(string.length()-1);
		
		System.out.print(sub2);
		reverse2(sub1);
		}
	}
	public static void main(String[] args) {
		String string = "1234567";
		String string2 = "1234567";
		String newString = reverse(string);
		System.out.println("method1: "+newString);
		char[] ch = string.toCharArray();
		System.out.print("method2: ");
		for(int i = ch.length-1;i>=0;i--){
			System.out.print(ch[i]);
		}
		System.out.println("");
		System.out.print("method3: ");
		reverse2(string2);
	}

}
