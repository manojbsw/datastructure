package learn.ds.arrays;

/**
 * This problem was asked by Google.

Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.

The list is very long, so making more than one pass is prohibitively expensive.

Do this in constant space and in one pass.
 * @author manoj
 *
 */
public class RemoveKthLastElement {

	public static void main(String[] args) {

		Node node = new Node(null, 10);
		node = new Node(node, 9);
		node = new Node(node, 8);
		node = new Node(node, 7);
		node = new Node(node, 6);
		node = new Node(node, 5);
		node = new Node(node, 4);
		node = new Node(node, 3);
		node = new Node(node, 2);
		node = new Node(node, 1);
		printNode(node);
		removeLastKthElement(node, 2);
		printNode(node);
	}

	public static void removeLastKthElement(Node node, int k) {
		
		int i = 1;
		Node KthPosition = null;
		Node KthPreviousPosition = null;
		while(node != null) {
			
			if(i == 1 ) {
				KthPosition = node;
				KthPreviousPosition = KthPosition;
			}
			if(i > k) {
				KthPreviousPosition = KthPosition;
				KthPosition = KthPosition.node;
			}
			i++;
			node = node.node;
		}
		
		KthPreviousPosition.node = KthPosition.node;
		
	}
	
	public static void printNode(Node node) {
		
		while(node != null) {
			System.out.println(node.value);
			node = node.node;
		}
	}
}
 class Node {
	
	int value;
    Node node;
    public Node(Node node, int value) {
    	this.node = node;
    	this.value = value;
    }
    
    public void addNode(Node node) {
    	this.node = node;
    }
}
