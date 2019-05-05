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
		mergeSort(arr);
		for(int i : arr) {
			System.out.println(i); 
		}
	}

	public static void mergeSort(int arr[]) {
		int n = arr.length;
		if (n < 2) 
			return ;
		int mid = n/2;
		
		int[] left = new int[mid];
		
		int[] right = new int[n-mid];
		
		int i =0;
		while(i < mid) {
			left[i] = arr[i];
			i++;
		}
		i = mid;
		int k =0;
		while(i < n) {
			right[k] = arr[i];
			i++;
			k++;
		}
		
		mergeSort(left);
		mergeSort(right);
	    merge(left, right, arr)	;
	}
	
	public static void merge(int[] left, int[] right, int[] arr) {
		
		int n = left.length;
		int l = right.length;
		
		int i =0;
		int j = 0;
		int k = 0;
		
		while(i < n && j < l) {
			
			if (left[i] < right[j])  {
				arr[k] = left[i];
				k++;
				i++;
			}
			else if (left[i] > right[j]) {
				arr[k] = right[j];
				k++;
				j++;
			}
		}
		while(i<n) {
			arr[k] = left[i];
			k++;
			i++;
		}
		while(j<n) {
			arr[k] = right[j];
			k++;
			j++;
		}
		
	}
	
}
