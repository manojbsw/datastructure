package learn.ds.arrays;

/**
 * https://www.geeksforgeeks.org/converting-decimal-number-lying-between-1-to-3999-to-roman-numerals/
 * @author manoj
 *
 */
public class IntegerToRoman {

	public static void main(String[] args) {
       int num = 1006;
       System.out.println(intToRoman(num));
		
	}

	public static String intToRoman(int num) {
		StringBuilder str = new StringBuilder();
		
		while(num != 0) {
			
			if(num >= 1000) {
				int m = num/1000;
				num = num%1000;
				addCharacter(m, "M", str);
			}
			
			else if(num >= 500) {
				
				if(num < 900) {
					
					int m = num/500;
					num = num%500;
					addCharacter(m, "D", str);
				}
				else {
					
					num = num%100;
					addCharacter(1, "CM", str);
				}
				
			}
			
			else if(num >= 100) {
				
				if(num < 400) {
					
					int m = num/100;
					num = num%100;
					addCharacter(m, "C", str);
				}
				else {
					
					num = num%100;
					addCharacter(1, "CD", str);
				}
				
			}
			
			else if(num >= 50) {
				
				if(num < 90) {
					
					int m = num/50;
					num = num%50;
					addCharacter(m, "L", str);
				}
				else {
					
					num = num%10;
					addCharacter(1, "XC", str);
				}
				
			}
			else if(num >= 10) {
				
				if(num < 40) {
					
					int m = num/10;
					num = num%10;
					addCharacter(m, "X", str);
				}
				else {
					
					num = num%10;
					addCharacter(1, "XL", str);
				}
				
			}
			else if(num >= 5) {
				
				if(num < 9) {
					
					int m = num/5;
					num = num%5;
					addCharacter(m, "V", str);
				}
				else {
					
					num = 0;
					addCharacter(1, "IX", str);
				}
				
			}
			else if(num >= 1) {
				
				if(num < 4) {
					
					addCharacter(num, "I", str);
					num = 0;
					
				}
				else {
					
					num = 0;
					addCharacter(1, "IV", str);
				}
				
			}
			
		}
		return str.toString();
	}
	
	public static void addCharacter(int count, String ch, StringBuilder str) {
		
		for(int i=0; i<count; i++) {
			str.append(ch);
		}
	}
}
