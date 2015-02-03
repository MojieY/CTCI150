package sorting_searching;

public class MergeSort {
	
	static void mergearray(int[] array, int first, int mid, int end, int[] temp){
		int i = first;
		int j = end;
		int m = mid;
		int n = mid+1;
		int k = 0;
		while(i <= m && n <= j){
			if(array[i]<=array[n]){
				temp[k++] = array[i++];
			}else{
			
				temp[k++] = array[n++];
			}
		}
		while(i<=m){
			temp[k++] = array[i++]; 
		}
		while(n<=j){
			temp[k++] = array[n++];
		}
		for(int count = 0; count < k; count++){
			array[first+count] = temp[count];
		}
	}
	
	static void mergesort(int[] array, int first, int end, int[] temp){
	
		if(first < end){
			int mid = (first+end)/2;
			mergesort(array,first,mid,temp);
			mergesort(array,mid+1,end,temp);
			mergearray(array,first,mid,end,temp);
		}
		
	}

	public static void main(String[] args) {
		int[] array = {1, 4, 12, 5 , 9, 6 ,3 ,11, 9};
		int[] temp = new int[array.length];
		mergesort(array,0,array.length-1,temp);
		for(int i = 0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}

}