package learn.ds.arrays;

/**
 * https://www.techiedelight.com/find-number-rotations-circularly-sorted-array/
 * 
 * 
 * This problem was asked by Amazon.

An sorted array of integers was rotated an unknown number of times.

Given such an array, find the index of the element in the array in faster than linear time. If the element doesn't exist in the array, return null.

For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).

You can assume all the integers in the array are unique.

 * @author manoj
 *
 */
public class RotatedArrayFindElement {

	public static void main(String[] args) {
		int[] arr = {13, 18, 25, 2, 8, 10};
		System.out.println(findElementInRotatedArray(arr, 18));
	}

	public static int findElementInRotatedArray(int[] arr, int k) {
		
		int pivot = findPivotElement(arr);
		if(pivot == -1) return -1;
		
		if(arr[pivot] == k) return pivot;
		
		if(arr[0] < k) {
			return binarySearch(arr, 0, pivot - 1, k);
		}
		else {
			return binarySearch(arr, pivot, arr.length, k);
		}
		
	}
	
	public static int binarySearch(int[] arr, int low, int high, int k) {
		
		while(low <= high) {
			
			int mid = low + (high - low)/2;
			if(arr[mid] == k) {
				return mid;
			}
			if(arr[mid] < k) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
			
		}
		return -1;
	}
	
	public static int findPivotElement(int[] arr) {
		
		int low = 0;
		int high = arr.length - 1;
		
		if (high < low)   
            return -1; 
        if (high == low)  
            return low; 
       
		
		while(low <= high) {
			
			int mid = (low + high) / 2;
			
			int next = ((mid+1)+arr.length)%arr.length;
			int prev = ((mid-1)+arr.length)%arr.length;
			
			
			if(arr[mid] >= arr[next] && arr[mid] >= arr[prev]) {
				return mid;
			}
			if(arr[low] < arr[mid]) {
				low = mid + 1;
			}
			else if(arr[mid] < arr[high] ) {
				high = mid-1;
			}

			
		}
		
		return -1;
	}
}
