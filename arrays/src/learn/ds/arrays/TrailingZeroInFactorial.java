package learn.ds.arrays;

/**
 * https://www.purplemath.com/modules/factzero.htm
 * @author manoj
 *
 */
public class TrailingZeroInFactorial {

	public static void main(String[] args) {

		int n = 4617;
		System.out.println(trailingZeroInFactorial(n));
	}

	public static int trailingZeroInFactorial(int n) {
		
		boolean loopChecker = true;
		int totalZero = 0;
		int multipleOfFive = 5;
		while(loopChecker) {
			
			int tempTotalZero = n / multipleOfFive;
			if(tempTotalZero < 1) {
				loopChecker = false;
			} else {
				multipleOfFive = multipleOfFive * 5;
			}
			 
			totalZero = totalZero + tempTotalZero;
			
		}
		return totalZero;
	}
}
