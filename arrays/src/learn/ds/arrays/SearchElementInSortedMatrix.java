package learn.ds.arrays;

/**
 * Given a matrix mat[] of size n x m, where every row and column is sorted in increasing order, and a number x is given. The task is to find whether element x is present in the matrix or not.

Expected Time Complexity : O(m + n)

Input:
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consists of three lines. First line of each test case consist of two space separated integers N and M, denoting the number of element in a row and column respectively. Second line of each test case consists of N*M space separated integers denoting the elements in the matrix in row major order. Third line of each test case contains a single integer x, the element to be searched.

Output:
Corresponding to each test case, print in a new line, 1 if the element x is present in the matrix, otherwise simply print 0.

Constraints:
1 <= T <= 200
1 <= N, M <= 30
1 <= mat[][] <= 100
1<= X <= 100
Example:
Input:
2
3 3
3 30 38 44 52 54 57 60 69
62
1 6
18 21 27 38 55 67
55

Output:
0
1

Explanation:
Testcase 1: 62 is not present in the matrix, so output is 0.
Testcase 2: 55 is present in the matrix at 5th cell.
 
 * @author manoj
 *
 */
public class SearchElementInSortedMatrix {

	public static void main(String[] args) {

		int[][] matrix = {{3, 30, 38}, { 44, 52, 54},{ 57, 60, 69}};
		int k=53;
		System.out.println(searchMatrix(matrix, k));
	}

	public static boolean searchMatrix(int[][] matrix, int k) {
		
		for(int i=0; i<matrix.length; i++) {
			
			for(int j=0; j<matrix[0].length; j++) {
				
				if(matrix[i][j] == k) return true;
				else if(matrix[i][j] < k && matrix[i][matrix[0].length-1] < k) {
					break;
				}
				else 
					continue;
				
			}
		}
		
		return false;
	}
}