package learn.ds.arrays;

/**
 * 
 * https://www.youtube.com/watch?v=xouin83ebxE
 * @author manoj
 *
 */
public class NQueens {

	public static void main(String[] args) {
		
		Position positions[] = new Position[4];
		boolean solved = placeQueens(positions.length, 0, positions);
		if(solved) {
			for(Position pos : positions) {
				System.out.println(pos);
			}
		}
		else {
			System.out.println("row " + positions[0].row + " col " + positions[0].col);
		}
		

	}
	
	private static boolean solveNQueenOneSolutionUtil(int n, int row, Position[] positions) {
        if (n == row) {
            return true;
        }
        int col;
        for (col = 0; col < n; col++) {
            boolean foundSafe = true;

            //check if this row and col is not under attack from any previous queen.
            for (int queen = 0; queen < row; queen++) {
                if (positions[queen].col == col || positions[queen].row - positions[queen].col == row - col ||
                        positions[queen].row + positions[queen].col == row + col) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                positions[row] = new Position(row, col);
                if (solveNQueenOneSolutionUtil(n, row + 1, positions)) {
                    return true;
                }
            }
        }
        return false;
    }

	
	public static boolean placeQueens(int n, int row, Position pos[]) {
		
		if(n == row) {
			return true;
		}
		
		for(int col = 0; col < n; col++) {
			
			boolean isSafeToPlace = true;
			
			for(int queen = 0; queen < row; queen++) {
				if(pos[queen].col == col || (pos[queen].row + pos[queen].col == row + col) || (pos[queen].row - pos[queen].col == row - col)) {
					isSafeToPlace = false;
					break;
				}
			}
			
			if(isSafeToPlace) {
				pos[row] = new Position(row, col);
				if(placeQueens(n, row+1, pos)) {
					return true;
				}
			}	
		
		}
		return false;
	}
}
final class Position {
	public int row, col;
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public String toString() {
		return "x = " + row + " y = " + col;
	}

}
