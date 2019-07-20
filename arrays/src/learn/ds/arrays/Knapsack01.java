package learn.ds.arrays;

/**
 * 
 * @author manoj
 *
 */
public class Knapsack01 {

	public static void main(String[] args) {

        int val[] = new int[]{60, 100, 120}; 
        int wt[] = new int[]{10, 20, 30}; 
        int capacity = 50;
        int n = val.length;
        int[][] memorize = new int[n+1][capacity+1];
		System.out.println(knapsack(val, wt, capacity, n-1, memorize));
	}
	
	public static int knapsack(int val[], int wt[], int capacity, int n, int memorize[][]) {
		
		
		
		int result = 0;
		if(n == -1 || capacity == 0) {
			return 0;
		}
		
		if(memorize[n][capacity] != 0)
			return memorize[n][capacity] ;
		
		if(wt[n] > capacity) {
			result = knapsack(val, wt, capacity, n-1, memorize);
		} else {
			int temp1 = knapsack(val, wt, capacity, n-1, memorize);
			int temp2 = val[n] + knapsack(val, wt, capacity - wt[n], n-1, memorize);
			result = Math.max(temp1, temp2);
		}
		memorize[n][capacity] = result;
		return result;
		
		
	}

}
