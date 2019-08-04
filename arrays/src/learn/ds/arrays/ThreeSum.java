package learn.ds.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
Return the sum of the three integers.

Assume that there will only be one solution

Example:
given array S = {-1 2 1 -4},
and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
https://www.interviewbit.com/problems/3-sum/
 * @author manoj
 *
 */
public class ThreeSum {

	public static void main(String[] args) {

		int[] arr = {-1, 2, 1, -4};
		System.out.println(threeSum(arr, 1));
	}

	public static int threeSum(int arr[], int num) {
		
		Arrays.sort(arr);
		int n = arr.length;
		int res = arr[0] + arr[1] + arr[2];
		
		if(arr.length == 3) {
			return res;
		}
		
		int sum = 0;
		for(int low = 0; low < n - 2; low++) {
			
			int mid = low + 1;
			int high = n - 1;
			
			int numm = num - arr[low];
			
			while(mid < high) {
				
			    sum = arr[mid] + arr[high];
				
				if(sum == num) {
					return num;
				} 
				else if (sum < numm) {
					mid++;
				}else {
					high--;
				}
				
				int dif = Math.abs(numm - sum);
				int otherDiff = Math.abs(res - num);
				
				if(dif < otherDiff) {
					res = sum + arr[low];
				}
				
			}
			
			
			
		}
		
		return 0;
	}
}
