package sorting_searching;

public class Merge2SortedArray {
	
	public static int[] merge(int[] array1, int[] array2){
		
		int[] array = new int[array1.length + array2.length];
		
		if(array2[0]>=array1[array1.length-1]){
			for(int i = 0; i<array1.length; i++){
				array[i] = array1[i];
			}
			for(int j = 0; j< array2.length; j++){
				array[array1.length+j] = array2[j];
			}
		}
		
		else if(array1[0]>array2[array2.length-1]){
			for(int i = 0; i<array2.length; i++){
				array[i] = array2[i];
			}
			for(int j = 0; j< array1.length; j++){
				array[array2.length+j] = array1[j];
			}
		}
		
		else{
			int left = 0;
			int right = 0;
			for(int i = 0; i<array1.length-1; i++){
				if(array2[0]>=array1[i] && array2[0] <= array1[i+1]){
					left = i;
					break;
				}
			}
			System.out.println("left: "+left);
			for(int j = left; j<array1.length-1; j++){
				if(array2[array2.length-1]>=array1[j] && array2[array2.length-1] <= array1[j+1]){
					right = j+1;
					break;
				}
			}
			System.out.println("right: "+right);
			int k = 0;
			int m = left;
			
				while(left <= right-1 && k<= array2.length-1){
					if(array1[left] <= array2[k]){
						array[m++] = array1[left++];
						//System.out.println(1);
					}
					else{
						array[m++] = array2[k++];
						//System.out.println(2);
					}
				}
				while(left<=right-1){
					array[m++] = array1[left++];
					//System.out.println(3);
				}
				while(k<=array2.length-1){
					array[m++] = array2[k++];
					//System.out.println(4);
				}
			for(int i = 0; i<left-1; i++){
				array[i] = array1[i];
			}
			for(int j = right; j<array1.length; j++){
				array[array2.length+j] = array1[j];
			}
			}
		
		return array;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {1,4,9,12};
		int[] array2 = {1,4,5,6};
		
		int[] array3 = merge(array1, array2);
		for(int i = 0; i<array3.length; i++){
			System.out.println(array3[i]);
		}
	}

}
