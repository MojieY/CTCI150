package recursionDynamic;

import java.util.ArrayList;

public class PermutationsOfString {
	public static ArrayList<String> getPem(String string){
		if(string == null){
			return null;
		}
		ArrayList<String> permutations = new ArrayList<String>();
		if(string.length() == 0){
			permutations.add("");
			return permutations;
		}
		
		char first = string.charAt(0);
		String remainder = string.substring(1);
		ArrayList<String> words = getPem(remainder);
		for(String word : words){
			for(int i = 0; i <= word.length(); i++){
				String s = insertAt(word, first, i);
				permutations.add(s);
			}
		}
		return permutations;
	}
	
	public static String insertAt(String string, char c, int i){
		String left = string.substring(0, i);
		String right = string.substring(i);
		return left+c+right;
	}
	public static void main(String[] args) {
		String string ="abc";
		ArrayList<String> array = new ArrayList<String>();
		array = getPem(string);
		for(int i = 0; i<array.size(); i++){
		   System.out.println(array.get(i));
		}
	}

}
