package array;
//Question: implement a method to perform basic string compression using the counts of 
//repeated characters.
public class Compression {
//这个函数用来计算每个字符连续出现的次数
	public static int[] compressed(String string, int num) {
		int[] count = new int[num];
		for (int i = 0; i < num; i++) {
			count[i] = 1;
		}
		int i = 0;
		int j = 0;
		while(i < string.length() - 1){
			if(string.charAt(i) == string.charAt(i+1)) {
				count[j]++;
			}
			if(string.charAt(i) != string.charAt(i+1)) {
				j++;
			}
			i++;

		}
		return count;
	}
//这个函数返回字符数组，连续一样的数组会只显示一次
	public static char[] check(String string, int num) {
		char[] ch = new char[num];
		int i = 0;
		int j = 0;
		while(i < string.length() - 1) {
			if (string.charAt(i) != string.charAt(i+1)) {
				ch[j] = string.charAt(i);
				ch[++j] = string.charAt(i+1);
			}
			i++;
		}
		return ch;
	}
//计算字符的个数（不同的）
	public static int count(String string) {
		int num = 1;
		int i = 0;
		
		while (i<string.length()-1) {
			if(string.charAt(i) != string.charAt(++i)){
				num++;
			}
			}

		return num;
	}
//输出函数
	public static String combine(String string, int num) {

		String Nstring = "";

		int[] a1 = compressed(string, num);
		char[] a2 = check(string, num);

		for (int i = 0; i < num; i++) {
			Nstring = Nstring + a2[i] + a1[i];
		}
		return Nstring;

	}

	public static void end(String string) {

		int num = count(string);
		if(num == 1){
			System.out.println(string.charAt(0)+""+string.length());
			return;
		}
		System.out.println(num);
		if (num == string.length()) {
			System.out.println(string);
		} else {
			System.out.println(combine(string, num));
		}
	}

	public static void main(String[] args) {

		String string = "aaabcdscccddaaaiiopl";
		String string2 = "puuuhhhgh";
		System.out.print("new string: ");
		end(string2);
		

	}

}
