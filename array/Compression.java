package array;

public class Compression {

	public static int[] compressed(String string, int num) {
		int[] count = new int[num];
		for (int i = 0; i < count.length; i++) {
			count[i] = 1;
		}
		for (int i = 0, j = 0; i < string.length() - 2; j++) {

			while (string.charAt(i) == string.charAt(++i)) {
				count[j]++;
			}

		}

		return count;
	}

	public static char[] check(String string, int num) {
		char[] ch = new char[num];
		for (int i = 0, j = 0; i < string.length() - 2;) {
			while (string.charAt(i) != string.charAt(++i)) {
				ch[j] = string.charAt(i - 1);
				ch[j + 1] = string.charAt(i);
				j++;
			}
			if (string.charAt(string.length() - 1) != string.charAt(string
					.length() - 2)) {
				ch[num - 1] = string.charAt(string.length() - 1);
			}
		}

		return ch;
	}

	public static int count(String string) {
		int num = 1;
		for (int i = 0; i < string.length() - 2;) {
			while (string.charAt(i) != string.charAt(++i)
					&& i < string.length() - 1) {
				num++;
			}
		}
		if (string.charAt(string.length() - 1) != string
				.charAt(string.length() - 2)) {
			num = num + 1;
		}

		return num;
	}

	public static String combine(String string, int num) {

		String Nstring = "";

		int[] a1 = compressed(string, num);
		char[] a2 = check(string, num);

		for (int i = 0; i < a1.length; i++) {
			Nstring = Nstring + a2[i] + a1[i];
		}
		return Nstring;

	}

	public static void end(String string) {

		int num = count(string);

		if (num == string.length()) {
			System.out.println(string);
		} else {
			System.out.println(combine(string, num));
		}
	}

	public static void main(String[] args) {

		String string = "aaabcdscccddaawwe";
		String string2 = "abcdf";
		System.out.print("new string: ");
		end(string);
		System.out.print("new string2: ");
		end(string2);

	}

}
