package learn.ds.arrays;

/**
 * https://www.youtube.com/watch?v=JQDHz72OA3c&list=PLkQkbY7JNJuBoTemzQfjym0sqbOHt5fnV&index=4
 * 
 * https://www.geeksforgeeks.org/how-to-design-a-tiny-url-or-url-shortener/
 * @author manoj
 *
 */
public class URLShortening {

	private static String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public static void main(String[] args) {

		System.out.println(idToShortURL(99));
		System.out.println(decode(idToShortURL(999998974)));
	}

	public static String idToShortURL(int n) {
		
		
		
		StringBuilder res = new StringBuilder();
		while(n > 0) {
			res.append(str.charAt(n%62));
			n = n/62;
		}
		
		return res.reverse().toString();
	}
	
	public static int decode(String s) {
		char ch[] = s.toCharArray();
		int n = 0;
		for(int i=0; i<ch.length; i++) {
		   n = n*62 + str.indexOf(ch[i]);
		}
		
		return n;
	}
}
