package learn.ds.arrays;

/**
 * Implement division of two positive integers without using the division, multiplication, or modulus operators. Return the quotient as an integer, ignoring the remainder.
 * 
 * @author manoj
 *
 *https://www.geeksforgeeks.org/divide-two-integers-without-using-multiplication-division-mod-operator/
 */
public class DevideIntegerWithouMath {

	public static void main(String[] args) {

		System.out.println("using subtract " + usingSubtract(5, 500001 ));
		
		System.out.println("using subtract " + usingBit(5, 500001));
		
	}

	public static int usingSubtract(int devisor, int dividend) {
		
	    int sign = (1 > devisor) ? -1 : (1 > dividend) ? -1 : 1;
	    devisor = Math.abs(devisor);
	    dividend = Math.abs(dividend);
		int quotient = 1;
		int reminder = dividend - devisor;
		while(reminder > devisor) {
			quotient++;
			reminder = reminder - devisor;
		}
		
		return quotient * sign;
	}
	
	
	public static long usingBit(int divisor, int dividend) {  
		  
		// Calculate sign of divisor  
		// i.e., sign will be negative  
		// only iff either one of them  
		// is negative otherwise it  
		// will be positive  
		long sign = ((dividend < 0) ^  
		            (divisor < 0)) ? -1 : 1;  
		  
		// remove sign of operands  
		dividend = Math.abs(dividend);  
		divisor = Math.abs(divisor);  
		  
		// Initialize the quotient  
		long quotient = 0, temp = 0;  
		  
		// test down from the highest  
		// bit and accumulate the  
		// tentative value for  
		// valid bit  
		// 1<<31 behaves incorrectly and gives Integer 
		// Min Value which should not be the case, instead  
		  // 1L<<31 works correctly.  
		for (int i = 31; i >= 0; --i)  
		{  
		  
		    if (temp + (divisor << i) <= dividend)  
		    {  
		        temp += divisor << i;  
		        quotient |= 1L << i;  
		    }  
		}  
		  
		return (sign * quotient);  
	}
}
