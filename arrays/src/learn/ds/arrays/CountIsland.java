package learn.ds.arrays;

/**
 * This problem was asked by Amazon.

Given a matrix of 1s and 0s, return the number of “islands” in the matrix. A 1 represents land and 0 represents water, so an island is a group of 1s that are neighboring whose perimeter is surrounded by water.

For example, this matrix has 4 islands.

1 0 0 0 0
0 0 1 1 0
0 1 1 0 0
0 0 0 0 0
1 1 0 0 1
1 1 0 0 1

Solution: We need to find the connected ones like below.

From the above images, it is very clear that:

    Visit each value with 1 and its adjacents 1(DFS)
    sum them of the visit

To avoid all the duplicates, we will replace the value with 2 in the input. So we can avoid using the extra matrix as visited.

 * @author manoj
 *
 */
public class CountIsland {

	    static int[][] in;
	    static int[][] path;
	    
	public static void main(String[] args) {

		in = new int[][]{
            {1, 0, 0, 0, 0},
            {0, 0, 1, 1, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {1, 1, 0, 0, 1}
    };

    path = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    System.out.println(numberOfIsland(in));
	}
	
	
	private static int numberOfIsland(int[][] in) {
        int total = 0;
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[0].length; j++) {
                if (in[i][j] == 1) {
                    helper(in, i, j);
                    total++;
                }
            }
        }
        return total;
    }

    private static void helper(int[][] in, int r, int c) {
        if (r < 0 || r >= 6 || c < 0 || c >= 5 || in[r][c] == 0 || in[r][c] == 2)
            return;
        in[r][c] = 2;
        for (int i = 0; i < path.length; i++) {
            int[] p = path[i];
            helper(in, r + p[0], c + p[1]);
        }
    }

}
