package learn.ds.arrays;

/**
 * https://www.algoexpert.io/gaurav
 * 
 * sample video
 * 
 * Find the max profit from share market after doing k number of transactions
 * 
 * @author manoj
 *
 */
public class MaxProfitWithKtransactions {

	public static void main(String[] args) {

		int[] prices = {10,2,15,30,60,90};
		int k=2;
		System.out.println(findMaxProfit(prices, k));
		System.out.println(findMaxProfitPerformance(prices, k));
	}
	
	/**
	 * Time complexity = O(nk)
	 * space complexity = O(nk)
	 * @param prices
	 * @param k
	 * @return
	 */
	private static int findMaxProfit(int[] prices, int k) {
		
		int length = prices.length;
		if(prices != null && prices.length < 1) {
			return 0;
		}
		int[][] profit = new int[k+1][length];
		
		for(int i=1; i < k+1; i++) {
			int maxThusFar = Integer.MIN_VALUE;
			
			for(int j=1; j < length; j++) {
				
				maxThusFar = Math.max(maxThusFar, profit[i-1][j-1] - prices[j-1]);
				
				profit[i][j] = Math.max(profit[i][j-1], prices[j]+maxThusFar);
			}
		}
		return profit[k][length-1];
		
	}

	
	private static int findMaxProfitPerformance(int prices[], int k) {
		
		int length = prices.length;
		if(prices != null && prices.length < 1) {
			return 0;
		}
		int[] evenProfit = new int[length];
		int[] oddProfit = new int[length];
		
		
		for(int i=1; i<k+1; i++) {
			
			int maxThusFar = Integer.MIN_VALUE;
			int currentProfit[];
			int previousProfit[];
			if(i%2 == 0) {
				currentProfit = evenProfit;
				previousProfit = oddProfit;
			} else {
				currentProfit = oddProfit;
				previousProfit = evenProfit;
			}
			
			for(int j=1; j<length; j++) {
				maxThusFar = Math.max(maxThusFar, previousProfit[j-1] - prices[j-1]);
				currentProfit[j] = Math.max(currentProfit[j-1], prices[j]+maxThusFar);
			}
		}
		
		return (length%2==0 ? evenProfit[length-1] : oddProfit[length-1]);
	}
}
