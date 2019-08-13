package learn.ds.tree;

public class LCABinaryTree {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.right.right = new Node(8);
		
		findLCA(root, root.right.left.left, root.right.right);  // {7 ,  6}->3
		
		
	}

	public static boolean findLCAUtil(Node root, LCAWrapper lca, Node node1, Node node2) {
		
		if(root == null) {
			return false;
		}
		
		if(root.data == node1.data || root.data == node2.data) {
			return true;
		}
		boolean left = findLCAUtil(root.left, lca, node1, node2);
		boolean right = findLCAUtil(root.right, lca, node1, node2);
		
		if(left && right) {
			lca.lca = root.data;
		}
		return left || right;
	}
	
	public static void findLCA(Node root, Node node1, Node node2) {
		
		LCAWrapper lca = new LCAWrapper();
		if(isNodePresent(root, node1) && isNodePresent(root, node2)) {
			findLCAUtil(root, lca, node1, node2);
		}
		
		if(lca.lca != 0) {
			System.out.println("LCA is " + lca.lca);
		}
		else {
			System.out.println("LCA not found");
		}
	}
	
	public static boolean isNodePresent(Node root, Node node1) {
		
		if(root == null) {
			return false;
		}
		if(root.data == node1.data) {
			return true;
		}
		
		return isNodePresent(root.left, node1) || isNodePresent(root.right, node1);
	}
}

class LCAWrapper {
   int lca;
}

class Node
{
	int data;
	Node left = null, right = null;

	Node(int data) {
		this.data = data;
	}
}
