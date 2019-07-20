package learn.ds.graph;

import java.util.Set;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/transitive-closure-of-a-graph-using-dfs/
 * @author manoj
 *
 */
public class Transitive_closure {

	public static void main(String[] args) {

		int n = 4;
		Graph g = new  Graph(n);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 0);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		
		int[][] tc = new int[n][n];
		
		Stack<Integer> tempSt = new Stack<>();
		
		for(int i = 0; i<n;i++) {
			tc[i][i] = 1;
			DFS(i, g , tempSt, tc);
		}
		for(int i=0; i < n; i++) {
			for(int j=0; j<n;j++) {
				System.out.print(" " + tc[i][j]);
			}
			System.out.println("");
		}
	}
	
	public static void DFS(int v, Graph g, Stack<Integer> tempSt, int[][] tc) {
		
		tempSt.push(v);
		
		while(tempSt.size() != 0) {
			int vt = tempSt.pop();
			
			Set<Integer> vertexes = g.getAdjacencyVertex(vt);
			if(vertexes == null) {
				continue;
			}
			
			for(int vts : vertexes) {
				if(tc[v][vts] == 0) {
					tc[v][vts] = 1;
					tempSt.push(vts);
				}
				
			}
			
		}
	}

}
