package learn.ds.tree;

/**
 * This problem was asked by Dropbox.

Given the root to a binary search tree, find the second largest node in the tree.
 * @author manoj
 *
 */
public class SecondLargetElementBST {

	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(50);
		bst.insert(60);
		bst.insert(70);
		//bst.insert(80);
		bst.insert(20);
		bst.insert(30);
		bst.insert(40);

		System.out.println(bst.secondLargetInBst());
	}
	
	

}

