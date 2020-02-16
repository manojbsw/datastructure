package learn.ds.tree;

/**
 * This problem was asked by Google.

Invert a binary tree.

For example, given the following tree:

    1
   / \
  2   3
 / \  /
4   5 6

should become:

  1
 / \
 3  2
 \  / \
  6 5  4

 * @author manoj
 *
 */
public class InvertBinaryTree {

	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);

		printPostOrder(root);
		System.out.println("--After invert----");
		invertBT(root);
		printPostOrder(root);
	}

	
	private static void invertBT(Node root) {
		
		if(root == null) {
			return ;
		}
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertBT(root.left);
		invertBT(root.right);
		
	}
	
	private static void printPostOrder(Node root) {
		if(root == null) {
			return;
		}
		System.out.println(root.data + " ");
		printPostOrder(root.left);
		printPostOrder(root.right);
	}
}
