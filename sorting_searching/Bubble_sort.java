package sorting_searching;

public class Bubble_sort {
	
	public static void bubbleSort1(int[] array){
		for(int i = 0; i<array.length; i++){
			for(int j = 1; j<array.length-i; j++){
				if(array[j-1]>array[j]){
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	public static void bubbleSort2(int[] array){
		
		boolean flag = true;
		int n = array.length;
		while(flag){
			flag = false;
		
			for(int j = 1; j<n; j++){
				if(array[j-1]>array[j]){
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
					flag = true;
				}
			}
			n--;
		}
	}
	
	public static void bubbleSort3(int[] array){
		
		int flag = array.length;
		int n;
		while(flag>0){
			
			n = flag;
			flag = 0;//很重要！不交换后0就不会改变了，while循环也不会进入
			
			for(int j = 1; j<n; j++){
				if(array[j-1]>array[j]){
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
					flag = j;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = {1, 4, 12, 5 , 6 ,3 ,11, 9};
		bubbleSort1(array);
		for(int i = 0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}

}
