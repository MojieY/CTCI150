package tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree {
	
	private TreeNode root;
	
	public BinaryTree(){};
	
	public BinaryTree(TreeNode root){
		this.root = root;
	}
	
	public TreeNode getRoot(){
		return root;
	}

	public void setRoot(TreeNode root){
		this.root = root;
	}
	
	static class TreeNode{
		private int data;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int data){
			this.data = data;
		}
		
		public TreeNode(int data, TreeNode left, TreeNode right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public int getData(){
			return data;
		}
		
		public void setData(int data){
			this.data = data;
		}
		
		public TreeNode getLeft(){
			return left;
		}
		
		public void setLeft(TreeNode left){
			this.left = left;
		}
		
		public TreeNode getRight(){
			return right;
		}
		
		public void setRight(TreeNode right){
			this.right = right;
		}
		
	}
	
	public TreeNode getParent(TreeNode element){
		return (root == null || root == element) ? null:parent(root, element);
	}
	
	public TreeNode parent(TreeNode subTree, TreeNode element){
		if(subTree == null)
			return null;
		if(subTree.getLeft() == element || subTree.getRight() == element)
			return subTree;
		TreeNode p;
		if((p = parent(subTree.getLeft(), element)) != null)
			return p;
		else
			return parent(subTree.getRight(), element);
	}
	
	public int getSize(){
		return getNum(root);
	}
	
	public int getNum(TreeNode node){
		if(node == null){
			return 0;
		}
		else
		{
			int i = getNum(node.getLeft());
			int j = getNum(node.getRight());
			return j+i+1;
		}
	}
	
	public int getHeight(){
		return getHeight(root);
	}
	
	public int getHeight(TreeNode node){
		if(node == null)
			return 0;
		else
		{
			int i = getHeight(node.getLeft());
			int j = getHeight(node.getRight());
			return (i<j) ? (j+1) : (i+1);
		} 
	}
	
	public void preOrder(TreeNode node){
		if(node != null){
			System.out.println(node.getData());
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	
	public void inOrder(TreeNode node){
		if(node != null){
			inOrder(node.getLeft());
			System.out.println(node.getData());
			inOrder(node.getRight());
		}
	}
	
	public void postOrder(TreeNode node){
		if(node != null){
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.println(node.getData());
		}
	}
	
	public static int checkHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		
		int leftHeight = checkHeight(root.getLeft());
		if(leftHeight == -1){
			return -1;
		}
		int rightHeight = checkHeight(root.getRight());
		if(rightHeight == -1){
			return -1;
		}
		int heightDiff = rightHeight - leftHeight;
		if(Math.abs(heightDiff)>1){
			return -1;
		}else{
			return Math.max(leftHeight, rightHeight)+1;
		}
	}
	
	public static boolean isBanlanced(TreeNode node){
		if(checkHeight(node) == -1){
			return false;
		}
		else{
			return true;
		}
	}
	
	public static TreeNode createMinimalBST(int arr[], int start, int end){
		if(end<start){
			return null;
		}
		int mid = (start+end)/2;
		TreeNode n = new TreeNode(arr[mid]);
		//n.data = mid;
		n.left = createMinimalBST(arr, start, mid-1);
		n.right = createMinimalBST(arr, mid+1, end);
		return n;
	}
	
	public static TreeNode createMinimalBST(int array[]){
		return createMinimalBST(array, 0, array.length-1);
	}
	
	static void createLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
		if(root == null) return;
		
		LinkedList<TreeNode> list = null;
		if(lists.size() == level){
			list = new LinkedList<TreeNode>();
			lists.add(list);
		}
		else{
			list = lists.get(level);
		}
		list.add(root);
		createLinkedList(root.left, lists, level+1);
		createLinkedList(root.right, lists, level+1);
	}
	
	static ArrayList<LinkedList<TreeNode>> createLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLinkedList(root, lists, 0);
		return lists;
	}
	 public static void main(String[] args)
	    {
		 	
	        int[] array = {1,2,3,4,5,6,7};
	        TreeNode root = createMinimalBST(array);

	        BinaryTree bt = new BinaryTree(root);
	        System.out.println("=======先序遍历======");
	        bt.preOrder(bt.getRoot());
	        System.out.println("=======中序遍历======");
	        bt.inOrder(bt.getRoot());
	        System.out.println("========后续遍历=======");
	        bt.postOrder(bt.getRoot());
	        System.out.println("===========");
	        System.out.println("height: "+bt.getHeight());
	        System.out.println("size: "+bt.getSize());
	        System.out.println("===========");
	        ArrayList<LinkedList<TreeNode>> list = createLinkedList(root);
	        
	        for(int i = 0; i<list.size(); i++){
	        	for(int j = 0; j<list.get(i).size(); j++)
	        	System.out.println(list.get(i).get(j).data);
	        }
	        System.out.println("===========");
	        System.out.println("balanced? "+BinaryTree.isBanlanced(root));
	    }
	}