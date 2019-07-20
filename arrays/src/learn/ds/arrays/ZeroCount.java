package learn.ds.arrays;

/**
 * Given an array of size N consisting of only 0's and 1's ,which is sorted in such a manner that all the 1's are placed first and then they are followed by all the 0's. You have to find  the count of all the 0's.
 * @author manoj
 *
 */
public class ZeroCount {

	public static void main(String[] args) {

		int[] arr = new int[] {1,1,1,1,0,0,0,0};
		
		int spanner = (int) Math.sqrt(arr.length);
		int start = 0;
		int end = arr.length;
		int foundIndex = 0;
		while(start < end) {
			if(arr[start] == 0) {
				foundIndex = start;
				while(arr[start]==0) {
					foundIndex = start;
					start --;
				}
				break;
			}
			start = start+ spanner;
			
		}
		
		System.out.println(arr.length - foundIndex);
		
	}

}
