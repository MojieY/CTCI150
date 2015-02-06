package recursionDynamic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Parentheses {

	public static Set<String> generate(int remains) {
		Set<String> set = new HashSet<String>();
		if (remains == 0) {
			set.add("");

		} else {
			Set<String> prev = generate(remains - 1);
			for (String string : prev) {
				for (int i = 0; i < string.length(); i++) {
					if (string.charAt(i) == '(') {
						String s = insert(string, i);
						if (!set.contains(s)) {
							set.add(s);
						}
					}
				}
				if (!set.contains("()" + string)) {
					set.add("()" + string);
				}

			}
		}
		return set;
	}

	public static String insert(String string, int i) {
		String left = string.substring(0, i + 1);
		String right = string.substring(i + 1);
		return left + "()" + right;
	}

	public static void main(String[] args) {

		Set<String> s = new HashSet<String>();
		s = generate(4);

		Iterator<String> iterator1 = s.iterator();

		while (iterator1.hasNext()) {
			String s1 = iterator1.next();
			System.out.println(s1);
		}

	}

}
