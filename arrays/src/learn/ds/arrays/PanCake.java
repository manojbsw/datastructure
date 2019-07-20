package learn.ds.arrays;

public class PanCake {


	static void flip(int arr[], int k) {
		
		int i,j;
		for(i=0, j=k ; i <=j; i++,j-- ) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	
	static int maxElementIndex(int arr[], int length) {
		
		int i,m;
		for( i=0, m=0; i<=length; ++i) {
			
			if(arr[i] > arr[m]) {
				m = i;
			}
			
		}
		
		return m;
	}
	
	
	static int[] pancake(int arr[]) {
		
		int n = arr.length;
		for(int i=n-1; i>=0; i-- ) {
			
			int max = maxElementIndex(arr, i);
			
			if(max != i) {
				
				flip(arr, max);
				flip(arr, i);
				
			}
			
		}
		
		return arr;
		
	}
	  
	  public static void main(String[] args) {

	    int[] arr = {1,5,4,3,2};
	    long start = System.currentTimeMillis();
	    pancake(arr);
	    long end = System.currentTimeMillis();
	    System.out.println("time "+  (start-end));
	    
	     for(int i =0; i<arr.length; i++) {
	       System.out.println(arr[i]);
	     }
	    
	    
	  }


}
