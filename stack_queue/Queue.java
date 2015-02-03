package stack_queue;

public class Queue {
	
	private static class Node{
		int data;
		Node next;
		
		Node(int x){
			this.data = x;
		}
	}
	
	private Node head;
	private Node tail;
	private int size = 0;
	
	private Queue(){
		head = null;
		tail = null;
	}
	
	public void ENQUEUE(int x){
		if(head == null){
			Node temp = new Node(x);
			head = temp;
			tail = temp;
			head.next = tail;
		} else{
		Node temp = new Node(x);
		tail.next = temp;
		tail = tail.next;
	}
		size++;
	}
	public void DEQUEUE(){
		if(head == null){
			return;
		}
		head = head.next;
		size--;
	}
	public Node get(int x){
		Node temp = head;
		for(int i = 0; i<x; i++){
			temp = temp.next;
		}
		return temp;
	}
	
	public static void main(String[] args) {
		
		Queue queue = new Queue();
		queue.ENQUEUE(1);
		queue.ENQUEUE(2);
		queue.ENQUEUE(3);
		
		for(int i = 0; i<queue.size; i++){
			System.out.print(queue.get(i).data);
		}
		System.out.println();
		queue.DEQUEUE();
		for(int i = 0; i<queue.size; i++){
			System.out.print(queue.get(i).data);
		}

	}

}
