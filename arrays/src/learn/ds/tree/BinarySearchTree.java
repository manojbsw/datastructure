package learn.ds.tree;

public class BinarySearchTree {

private TreeNode root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public void insert(int value) {
		root = insertNode(root, value);
	}
	
	private TreeNode insertNode(TreeNode root, int value) {
		
		if(root == null) {
			root = new TreeNode(value);
		}
		
		if(value < root.value) {
			root.leftChild = insertNode(root.leftChild, value);
		}
		else if(value > root.value){
			root.rightChild = insertNode(root.rightChild, value);
		}
		
		return root;
	}
	
	public void print() {
		printInOrder(root);
	}
	
	private void printInOrder(TreeNode root) {
		
		if(root != null) {
			printInOrder(root.leftChild);
			System.out.println(root.value);
			printInOrder(root.rightChild);
			
		}
		
	}
	
	public int secondLargetInBst() {
		
		TreeNode parentRoot = root;
		TreeNode childRoot = parentRoot.rightChild;
		int secondLarget = 0;
		while(childRoot != null) {
			
			if(childRoot.rightChild  == null && childRoot.leftChild == null) {
				
				secondLarget = parentRoot.value;
				
			} else if(childRoot.rightChild == null) {
				secondLarget = childRoot.leftChild.value;
			}
			
			childRoot = childRoot.rightChild;
			parentRoot = parentRoot.rightChild;
		}
		return secondLarget;
	}

}
