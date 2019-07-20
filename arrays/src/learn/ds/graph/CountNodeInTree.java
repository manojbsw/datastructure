package learn.ds.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Count the number of nodes at given level in a tree using BFS.
 * https://www.geeksforgeeks.org/count-number-nodes-given-level-using-bfs/
 * @author manoj
 *
 */
public class CountNodeInTree {

	public static void main(String[] args) {

		 int n = 6;
		 int k = 3;
		UndirectedGraph g = new  UndirectedGraph(n);
		    g.addEdge(0, 1); 
		    g.addEdge(0, 2); 
		    g.addEdge(1, 3); 
		    g.addEdge(2, 4); 
		    g.addEdge(2, 5); 
		    
		    Set<Integer> visited = new HashSet<>();
			Queue<Integer> tempSt = new LinkedList<>();
			for(int i = 0; i<n;i++) {
				if(visited.contains(i)) {
					continue;
				}
				BFS(i, g , tempSt, visited, k);
			}
	}

	public static void BFS(int v, UndirectedGraph g, Queue<Integer> tempSt, Set<Integer> visited, int k)  {
		
		visited.add(v);
		tempSt.add(v);
		int adjNode = g.getDegree(v);
		while(tempSt.size() != 0) {
			
			
			
			tempSt.poll();
			
		}
		
		
	}
}
