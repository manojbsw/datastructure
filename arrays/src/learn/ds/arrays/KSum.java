package learn.ds.arrays;

import java.util.Arrays;

public class KSum {

	public static void main(String[] args) {
        int[] arr = {10,5,2,6};
        kSum(arr, 11);
	}
	
	
	public static void kSum(int arr[], int k) {
		
		int n = arr.length;
		Arrays.sort(arr);
		int sum = 0;
		boolean found = false;
		for(int i =0, j = n-1; i < j;) {
			
			sum = arr[i] + arr[j];
			
			if (sum > k) {
				j--;
			}
			if(sum < k) {
				i++;
			}
			if(sum == k) {
				found = true;
				System.out.println("Values are " + arr[i] + " " + arr[j] );
				break;
			}
			
			
		}
		if(!found) 
			System.out.println("No combination found");
	}

}
