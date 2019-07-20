package learn.ds.arrays;

import jdk.nashorn.internal.runtime.FindProperty;

/**
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

solution: https://www.youtube.com/watch?v=qli-JCrSwuk
 * @author manoj
 *
 */
public class CharacterDecoding {

	public static void main(String[] args) {

		String s = "1111";
		int[] memo = new int[s.length() + 1];
		for(int i =0; i< memo.length; i ++) {
			memo[i] = -1;
		}
		int result = findways_dp(s.toCharArray(), s.length(), memo);
		System.out.println(result);
		
	}

	public static int findways_dp(char[] s, int k, int[] memo) {
		int result;
		if(k == 0) return 1;  //for empty string it will be 1
		int firstIndex = s.length - k;
		if(s[firstIndex] == '0' ) return 0;
		
		if(memo[k] != -1) {
			return memo[k];
		}
		
		result = findways_dp(s, k-1, memo);
		int doubleDigit = Integer.parseInt(s[firstIndex] + "" + s[firstIndex+1]);
		if(doubleDigit > 9 && doubleDigit < 27) {
			result = result + findways_dp(s, k-2, memo);
		}
		memo[k] = result;
		return result;
		
	}
}
