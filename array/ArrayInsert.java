package array;
//Question: write a method to replace all spaces in a string with "%20". you may assume
//that the string has sufficient space at the end of the string to hold the additional 
//characters, and that you are given the "true" length of the string.
public class ArrayInsert {

	public static String insert(String string) {
		StringBuffer sb = new StringBuffer();
		char[] ch = string.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == ' ') {
				sb.append("%20");

			} else {
				sb.append(ch[i]);
			}
		}
		return sb.toString();
	}
	
	public static char[] insert2(String string){
		int count = 0;
		for(int i = 0; i<string.length(); i++){
			if(string.charAt(i) == ' '){
				count++;
			}
		}
		
		int length = string.length()+2*count;
		char[] ns = new char[length];
		for(int j = 0, i = j; j<string.length(); j++, i++){
			if(string.charAt(j) == ' '){
				ns[i++] = '%';
				ns[i++] = '2';
				ns[i] = '0';
			} 
			else{
				ns[i] = string.charAt(j);
			}
		}
		return ns;
		
	}

	public static void main(String[] args) {

		String string = "Mr John Smith";
		System.out.println(insert(string));
		System.out.println(insert2(string));
		System.out.print(insert2(string));
	}
}
