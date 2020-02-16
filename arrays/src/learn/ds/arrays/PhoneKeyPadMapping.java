package learn.ds.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a mapping of digits to letters (as in a phone number), and a digit string, return all possible letters the number could represent. You can assume each valid number in the mapping is a single digit.

For example if {“2”: [“a”, “b”, “c”], 3: [“d”, “e”, “f”], …} then “23” should return [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf"].

https://www.geeksforgeeks.org/iterative-letter-combinations-of-a-phone-number/
 * @author manoj
 *
 */
public class PhoneKeyPadMapping {

	public static void main(String[] args) {

		String[] table = { "", "", "abc", "def", "ghi", "jkl",  
	            "mno", "pqrs", "tuv", "wxyz" };  
	  
		int[] numbers = {2, 3, 9};
		prepareCombinations(numbers, table).forEach(str -> System.out.println(str));
		
	}

	
	private static List<String> prepareCombinations(int[] numbers, String[] table) {
		
		List<String> output = new ArrayList();
		Queue<String> q = new LinkedList<>();
		q.add("");
		int n = numbers.length;
		
		while(!q.isEmpty()) {
			
			String s = q.remove();
			
			if(s.length() == n) {
				output.add(s);
			}
			else {
				String val = table[numbers[s.length()]];
				for(int i = 0; i < val.length(); i++) {
					q.add(s + val.charAt(i));
				}
			}
		}
		System.out.println("size "+output.size());
		return output;
	}
}
