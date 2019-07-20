package learn.ds.tree;

import java.util.Arrays;

/**
 * https://www.techiedelight.com/place-convert-given-binary-tree-to-doubly-linked-list/
 * @author manoj
 *
 */
public class BinaryTreeToDoubleLinkedList {

	public static void main(String[] args) {

        testBST bst = new testBST();
		
		int[] arr = {2,34,65,34,78,12,2};
		
		Arrays.stream(arr).forEach(d -> bst.Insert(d));
		bst.BSTtoDoublyLinkedList();
		
	}

}
