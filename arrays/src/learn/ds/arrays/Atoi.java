package learn.ds.arrays;

/**
 * https://www.geeksforgeeks.org/write-your-own-atoi/
 * @author manoj
 *
 */
public class Atoi {

	public static void main(String[] args) {

		String s = "-123";
		System.out.println(atoi(s));
	}

	public static boolean isNumeric(char c) {
		return c>='0' && c<='9';
	}
	
	public static int atoi(String s) {
		
		char[] chrs = s.toCharArray();
		int sign = 1;
		int res = 0;
		for(int i=0; i<chrs.length; i++) {
		    if (i==0 && chrs[0] == '-') {
		    	sign = -1;
		    	continue;
		    }
			
		    if(chrs[i] == ' ') {
		    	continue;
		    }
		    
			if(isNumeric(chrs[i])) {
				
				res =  res * 10 + (chrs[i] - '0');
				
			} else 
			{
				return -1;
			}
		}
		return sign*res;
	}
}
