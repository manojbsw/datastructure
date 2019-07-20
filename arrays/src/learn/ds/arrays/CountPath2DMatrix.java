package learn.ds.arrays;

/**
 * Objective: Given two dimensional matrix, write an algorithm to count all possible paths from top left corner to bottom-right corner. You are allowed to move only in two directions, move right OR move down. There are few obstructions as well, means few cells are blocked and you cannot travel that cell.

Many times this problem is being referred as “Robot Travel Problem“. Given a 2d matrix, how many ways a robot can travel from top left corner to bottom right corner and there are few cells in which robot cannot travel.
Solution: https://algorithms.tutorialhorizon.com/dynamic-programming-count-all-paths-in-2d-matrix-with-obstructions-in-it/
 * @author manoj
 *
 */
public class CountPath2DMatrix {

	public static void main(String[] args) {

		int[][] arr = {{1,1,1},{1,-1,1},{1,-1,1}};
		
		System.out.println("Result with recursive "+ recursiveCountPath(arr, 0, 0));
		
		System.out.println("Result with iterative " + countPath(arr));
		
	}

	public static int recursiveCountPath(int[][] arr, int row, int col) {
		
		if(row == arr.length-1 && col == arr.length-1) {
			return 1;
		}
		
		int right = 0;
		int down = 0;
		if(row != arr[row].length-1 && arr[row+1][col] != -1) {
			down += recursiveCountPath(arr, row+1, col);
		}
		if(col != arr[col].length-1 && arr[row][col+1] != -1) {
			right += recursiveCountPath(arr, row, col+1);
		}
		
		return right+down;
	}
	
	public static int countPath(int[][] arr) {
		
		int[][] result = arr;
		
		for(int i=1; i< arr.length; i++) {
			for(int j=1; j<arr.length; j++) {
				
				if(arr[i][j] != -1) {
					
					arr[i][j] = 0;
					
					if(arr[i-1][j] > 0) {
						result[i][j] += result[i-1][j];
					}
					
					if(arr[i][j-1] > 0) {
						result[i][j] += result[i][j-1];
					}
				}
				
			}
		}
		
		
		return arr[arr.length-1][arr.length-1];
	}
}
