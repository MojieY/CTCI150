package tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinarySearchTree  {
	
	private static class BinaryNode{
		
		BinaryNode(int value){
			this.value = value;
			this.left = null;
			this.right = null;
			this.parent = null;
		}
		
		BinaryNode(int value, BinaryNode lt, BinaryNode rt){
			this.value = value;
			this.left = lt;
			this.right = rt;
			lt.parent = this;
			rt.parent = this;
		}
		int value;
		BinaryNode left;
		BinaryNode right;
		BinaryNode parent;
	}
	
	private BinaryNode root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public void makeEmpty(){
		root = null;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public boolean contains(int x){
		return contains(x, root);
	}
	
	public int findMin(){
		if(isEmpty()) return 0;
		return findMin(root).value;
	}
	
	public int findMax(){
		if(isEmpty()) return 0;
		return findMax(root).value;
	}
	
	public void insert(int x){
		root = insert(x, root);
	}
	
	public void remove(int x){
		root = remove(x, root);
	}
	
	public void printTree(){
		
	}
	//this operation requires returning true if there is a node in tree T that has item X
	private boolean contains(int x, BinaryNode t){
		if(t == null)
			return false;
		
		if(x < t.value)
			return contains(x, t.left);
		else if(x > t.value)
			return contains(x, t.right);
		else
			return true;
		}
	/*
	public class BinarySearchTree{
		private BianryNode root;
		private Comparator cmp;
		
		public BinarySearchTree(){}
		
		public BinarySearchTree(Comparator c){
			this.root = nul;
			this.cmp = c;
		}
		private int myCompare(int lhs, int rhs){
			if(cmp != null) return cmp.compare(lhs, rhs);
			else return ((comparable)lhs).compareTo(rhs);
		}
		
		private boolean contains(int x, BinaryNode t){
			if(t == null)
				return false;
			int compareResult = myCompare(x, t.elemet);
			
			if(compareResult < 0){
				return contains(x.left);
				if(compareResult < 0){
					return contains(x, t.left);
				}
				else if(compareResult >0){
					return contains(x, t.right);
				}
				else{
					return true;
				}
			}
		}
	}
	*/
//Find the minimal element. start at the root and go left as long as there is a left child. the stopping point 
//is the smallest element.
	private BinaryNode findMin(BinaryNode t){
		if(t == null){
			return null;
		}
		else if(t.left == null){
			return t;
		}
		return findMin(t.left);
	}
//no recursive way
	private BinaryNode findMax(BinaryNode t){
		if(t != null)
			while(t.right != null)
				t = t.right;
		return t;
	}
//using recursive way to find the position to insert	
	private BinaryNode insert(int x, BinaryNode t){
		if(t == null)
			return new BinaryNode(x);
		if(x < t.value)
			t.left = insert(x, t.left);
		else if(x > t.value)
			t.right = insert(x, t.right);
		return t;
	}
	
	private BinaryNode remove(int x, BinaryNode t){
		if(t == null)
			return t;
		if(x < t.value)
			t.left = remove(x, t.left);
		else if(x > t.value)
			t.right = remove(x, t.right);
		else if(x == t.value && t.left != null && t.right != null){
			t.value = findMin(t.right).value;
			t.right = remove(t.value, t.right);
		}
		else
			t = (t.left != null) ? t.left : t.right;
		return t;
	}
//Question: implement a function to check if a binary tree is balanced. a balanced tree is defined to be a tree
//such that the heights of the two subtrees of any node never differ by more than one.
	//this code runs in O(n) time and O(log N) space
	public static int check(BinaryNode node){
		if(node == null){
			return -1;
		}
		int leftHeight = check(node.left);
		if(leftHeight == -1){
			return -1;
		}
		int rightHeight = check(node.right);
		if(rightHeight == -1){
			return -1;
		}
		
		int currentHeight = leftHeight - rightHeight;
		if(Math.abs(currentHeight)>1){
			return -1;
		}
		else{
			return Math.max(rightHeight, leftHeight)+1;
		}
		
	}
	public static boolean isBalanced(BinaryNode node){
		if(check(node) == 1){
			return true;
		}
		else{
			return false;
		}
	}
	
//Question: Given a sorted array, write an algorithm to create a binary search tree with minimal height.
	public BinaryNode bstArray(int[] array, int begin, int end){
		if(end < begin)
			return null;
		int mid = (begin+end)/2;
		BinaryNode midNode = new BinaryNode(array[mid]);
		midNode.left = bstArray(array, begin, mid-1);
		midNode.right = bstArray(array, mid+1, end);
		return midNode;
		
	}

//Question: Given a binary search tree, design an algorithm which create a linked list of all the nodes at each depth.
	//method1: 递归法
	public void createLinkedList(BinaryNode node, int level, ArrayList<LinkedList<BinaryNode>> lists){
		if(node == null){
			return;
		}
		
		LinkedList<BinaryNode> list = new LinkedList<BinaryNode>();
		
		if(lists.size() == level){
			lists.add(list);
		}
		else{
			list = lists.get(level);
		}
		list.add(node);
		
		createLinkedList(node.left, level+1, lists);
		createLinkedList(node.right, level+1, lists);
	}
	
	//method2: 广域遍历法
	public ArrayList<LinkedList<BinaryNode>> createLinkedList2(BinaryNode node){
		if(node == null)
			return null;
		
		ArrayList<LinkedList<BinaryNode>> result = new ArrayList<LinkedList<BinaryNode>>();
		LinkedList<BinaryNode> current = new LinkedList<BinaryNode>();
		current.add(node);
		result.add(current);
		
		while(current.size() > 0){
			LinkedList<BinaryNode> parents = current;
			current = new LinkedList<BinaryNode>();
			for(BinaryNode parent : parents){
				if(parent.left != null)
				current.add(parent.left);
				if(parent.right != null)
				current.add(parent.right);
			}
			result.add(current);
		}
		return result;
	}

//Question: check whether a tree is a binary search tree
	//method1: copy all the node in a arraylist from the smallest to the largest
	public static int index = 0;
	public static void determineBST_COPY(BinaryNode node, ArrayList<Integer> list){
		if(node == null)
			return;
		determineBST_COPY(node.left, list);
		list.add(node.value);
		determineBST_COPY(node.right, list);
		}
	
	public static boolean determinBST_CHECK(BinaryNode node){
		ArrayList<Integer> list = new ArrayList<Integer>();
		determineBST_COPY(node, list);
		for(int i = 0; i<list.size(); i++){
			if(list.get(i) > list.get(i+1))
				return false;
		}
		return true;
	}
	//method2	
	public static int lastPrint = Integer.MIN_VALUE;
	
	public static boolean checkBST(BinaryNode node){
		if(node == null) return true;
		
		if(!checkBST(node.left)) return false;
		
		if(node.value > lastPrint){
			lastPrint = node.value;
		}
		
		if(!checkBST(node.right)) return false;
		
		return true;
	}
	
	//method3:
	private static boolean checkBST2(BinaryNode node, int min, int max){
		if(node == null) return true;
		
		if(node.value < min || node.value > max) return false;
		
		if(!checkBST2(node.left, min, node.value) || !checkBST2(node.right, node.value, max));
		return false;
	}
	
	public static boolean checkBST2_implement(BinaryNode root){
		return checkBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	//Question: Finding the next node using in-order traversal
	public static BinaryNode inorderSucc(BinaryNode node){
		if(node == null) return null;
		
		if(node.right != null){
			return leftMostChild(node.right);
		}
		else {
			BinaryNode q = node;
			BinaryNode x = q.parent;
			
			while(x.parent != null && x.left != q){
				q = x;
				x = x.parent;
			}
			return x;
		}
	}
	
	private static BinaryNode leftMostChild(BinaryNode node){
		if(node == null) return null;
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
	
//Question: You have two very large trees: T1 with millions of nodes, AND T2, with hundreds 
//of nodes. create a algorithm to decide if T2 is a subtree of T1.
	//a tree T2 is a subtree of t1 if there exist a node in n in T1 such that the subtree of
	//n is identical to T2. That is, if you cut off the tree at the node n, the two trees would 
	//be the same.
	public static boolean checkSubTree(BinaryNode t1, BinaryNode t2){
		
		//如果t2是null，则一定是t1的子树
		if(t2 == null){
			return true;
		}
		//如果t2不为空，t1为空，则一定不是子树
		else if (t1 == null){
			return false;
		}
		//如果均不是空集，跳到下一步骤
		return checkMatch(t1, t2);
	}
	//此函数的作用是寻找t1, t2一致的node，作为子树的起点
	private static boolean checkMatch(BinaryNode t1, BinaryNode t2){
		//基本情况，如果迭代过程中发现t1到底了，则说明没有子树
		if(t1 == null){
			return false;
		}
		//找到一处一致的
		if(t1.value == t2.value){
			//跳到下一步骤
			if(match(t1, t2)){
				return true;
			}
		}
		//没找到？找t1的左孩子和右孩子
		return (checkMatch(t1.left, t2) ||checkMatch(t1.right, t2));
		
	}
	
	//此函数的目的是在找到可能的子树根节点的情况下，继续判断其孩子是否同样一致
	private static boolean match(BinaryNode t1, BinaryNode t2){
		//底层情况，同时遍历完成
		if(t2 == null && t1 == null){
			return true;
		}
		//若有一个先到底，跪
		if(t1 == null || t2 == null){
			return false;
		}
		//若值不同，跪
		if(t1.value != t2.value){
			return false;
		}
		//若相同，继续向下
		else{
			return (match(t1.left, t2.left) && match(t1.right, t2.right));
		}
	}
	
//Question: print all paths which sum to a given value
	//从root开始向下遍历，每个节点自底向上寻找。发现值相等，即打印
	private static void findSum(BinaryNode node, int[] path, int level, int sum){
		if(node == null){
			return;
		}
		
		path[level] = node.value;
		
		int temp = 0;
		for(int i = level; i>=0; i--){
			temp += path[level];
			if(temp == sum){
				print(path);
			}
		}
		
		findSum(node.left, path, level+1, sum);
		findSum(node.right, path, level+1, sum);
	}
	
	private static int findLevel(BinaryNode node){
		if(node == null){
			return 0;
		}
		return(1+Math.max(findLevel(node.left), findLevel(node.right)));
	}
	
	private static void print(int[] path){
		for(int i = 0; i<path.length; i++){
			System.out.print(path[i]);
		}
	}
	
	public static void findPath(BinaryNode node, int sum){
		if(node == null) return;
		
		int level = findLevel(node);
		int[] path = new int[level];
		
		findSum(node, path, 0, sum);
	}
	public static void main(String[] args) {
		

	}

}
