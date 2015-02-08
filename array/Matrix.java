package array;

public class Matrix {
	
	//to begin with, print a matrix using array
	public static void matrxPrint(int[] array){
		int width = (int) Math.sqrt(array.length);
		
		for(int i = 0; i<array.length; i++){
			if(i%width == 0){
				System.out.println();
			} 
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	public static void rotate(int[] array){
		int width = (int) Math.sqrt(array.length);
		//System.out.println(width);
		int temp = 0;
			for(int j = 4, layer = 1; layer < width-1;layer++,j=j-2){
				for(int i = 0; i<j-1; i++){
			temp = array[width*(width-1)-j*i-(width-1)*(layer-1)];
			array[width*(width-1)-j*i-(width-1)*(layer-1)] = array[(width-1)*width+width-1-i-(width+1)*(layer-1)];
			array[(width-1)*width+width-1-i-(width+1)*(layer-1)] = array[(width-1)*(layer-1)+i*j+width-1];
			array[(width-1)*(layer-1)+i*j+width-1] = array[(width+1)*(layer-1)+i];
			array[(width+1)*(layer-1)+i] = temp;
				}
			
		}
	}

	public static void main(String[] args) {
		int[] array = new int[25];
		for(int i = 1; i<26 ;i++){
		array[i-1] = i;
		}
		matrxPrint(array);
		rotate(array);
		matrxPrint(array);

	}

}
