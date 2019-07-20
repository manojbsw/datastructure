package learn.ds.arrays;

/**
 * https://www.techiedelight.com/find-maximum-sum-path-involving-elements-given-arrays/
 * @author manoj
 *
 */
public class MaxSumPathOfArrays {

	public static void main(String[] args) {

     int X[] = { 3, 6, 7, 8, 10, 12, 15, 18, 100 };
     
     int Y[] = { 1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50 };
		System.out.println(calculateSumPath(X, Y));
	}
	
	public static int calculateSumPath(int[] x, int[] y) {
		
		int i=0, m = x.length;
		int j=0, n = y.length;
		int total = 0;
		int sum_x = 0 ;
		int sum_y = 0 ;
		while(i<m && j<n) {
			
			
			//add duplicate element
			while(i < m-1 && x[i] == x[i+1]) {
				sum_x +=x[i++];
			}
			
			while(j < n-1 && y[j] == y[j+1]) {
				sum_y +=y[j++];
			}
			
			if(x[i] < y[j]) {
				sum_x += x[i];
				i++;
			} else if(y[j] < x[i]) {
				sum_y += y[j];
				j++;
			} else {
				
				total += Math.max(sum_x, sum_y) + x[i];
				i++;
				j++;
				sum_x = 0;
				sum_y = 0;
			}
			
		}
		
		while(i < m) {
			total += x[i++];
		}
		while(j < n) {
			total += y[i++];
		}
		
		return total;
	}

}
