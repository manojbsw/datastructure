package learn.ds.sorting;

/**
 * https://www.youtube.com/watch?v=COk73cpQbFQ&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=7
 * 
 * Works on divide and conquer technique. 
 * Take end element as pivot and first element index as pIndex. 
 * Compare first index element with pivot element, if it is less than pivot than swap first index element with pivot.
 * If it is greater than pivot then increment index and compare next index element with pivot. Continue till end of the loop.
 * At last swap pivot with pindex element.
 * 
 * Time complexity: O(nlogn)  in best and average case
 *    O(n2) in worst case. But it can be reduce using randome quick sort.
 *    
 *  In place sorting so space complexity is O(1)
 * @author manoj
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] {8,9,2,4,6,3};
		quickSort(arr, 0 , arr.length-1);
		for(int i : arr) {
			System.out.println(i); 
		}
	}

	public static void quickSort(int[] arr, int start, int end) {
		
		if(start< end) {
			int pIndex = partition(arr, start, end);
			quickSort(arr, start, pIndex-1);
			quickSort(arr, pIndex+1, end);
				
		}
		
	}
	
	
	public static int partition(int[] arr, int start, int end) {
		
			int pivot = arr[end];
			int pIndex = start;
			
			for(int i=start; i<end-1; i++) {
				
				if(arr[i] < pivot) {
					
					swap(arr, i, pIndex);
					pIndex++;
				}
			}
			swap(arr, pIndex, end);
		
		return pIndex;
		
	}
	
	public static void swap(int[] arr, int source, int dest) {
		int temp = arr[source];
		arr[source] = arr[dest];
		arr[dest] = temp;
	}
}
