package learn.ds.arrays;

import java.util.Arrays;

/**
 * https://www.techiedelight.com/sort-array-containing-0s-1s-2s-dutch-national-flag-problem/
 * @author manoj
 *
 */
public class SortArrayWithZeroAndOne {

	public static void main(String[] args) {

		int[] arr = {0,0,1,0,1,2,0,2,1};
		sortArray(arr);
		Arrays.stream(arr).forEach(i -> System.out.println(i));
	}

	public static void sortArray(int[] arr) {
		
		int start = 0, mid = 0;
		int pivot = 1;
		int end = arr.length-1;
		while(mid <= end) {
			
			if(pivot > arr[mid]) {
				swap(arr, start, mid);
				start++;
				mid++;
			}
			else if (pivot < arr[mid]) {
				swap(arr, end, mid);
				end--;
			} else {
				mid++;
			}
		}
	}
	
	public static void swap(int arr[], int source, int dest) {
	
		int temp = arr[source];
		arr[source] = arr[dest];
		arr[dest] = temp;
	}
}
