package sorting_searching;

public class MatrixSort {
	public static void MatrixSearch(int[][] matrix, int value) {
		int column = 0;	//列
		int row = matrix[0].length-1;	//行
		while (column < matrix.length && row >= 0) {
			if (matrix[column][row] == value) {
				System.out.println(row + " " + column);
				return;
			} else if (matrix[column][row] > value) {
				row--;
			} else {
				column++;
			}
		}

	}

	public static void main(String[] args) {
		
		int[][] matrix = { { 1, 3, 5, 6, 9 }, { 2, 4, 7, 8, 12 },
				{ 3, 6, 9, 10, 14 }, { 4, 8, 10, 12, 16 } };
		MatrixSearch(matrix, 9);
	}
}
