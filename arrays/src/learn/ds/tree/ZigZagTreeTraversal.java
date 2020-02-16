package learn.ds.tree;

import java.util.Stack;

/**
 * his problem was asked by Morgan Stanley.

In Ancient Greece, it was common to write text with the first line going left to right, the second line going right to left, and continuing to go back and forth. This style was called "boustrophedon".

Given a binary tree, write an algorithm to print the nodes in boustrophedon order.

For example, given the following tree:

       1
    /     \
  2         3
 / \       / \
4   5     6   7

You should return [1, 3, 2, 4, 5, 6, 7].

 * @author manoj
 *
 */

public class ZigZagTreeTraversal {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		System.out.println("Using stack :");
		printZigZagWithStack(root);
		
		System.out.println();
		System.out.println("Using tree height :");
		printZigZagWithHeight(root);
	}
	
	public static void printZigZagWithHeight(Node root) {
		
		//Get tree height
		int height = getTreeHeight(root);
		boolean leftToRight = true;
		for(int i=1; i<=height; i++) {
			
			if(leftToRight) {
				printLeftToRightTree(root, i);
				leftToRight = false;
			} else {
				printRightToLeftTree(root, i);
				leftToRight = true;
			}
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
	
	public static void printRightToLeftTree(Node root, int level) {
		if(root == null)
			return;
		if(level == 1) {
			System.out.print(root.data);
		}else if(level > 1) {
			printRightToLeftTree(root.right, level-1);
			printRightToLeftTree(root.left, level-1);
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
	
	/**
	 * Method1: Using stack
	*/
	public static void printZigZagWithStack(Node root) {
		
		Stack<Node> currentLevel = new Stack<>();
		Stack<Node> nextLevel = new Stack<>();
		boolean leftToRight = true;
		currentLevel.push(root);
		
		while(!currentLevel.isEmpty()) {
			
			Node node = currentLevel.pop();
			System.out.print(node.data);
			
			if(leftToRight) {
				
				if(node.left != null) {
					nextLevel.push(node.left);
				}
				if(node.right != null) {
					nextLevel.push(node.right);
				}
				
			} else {
				
				if(node.right != null) {
					nextLevel.push(node.right);
				}
				
				if(node.left != null) {
					nextLevel.push(node.left);
				}
				
			}
			
			if(currentLevel.isEmpty()) {
				leftToRight = !leftToRight;
				Stack<Node> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
			}
			
		}
		
	}

}
