package learn.ds.arrays;

/**
 * You are given an array of non-negative integers that represents a two-dimensional elevation map where each element is unit-width wall and the integer is the height. Suppose it will rain and all spots between two walls get filled up.

Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.
 * @author manoj
 *
 *https://www.youtube.com/watch?v=KV-Eq3wYjxI
 */
public class WaterHoldProblem {

	public static void main(String[] args) {

		//int[] arr = {3, 0, 1, 3, 0, 5};
		int[] arr = {7,0,4,2,5,0,6,4,0,5};
		System.out.println(maxWaterHold(arr));
	}

	public static int maxWaterHold(int[] arr) {
		
		
		int[] maxHieghtRight = new int[arr.length];
		int maxRightSideHeight = 0;
		
		for(int i = arr.length - 1; i>=1; i--) {
			
			maxRightSideHeight = Math.max(maxRightSideHeight, arr[i]);
			maxHieghtRight[i] = maxRightSideHeight;
			
		}
		
		int leftWallHight = 0;
		int rainwater = 0;
		for(int i=0; i<arr.length-1; i++) {
			
			rainwater = rainwater + Math.max(Math.min(leftWallHight, maxHieghtRight[i]) - arr[i], 0);
			if(arr[i] > leftWallHight) {
				leftWallHight = arr[i];
			}
			
			
		}
		
		return rainwater;
	}
}
