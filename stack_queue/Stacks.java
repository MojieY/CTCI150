package stack_queue;

public class Stacks {

	private static class Node {

		int data;
		Node next;
		

		Node(int x) {
			this.data = x;
		}
	}

	private Node top;
	private int size = 0;
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}


	int min = 0;
	
	public Stacks() {
		top = null;
	}
	
	public boolean isEmpty(){
		if(top == null){
			return true;
		}
		return false;
	}
	
	public void push(int x) {
		if(top == null){
			Node t = new Node(x);
			top = t;
			min = x;
		} else {
		Node t = new Node(x);
		t.next = top;
		top = t;
		if(min > x){
			min = x;
		}
		}
		size++;
	}
	
	public void pop(){
		if(top != null){
			top = top.next;
			size--;
			}
		
	}

	public int get(int x) {
		Node temp = top;
		for (int i = 0; i < x; i++) {
			temp = temp.next;
		}
		return temp.data;
	}
	
	public int min(){
		return min;
	}
	

	public static void main(String[] args) {
		
		/*StackSet set = new StackSet();
		for(int i = 0; i<15; i++){
			set.push(i);
		}
		for(int i = 0; i<set.sizeall; i++){
			System.out.print(set.get2(i)+" ");
		}
		set.pop();set.pop();
		set.pop();set.pop();
		set.pop();set.pop();
		
		for(int i = 0; i<set.sizeall; i++){
			System.out.print(set.get2(i)+" ");
		}
		*/
		int[] array = { 1, 2, 3, 4, 5, 6, 12, 8, 9 };

		Stacks stack1 = new Stacks();
		Stacks stack2 = new Stacks();
		Stacks stack3 = new Stacks();
		for (int i = 0; i < array.length/3; i++) {
			stack1.push(array[i]);
			stack2.push(array[i + 3]);
			stack3.push(array[i + 6]);
		}
		System.out.print("stack1: ");
		for (int i = 0; i < stack1.size; i++) {
			System.out.print(stack1.get(i)+" ");
		}
		System.out.println();
		System.out.print("stack2: ");
		for (int i = 0; i < stack2.size; i++) {
			System.out.print(stack2.get(i)+" ");
		}
		System.out.println();
		System.out.print("stack3: ");
		for (int i = 0; i < stack2.size; i++) {
			System.out.print(stack3.get(i)+" ");
		}
		System.out.println();
		System.out.print("stack3 min: "+ stack3.min);
		System.out.println();
		System.out.println("stack1 pop!");
		stack1.pop();
		stack1.pop();
		for (int i = 0; i < stack1.size; i++) {
			System.out.print("now stack1: "+stack1.get(i));
		}
		
	}
	

}
