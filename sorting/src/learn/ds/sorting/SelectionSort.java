package learn.ds.sorting;

/**
 * Take first element and compare with all the element, now take second element and compare it with remaining element. Do for all other remaining element.
 * Time Complexity:
 * = n * (n-1)*c
 * =O(n2)
 * 
 * In place sorting so space complexity = O(1)
 * 
 * @author manoj
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		
		int[] arr = {2,3,1,5,4,8};
		selectionSort(arr);

		for(int i=0; i < arr.length; i++) 
			System.out.println(arr[i]);
		
	}
	
	public static void selectionSort(int arr[]) {
		int n = arr.length;
		for(int i = 0 ; i < n-1; i++) {
			int imin = i;
			for(int j = i+1; j < n; j++) {
				
				if(arr[j] < arr[imin]) {
					imin = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[imin];
			arr[imin] = temp;
		}
		
	}
	
	/*public static void selectionSort(int arr[]) {
		int n = arr.length;
		for(int i = 0 ; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				
				if(arr[j] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
	}*/
	

}
