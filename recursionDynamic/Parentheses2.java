package recursionDynamic;

import java.util.ArrayList;

public class Parentheses2 {
	
	public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count){
		if(leftRem < 0 || rightRem <0) return;
		if(leftRem == 0 && rightRem == 0){
			String string = String.copyValueOf(str);
			list.add(string);
		}
		else{
			if(leftRem > 0){
				str[count] ='('; 
				addParen(list, leftRem-1, rightRem, str, count+1);
			}
			if(rightRem > leftRem){
				str[count] = ')';
				addParen(list, leftRem, rightRem-1, str, count+1);
			}
		}
		
	}

	public static void main(String[] args) {
		int num = 4;
		char[] str = new char[num*num];
		ArrayList<String> list = new ArrayList<String>();
		addParen(list, num, num, str, 0);
		for(int i = 0; i<list.size(); i++){
			System.out.println(list.get(i));
		}

	}

}
