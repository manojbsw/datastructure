package learn.ds.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.javafx.css.CalculatedValue;

/**
 * https://www.youtube.com/watch?v=nYFd7VHKyWQ
 * @author manoj
 *
 */
public class StringPermutation {

	public static void main(String[] args) {

		String str = "ABCD";
		char[] arr = str.toCharArray();
		flattenStr(arr);
		
	}

	public static void flattenStr(char[] arr) {
		
		Map<Character, Integer> map = new HashMap<>();
		for(char c : arr) {
			
			map.compute(c, (key, value) -> {
				if(value == null) {
					return 1;
				}
				else {
					return value+1;
				}
			});
		}
		
		char[] result = new char[arr.length];
		char[] str = new char[map.size()];
		int[] count = new int[map.size()];
		
		int index = 0;
		for(Entry<Character, Integer> entry : map.entrySet()) {
				str[index] = entry.getKey();
				count[index] = entry.getValue();
				index++;
		}
		
		caculatePermutation(str, result, count, 0);
		
	}
	
	public static void caculatePermutation(char[] str, char[] result, int[] count, int level) {
		
		if(level == result.length) {
			//print str
			for(char c: result) {
				System.out.print(c);
			}
			System.out.println();
			return;
		}
		
		
		for(int i=0 ; i<str.length; i++) {
			
			if(count[i] == 0) {
				continue;
			}
			
			result[level] = str[i];
			count[i]--;
			caculatePermutation(str, result, count, level+1);
			count[i]++;
		}
			
		
	}
}
