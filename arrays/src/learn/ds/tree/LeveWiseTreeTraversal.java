package learn.ds.tree;

import java.util.Stack;

/**
For example, given the following tree:

       1
    /     \
  2         3
 / \       / \
4   5     6   7

You should return [1, 2, 3, ,4, 5, ,6, 7].

 * @author manoj
 *
 */

public class LeveWiseTreeTraversal {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		printZigZagWithHeight(root);
	}
	
	public static void printZigZagWithHeight(Node root) {
		
		//Get tree height
		int height = getTreeHeight(root);
		for(int i=1; i<=height; i++) {
				printLeftToRightTree(root, i);
		}
	}
	
	public static void printLeftToRightTree(Node root, int level) {
		if(root == null)
			return;
		if(level == 1) {
			System.out.print(root.data);
		} else if(level > 1) {
			printLeftToRightTree(root.left, level-1);
			printLeftToRightTree(root.right, level-1);
		}
	}
	
	public static int getTreeHeight(Node root) {
		
		if(root == null) {
			return 0;
		}
		int rHeight = getTreeHeight(root.right);
		int lHeight = getTreeHeight(root.left);
		
		return Math.max(rHeight+1, lHeight+1);
	}
	
	

}
