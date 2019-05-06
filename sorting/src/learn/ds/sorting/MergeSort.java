package learn.ds.sorting;

/**
 * https://www.youtube.com/watch?v=0nlPxaC2lTw&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=6
 * 1. Devide and conquer method
 * 2. Not in place sort algo
 * 3. Time complexity O(n log n)
 * 4. Space complexity O(n)
 * @author manoj
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = new int[] {8,9,2,4,6,3};
		mergeSort(arr, 0 , arr.length-1);
		for(int i : arr) {
			System.out.println(i); 
		}
	}

	public static void mergeSort(int arr[], int start, int end) {
		
		if (start < end) {
			int mid = (start+end)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end)	;
		}
	}
	
	public static void merge(int[] arr, int start, int mid, int end) {
		
        int[] temp = new int[end-start+1];
        
        int i = start, j = mid+1, k=0; 
		
		
		while(i <= mid && j <= end) {
			
			if (arr[i] <= arr[j])  {
				temp[k] = arr[i];
				k++;
				i++;
			}
			else {
				temp[k] = arr[j];
				k++;
				j++;
			}
		}
		while(i<=mid) {
			temp[k] = arr[i];
			k++;
			i++;
		}
		while(j<=end) {
			temp[k] = arr[j];
			k++;
			j++;
		}
		for(i = start; i<=end; i++) {
			arr[i] = temp[i-start];
		}
		
	}
	
}
