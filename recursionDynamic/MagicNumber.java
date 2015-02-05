package recursionDynamic;

public class MagicNumber {
	//brute force. distinct
	public static int check(int[] array){
		for(int i = 0; i<array.length; i++){
			if(array[i] == i){
				return i;
			}
		}
		return -1;
	}
	//binary search
	public static int check2(int[] array, int start, int end){
		if(start<0 || start>end || end>=array.length){
			return -1;
		}
		int middle = (end+start)/2;
		
		if(middle == array[middle]){
			return middle;
		}
		else if(middle < array[middle]){
			return check2(array, start, middle-1);
		}
		else{
			return check2(array, middle+1, end);
		}
	}
	//multiple binary search, non-distinct
	public static void check3(int[] array, int start, int end){
		if(start<0 || start>end || end>=array.length){
			//System.out.println(-1);
			return;
		}
		int index = (end+start)/2;
		int middle = array[index];
		if(index== middle){
			System.out.println(middle);
		}
		int leftIndex = Math.min(index-1, middle);
		check3(array, start, leftIndex);
		
		int rightIndex = Math.max(index+1, middle);
		check3(array, rightIndex, end);
		
		
		
		
	}
	public static void main(String[] args) {
		int[] array = {-40, -20, 2, 2, 2, 3, 4, 7, 9, 12, 13};
		check3(array, 0, array.length-1);
		//System.out.println(check(array));

	}

}
