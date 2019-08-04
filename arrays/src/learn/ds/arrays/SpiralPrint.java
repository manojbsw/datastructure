package learn.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Print multidimensional array in to spiral order
 * 
 * Given the following matrix:

[
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
]

You should return

[1, 2, 3, 6, 9, 8, 7, 4, 5]


 * 
 * @author manoj
 *
 */
public class SpiralPrint {

	public static void main(String[] args) {
		//int[][] array = {{1,2,3}, {4,5,6}, {7,8,9}};
		List<ArrayList<Integer>> list = new ArrayList<>();
		
		ArrayList<Integer> alist = new ArrayList<>();
		alist.add(1);
		alist.add(2);
		alist.add(3);
		list.add(alist);
		
		alist = new ArrayList<>();
		alist.add(4);
		alist.add(5);
		alist.add(6);
		list.add(alist);
		
		alist = new ArrayList<>();
		alist.add(7);
		alist.add(8);
		alist.add(9);
		list.add(alist);
		
      List<ArrayList<Integer>> list1 = new ArrayList<>();
		
		ArrayList<Integer> alist1 = new ArrayList<>();
		alist1.add(1);
		
		list1.add(alist1);
		
		spiralOrder(list);
		
	}
	
	public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
		
		int n = A.get(0).size();
		int m = A.size();
		int top = 0, bottom = m - 1, left = 0, right = n-1;
		int dir = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(top <= bottom && left <=right)  {
			
			if (dir == 0) {
				
				for(int i = left; i <= right; i++ ) {
					System.out.println(A.get(top).get(i));
					list.add(A.get(top).get(i));
				}
				top++;
				dir = 1;
			}
			
			if (dir == 1) {
				
				for(int i = top; i<= bottom; i++) {
					System.out.println(A.get(i).get(right));
					list.add(A.get(i).get(right));
				}
				right--;
				dir = 2;
			}
			
			if(dir == 2) {
				
				for(int i = right; i>=left; i--) {
					System.out.println(A.get(bottom).get(i));
					list.add(A.get(bottom).get(i));
				}
				bottom --;
				dir = 3;
			}
			if(dir == 3) {
				
				for(int i = bottom; i>=top; i--) {
					System.out.println(A.get(i).get(left));
					list.add(A.get(i).get(left));
				}
				left++;
				dir=0;
			}
		}
			
		return list;
    }

}
