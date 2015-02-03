package sorting_searching;

public class QuickSort {

	static void quicksort(int[] array, int left, int right) {

		if (left < right) {

			int i = left;
			int j = right;
			int x = array[left];
			
			while (i < j) {
				while (i < j && array[j] >= x) {
					j--;
				}
				if (i < j) {
					array[i++] = array[j];
				}
				
				while (i < j && array[i] < x) {
					i++;
				}
				if (i < j) {
					array[j--] = array[i];
				}
			}
			
			array[i] = x;
			quicksort(array, left, i - 1);
			quicksort(array, i + 1, right);

		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 4, 12, 5, 6, 3, 11, 9 };
		quicksort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
