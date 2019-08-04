package learn.ds.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindNextNodeInBinaryTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.leftChild = new TreeNode(2);
		root.rightChild = new TreeNode(3);
		
		root.leftChild.leftChild = new TreeNode(4);
		root.leftChild.rightChild = new TreeNode(5);
		
		root.rightChild.leftChild = new TreeNode(6);
		root.rightChild.leftChild.leftChild = new TreeNode(7);
		root.rightChild.leftChild.rightChild = new TreeNode(8);
		
		//BinarySearchTree bst = new BinarySearchTree();
        //int[] arr = {2,34,65,34,78,12,2};
		
		//Arrays.stream(arr).forEach(d -> bst.insert(d));
		//System.out.println(bst.checkBST());
		//bst.traverse();
		
		//TreeNode root = bst.getRooNode();
		System.out.println(DFS(root, 5));
		
	}
	
	public static int DFS(TreeNode root, int x) {
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		boolean found = false;
		while(queue.size() != 0) {
			
			TreeNode node = queue.poll();
			if(found) {
				return node.value;
			}
			if(node.value == x) {
				found = true;
			}
			if(node.leftChild != null) {
				queue.add(node.leftChild);
			}
			if(node.rightChild != null) {
				queue.add(node.rightChild);
			}
		}
		return -1;
	}

}
