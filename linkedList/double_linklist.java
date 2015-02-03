package linkedList;


public class double_linklist {
	
	class Node{
		int data;
		Node next;
		Node prev;
		
		Node(int x){
			this.data = x;
		}
	}
		private Node head;
		private Node tail;
		private int size = 0;
		
		public double_linklist(){
			head = null;
			tail = null;
		}
		
		public void add(int x){
			
			Node temp = new Node(x);
			if(head == null){
				head = temp;
				tail = temp;
			}
			else{
				head.prev = temp;
				temp.next = head;
				head = temp;
			}
			size++;
		}
		
		public Node search(int x){
			Node temp = head;
			while(temp.next != null){
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
			for(int x = 0; x < index; x++){
				temp = temp.next;
			}
			return temp;
		}
		
		public void partition(Node x){
			int key = x.data;
			System.out.println("key:"+key);
			Node h = head;
			System.out.println("h:"+h.data);
			Node t = tail;
			System.out.println("t:"+t.data);
			
			while(h.next!=t){
				//System.out.println("entrance");
				while(h.data < key){
					h = h.next;
					System.out.println(1);
				}
				while(t.data > key){
					t = t.prev;
					System.out.println(2);
				}
				int temp = h.data;
				h.data = t.data;
				t.data = temp;
				
				System.out.println("h"+h.data);
				System.out.println("t"+t.data);
			}
			
		}
		
		public static int specialAdd(double_linklist A, double_linklist B){
			int count = 0;
			int sum1 = 0;
			int sum2 = 0;
			Node temp1 = A.tail;
			Node temp2 = B.tail;
			
			while(temp1.prev!=null){
				sum1 += (temp1.data*Math.pow(10, count));
				count++;
				temp1 = temp1.prev;
			}
			sum1 += (temp1.data*Math.pow(10, count));
			System.out.println(sum1);
			
			count = 0;
			while(temp2.prev!=null){
				sum2 += (temp2.data*Math.pow(10, count));
				count++;
				temp2 = temp2.prev;
			}
			sum2 += (temp2.data*Math.pow(10, count));
			System.out.println(sum2);
			return sum1+sum2;
		}

	public static void main(String[] args) {
		
		double_linklist list = new double_linklist();
		double_linklist list2 = new double_linklist();
		
		list.add(2);
		list.add(1);
		list.add(5);
		
		list2.add(3);
		list2.add(4);
		list2.add(6);
		
		int sum = specialAdd(list, list2);
		System.out.print(sum);
		/*list.add(3);
		list.add(9);
		list.add(6);
		list.add(4);
		list.add(2);
		for(int i = 0; i<list.size; i++){
			System.out.print(list.get(i).data);
		}
		System.out.println();
		list.partition(list.get(2));
		System.out.println(list.get(2).data);
		
		for(int i = 0; i<list.size; i++){
			System.out.print(list.get(i).data);
		}
		*/
	}

}
