package sorting_searching;

public class shellSort {
	
	public static void shell(int[] array){
		int i, j, gap;
		for(gap = array.length/2; gap>0; gap /= 2){
			for(i = 0; i<gap; i++){
				
				for(j = i+gap; j<array.length; j+=gap){
					if(array[j]<array[j-gap]){
						int temp = array[j];
						int k = j-gap;
						while(k>0 && array[k]>temp){
							array[k+gap] = array[k];
							k = k - gap;
						}
						array[k+gap] = temp;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = {1, 4, 12, 5 , 6 ,3 ,11, 9};
		shell(array);
		for(int i = 0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}

}