package learn.ds.arrays;

/**
 * https://www.techiedelight.com/convert-given-number-corresponding-excel-column-name/
 * @author manoj
 *
 */
public class NumberToExcelColumn {

	public static void main(String[] args) {

		int n = 28;
		
		String column = numberToExcelColumn(n);
		System.out.println(column);
		
		System.out.println(excelColumnToNumber(column));
		
		
		
	}
	
	public static String numberToExcelColumn(int num) {
		
		StringBuilder column = new  StringBuilder();
		while(num > 0) {
		
			int i = (num-1) % 26;
			column.append((char)(i + 'A'));
			num = (num-1)/26;
		
		}
		
		return column.reverse().toString();
	}

	public static double excelColumnToNumber(String str) {
		double ans = 0;
		char[] chars = str.toCharArray();
	    int n = str.length();
	    
	    for(int i=n-1; i >=0; i--) {
	    	ans = ans + (chars[i]-'A' + 1) * Math.pow(26, n-i); 
	    }
		return ans;
	}
}
