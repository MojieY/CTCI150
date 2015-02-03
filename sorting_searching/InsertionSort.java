package sorting_searching;

public class InsertionSort {
	
	public static void insertion1(int[] a){
		int i, j, k;
		for(i = 1; i<a.length; i++){
			// 找位置，记录为j，新的数应该插入到j+1
			for(j = i-1; j>=0; j--){
				if(a[j]<a[i]){
					break;
				}
			}
			//j+1到i-1全部右移一位，i的数放入j+1
				if(j!=i-1){
					int temp = a[i];
					for(k = i-1; k>j; k--){
						a[k+1] = a[k];
					}
					a[k+1] = temp;
				}
			}
		}
	
	public static void insertion2(int[] a){
		int i, j;
		for(i = 1; i<a.length; i++){
			if(a[i]<a[i-1]){
				int temp = a[i];
				for(j = i-1; j>=0 && a[j]>temp; j--){
					a[j+1] = a[j];
					}
				a[j+1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = {1, 4, 12, 5 , 6 ,3 ,11, 9};
		insertion2(array);
		for(int i = 0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}

}