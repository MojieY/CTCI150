package sorting_searching;

public class RoatedArray {

	public static int search(int[] a, int left, int right, int x){
		int mid = (left+right)/2;
		
		if(x == a[mid]){
			return mid;
		}
		
		if(right<left){
			return -1;
		}
		
		if(a[left]<a[mid]){
			if(x<a[mid] && x>a[left]){
				return search(a,left, mid-1, x);
			}
			else{
				return search(a, mid+1, right, x);
			}
		}
		else if(a[left]>a[mid]){
			if(x<a[right] && x>a[mid]){
				return search(a,mid+1, right, x);
			}
			else{
				return search(a, left, mid-1, x);
			}
		}
		else {
			if(a[mid] != a[right]){
				return search(a,mid+1, right, x);
			}
			else{
				int result = search(a, left, mid-1, x);
				if(result == -1){
					return search(a,mid+1, right, x);
				}
				else{
					return result;
				}
			}
		}
		//return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2,2,2,3,2};
		System.out.println(search(array, 0, array.length-1, 3));
		
	}

}
