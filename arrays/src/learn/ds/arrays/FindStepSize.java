package learn.ds.arrays;

/**There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

    1, 1, 1, 1
    2, 1, 1
    1, 2, 1
    1, 1, 2
    2, 2

What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 * 
 * 
 * https://www.youtube.com/watch?v=5o-kdjv7FD0
 */
public class FindStepSize {

	public static void main(String[] args) {
		
		int[] x = {1,3,5};
		int totalStairCase = 5;
		//long startTime = System.currentTimeMillis();
        System.out.println("Recursive Approach " + waysToClimb(x, totalStairCase));
        
        System.out.println("Bottom up (best) Approach " + waysToClib_bottom_up(x, totalStairCase));
        
       // System.out.println(System.currentTimeMillis() - startTime);
	}

	public static int waysToClimb(int[] arr, int totalStairCase) {
		
		if(totalStairCase == 0) return 1;
		
		int result = 0;
		for(int i = 0; i< arr.length ; i++) {
			if(totalStairCase-arr[i] >= 0) {
				result = result +waysToClimb(arr, totalStairCase-arr[i]);
			}
		}
		return result;
		
	}
	
	public static int waysToClib_bottom_up(int arr[], int totalStairCase) {
		
		int[] numArr = new int[totalStairCase + 1];
		
		numArr[0] = 1;
		
		for(int i=1; i <= totalStairCase; i++) {
		
			int result = 0;
			for(int j=0 ; j<arr.length; j++) {
				if(i-arr[j] >=0) {
					result = result + numArr[i-arr[j]];
				}
			}
			numArr[i] = result;
			
		}
		
		return numArr[totalStairCase];
	}
	
}
