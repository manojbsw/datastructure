package learn.ds.tree;

/**
 * Given the root of a binary tree, return a deepest node. For example, in the following tree, return d.

    a
   / \
  b   c
 /
d

 * @author manoj
 *
 */
public class DeepestNodeInBT {

	private static int MAX_HEIGHT = Integer.MIN_VALUE;
	private static int node = -1;
	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		findDeepestNode(root, 0);
		System.out.println(node);
		
		MAX_HEIGHT = Integer.MIN_VALUE;
		root.right.left = new Node(5);
		root.right.left.right = new Node(6);
		printLeftSubtree(root, 0);
	}
	
	private static void findDeepestNode(Node root, int height) {
		
		if(root == null) {
			return;
		}
		
		findDeepestNode(root.left, ++height);
		
		if(height > MAX_HEIGHT) {
			MAX_HEIGHT = height;
			node = root.data;
		}
		findDeepestNode(root.right, height);
		
	}
	
	private static void printLeftSubtree(Node root, int height) {
		if(root == null) {
			return ;
		}
		
		if(height > MAX_HEIGHT) {
			MAX_HEIGHT = height;
			System.out.println(root.data);
		}
		printLeftSubtree(root.left, ++height);
		printLeftSubtree(root.right, height);
	}

}
