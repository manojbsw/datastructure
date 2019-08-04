package learn.ds.arrays;

/**
 * https://www.geeksforgeeks.org/unique-paths-in-a-grid-with-obstacles/
 * @author manoj
 *
 */
public class UniquePathInGridWithObstacle {

	public static void main(String[] args) {
       int[][] arr = {{0, 0, 0},
                      {0, 1, 0},
                      {0, 0, 0}};
       
       System.out.println(uniquePath(arr));
	}

	public static int uniquePath(int[][] arr) {
		
		int[][] path = new int[arr.length][arr[0].length];
		
		//First element can not be 1
		if(arr[0][0] == 1) {
			return 0;
		}
		
		path[0][0]=1;
		
		//Initialize first row
		for(int i=1; i < arr.length; i++) {
			if(arr[0][i] == 0) //If not obstacle
			path[0][i] = path[0][i-1];
		}
		
		//Initialize first column
		for(int i=1; i < arr[0].length; i++) {
			if(arr[i][0] == 0) //If not obstacle
			path[i][0] = path[i-1][0];
		}
		
		for(int i=1; i < arr.length; i++) {
			
			for(int j=1; j<arr[0].length; j++) {
				if(arr[i][j] == 0)
					path[i][j] = path[i][j-1] + path[i-1][j];
			}
		}
		
		return path[arr.length-1][arr[0].length-1];
	}
}
