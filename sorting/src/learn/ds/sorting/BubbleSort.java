package learn.ds.sorting;

/**
 * Compare the current and its next number, Complete this comparison for all n numbers.
 * Time complexity:
 * (n-1)(n-2)*c = O(n2)
 * 
 * in place sorting algo so space complexity = O(1)
 * 
 * @author manoj
 *
 */
public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = {2,3,1,5,4,8};
		bubbleSort(arr);

		for(int i=0; i < arr.length; i++) 
			System.out.println(arr[i]);
	}

	public static void bubbleSort(int arr[]) {
		int n = arr.length;
		for(int i=1; i<n-1; i++) {
			
			for(int j=0;j<n-2;j++) {
				
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				
			}
			
		}
		
	}
}
