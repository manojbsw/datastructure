package learn.ds.arrays;

/**
 * Implement integer exponentiation. That is, implement the pow(x, y) function, where x and y are integers and returns x^y.

Do this faster than the naive method of repeated multiplication.

For example, pow(2, 10) should return 1024.
 * @author manoj
 *
 */
public class ExponentiationInteger {

	public static void main(String[] args) {

		int x = 3;
		int y = 5;
		int z = x<<(y-1);
		
		System.out.println("recursive " + recursive(x, y));
		System.out.println("iterative " + iterative(x, y));
		
	}
	
	public static int recursive(int x, int y) {
		
		if(y == 0) {
			return 1;
		}
		else if (y%2 == 0) {
			return recursive(x, y/2) * recursive(x, y/2);
		}
		else {
			return x * recursive(x, y/2) * recursive(x, y/2);
		}
		
	}
	
	public static int iterative(int x, int y ) {
		
		int res = 1;
		
		while(y > 0) {
			
			if((y & 1) == 1) {
				res = res * x;
			}
			y = y >> 1;
		    x = x * x;
		}
		return res;
	}

}
