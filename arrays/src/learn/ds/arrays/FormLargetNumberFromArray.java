package learn.ds.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
 * https://www.geeksforgeeks.org/arrange-given-numbers-form-biggest-number-set-2/
 * @author manoj
 *
 */
public class FormLargetNumberFromArray {

	public static void main(String[] args) {

		Integer[] arr = {54, 546, 548, 60};
		largestNumber(arr);
		System.out.println();
		otherApproach(arr);
	}

	public static void largestNumber(Integer arr[]) {
		
		List<Integer> list = Arrays.asList(arr); 
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				int s1 = Integer.parseInt(o1.toString() + o2.toString());
				int s2 = Integer.parseInt(o2.toString() + o1.toString());
				
				return s2-s1;
			}
		});
		
		list.stream().forEach(str -> System.out.print(str));
		
	}
	
	public static void otherApproach(Integer arr[]) {
		
		final int n = Collections.max(Arrays.asList(arr)).toString().length() + 1;
		List<maxNumber> list = Arrays.asList(arr).stream().map(num -> new maxNumber(num, n)).collect(Collectors.toList());
		
		Collections.sort(list, new Comparator<maxNumber>() {

			@Override
			public int compare(maxNumber o1, maxNumber o2) {
				
				return (int) (o2.newNumber - o1.newNumber);
			}
		});
		
		list.stream().forEach(mx -> System.out.print(mx.originalNumber));
		
	}
}

class maxNumber {
	
	public int originalNumber;
	public long newNumber;
	public maxNumber(int num, int n) {
		this.originalNumber = num;
		
		String s = Integer.toString(originalNumber); 
        StringBuilder sb = new StringBuilder(s); 
        StringBuilder ans = new StringBuilder(); 
        while (ans.length() <= n + 1) 
            ans.append(sb); 
  
        s = ans.toString().substring(0, n + 1); 
        newNumber = Long.parseLong(s); 
		
	}
	
}