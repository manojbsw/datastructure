package learn.ds.arrays;

public class RegularExpression {

	public static void main(String[] args) {

		System.out.println(isMatch("ray", "ra.*"));
		
	}
	
	
	 public static boolean isMatch(String s, String p) {
	        int[][] cache = new int[s.length()+1][p.length()+1];
	        return isMatchAux(s, p, 0, 0, cache);
	    }
	    
	    private static boolean isMatchAux(String s, String p, int curS, int curP, int[][] cache) {
	        if (curP >= p.length()) return curS >= s.length();
	        
	        if (curP == p.length()-1) return curS == s.length()-1 &&
	            (p.charAt(curP) == '.' || p.charAt(curP) == s.charAt(curS));
	        
	        if (cache[curS][curP] != 0) return cache[curS][curP] == 1;
	        
	        if (p.charAt(curP+1) != '*') {
	        	
	            boolean match = curS < s.length() &&
	                (p.charAt(curP) == '.' || p.charAt(curP) == s.charAt(curS)) &&
	                isMatchAux(s, p, curS+1, curP+1, cache);
	            cache[curS][curP] = match ? 1 : -1;
	            return match;
	            
	        }
	        
	        char charP = p.charAt(curP);
	        int i = curS;
	        do {
	                if (isMatchAux(s, p, i, curP+2, cache)) {
	                    cache[curS][curP] = 1;
	                    return true;
	                }
	        } while (i < s.length() && (s.charAt(i++) == charP || charP == '.'));
	        
	        cache[curS][curP] = -1;
	        return false;
	    }
	}


