package array;

import java.util.ArrayList;
//Question: write a algorithm such that if an M*N matrix is 0, the enire row and column
//are set to 0
public class columnTo0 {
//一维数组	
	public static void check(int[] array){
		
		System.out.println();
		System.out.println();
		int n = (int) Math.sqrt(array.length);
		System.out.println("矩阵大小："+n);
		
		int num = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<array.length; i++){
			if(array[i] == 0){
				num++;
				list.add(i);
			}
		}
		
		System.out.println("0的个数："+num);
		
		for(int i = 0; i<list.size(); i++){
			System.out.println("0的位置："+list.get(i));
		}
		
		for(int i = 0; i< list.size(); i++){
			//消行
			int column = list.get(i)/n;
			for(int a = n*column; a<n*(column+1); a++){
				array[a] = 0;
			}
			//消列
			int row = list.get(i)%n;
			for(int b = 0; b<n; b++){
				array[b*n+row] = 0;
			}
		}
	}
//二维数组	
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
