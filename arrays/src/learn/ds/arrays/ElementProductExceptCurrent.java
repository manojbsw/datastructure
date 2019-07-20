package learn.ds.arrays;

/**
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers
 *  in the original array except the one at i.  (We should not use division operator)

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
  If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * @author manoj
 *
 */
public class ElementProductExceptCurrent {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4};
		prod(arr);
	}

	public static void prod(int arr[]) {
		int n =arr.length;
		int left[] = new int[n];
		int right[] = new int[n];
		int prod[] = new int[n];
		
		left[0] = 1;
		right[n-1] = 1;
		
		for(int i=1; i<n; i++) {
			left[i] = left[i-1] * arr[i-1];
		}
		
		for(int i=n-2; i>=0; i--) {
			right[i] = right[i+1] * arr[i+1];
		}
		
		for(int i=0; i<n; i++) {
			prod[i] = left[i] * right[i];
		}
		
		for(int  i=0;i < n; i++) {
			System.out.println(prod[i]);
		}
		
	}
}
