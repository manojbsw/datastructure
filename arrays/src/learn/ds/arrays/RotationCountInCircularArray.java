package learn.ds.arrays;
/**
 * https://www.techiedelight.com/find-number-rotations-circularly-sorted-array/
 * @author manoj
 *
 */
public class RotationCountInCircularArray {

	public static void main(String[] args) {

		int[] arr = {8, 9, 10, 2, 5, 6};
		System.out.println(rotatinCount(arr));
		
	}

	
	public static int rotatinCount(int[] arr) {
		
		int low =0;
		int high = arr.length-1;
		
		while(low <= high) {
			
			if(arr[low] <= arr[high]) {
				return low;
			}
			
			int mid = (low + high)/2;
			
			int next = ((mid + 1) + arr.length)%arr.length;
			int prev = ((mid - 1) + arr.length)%arr.length;
			
			if(arr[mid] <= arr[next] && arr[mid] >= arr[prev]) {
				return mid;
			}
			else if(arr[mid] > arr[low]) {
				low = mid + 1;
			}
			else if(arr[mid] < arr[high]) {
				high = mid - 1;
			}
		}
		
		
		return -1;
		
	}
}
