package learn.ds.graph;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Find mother vertex of the graph
 * 
 * https://www.geeksforgeeks.org/find-a-mother-vertex-in-a-graph/
 * @author manoj
 *
 */
public class MotherVertex_Graph {

	public static void main(String[] args) {

		int n = 7;
		Graph g = new  Graph(n);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		g.addEdge(4, 1);
		g.addEdge(6, 4);
		g.addEdge(6, 0);
		g.addEdge(5, 6);
		g.addEdge(5, 2);
		
		Set<Integer> visited = new HashSet<>();
		Stack<Integer> tempSt = new Stack<>();
		int v = 0;
		for(int i = 0; i<n;i++) {
			if(visited.contains(i)) {
				continue;
			}
			DFS(i, g , tempSt, visited);
			v =i;
		}
		
		visited = new HashSet<>();
		DFS(v, g , tempSt, visited);
		if(visited.size() < 7) {
			System.out.println(" No mother vertex found");
		}
		else {
			System.out.println("Mother vertex is " + v);
		}
	}

	public static void DFS(int v, Graph g, Stack<Integer> tempSt, Set<Integer> visited) {
		
		tempSt.push(v);
		
		while(tempSt.size() != 0) {
			int vt = tempSt.pop();
			visited.add(vt);
			System.out.println(vt);
			
			Set<Integer> vertexes = g.getAdjacencyVertex(vt);
			if(vertexes == null) {
				continue;
			}
			
			for(int vts : vertexes) {
				
				if(visited.contains(vts)) {
					continue;
				}
				tempSt.push(vts);
			}
			
		}
	}
	
	
	
}


class Graph {
	
	Set<Integer>[] adjcent = null;
	//List<Integer>[] adcent = new ArrayList[];
	public Graph(int totalVertex) {
		adjcent = new HashSet[totalVertex];
	}
	
	public void addEdge(int u, int v) {
		if(adjcent[u] == null) {
			adjcent[u] = new HashSet<>();
		}
		adjcent[u].add(v);
	}
	
	public void removeEdge(int u, int v) {
		if(adjcent[u] != null) {
			adjcent[u].remove(v);
		}
	}
	
	public int getDegree(int u) {
		if(adjcent[u] != null) {
		  return adjcent[u].size();
		}
		return 0;
	}
	
	public Set<Integer> getAdjacencyVertex(int u) {
		return adjcent[u];
	}
	
	public Set[] getAllVertex() {
		return adjcent;
	}
}