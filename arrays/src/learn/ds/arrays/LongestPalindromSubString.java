package learn.ds.arrays;

/**
 * https://www.techiedelight.com/longest-palindromic-substring-non-dp-space-optimized-solution/
 * @author manoj
 *
 */
public class LongestPalindromSubString {

	public static void main(String[] args) {

		String ss = "ABDCBCDBDCBBC";
		System.out.println(checkPalindrom(ss));
	}
	
	public static String expandStringFromGivenRange(String str, int low, int high) {
		
		while(low>=0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
			low--;
			high++;
		}
		
		return str.substring(low+1, high);
	}
	
	public static String checkPalindrom(String ss) {
		
		int max_length =0;
		String max_string = "";
		
		
		for(int i = 0; i < ss.length(); i++) {
			
			
			//calculation for odd length
			String tempStr = expandStringFromGivenRange(ss, i, i);
			
			if(tempStr.length() > max_length) {
				max_length = tempStr.length();
				max_string = tempStr;
			}
			
			//Calculation for even length
			tempStr = expandStringFromGivenRange(ss, i, i+1);
			if(tempStr.length() > max_length) {
				max_length = tempStr.length();
				max_string = tempStr;
			}
		}
		return max_string;
	}

}
