package sorting_searching;

public class EmptyStrings {

	public static int findMiddle(String[] str, int first, int last, String target){
		int middle = (first+last)/2;
		if(str[middle].isEmpty()){
			int left = middle-1;
			int right = middle+1;
			while(true){
				if(left<first && right>last){
					return -1;
				}
				else if(left>first && !str[left].isEmpty()){
					middle = left;
					break;
				}
				else if(right<last && !str[right].isEmpty()){
					middle = right;
					break;
				}
				else{
					left--;
					right++;
				}
			}
		}
		
		if(str[middle].compareTo(target)==0){
			return middle;
		}
		else if(str[middle].compareTo(target)<0){
			return findMiddle(str, middle+1, last, target);
		}
		else{
			return findMiddle(str, first, middle-1, target);
		}
			
	}
	public static void main(String[] args) {
		
		String[] array = {"apple","", "bpinapple", "", "", "ghost", "yamato", "zmelon"};
		System.out.println(findMiddle(array, 0, array.length, "ghost"));
	}

}
