package array;
//Question: implement a function void reverse(char* str) in 
//C++ which reverse a null-terminated String

public class Reverse {
//使用StringBuffer,简单，缺点是会用到额外的内存空间
	public static String reverse(String string){
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i<string.length(); i++){
			buffer.insert(0, string.charAt(i));
		}
		return buffer.toString();
	}
//用迭代方法	
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
//字符串原地逆序，使用中间变量	
	public static String reverse3(String string){
		int n = string.length();
		char[] charString = string.toCharArray();
		if(n == 1){
			return string;
		}
		for(int i=0; i<n/2; i++){
			char temp = charString[i];
			charString[i] = charString[n-i-1];
			charString[n-i-1] = temp;
		}
		return String.valueOf(charString);
		
	}
//字符串原地逆序，不允许使用中间变量，使用^进行运算
	public static String reverse4(String string){
		int n = string.length();
		char[] charString = string.toCharArray();
		if(n == 1){
			return string;
		}
		for(int i = 0; i<n/2; i++){
			charString[i] = (char)(charString[i]^charString[n-i-1]);
			charString[n-i-1] = (char)(charString[i]^charString[n-i-1]);
			charString[i] = (char)(charString[i]^charString[n-i-1]);
		}
		
		return String.valueOf(charString);
	}
	
//对一个句子或段落逆序，先对每个单词逆序再对整个string逆序
	public static String reverseParagraph(String string){
		int n = string.length();
		if(n<2){
			return string;
		}
		char[] charString = string.toCharArray();
		int bound = 0;
		for(int i = 0; i<n; i++){
			if(charString[i] == ' '){
				swap(charString, bound, i-1);
				bound = i+1;
			}
			
		}
		//当结尾不为‘ ’时
		if(charString[n-1]!=' '){
			swap(charString, bound, n-1);
		}
		swap(charString, 0, n-1);
		return String.valueOf(charString);
	}
	
	public static char[] swap(char[] array, int left, int right){
		if(right - left<1){
			return array;
		}
		
		for(int i = left; i<(right-left+1)/2+left; i++){
			array[i] = (char)(array[i]^array[right-i+left]);
			array[right-i+left] = (char)(array[i]^array[right-i+left]);
			array[i] = (char)(array[i]^array[right-i+left]);
		}
		return array;
		
	}
	public static void main(String[] args) {
		String string = "1234567";
		String string2 = "1234567";
		String string3 = "1234567";
		String string4 = "1234567";
		String string5 = "here am iw";
		String newString = reverse(string);
		System.out.println("method1: "+newString);
		System.out.print("method2: ");
		reverse2(string2);
		System.out.print("method3: ");
		System.out.println(reverse3(string3));
		System.out.print("method4: ");
		System.out.println(reverse3(string4));
		System.out.println("paragraph reverse: ");
		System.out.print(reverseParagraph(string5));
	}

}
