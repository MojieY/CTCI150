package tree;

public class AVLTree {
	
	private static class AvlNode{
		AvlNode(int value){
			this.value = value;
		}
		AvlNode(int value, AvlNode lt, AvlNode rt){
			this.value = value;
			this.left = lt;
			this.right = rt;
		}
		
		int value;
		AvlNode left;
		AvlNode right;
		int height;
	}
	
	private int height(AvlNode t){
		return t == null ? -1:t.height;
	}
	
	private AvlNode insert(int x, AvlNode t){
		if(t == null)
			return new AvlNode(x, null, null);
		if(x < t.value){
			t.left = insert(x, t.left);
		}
		if(x > t.value){
			t.right = insert(x, t.right);
		}
		return balance(t);
	}
	
	private static final int ALLOWED_IMBALANCE = 1;
	
	private AvlNode balance(AvlNode t){
		if(t == null)
			return t;
		if(height(t.left) - height(t.right) > ALLOWED_IMBALANCE)
			if(height(t.left.left) >= height(t.left.right))
				t = rotateWithLeftChild(t);
			else
				t = doubleWithLeftChild(t);
		else
			if(height(t.right) - height(t.left) > ALLOWED_IMBALANCE)
				if(height(t.right.right) >= height(t.right.left))
					t = rotateWithRightChild(t);
				else
					t = doubleWithRightChild(t);
		
		t.height = Math.max(height(t.left), height(t.right))+1;
		return t;
	}
	
	private AvlNode rotateWithLeftChild(AvlNode k2){
		AvlNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), k2.height) + 1;
		return k1;
	}
	
	private AvlNode rotateWithRightChild(AvlNode k1){
		AvlNode k2 = k1.right; 
		k1.right = k2.left;
		k2.left = k1;
		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		k2.height = Math.max(k1.height, height(k2.right)) + 1;
		return k2;
	}
	
	private AvlNode doubleWithLeftChild(AvlNode k3){
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}
	
	private AvlNode doubleWithRightChild(AvlNode k4){
		k4.right = rotateWithLeftChild(k4.right);
		return rotateWithRightChild(k4);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
