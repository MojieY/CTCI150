package linkedList;

public class Circular_list {
	
	class Node{
		int data;
		Node next;
		Node(int x, Node next){
			this.data = x;
			this.next = next;
		}
	}
		private Node head;
		private Node tail;
		private int size = 0;
		
		public Circular_list(){
			head = null;
			tail = null;	
		}
		
		public void add(int x){
			if(head == null){
				Node temp = new Node(x, null);
				head = temp;
				tail = temp;
				head.next = tail;
				tail.next = head;
			}
			else{
			head = new Node(x, head);
			}
			size++;
		}
		
		public void delete(int x){
			Node temp = head;
			while(temp.next.data!= x){
				temp = temp.next;
			}
			//temp.next.next = null;
			temp.next = temp.next.next;
			size--;
		}
		
		public Node search(int x){
			Node temp = head;
			while(temp.next != head){
				if(temp.data == x){
					return temp;
				}
				temp = temp.next;
			}
			return null;
		}
		
		public int size(){
			
			return size;
			
		}
		
		public Node get(int index){
			Node temp = head;
			for(int x = 0; x<index; x++){
				temp = temp.next;
			}
			return temp;
		}
//Question: 寻找环的起点(入口)		
		public Node FindBeginning(Circular_list list){
			
			Node slow = list.head;
			Node fast = list.head;
			
			while(fast != null && fast.next != null){
				fast = fast.next.next;
				slow = slow.next;
				if(slow == fast){
					break;
				}
			}
			if(fast == null || fast.next == null){
				return null;
			}
			
			slow = head;
			while(slow != fast){
				slow = slow.next;
				fast = fast.next;
			}
			return fast;
		}

	public static void main(String[] args) {
		
		Circular_list list = new Circular_list();
		
		System.out.println(list.size());
		for(int x = 0; x < 10; x++){
			list.add(x);
		}
		for(int x = 0; x < 10; x++){
			System.out.print(list.get(x).data+" ");
		}
		list.delete(3);
		list.delete(4);
		System.out.println();
		System.out.println(list.size());
		for(int x = 0; x < list.size(); x++){
			System.out.print(list.get(x).data+" ");
		}
		System.out.println();
		Node temp = list.search(5);
		System.out.println(temp.data);

	}

}
