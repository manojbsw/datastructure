package learn.ds.arrays;
/**
 * https://www.techiedelight.com/maximum-subarray-problem-kadanes-algorithm/
 * @author manoj
 *
 */
public class MaxSubArray {

	public static void main(String[] args) {

		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(arr));
	}

	public static int maxSubArray(int[] arr) {
		
		int maxSoFar = 0;
		
		int maxNumber = 0;
		for(int i : arr) {
			
			maxNumber = maxNumber + i;
			maxNumber = Math.max(maxNumber, 0);
			maxSoFar = Math.max(maxSoFar, maxNumber);
			
		}
		
		return maxSoFar;
	}
}
