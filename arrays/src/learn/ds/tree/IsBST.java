package learn.ds.tree;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=MILxfAbIhrE
 * @author manoj
 *
 */
public class IsBST {

	public static void main(String[] args) {
      
		testBST bst = new testBST();
		
		int[] arr = {2,34,65,34,78,12,2};
		
		Arrays.stream(arr).forEach(d -> bst.Insert(d));
		System.out.println(bst.checkBST());
		bst.traverse();
	}

}

class testBST {
	
    TreeNode root;
    
    public testBST() {
    	root = null;
    }
	
	public void Insert(int data) {
		root = addNode(root, data);
	}
	
	public TreeNode addNode(TreeNode root, int data) {
		
		  if(root == null) {
			  return new TreeNode(data);
		  }
		  
		  if(data <= root.value) {
			  root.leftChild = addNode(root.leftChild, data);
		  }
		  
		  if(data > root.value) {
			  root.rightChild = addNode(root.rightChild, data);
		  }
		  
		  return root;
		
	}

	public boolean checkBST() {
		return IsBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
  public boolean IsBST(TreeNode root, int min, int max) {
	  
	  if(root == null) return true;
	  
	  if(root.value <= min || root.value > max) return false;
	  
	  return IsBST(root.leftChild, min, root.value) && IsBST(root.rightChild, root.value, max);
	  
  }
  
  public void traverse() {
	  inorderTraversal(root);
  }
  
  public void inorderTraversal(TreeNode root) {
	  
	  if(root == null) return;
	  inorderTraversal(root.leftChild);
	  System.out.println(root.value);
	  inorderTraversal(root.rightChild);
	  
  }
  
  public void BSTtoDoublyLinkedList() {
	  TreeNode head = null;
	  todoubly(root, head);
	  while(head != null) {
		  System.out.println(head.value);
		  head = head.leftChild;
	  }
  }
  
  public void todoubly(TreeNode root, TreeNode head) {
	  
	  if(root == null) return;
	  todoubly(root.leftChild, head);
	   if(head == null) {
		   head = root;
	   } else {
		   head.rightChild = root;
		   root.leftChild = head;
		   head = root;
	   }
	   
	   todoubly(root.rightChild, head);
	  
  }
}
