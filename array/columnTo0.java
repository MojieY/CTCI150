package array;

public class columnTo0 {
	
	public static void check(int[] array){
		
		System.out.println();
		System.out.println();
		int n = (int) Math.sqrt(array.length);
		System.out.println(n);
		
		int num = 0;
		for(int i = 0; i<array.length; i++){
			if(array[i] == 0){
				num++;
			}
		}
		
		System.out.println(num);
		
		int[] list = new int[num];
		for(int i = 0,j=0; i<array.length; i++){
			if(array[i] == 0){
				list[j] = i;
				j=j+1;
			}
		}
		
		for(int i = 0; i<list.length; i++){
			System.out.println(list[i]);
		}
		
		for(int i = 0; i< list.length; i++){
			int column = list[i]/n;
			for(int a = n*column; a<n*(column+1); a++){
				array[a] = 0;
			}
			int row = list[i]%n;
			for(int b = 0; b<n; b++){
				array[b*n+row] = 0;
			}
		}
	}
	
	public static void check2(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		for(int i = 0; i<row.length; i++){
			for(int j = 0; j<column.length; j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		for(int i = 0; i<row.length; i++){
			for(int j = 0; j<column.length; j++){
				if(row[i]||column[j]){
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5,6,0,8,9,0,11,12,13,14,15,16};
		for(int i = 0; i<array.length;i++){
			if(i%4 == 0){
				System.out.println();
			}
			System.out.print(array[i]+" ");
			}
		
		check(array);
		for(int i = 0; i<array.length;i++){
		if(i%4 == 0){
			System.out.println();
		}
		System.out.print(array[i]+" ");
		
		}
		System.out.println();
		System.out.println();
		int[][] matrix = {{1,2,3,4},{5,6,0,8},{9,0,11,12},{13,14,15,16}};
		check2(matrix);
		for(int i = 0; i<matrix.length; i++){
			for(int j = 0; j<matrix[i].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
