package sorting_searching;

public class selectionSort {
	public static void swap(int a, int b){
		int c = a;  
	    a = b;  
	    b = c;  
	}//this is useless, very tricky
	
	public static void selection(int[] a){
		int i, j, nMinIndex;  
	    for (i = 0; i < a.length; i++)  
	    {  
	        nMinIndex = i; //找最小元素的位置  
	        for (j = i + 1; j < a.length; j++){  
	            if (a[j] < a[nMinIndex]){  
	                nMinIndex = j;
	            }
	        }
	        int temp = a[nMinIndex];
	        a[nMinIndex] = a[i];
	        a[i] = temp;
	        
	    }  
	}
	public static void main(String[] args) {
		int[] array = {1, 4, 12, 5 , 6 ,3 ,11, 9};
		selection(array);
		for(int i = 0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}

}