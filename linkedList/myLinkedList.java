package linkedList;

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

	public void reverse() {
		myLinkedList list = new myLinkedList();
		Node temp = head;
		list.addBegin(head.data);
		while (temp.next != null) {
			temp = temp.next;
			list.addBegin(temp.data);
		}
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

	public static int specialAdd(myLinkedList A, myLinkedList B) {
		int count = 0;
		int sum1 = 0;
		int sum2 = 0;
		Node temp1 = A.head;
		Node temp2 = B.head;

		while (temp1.next != null) {
			sum1 += (temp1.data * Math.pow(10, count));
			count++;
			temp1 = temp1.next;
		}
		sum1 += (temp1.data * Math.pow(10, count));
		System.out.println(sum1);

		count = 0;
		while (temp2.next != null) {
			sum2 += (temp2.data * Math.pow(10, count));
			count++;
			temp2 = temp2.next;
		}
		sum2 += (temp2.data * Math.pow(10, count));
		System.out.println(sum2);
		return sum1 + sum2;
	}

	public static void main(String[] args) {
		myLinkedList list = new myLinkedList();

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

		list.insertionSort();

		for (int x = 0; x < list.length(); x++) {
			System.out.print(list.get(x));
		}

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
