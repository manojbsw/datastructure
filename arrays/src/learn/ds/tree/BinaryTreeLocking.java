package learn.ds.tree;

/**
 * Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.

Design a binary tree node class with the following methods:

    is_locked, which returns whether the node is locked
    lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true.
    unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true.

You may augment the node to add parent pointers or any other property you would like. You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes. Each method should run in O(h), where h is the height of the tree.
 * 
 * @author manoj
 *https://www.geeksforgeeks.org/locking-and-unlocking-of-resources-in-the-form-of-n-ary-tree/
 */
public class BinaryTreeLocking {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);
		TreeNode node = new TreeNode(8);
		root.leftChild = node;
		node = new TreeNode(9);
		root.rightChild = node;
		root.leftChild.parentNode = root;
		root.rightChild.parentNode = root;
		
		
		root = root.leftChild;
		node = new TreeNode(7);
		root.leftChild = node;
		node = new TreeNode(6);
		root.rightChild = node;
		root.leftChild.parentNode = root;
		root.rightChild.parentNode = root;
		
		root = root.rightChild;
		TreeNode someNode = root;
		node = new TreeNode(5);
		root.leftChild = node;
		node = new TreeNode(4);
		root.rightChild = node;
		root.rightChild.parentNode = root;
		root.leftChild.parentNode = root;
		
		System.out.println("Lock node " + someNode.lock());
		System.out.println("Lock node " + someNode.lock());
		System.out.println("Lock node " + someNode.un_lock());
		System.out.println("Lock node " + someNode.lock());
	}

	
}

class TreeNode {
	
	int value;
	TreeNode parentNode;
	TreeNode leftChild;
	TreeNode rightChild;
	boolean is_locked;
	int decendentLocked;
	
	public TreeNode(int value) {
	     this.value = value;
	}
	
	public void addLeftChild(TreeNode node) {
		this.leftChild = node;
	}
	
	public void addRightChild(TreeNode node) {
		this.rightChild = node;
	}
	
	public void setParent(TreeNode node) {
		node.parentNode = this;
	}
	
	public boolean isLock() {
		return is_locked;
	}
	
	public boolean lock() {
		if(!is_locked && decendentLocked == 0) {
			TreeNode parent = this.parentNode;
			boolean ancestor = false;
			while(parent != null) {
				if(parent.is_locked) {
					ancestor = true;
				}
				parent = parent.parentNode;
			}
			if(ancestor) {
				return false;
			}
 			is_locked = true;
 			
 			parent = this.parentNode;
 			while(parent != null) {
 				parent.decendentLocked++;
				parent = parent.parentNode;
				
			}
 			return true;
		}
		return false;
	}
	
	public boolean un_lock() {
		is_locked = false;
		if( decendentLocked > 0) {
			decendentLocked--;
			TreeNode parent = this.parentNode;
			while(parent != null) {
				if(parent.decendentLocked > 0) {
					parent.decendentLocked--;
				}
				parent.decendentLocked++;
			}
		}
		return true;
	}
}