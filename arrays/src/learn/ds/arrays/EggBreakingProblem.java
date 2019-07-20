package learn.ds.arrays;

/**
 * https://www.youtube.com/watch?v=3hcaVyX00_4
 * 
 * @author manoj
 *
 */
public class EggBreakingProblem {

	public static void main(String[] args) {

		int noOfEgg = 3;
		int noOfFloor = 6;
		
		System.out.println(eggBreakingProblem(noOfEgg, noOfFloor));
		
	}

	public static int eggBreakingProblem(int eggs, int floors) {
		
		int[][] T = new int[eggs+1][floors+1];
		int c = 0;
		
		
		for(int i=0; i <= floors; i++) {
			T[1][i] = i;
		}
		
		for(int egg=2; egg<=eggs; egg++) {
			
			for(int floor = 1; floor <= floors; floor++) {
				
				T[egg][floor] = Integer.MAX_VALUE;
				
				for(int k=1; k<=floor; k++) {
					
					c = 1 + Math.max(T[egg-1][k-1], T[egg][floor-k]);
					if(c < T[egg][floor]) {
						T[egg][floor] = c;
					}
					
				}
				
			}
			
		}
		
		return T[eggs][floors];
	}
}
