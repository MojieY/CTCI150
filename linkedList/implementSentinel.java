package linkedList;

public class implementSentinel {

	public static class Node {
		Object data;
		Node prev;
		Node next;
	}
	
	private Node pre;
	private Node post;
	private int num;

	public implementSentinel() {
		pre = new Node();
		post = new Node();
		pre.next = post;
		post.prev = pre;
		
	}
	
	public int size(){
		return num;
	}

	public void addFirst(int x) {
		Node first = pre.next;
		Node node = new Node();
		node.data = x;
		node.next = first;
		node.prev = pre;
		pre.next = node;
		first.prev = node;
		num++;
	}

	public void deleteEnd() {
		post.prev.prev.next = post;
		post.prev = post.prev.prev;
		num--;
		
	}
	

	public Object get(int index) {
		Node temp = pre.next;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	public static void main(String[] args) {
		implementSentinel list = new implementSentinel();
		for (int i = 0; i < 10; i++) {
			list.addFirst(i);
		}
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
		
		System.out.println();
		
		list.deleteEnd();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
		
			
		
	}

}
