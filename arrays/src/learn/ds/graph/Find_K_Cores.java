package learn.ds.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/find-k-cores-graph/
 * @author manoj
 *
 */
public class Find_K_Cores {

	public static void main(String[] args) {

		int n = 9;
		int k = 3;
		UndirectedGraph g1 = new  UndirectedGraph(n);

		g1.addEdge(0, 1); 
		g1.addEdge(0, 2) ;
		g1.addEdge(1, 2) ;
		g1.addEdge(1, 5) ;
		g1.addEdge(2, 3) ;
		g1.addEdge(2, 4) ;
		g1.addEdge(2, 5) ;
		g1.addEdge(2, 6) ;
		g1.addEdge(3, 4) ;
		g1.addEdge(3, 6) ;
		g1.addEdge(3, 7) ;
		g1.addEdge(4, 6) ;
		g1.addEdge(4, 7) ;
		g1.addEdge(5, 6) ;
		g1.addEdge(5, 8) ;
		g1.addEdge(6, 7) ;
		g1.addEdge(6, 8) ;
		
		int[] degree = new int[n];
		boolean[] visited = new boolean[n];
		for(int i=0; i < n; i++) {
			degree[i] = g1.getDegree(i);
		}
		for(int i=0; i < n; i++) {
			dfsSearch(i, g1, degree, visited, k);
		}
		printKCores(g1,n, degree, k);
	}
	
	public static boolean dfsSearch(int v, UndirectedGraph g, int[] degree, boolean[] visited, int k) {
		
		
		
		visited[v] = true;
		Set<Integer> adajcents = g.getAdjacencyVertex(v);
		
		for(int vt : adajcents) {
			
			if(degree[v] < k) {
				degree[vt] = degree[vt] - 1;
				
			}
			
			if(!visited[vt]) {
				if(dfsSearch(vt, g, degree, visited, k)) {
					degree[v] = degree[v] -1;
				}
			}
			
		}
		return degree[v] < k;
	}

	
	public static void printKCores(UndirectedGraph g, int n, int[] degree, int k) {
		
		for(int i=0; i<n; i++) {
			
			if(degree[i] >= k) {
				Set<Integer> adjcents = g.getAdjacencyVertex(i);
				System.out.print(i + ">>:");
				for(int ad : adjcents) {
					System.out.print(">"+ad);
				}
				System.out.println();
			}
			
		}
		
	}
}

class UndirectedGraph {
	
	Set<Integer>[] adjcent = null;
	//List<Integer>[] adcent = new ArrayList[];
	public UndirectedGraph(int totalVertex) {
		adjcent = new HashSet[totalVertex];
	}
	
	public void addEdge(int u, int v) {
		if(adjcent[u] == null) {
			adjcent[u] = new HashSet<>();
		}
		adjcent[u].add(v);
		if(adjcent[v] == null) {
			adjcent[v] = new HashSet<>();
		}
		adjcent[v].add(u);
		
	}
	
	public void removeEdge(int u, int v) {
		if(adjcent[u] != null) {
			adjcent[u].remove(v);
		}
		if(adjcent[v] != null) {
			adjcent[v].remove(u);
		}
	}
	
	public void removeVertex(int u) {
		Set<Integer> adjcents = getAdjacencyVertex(u);
		if(adjcents != null) {
			for(int ad : adjcents) {
				removeEdge(u, ad);
			}
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