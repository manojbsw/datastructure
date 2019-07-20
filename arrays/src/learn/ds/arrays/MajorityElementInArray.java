package learn.ds.arrays;

/**
 * https://www.techiedelight.com/find-majority-element-in-an-array-boyer-moore-majority-vote-algorithm/
 * 
 * @author manoj
 *
 */
public class MajorityElementInArray {

	public static void main(String[] args) {

		int[] arr = {2,8,7,2,2,5,2,3,1,2,5};
		System.out.println(FindMajorityElementInArray(arr));
		System.out.println("Moore algo " + mooreAlgo(arr));
	}
	
	/*
	 * Time complexity is O(n2)
	 */
	public static int FindMajorityElementInArray(int[] arr) {
		
		
		int n = arr.length;
		for(int i=0; i<n/2;i++) {
			int count = 1;
			for(int j=i+1; j < n; j++) {
				if(arr[i] == arr[j]) {
					count++;
				}
			}
			//System.out.println(count);
			if(count > n/2)
				return arr[i];
		}
		
		return -1;
	}

	/*
	 * moore boyer algo to find majority element
	 * 
	 */
	public static int mooreAlgo(int[] arr) {
		
		int m = -1;
		int i=0;
		for(int j=0; j<arr.length; j++) {
			
			if(i == 0) {
				m = arr[j];
				i++;
			} else if(m == arr[j]) {
				i++;
			} else {
				i--;
			}
			
		}
		return m;
		
	}
}
