package linkedList;

import java.util.Hashtable;

public class myLinkedList {

	private static class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		
	}

	private Node head;

	public myLinkedList() {
		head = null;

	}

	public void insertionSort() {
		if (head == null && head.next == null) {
			return;
		}
		int n = 1;
		Node temp = head;
		while (temp.next.next != null) {
			Node sorted = head;
			temp = head;

			for (int i = 0; i < n - 1; i++) {
				temp = temp.next;
			}
			Node current = temp.next;
			System.out.println(current.data);

			if (head.data >= current.data) {

				head = new Node(current.data, head);
				temp.next = temp.next.next;

			} else {

				while (sorted != temp) {

					if (sorted.data <= current.data
							&& sorted.next.data > current.data) {
						Node bigger = sorted.next;
						temp.next = temp.next.next;
						sorted.next = current;
						current.next = bigger;
						break;
					} else {
						sorted = sorted.next;

					}

				}
			}
			n++;
		}

		if (temp.next.next == null) {
			Node sorted = head;
			temp = head;

			for (int i = 0; i < n - 1; i++) {
				temp = temp.next;
			}
			Node current = temp.next;
			System.out.println(current.data);

			if (head.data >= current.data) {

				head = new Node(current.data, head);
				temp.next = null;

			} else {

				while (sorted != temp) {

					if (sorted.data <= current.data
							&& sorted.next.data > current.data) {
						Node bigger = sorted.next;
						temp.next = null;
						sorted.next = current;
						current.next = bigger;
						break;
					} else {
						sorted = sorted.next;

					}

				}
			}
			n++;
		}

	}

	public void addEnd(int x) {
		if (head == null) {
			head.data = x;
			head.next = null;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(x, null);
		}
	}

	public void addBegin(int x) {
		if (head == null) {
			head = new Node(x, null);
		} else {
			head = new Node(x, head);
		}
	}

	public int length() {
		int x = 0;
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
			x++;
		}
		return x + 1;
	}

	public int get(int index) {
		Node temp = head;
		for (int x = 0; x < index; x++) {
			temp = temp.next;
		}
		return temp.data;
	}

	public void delete(int x) {
		if (x == 0 || head.next == null) {
			head.next = head;
			head = null;
		} else {
			Node temp = head;

			for (int i = 0; i < x - 1; i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
		}
	}
//Question: write a code to partition a linked list around a value x, such that all nodes less
//than x come before all nodes greater than or equal to x.
	public static Node partition(myLinkedList list, int x){
		
		//node begin and end is the head of the "small list" and "big list"
		Node begin = null;
		Node end = null;
		
		//traverse the whole list
		Node current = list.head;
		if(list.length() < 2){
			return current;
		}
		while(current != null){
			Node next = current.next;
			if(current.data < x){
				current.next = begin;
				begin = current;
			}
			else {
				current.next = end;
				end = current;
			}
			current = next;
		}
		if(begin == null){
			return end;
		}
		else{
			Node head = begin;
			while(begin.next!=null){
				begin = begin.next;
			}
			begin.next = end;
			return head;
		}
	}

	
//********Question：remove duplicate data from unsorted linked list********//
//method one: runs in O(1) space, but O(n^2) time
	public static void rmDuplicate(myLinkedList list) {
		if (list == null || list.head.next == null) {
			return;
		} else {
			Node current = list.head;
			while (current.next != null) {
				Node runner = current;
				while (runner.next != null) {
					if (runner.next.data != current.data) {
						runner = runner.next;
					} else {
						runner.next = runner.next.next;
					}
				}
				current = current.next;
			}
		}
	}

//method2:O(N) time, but extra space needed.
//使用了hashtable，以及containsKey方法
	public static void removeDuplicate(myLinkedList list){
		Node previous = null;
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		if(list == null || list.head.next == null){
			return;
		} else {
			Node current = list.head;
			while(current!= null){
				if(table.containsKey(current.data)){
					previous.next = current.next;
				}
				else{
					table.put(current.data, true);
					previous = current;
				}
				current = current.next;
			}
		}
	}
	public void reverse() {
		myLinkedList list = new myLinkedList();
		Node temp = head;
		list.addBegin(head.data);
		while (temp.next != null) {
			temp = temp.next;
			list.addBegin(temp.data);
		}
	}
	public static myLinkedList reverse(myLinkedList list) {
		myLinkedList newList = new myLinkedList();
		Node temp = list.head;
		newList.addBegin(temp.data);
		while (temp.next != null) {
			temp = temp.next;
			newList.addBegin(temp.data);
		}
		return newList;
	}

	public void deleteMiddle() {
		Node current = head;
		Node runner = head.next.next;
		while (runner.next != null) {
			runner = runner.next.next;
			current = current.next;
		}
		current.next = current.next.next;
	}

//*******Question: Return the kth element from the last**********//
//method 1: just print the data.无法返回node类型
	public static int getFromLast(Node head, int k) {
		if (head == null) {
			return 0;
		}
		int i = getFromLast(head.next, k) + 1;
		if (i == k) {
			System.out.println(head.data);
		}
		return i;
	}
//method 2: using class intWrapper to store the value, when the value == k, we find the
//kth element.
	
	
	public static Node getFromLast2(Node head, int k, int intWrapper){
		if(head == null){
			return null;
		}
		Node node = getFromLast2(head.next, k, intWrapper);
		intWrapper++;
		if(intWrapper == k){
			
			return head;
		}
		return node;
	}

	public static Node getFromLast3(Node head, int k){
		if(k<0)
			return null;
		Node p1 = head;
		Node p2 = head;
		
		for(int i = 0; i<k-1; i++){
			if(p1 == null){
				return null;
			}
			p1 = p1.next;
		}
		if(p1 == null) return null;
		
		while(p1.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
	
//Question: check the palindrome
	//判断是否回文
	public static boolean detectPalindrome(myLinkedList A){
		
		//首先逆序
		myLinkedList B = reverse(A);
		
		Node headA = A.head;
		Node headB = B.head;
		
		while(headA != null && headB != null){
			if(headA.data != headB.data){
				return false;
			}
			System.out.print(headA.data);
			System.out.print(headB.data);
			headA = headA.next;
			headB = headB.next;
		}
		return true;
	}
	
//Question: You have two numbers represented by a linked list, where each node contains
//a single digit.The digit are stored in reverse order, such that the first digit is at 
//head of the list.
	
//first method:
	public static int specialAdd(myLinkedList A, myLinkedList B) {
		int count = 0;
		int sum1 = 0;
		int sum2 = 0;
		Node temp1 = A.head;
		Node temp2 = B.head;

		while (temp1!= null) {
			sum1 += (temp1.data * Math.pow(10, count));
			count++;
			temp1 = temp1.next;
		}
		
		System.out.println(sum1);

		count = 0;
		while (temp2 != null) {
			sum2 += (temp2.data * Math.pow(10, count));
			count++;
			temp2 = temp2.next;
		}
		
		System.out.println(sum2);
		return sum1 + sum2;
	}
	
//second method:	
	public static int specialAdd2(myLinkedList A, myLinkedList B){
		if(A == null && B == null){
			return 0;
		}
		Node headA = A.head;
		Node headB = B.head;
		
//carry是进位，value是单纯的对应位数字相加+进位数的和，count是计算当前是第几位，sum是最终结果	
		int carry = 0;
		int value = 0;
		int count = 0;
		int sum = 0;
		
//情况1：两个list都没有到底		
		while(headA != null && headB != null){
			value = headA.data+headB.data+carry;
			carry = value/10;
			sum = (int) (sum + (value%10)*Math.pow(10, count));
			headA = headA.next;
			headB = headB.next;
			count ++;
		}
//情况2：其中有一个list到底，另外一个没有
		while(headA != null){
			value = headA.data+carry;
			carry = value/10;
			sum = (int) (sum + (value%10)*Math.pow(10, count));
			headA = headA.next;
			count++;
		}
		
		while(headB != null){
			value = headB.data+carry;
			carry = value/10;
			sum = (int) (sum + (value%10)*Math.pow(10, count));
			headB = headB.next;
			count++;
		}
//情况3：两个都到底，但是还有进位		
		while(carry != 0){
			value = carry;
			carry = value/10;
			sum = sum+(int) ((value%10)*Math.pow(10, count));
		}
		//返回最终值
		return sum;
	}

	public static void main(String[] args) {
		myLinkedList list1 = new myLinkedList();
		//myLinkedList list2 = new myLinkedList();
		list1.addBegin(1);
		list1.addBegin(2);
		list1.addBegin(9);
		list1.addBegin(2);
		list1.addBegin(1);
		
		System.out.println(detectPalindrome(list1));
		/*
		list2.addBegin(9);
		list2.addBegin(9);
		list2.addBegin(9);
		list2.addBegin(9);
		list2.addBegin(1);
		
		int sum = specialAdd2(list1, list2);
		
		System.out.println(sum);
/*
		list.addBegin(4);
		list.addBegin(0);
		list.addBegin(3);
		list.addBegin(5);
		list.addBegin(7);
		list.addBegin(4);
		list.addBegin(1);
		list.addBegin(2);
		list.addBegin(4);

		for (int x = 0; x < list.length(); x++) {
			System.out.print(list.get(x));
		}
		System.out.println();
		//removeDuplicate(list);
		//list.insertionSort();
		/*
		 * myLinkedList list2 = new myLinkedList(); list2.addBegin(2);
		 * list2.addBegin(9); list2.addBegin(5);
		 * 
		 * int sum = 0;
		 * 
		 * sum = specialAdd(list, list2); System.out.println(sum);
		 * /*list.addBegin('P'); list.addBegin('U'); list.addBegin(' ');
		 * list.addBegin('W'); list.addBegin('O'); list.addBegin('L');
		 * list.addBegin('L'); list.addBegin('O'); list.addBegin('F');
		 * 
		 * getFromLast(list.head, 5);
		 * 
		 * list.deleteMiddle();
		 * 
		 * 
		 * //rmDuplicate(list);
		 * 
		 * for(int x = 0; x<list.length(); x++){ System.out.print(list.get(x));
		 * }
		 * 
		 * /*int n = 10000; long startTime = System.currentTimeMillis(); for
		 * (int i = 0; i < n; i++) { list.addBegin(i); } long endTime =
		 * System.currentTimeMillis(); long totalTime = endTime - startTime;
		 * System.out.println(totalTime); //
		 * ////////////////////////////////////////////////////////////
		 * LinkedList<Integer> newList = new LinkedList<Integer>(); startTime =
		 * System.currentTimeMillis(); for (int i = 0; i < n; i++) {
		 * newList.addFirst(i); ; } endTime = System.currentTimeMillis();
		 * totalTime = endTime - startTime; System.out.println(totalTime);
		 */
	}

}
