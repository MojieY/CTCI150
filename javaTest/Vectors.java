package javaTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Vectors {

	public static void main(String[] args) {
		
		Vector<String> vec = new Vector<String>();
		vec.add("one");
		vec.add("two");
		
		ArrayList<String> array = new ArrayList<String>();
		array.add("one");
		array.add("two");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("one", "this is one");
		map.put("two", "this is two");
		
		System.out.println(vec.get(0));
		
		System.out.println(array.get(0));

		System.out.println(map.get("one"));
	}

}
