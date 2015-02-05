package recursionDynamic;

import java.util.ArrayList;

public class SubSet {
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>(); //最终的子集的集合
		if (set.size() == index) {
			allsubsets.add(new ArrayList<Integer>()); //加空集，最终形态
		} else {
			allsubsets = getSubsets(set, index + 1); //迭代，起始位置是index ＝ 0
			int item = set.get(index); //取最后一个数 index从0开始
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();//这也是一堆集合的集合
			
			for (ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset); //复制前次迭代的子集
				newSubset.add(item); //加入新item
				moresubsets.add(newSubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}

	public static void main(String[] args) {

		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(4);
		ArrayList<ArrayList<Integer>> array = getSubsets(set,0);
		for(int i = 0; i<array.size(); i++){
			System.out.print("{");
			for(int j = 0; j<array.get(i).size(); j++){
				System.out.print(array.get(i).get(j)+" ");
			}
			System.out.println("}");
		}
	}

}
