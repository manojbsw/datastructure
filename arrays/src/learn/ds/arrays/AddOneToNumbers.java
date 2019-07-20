package learn.ds.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class AddOneToNumbers {

	public static void main(String[] args) {
		int[] arr = new int[] {1,1,1,1,0,0,0,0};
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(6);
		list.add(4);
		list.add(7);
		list.add(7);
		list.add(8);
		list.add(9);
		list = addOne(list);
		list.forEach(l -> System.out.println(l));
		}
		

	public static ArrayList<Integer> addOne(ArrayList<Integer> list) {
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		int n = list.size();
		
		int num = list.get(n-1) + 1;
		int reminder = 0;
		if (num > 9) {
			list2.add(0);
			reminder = 1;
		} else {
			list2.add(num);
		}
	    
		
		for(int i = n-2; i >= 0;i-- ) {
			num = list.get(i);
			num = num + reminder;
			
			if (num > 9) {
				list2.add(0);
				reminder = 1;
			} else {
				list2.add(num);
				reminder = 0;
			}
			
		}
		if (num > 9 && reminder > 0) {
			list2.add(reminder);
		}
		Collections.reverse(list2);
		return list2;
		
	}
}
