package learn.ds.arrays;

/**
 * https://www.youtube.com/watch?v=a9-NtLIs1Kk
 * 
 * @author manoj
 *
 */
public class CountNumberOfBinaryWithoutConsecutive1s {

	public static void main(String[] args) {

		int n = 4;
		int[] memotized = new int[n+1];
		
		System.out.println(solutionWithRecursive(n, 0, memotized));
		System.out.println(solutionWithIterative(n));
	}

	
	public static int solutionWithRecursive(int n, int sum, int[] memotized) {
		
		if(memotized[n] > 0) return memotized[n];
		if(n == 1) return 2;
		if(n == 2) return 3;
		if(n == 3) return 5;
		
		 int data = solutionWithRecursive(n-1, sum, memotized) + solutionWithRecursive(n-2, sum, memotized);
		 memotized[n] = data;
		 sum = sum + data;
		
		return sum;
		
	}
	
	public static int solutionWithIterative(int n) {
		
		int[] b = new int[n];
		int[] a = new int[n];
		a[0] = b[0] = 1;
		
		for(int i = 1; i < n; i++) {
			a[i] = a[i-1] + b[i-1];
			b[i] = a[i-1];
		}
		return a[n-1] + b[n-1];
	}
}
