package learn.ds.arrays;

/**
 * This problem was asked by Amazon.

Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.

 * @author manoj
 *
 */
public class CharacterEncodingCount {

	public static void main(String[] args) {

		String characters = "AAAABBBCCDAAC";
		System.out.println(characterEncoding(characters.toCharArray()));
		
	}

	public static String characterEncoding(char[] chars) {
		
		char prev = chars[0];
		int count = 0;
		String resultStr = "";
		for(int i=0 ; i<chars.length; i++) {
			
			if(prev == chars[i]) {
				count++;
			} else {
				resultStr = resultStr + count + prev;
				count = 1;
			}
			prev = chars[i];
		}
		
		resultStr = resultStr + count + prev;
		
		return resultStr;
	}
}
