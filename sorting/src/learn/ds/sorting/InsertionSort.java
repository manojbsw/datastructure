package learn.ds.sorting;

/**
 * https://www.youtube.com/watch?v=i-SKeOcBwko
 * @author manoj
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		
		int[] arr = new int[] {8,9,2,4,6,3};
		arr = insertionSort(arr);
		for(int i : arr) {
			System.out.println(i); 
		}
	}
	
	
	public static int[] insertionSort(int items[]) {
		
		for(int i = 1 ; i<items.length; i++) {
			
			int hole = i;
			int value = items[i];
			
			while(hole > 0 && items[hole - 1] > value) {
				
				items[hole] = items[hole - 1];
				hole = hole - 1;
				
			}
			items[hole] = value;
			
		}
		return items;
	}

}

/*
 * Time complexity of insertion sort
 * Best = O(n)
 * Worst = O(n2)
 * Average =  
*/