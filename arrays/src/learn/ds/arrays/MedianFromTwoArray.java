package learn.ds.arrays;

/**
 * Find median of two sorted arrays of different sizes. Algorithm is based on binary search
 * 
 * https://www.youtube.com/watch?v=LPFhl65R7ww
 * @author manoj
 *
 */
public class MedianFromTwoArray {

	public static void main(String[] args) {

		int input1[] = {1,2,3,8,9,10,14};
		int input2[] = {4,6,11,13,15}; // 1 2 3 4 6 8 9 10 11 13 14 15
		
		System.out.println(medianFromSortedArray(input1, input2));
		
	}

	public static double medianFromSortedArray(int input1[], int input2[]) {
		
		if(input1.length > input2.length) {
			return medianFromSortedArray(input2, input1);
		}
		
		int low=0;
		int high = input1.length;
		int x = input1.length;
		int y = input2.length;
		while(low < high) {
			
			int partitionX = (low + high) /2;
			int partitionY = ((input1.length + input2.length + 1)/2 ) - partitionX;  // (x+y+1)/2 - partitionX
			
			int leftMaxX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
			int rightMinX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];
			
			int leftMaxY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
			int rightMinY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];
			
			if(leftMaxX <= rightMinY && leftMaxY <= rightMinX) {
				if((x+y)%2 == 0) {
					return (double)(Math.max(leftMaxX, leftMaxY) + Math.min(rightMinX, rightMinY)) / 2;
				}
				else {
					return Math.max(leftMaxX, leftMaxY);
				}
			} else if( leftMaxX > rightMinY) {
				high = partitionX - 1;
			} else {
				low = partitionX + 1;
			}
			
			
		}
		throw new  IllegalArgumentException("Arrays are unsorted");
	}
}
